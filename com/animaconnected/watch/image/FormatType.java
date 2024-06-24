package com.animaconnected.watch.image;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Graphics.kt */
/* loaded from: classes3.dex */
public final class FormatType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FormatType[] $VALUES;
    public static final Companion Companion;
    public static final FormatType INDEXED_1BIT = new FormatType("INDEXED_1BIT", 0, 7, 1, 2);
    public static final FormatType INDEXED_2BIT = new FormatType("INDEXED_2BIT", 1, 8, 2, 4);
    public static final FormatType INDEXED_4BIT = new FormatType("INDEXED_4BIT", 2, 9, 4, 16);
    public static final FormatType INDEXED_8BIT = new FormatType("INDEXED_8BIT", 3, 10, 8, 256);
    private final int bit;
    private final int colors;
    private final int value;

    /* compiled from: Graphics.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FormatType parseFromValue(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = FormatType.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((FormatType) obj).getValue() == r4) {
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
            return (FormatType) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FormatType[] $values() {
        return new FormatType[]{INDEXED_1BIT, INDEXED_2BIT, INDEXED_4BIT, INDEXED_8BIT};
    }

    static {
        FormatType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FormatType(String str, int r2, int r3, int r4, int r5) {
        this.value = r3;
        this.bit = r4;
        this.colors = r5;
    }

    public static EnumEntries<FormatType> getEntries() {
        return $ENTRIES;
    }

    public static FormatType valueOf(String str) {
        return (FormatType) Enum.valueOf(FormatType.class, str);
    }

    public static FormatType[] values() {
        return (FormatType[]) $VALUES.clone();
    }

    public final int getBit() {
        return this.bit;
    }

    public final int getColors() {
        return this.colors;
    }

    public final int getValue() {
        return this.value;
    }
}
