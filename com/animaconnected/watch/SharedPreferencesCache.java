package com.animaconnected.watch;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.BasicStorage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPreferencesCache.kt */
/* loaded from: classes3.dex */
public final class SharedPreferencesCache implements BasicStorage {
    private static final boolean DEBUG_GET = false;
    private static final boolean DEBUG_PUT = false;
    private final SharedPreferences sharedPreferences;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SharedPreferencesCache";

    /* compiled from: SharedPreferencesCache.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SharedPreferencesCache(Context context, String storageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        this.sharedPreferences = context.getSharedPreferences(storageName, 0);
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.contains(key);
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public Boolean getBoolean(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.sharedPreferences.contains(key)) {
            return Boolean.valueOf(this.sharedPreferences.getBoolean(key, false));
        }
        return null;
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public byte[] getBytes(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.sharedPreferences.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            return Base64.decode(string, 0);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Failed to read value from cache for ".concat(key), e);
            return null;
        }
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public Float getFloat(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.sharedPreferences.contains(key)) {
            return Float.valueOf(this.sharedPreferences.getFloat(key, Float.MAX_VALUE));
        }
        return null;
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public Integer getInt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.sharedPreferences.contains(key)) {
            return Integer.valueOf(this.sharedPreferences.getInt(key, Integer.MIN_VALUE));
        }
        return null;
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public Long getLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.sharedPreferences.contains(key)) {
            return Long.valueOf(this.sharedPreferences.getLong(key, Long.MAX_VALUE));
        }
        return null;
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sharedPreferences.getString(key, null);
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().putString(key, str).apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().remove(key).apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, byte[] bArr) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().putString(key, Base64.encodeToString(bArr, 0)).apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.sharedPreferences, key, z);
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, int r3) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().putInt(key, r3).apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().putLong(key, j).apply();
    }

    @Override // com.animaconnected.watch.device.BasicStorage
    public void put(String key, float f) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPreferences.edit().putFloat(key, f).apply();
    }
}
