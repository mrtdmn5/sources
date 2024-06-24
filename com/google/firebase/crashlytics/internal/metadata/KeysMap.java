package com.google.firebase.crashlytics.internal.metadata;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class KeysMap {
    public final HashMap keys = new HashMap();
    public final int maxEntries = 64;
    public final int maxEntryLength;

    public KeysMap(int r2) {
        this.maxEntryLength = r2;
    }

    public static String sanitizeString(int r1, String str) {
        String trim = str.trim();
        if (trim.length() > r1) {
            return trim.substring(0, r1);
        }
        return trim;
    }

    public final synchronized void setKeys(Map<String, String> map) {
        String sanitizeString;
        int r0 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                String sanitizeString2 = sanitizeString(this.maxEntryLength, key);
                if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(sanitizeString2)) {
                    r0++;
                }
                String value = entry.getValue();
                HashMap hashMap = this.keys;
                if (value == null) {
                    sanitizeString = "";
                } else {
                    sanitizeString = sanitizeString(this.maxEntryLength, value);
                }
                hashMap.put(sanitizeString2, sanitizeString);
            } else {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
        }
        if (r0 > 0) {
            Log.w("FirebaseCrashlytics", "Ignored " + r0 + " entries when adding custom keys. Maximum allowable: " + this.maxEntries, null);
        }
    }
}
