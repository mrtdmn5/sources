package com.animaconnected.watch.device;

import java.util.NoSuchElementException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class WatchFace {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchFace[] $VALUES;
    public static final Companion Companion;
    private final int index;
    public static final WatchFace Main = new WatchFace("Main", 0, 0);
    public static final WatchFace FirstSubdial = new WatchFace("FirstSubdial", 1, 1);
    public static final WatchFace SecondSubdial = new WatchFace("SecondSubdial", 2, 2);

    /* compiled from: DeviceUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchFace parseIndex(int r4) {
            boolean z;
            for (WatchFace watchFace : WatchFace.getEntries()) {
                if (watchFace.getIndex$watch_release() == r4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return watchFace;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ WatchFace[] $values() {
        return new WatchFace[]{Main, FirstSubdial, SecondSubdial};
    }

    static {
        WatchFace[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private WatchFace(String str, int r2, int r3) {
        this.index = r3;
    }

    public static EnumEntries<WatchFace> getEntries() {
        return $ENTRIES;
    }

    public static WatchFace valueOf(String str) {
        return (WatchFace) Enum.valueOf(WatchFace.class, str);
    }

    public static WatchFace[] values() {
        return (WatchFace[]) $VALUES.clone();
    }

    public final int getIndex$watch_release() {
        return this.index;
    }
}
