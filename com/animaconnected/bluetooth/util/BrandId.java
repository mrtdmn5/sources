package com.animaconnected.bluetooth.util;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrandId.kt */
/* loaded from: classes.dex */
public final class BrandId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BrandId[] $VALUES;
    private final byte id;
    public static final BrandId None = new BrandId("None", 0, (byte) 0);
    public static final BrandId Kronaby = new BrandId("Kronaby", 1, (byte) 10);
    public static final BrandId Festina = new BrandId("Festina", 2, (byte) 11);
    public static final BrandId Jaguar = new BrandId("Jaguar", 3, (byte) 12);
    public static final BrandId Lotus = new BrandId("Lotus", 4, (byte) 13);

    private static final /* synthetic */ BrandId[] $values() {
        return new BrandId[]{None, Kronaby, Festina, Jaguar, Lotus};
    }

    static {
        BrandId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BrandId(String str, int r2, byte b) {
        this.id = b;
    }

    public static EnumEntries<BrandId> getEntries() {
        return $ENTRIES;
    }

    public static BrandId valueOf(String str) {
        return (BrandId) Enum.valueOf(BrandId.class, str);
    }

    public static BrandId[] values() {
        return (BrandId[]) $VALUES.clone();
    }

    public final byte getId() {
        return this.id;
    }
}
