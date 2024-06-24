package com.animaconnected.watch.workout;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: FitnessIndex.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexData {
    public static final Companion Companion = new Companion(null);
    private final FitnessIndexCategory category;
    private final int value;

    /* compiled from: FitnessIndex.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FitnessIndexData fromValue(int r5, FitnessProvider.Profile profile) {
            boolean z;
            boolean z2;
            boolean z3;
            FitnessIndexCategory fitnessIndexCategory;
            Intrinsics.checkNotNullParameter(profile, "profile");
            EnumEntries<FitnessIndexCategory> entries = FitnessIndexCategory.getEntries();
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
            Iterator<E> it = entries.iterator();
            while (it.hasNext()) {
                arrayList.add(FitnessIndexKt.getRange((FitnessIndexCategory) it.next(), profile, DateTimeUtilsKt.now()));
            }
            int coerceIn = RangesKt___RangesKt.coerceIn(r5, ((IntRange) CollectionsKt___CollectionsKt.first((List) arrayList)).first, ((IntRange) CollectionsKt___CollectionsKt.last(arrayList)).last);
            boolean z4 = false;
            IntRange intRange = (IntRange) arrayList.get(0);
            int r2 = intRange.first;
            if (coerceIn <= intRange.last && r2 <= coerceIn) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                fitnessIndexCategory = FitnessIndexCategory.POOR;
            } else {
                IntRange intRange2 = (IntRange) arrayList.get(1);
                int r22 = intRange2.first;
                if (coerceIn <= intRange2.last && r22 <= coerceIn) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    fitnessIndexCategory = FitnessIndexCategory.FAIR;
                } else {
                    IntRange intRange3 = (IntRange) arrayList.get(2);
                    int r23 = intRange3.first;
                    if (coerceIn <= intRange3.last && r23 <= coerceIn) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        fitnessIndexCategory = FitnessIndexCategory.GOOD;
                    } else {
                        IntRange intRange4 = (IntRange) arrayList.get(3);
                        int r1 = intRange4.first;
                        if (coerceIn <= intRange4.last && r1 <= coerceIn) {
                            z4 = true;
                        }
                        if (z4) {
                            fitnessIndexCategory = FitnessIndexCategory.EXCELLENT;
                        } else {
                            fitnessIndexCategory = FitnessIndexCategory.SUPERIOR;
                        }
                    }
                }
            }
            return new FitnessIndexData(coerceIn, fitnessIndexCategory);
        }

        private Companion() {
        }
    }

    public FitnessIndexData(int r2, FitnessIndexCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.value = r2;
        this.category = category;
    }

    public static /* synthetic */ FitnessIndexData copy$default(FitnessIndexData fitnessIndexData, int r1, FitnessIndexCategory fitnessIndexCategory, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = fitnessIndexData.value;
        }
        if ((r3 & 2) != 0) {
            fitnessIndexCategory = fitnessIndexData.category;
        }
        return fitnessIndexData.copy(r1, fitnessIndexCategory);
    }

    public final int component1() {
        return this.value;
    }

    public final FitnessIndexCategory component2() {
        return this.category;
    }

    public final FitnessIndexData copy(int r2, FitnessIndexCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return new FitnessIndexData(r2, category);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessIndexData)) {
            return false;
        }
        FitnessIndexData fitnessIndexData = (FitnessIndexData) obj;
        if (this.value == fitnessIndexData.value && this.category == fitnessIndexData.category) {
            return true;
        }
        return false;
    }

    public final FitnessIndexCategory getCategory() {
        return this.category;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.category.hashCode() + (Integer.hashCode(this.value) * 31);
    }

    public String toString() {
        return "FitnessIndexData(value=" + this.value + ", category=" + this.category + ')';
    }
}
