package com.animaconnected.watch;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Slot.kt */
/* loaded from: classes3.dex */
public final class GroupLayer {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GroupLayer[] $VALUES;
    private final int id;
    public static final GroupLayer Default = new GroupLayer("Default", 0, 0);
    public static final GroupLayer MezzoSecundo = new GroupLayer("MezzoSecundo", 1, 1);
    public static final GroupLayer Sonic = new GroupLayer("Sonic", 2, 2);
    public static final GroupLayer MagicKey = new GroupLayer("MagicKey", 3, 9);

    private static final /* synthetic */ GroupLayer[] $values() {
        return new GroupLayer[]{Default, MezzoSecundo, Sonic, MagicKey};
    }

    static {
        GroupLayer[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private GroupLayer(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<GroupLayer> getEntries() {
        return $ENTRIES;
    }

    public static GroupLayer valueOf(String str) {
        return (GroupLayer) Enum.valueOf(GroupLayer.class, str);
    }

    public static GroupLayer[] values() {
        return (GroupLayer[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
