package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessIndex.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FitnessIndexCategory[] $VALUES;
    public static final Companion Companion;
    public static final FitnessIndexCategory POOR = new FitnessIndexCategory("POOR", 0);
    public static final FitnessIndexCategory FAIR = new FitnessIndexCategory("FAIR", 1);
    public static final FitnessIndexCategory GOOD = new FitnessIndexCategory("GOOD", 2);
    public static final FitnessIndexCategory EXCELLENT = new FitnessIndexCategory("EXCELLENT", 3);
    public static final FitnessIndexCategory SUPERIOR = new FitnessIndexCategory("SUPERIOR", 4);

    /* compiled from: FitnessIndex.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int max(FitnessProvider.Profile profile, Instant instant) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            return FitnessIndexKt.getRange(FitnessIndexCategory.SUPERIOR, profile, instant).last;
        }

        public final int min(FitnessProvider.Profile profile, Instant instant) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            return FitnessIndexKt.getRange(FitnessIndexCategory.POOR, profile, instant).first;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FitnessIndexCategory[] $values() {
        return new FitnessIndexCategory[]{POOR, FAIR, GOOD, EXCELLENT, SUPERIOR};
    }

    static {
        FitnessIndexCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FitnessIndexCategory(String str, int r2) {
    }

    public static EnumEntries<FitnessIndexCategory> getEntries() {
        return $ENTRIES;
    }

    public static FitnessIndexCategory valueOf(String str) {
        return (FitnessIndexCategory) Enum.valueOf(FitnessIndexCategory.class, str);
    }

    public static FitnessIndexCategory[] values() {
        return (FitnessIndexCategory[]) $VALUES.clone();
    }
}
