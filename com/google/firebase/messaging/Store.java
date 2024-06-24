package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.animaconnected.firebase.AnalyticsConstants;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Store {
    public final SharedPreferences store;

    /* loaded from: classes3.dex */
    public static class Token {
        public static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        public Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AWSCognitoLegacyCredentialStore.TOKEN_KEY, str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(AnalyticsConstants.KEY_TIMESTAMP, j);
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e);
                return null;
            }
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString(AWSCognitoLegacyCredentialStore.TOKEN_KEY), jSONObject.getString("appVersion"), jSONObject.getLong(AnalyticsConstants.KEY_TIMESTAMP));
                } catch (JSONException e) {
                    Log.w("FirebaseMessaging", "Failed to parse token: " + e);
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }
    }

    public Store(Context context) {
        boolean isEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.store = sharedPreferences;
        Object obj = ContextCompat.sLock;
        File file = new File(ContextCompat.Api21Impl.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    synchronized (this) {
                        isEmpty = sharedPreferences.getAll().isEmpty();
                    }
                    if (!isEmpty) {
                        Log.i("FirebaseMessaging", "App restored, clearing state");
                        synchronized (this) {
                            sharedPreferences.edit().clear().commit();
                        }
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }
}
