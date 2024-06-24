package com.animaconnected.watch.device;

import android.content.Context;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.animaconnected.watch.SharedPreferencesCache;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPrefsStorageFactory.kt */
/* loaded from: classes3.dex */
public final class SharedPrefsStorageFactory implements StorageFactory {
    private final Context context;
    private final String deviceStoragePrefix;

    public SharedPrefsStorageFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.deviceStoragePrefix = "device_cache_";
    }

    @Override // com.animaconnected.watch.device.StorageFactory
    public BasicStorage createDeviceStorage(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return new SharedPreferencesCache(this.context, ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.deviceStoragePrefix, address));
    }

    @Override // com.animaconnected.watch.device.StorageFactory
    public BasicStorage createStorage(String storageName) {
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        return new SharedPreferencesCache(this.context, storageName);
    }
}
