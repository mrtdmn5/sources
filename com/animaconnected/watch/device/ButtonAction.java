package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class ButtonAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ButtonAction[] $VALUES;
    public static final Companion Companion;
    private final int id;
    private final String readableName;
    public static final ButtonAction Press = new ButtonAction("Press", 0, 1, "PRESS");
    public static final ButtonAction LongPress = new ButtonAction("LongPress", 1, 2, "LONG_PRESS");
    public static final ButtonAction DoublePress = new ButtonAction("DoublePress", 2, 3, "DOUBLE_PRESS");
    public static final ButtonAction TriplePress = new ButtonAction("TriplePress", 3, 4, "TRIPLE_PRESS");
    public static final ButtonAction QuadruplePress = new ButtonAction("QuadruplePress", 4, 5, "QUADRUPLE_PRESS");
    public static final ButtonAction DoubleLongPress = new ButtonAction("DoubleLongPress", 5, 6, "DOUBLE_LONG_PRESS");
    public static final ButtonAction TripleLongPress = new ButtonAction("TripleLongPress", 6, 7, "TRIPLE_LONG_PRESS");
    public static final ButtonAction QuadrupleLongPress = new ButtonAction("QuadrupleLongPress", 7, 8, "QUADRUPLE_LONG_PRESS");
    public static final ButtonAction UltraLongPress = new ButtonAction("UltraLongPress", 8, 11, "ULTRA_LONG_PRESS");
    public static final ButtonAction LongPressRelease = new ButtonAction("LongPressRelease", 9, 12, "LONG_PRESS_RELEASE");

    /* compiled from: DeviceUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ButtonAction parse$watch_release(Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = ButtonAction.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((ButtonAction) obj).getId();
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
            return (ButtonAction) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ButtonAction[] $values() {
        return new ButtonAction[]{Press, LongPress, DoublePress, TriplePress, QuadruplePress, DoubleLongPress, TripleLongPress, QuadrupleLongPress, UltraLongPress, LongPressRelease};
    }

    static {
        ButtonAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private ButtonAction(String str, int r2, int r3, String str2) {
        this.id = r3;
        this.readableName = str2;
    }

    public static EnumEntries<ButtonAction> getEntries() {
        return $ENTRIES;
    }

    public static ButtonAction valueOf(String str) {
        return (ButtonAction) Enum.valueOf(ButtonAction.class, str);
    }

    public static ButtonAction[] values() {
        return (ButtonAction[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }

    public final String getReadableName() {
        return this.readableName;
    }
}
