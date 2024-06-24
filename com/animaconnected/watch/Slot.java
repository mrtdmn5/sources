package com.animaconnected.watch;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Slot.kt */
/* loaded from: classes3.dex */
public final class Slot {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Slot[] $VALUES;
    public static final Slot BottomPusher;
    public static final Companion Companion;
    public static final Slot Display;
    public static final Slot MagicKey;
    public static final Slot MainComplication;
    public static final Slot MainComplicationDouble;
    public static final Slot SubComplication1;
    public static final Slot SubComplication2;
    public static final Slot TopPusher;
    private static final Slot[] all;
    private static final Slot[] complications;
    private static final Slot[] mainComplications;
    private static final Slot[] pushers;
    private static final Slot[] subComplications;
    private final int id;
    public static final Slot NotInitialized = new Slot("NotInitialized", 0, Integer.MIN_VALUE);
    public static final Slot Unknown = new Slot("Unknown", 1, 0);

    /* compiled from: Slot.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Slot[] getAll() {
            return Slot.all;
        }

        public final Slot[] getComplications() {
            return Slot.complications;
        }

        public final Slot[] getMainComplications() {
            return Slot.mainComplications;
        }

        public final Slot[] getPushers() {
            return Slot.pushers;
        }

        public final Slot[] getSubComplications() {
            return Slot.subComplications;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Slot[] $values() {
        return new Slot[]{NotInitialized, Unknown, SubComplication1, MainComplication, TopPusher, BottomPusher, SubComplication2, MainComplicationDouble, MagicKey, Display};
    }

    static {
        Slot slot = new Slot("SubComplication1", 2, 2);
        SubComplication1 = slot;
        Slot slot2 = new Slot("MainComplication", 3, 3);
        MainComplication = slot2;
        Slot slot3 = new Slot("TopPusher", 4, 4);
        TopPusher = slot3;
        Slot slot4 = new Slot("BottomPusher", 5, 5);
        BottomPusher = slot4;
        Slot slot5 = new Slot("SubComplication2", 6, 6);
        SubComplication2 = slot5;
        Slot slot6 = new Slot("MainComplicationDouble", 7, 7);
        MainComplicationDouble = slot6;
        MagicKey = new Slot("MagicKey", 8, 8);
        Display = new Slot("Display", 9, 9);
        Slot[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        Slot[] slotArr = {slot3, slot4};
        pushers = slotArr;
        Slot[] slotArr2 = {slot, slot5};
        subComplications = slotArr2;
        Slot[] slotArr3 = {slot2, slot6};
        mainComplications = slotArr3;
        Slot[] slotArr4 = (Slot[]) ArraysKt___ArraysJvmKt.plus((Object[]) slotArr3, (Object[]) slotArr2);
        complications = slotArr4;
        all = (Slot[]) ArraysKt___ArraysJvmKt.plus((Object[]) slotArr, (Object[]) slotArr4);
    }

    private Slot(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<Slot> getEntries() {
        return $ENTRIES;
    }

    public static Slot valueOf(String str) {
        return (Slot) Enum.valueOf(Slot.class, str);
    }

    public static Slot[] values() {
        return (Slot[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
