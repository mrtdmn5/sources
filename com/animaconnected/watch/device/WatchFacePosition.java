package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class WatchFacePosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchFacePosition[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final WatchFacePosition Center = new WatchFacePosition("Center", 0, 0);
    public static final WatchFacePosition CenterRight = new WatchFacePosition("CenterRight", 1, 1);
    public static final WatchFacePosition BottomRight = new WatchFacePosition("BottomRight", 2, 2);
    public static final WatchFacePosition BottomCenter = new WatchFacePosition("BottomCenter", 3, 3);
    public static final WatchFacePosition BottomLeft = new WatchFacePosition("BottomLeft", 4, 4);
    public static final WatchFacePosition CenterLeft = new WatchFacePosition("CenterLeft", 5, 5);
    public static final WatchFacePosition TopLeft = new WatchFacePosition("TopLeft", 6, 6);
    public static final WatchFacePosition TopCenter = new WatchFacePosition("TopCenter", 7, 7);
    public static final WatchFacePosition TopRight = new WatchFacePosition("TopRight", 8, 8);

    /* compiled from: DeviceUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchFacePosition parse$watch_release(Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = WatchFacePosition.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((WatchFacePosition) obj).getId();
                    if (num != null && id == num.intValue()) {
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
            return (WatchFacePosition) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ WatchFacePosition[] $values() {
        return new WatchFacePosition[]{Center, CenterRight, BottomRight, BottomCenter, BottomLeft, CenterLeft, TopLeft, TopCenter, TopRight};
    }

    static {
        WatchFacePosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private WatchFacePosition(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<WatchFacePosition> getEntries() {
        return $ENTRIES;
    }

    public static WatchFacePosition valueOf(String str) {
        return (WatchFacePosition) Enum.valueOf(WatchFacePosition.class, str);
    }

    public static WatchFacePosition[] values() {
        return (WatchFacePosition[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
