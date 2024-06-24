package com.animaconnected.watch.provider.quiethours;

import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.StorageFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuietHoursStorage.kt */
/* loaded from: classes3.dex */
public final class QuietHoursStorage {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_END_HOUR = 6;
    private static final int DEFAULT_START_HOUR = 22;
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_END_HOUR = "toHour";
    private static final String KEY_END_MINUTES = "toMinutes";
    private static final String KEY_START_HOUR = "fromHour";
    private static final String KEY_START_MINUTES = "fromMinutes";
    private static final String QUIET_HOURS_STORAGE = "quietHoursStorage";
    private final BasicStorage prefs;

    /* compiled from: QuietHoursStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public QuietHoursStorage(StorageFactory storageFactory) {
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        this.prefs = storageFactory.createStorage(QUIET_HOURS_STORAGE);
    }

    public final int getEndHour() {
        Integer num = this.prefs.getInt(KEY_END_HOUR);
        if (num != null) {
            return num.intValue();
        }
        return 6;
    }

    public final int getEndMinutes() {
        Integer num = this.prefs.getInt(KEY_END_MINUTES);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getStartHour() {
        Integer num = this.prefs.getInt(KEY_START_HOUR);
        if (num != null) {
            return num.intValue();
        }
        return 22;
    }

    public final int getStartMinutes() {
        Integer num = this.prefs.getInt(KEY_START_MINUTES);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean isEnabled() {
        Boolean bool = this.prefs.getBoolean(KEY_ENABLED);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void setEnabled(boolean z) {
        this.prefs.put(KEY_ENABLED, z);
    }

    public final void setEndHour(int r3) {
        this.prefs.put(KEY_END_HOUR, r3);
    }

    public final void setEndMinutes(int r3) {
        this.prefs.put(KEY_END_MINUTES, r3);
    }

    public final void setStartHour(int r3) {
        this.prefs.put(KEY_START_HOUR, r3);
    }

    public final void setStartMinutes(int r3) {
        this.prefs.put(KEY_START_MINUTES, r3);
    }
}
