package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessIndex.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexAgeGroup {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FitnessIndexAgeGroup[] $VALUES;
    public static final Companion Companion;
    public static final FitnessIndexAgeGroup Twenties = new FitnessIndexAgeGroup("Twenties", 0);
    public static final FitnessIndexAgeGroup Thirties = new FitnessIndexAgeGroup("Thirties", 1);
    public static final FitnessIndexAgeGroup Fourties = new FitnessIndexAgeGroup("Fourties", 2);
    public static final FitnessIndexAgeGroup Fifties = new FitnessIndexAgeGroup("Fifties", 3);
    public static final FitnessIndexAgeGroup Sixties = new FitnessIndexAgeGroup("Sixties", 4);
    public static final FitnessIndexAgeGroup Seventies = new FitnessIndexAgeGroup("Seventies", 5);

    /* compiled from: FitnessIndex.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FitnessIndexAgeGroup fromYears(int r5) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = true;
            if (r5 >= 0 && r5 < 30) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return FitnessIndexAgeGroup.Twenties;
            }
            if (30 <= r5 && r5 < 40) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return FitnessIndexAgeGroup.Thirties;
            }
            if (40 <= r5 && r5 < 50) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return FitnessIndexAgeGroup.Fourties;
            }
            if (50 <= r5 && r5 < 60) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                return FitnessIndexAgeGroup.Fifties;
            }
            if (60 > r5 || r5 >= 70) {
                z5 = false;
            }
            if (z5) {
                return FitnessIndexAgeGroup.Sixties;
            }
            return FitnessIndexAgeGroup.Seventies;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FitnessIndexAgeGroup[] $values() {
        return new FitnessIndexAgeGroup[]{Twenties, Thirties, Fourties, Fifties, Sixties, Seventies};
    }

    static {
        FitnessIndexAgeGroup[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FitnessIndexAgeGroup(String str, int r2) {
    }

    public static EnumEntries<FitnessIndexAgeGroup> getEntries() {
        return $ENTRIES;
    }

    public static FitnessIndexAgeGroup valueOf(String str) {
        return (FitnessIndexAgeGroup) Enum.valueOf(FitnessIndexAgeGroup.class, str);
    }

    public static FitnessIndexAgeGroup[] values() {
        return (FitnessIndexAgeGroup[]) $VALUES.clone();
    }
}
