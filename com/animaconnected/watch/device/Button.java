package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class Button {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Button[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final Button Top = new Button("Top", 0, 0);
    public static final Button Crown = new Button("Crown", 1, 1);
    public static final Button Bottom = new Button("Bottom", 2, 2);

    /* compiled from: DeviceUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Button parse$watch_release(Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = Button.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id$watch_release = ((Button) obj).getId$watch_release();
                    if (num != null && id$watch_release == num.intValue()) {
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
            return (Button) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Button[] $values() {
        return new Button[]{Top, Crown, Bottom};
    }

    static {
        Button[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private Button(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<Button> getEntries() {
        return $ENTRIES;
    }

    public static Button valueOf(String str) {
        return (Button) Enum.valueOf(Button.class, str);
    }

    public static Button[] values() {
        return (Button[]) $VALUES.clone();
    }

    public final int getId$watch_release() {
        return this.id;
    }
}
