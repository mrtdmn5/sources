package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DesugarDate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class HeartBeatInfoStorage {
    public final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseSharedPreferences = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void cleanUpStoredHeartBeats() {
        long j = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        String str = "";
        String str2 = null;
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str3 : (Set) entry.getValue()) {
                    if (str2 == null || str2.compareTo(str3) > 0) {
                        str = entry.getKey();
                        str2 = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.remove(str2);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong("fire-count", j - 1).commit();
    }

    public final synchronized void deleteAllHeartBeats() {
        SharedPreferences.Editor edit = this.firebaseSharedPreferences.edit();
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                edit.remove(entry.getKey());
            }
        }
        edit.remove("fire-count");
        edit.commit();
    }

    public final synchronized ArrayList getAllHeartBeats() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                arrayList.add(new AutoValue_HeartBeatResult(entry.getKey(), new ArrayList((Set) entry.getValue())));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            this.firebaseSharedPreferences.edit().putLong("fire-global", currentTimeMillis).commit();
        }
        return arrayList;
        return arrayList;
    }

    public final synchronized String getFormattedDate(long j) {
        Instant instant;
        if (Build.VERSION.SDK_INT >= 26) {
            instant = DesugarDate.toInstant(new Date(j));
            return instant.atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void removeStoredDate(String str) {
        String storedUserAgentString = getStoredUserAgentString(str);
        if (storedUserAgentString == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(storedUserAgentString, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.firebaseSharedPreferences.edit().remove(storedUserAgentString).commit();
        } else {
            this.firebaseSharedPreferences.edit().putStringSet(storedUserAgentString, hashSet).commit();
        }
    }

    public final synchronized boolean shouldSendSdkHeartBeat(long j) {
        if (this.firebaseSharedPreferences.contains("fire-global")) {
            long j2 = this.firebaseSharedPreferences.getLong("fire-global", -1L);
            synchronized (this) {
                if (!getFormattedDate(j2).equals(getFormattedDate(j))) {
                    this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
                    return true;
                }
                return false;
            }
        }
        this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
        return true;
    }

    public final synchronized void storeHeartBeat(long j, String str) {
        String formattedDate = getFormattedDate(j);
        if (this.firebaseSharedPreferences.getString("last-used-date", "").equals(formattedDate)) {
            String storedUserAgentString = getStoredUserAgentString(formattedDate);
            if (storedUserAgentString == null) {
                return;
            }
            if (storedUserAgentString.equals(str)) {
                return;
            }
            updateStoredUserAgent(str, formattedDate);
            return;
        }
        long j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        if (j2 + 1 == 30) {
            cleanUpStoredHeartBeats();
            j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(formattedDate);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", formattedDate).commit();
    }

    public final synchronized void updateStoredUserAgent(String str, String str2) {
        removeStoredDate(str2);
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).commit();
    }
}
