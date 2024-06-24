package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BatteryState.kt */
/* loaded from: classes3.dex */
public final class BatteryState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BatteryState[] $VALUES;
    public static final Companion Companion;
    private final DeviceError deviceError;
    public static final BatteryState NORMAL = new BatteryState("NORMAL", 0, DeviceError.BATTERY_OK);
    public static final BatteryState LOW = new BatteryState("LOW", 1, DeviceError.BATTERY_WARNING);
    public static final BatteryState CRITICAL = new BatteryState("CRITICAL", 2, DeviceError.BATTERY_CRITICAL);

    /* compiled from: BatteryState.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BatteryState fromDeviceError(DeviceError deviceError) {
            Object obj;
            boolean z;
            Intrinsics.checkNotNullParameter(deviceError, "deviceError");
            Iterator<E> it = BatteryState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((BatteryState) obj).deviceError == deviceError) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (BatteryState) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BatteryState[] $values() {
        return new BatteryState[]{NORMAL, LOW, CRITICAL};
    }

    static {
        BatteryState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private BatteryState(String str, int r2, DeviceError deviceError) {
        this.deviceError = deviceError;
    }

    public static EnumEntries<BatteryState> getEntries() {
        return $ENTRIES;
    }

    public static BatteryState valueOf(String str) {
        return (BatteryState) Enum.valueOf(BatteryState.class, str);
    }

    public static BatteryState[] values() {
        return (BatteryState[]) $VALUES.clone();
    }
}
