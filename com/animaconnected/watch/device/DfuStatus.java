package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public final class DfuStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DfuStatus[] $VALUES;
    public static final Companion Companion;
    private final boolean safeToDfu;
    private final Integer value;
    public static final DfuStatus Ready = new DfuStatus("Ready", 0, 0, true);
    public static final DfuStatus Unknown = new DfuStatus("Unknown", 1, null, true);
    public static final DfuStatus BatteryLow = new DfuStatus("BatteryLow", 2, 1, false);
    public static final DfuStatus TooCold = new DfuStatus("TooCold", 3, 2, false);
    public static final DfuStatus NotReady = new DfuStatus("NotReady", 4, null, false);

    /* compiled from: WatchIO.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DfuStatus fromInt(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = DfuStatus.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    Integer num = ((DfuStatus) obj).value;
                    if (num != null && num.intValue() == r4) {
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
            DfuStatus dfuStatus = (DfuStatus) obj;
            if (dfuStatus == null) {
                if (r4 == 3) {
                    return DfuStatus.Ready;
                }
                return DfuStatus.NotReady;
            }
            return dfuStatus;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DfuStatus[] $values() {
        return new DfuStatus[]{Ready, Unknown, BatteryLow, TooCold, NotReady};
    }

    static {
        DfuStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private DfuStatus(String str, int r2, Integer num, boolean z) {
        this.value = num;
        this.safeToDfu = z;
    }

    public static EnumEntries<DfuStatus> getEntries() {
        return $ENTRIES;
    }

    public static DfuStatus valueOf(String str) {
        return (DfuStatus) Enum.valueOf(DfuStatus.class, str);
    }

    public static DfuStatus[] values() {
        return (DfuStatus[]) $VALUES.clone();
    }

    public final boolean getSafeToDfu() {
        return this.safeToDfu;
    }
}
