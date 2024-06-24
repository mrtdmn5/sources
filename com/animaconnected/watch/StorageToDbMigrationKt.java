package com.animaconnected.watch;

import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: StorageToDbMigration.kt */
/* loaded from: classes3.dex */
public final class StorageToDbMigrationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyTo(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        SharedPreferences.Editor edit = sharedPreferences2.edit();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (value instanceof String) {
                    edit.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(key, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(key, ((Number) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(key, ((Number) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                } else {
                    throw new IllegalStateException(("Unknown value type: " + value).toString());
                }
            }
        }
        edit.apply();
    }
}
