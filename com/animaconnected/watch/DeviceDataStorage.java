package com.animaconnected.watch;

import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.StorageFactory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceDataStorage.kt */
/* loaded from: classes3.dex */
public final class DeviceDataStorage {
    private boolean dirty;
    private final String dirtyKey;
    private final BasicStorage prefs;
    private final String prefsName;

    public DeviceDataStorage(StorageFactory storageFactory) {
        boolean z;
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        this.dirtyKey = "dirty";
        this.prefsName = "deviceDataStorage";
        BasicStorage createStorage = storageFactory.createStorage("deviceDataStorage");
        this.prefs = createStorage;
        Boolean bool = createStorage.getBoolean("dirty");
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = true;
        }
        this.dirty = z;
    }

    public static /* synthetic */ boolean getBoolean$default(DeviceDataStorage deviceDataStorage, String str, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        return deviceDataStorage.getBoolean(str, z);
    }

    public static /* synthetic */ void put$default(DeviceDataStorage deviceDataStorage, String str, String str2, boolean z, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z = true;
        }
        deviceDataStorage.put(str, str2, z);
    }

    public final boolean getBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Boolean bool = this.prefs.getBoolean(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        return z;
    }

    public final boolean getDirty() {
        return this.dirty;
    }

    public final int getInt(String key, int r3) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = this.prefs.getInt(key);
        if (num != null) {
            return num.intValue();
        }
        return r3;
    }

    public final long getLong(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        Long l = this.prefs.getLong(key);
        if (l != null) {
            return l.longValue();
        }
        return j;
    }

    public final BasicStorage getPrefs() {
        return this.prefs;
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.prefs.getString(key);
    }

    public final void put(String key, String str, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.put(key, str);
        if (z) {
            setDirty(true);
        }
    }

    public final void setDirty(boolean z) {
        this.prefs.put(this.dirtyKey, z);
    }

    public static /* synthetic */ void put$default(DeviceDataStorage deviceDataStorage, String str, boolean z, boolean z2, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z2 = true;
        }
        deviceDataStorage.put(str, z, z2);
    }

    public final String getString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        String string = this.prefs.getString(key);
        return string == null ? str : string;
    }

    public static /* synthetic */ void put$default(DeviceDataStorage deviceDataStorage, String str, int r2, boolean z, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z = true;
        }
        deviceDataStorage.put(str, r2, z);
    }

    public final void put(String key, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.put(key, z);
        if (z2) {
            setDirty(true);
        }
    }

    public static /* synthetic */ void put$default(DeviceDataStorage deviceDataStorage, String str, long j, boolean z, int r5, Object obj) {
        if ((r5 & 4) != 0) {
            z = true;
        }
        deviceDataStorage.put(str, j, z);
    }

    public final void put(String key, int r3, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.put(key, r3);
        if (z) {
            setDirty(true);
        }
    }

    public final void put(String key, long j, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.put(key, j);
        if (z) {
            setDirty(true);
        }
    }
}
