package com.animaconnected.secondo.screens.settings.profile;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: ProfileWeightDialog.kt */
/* loaded from: classes3.dex */
public final class WeightData {
    public static final int $stable = 8;

    /* renamed from: default, reason: not valid java name */
    private final int f99default;
    private final IntRange range;
    private final Function1<Integer, Integer> toGram;
    private final Function1<Integer, Integer> toWeight;
    private final int unitStringRes;

    /* JADX WARN: Multi-variable type inference failed */
    public WeightData(IntRange range, int r3, int r4, Function1<? super Integer, Integer> toGram, Function1<? super Integer, Integer> toWeight) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(toGram, "toGram");
        Intrinsics.checkNotNullParameter(toWeight, "toWeight");
        this.range = range;
        this.f99default = r3;
        this.unitStringRes = r4;
        this.toGram = toGram;
        this.toWeight = toWeight;
    }

    public static /* synthetic */ WeightData copy$default(WeightData weightData, IntRange intRange, int r5, int r6, Function1 function1, Function1 function12, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            intRange = weightData.range;
        }
        if ((r9 & 2) != 0) {
            r5 = weightData.f99default;
        }
        int r10 = r5;
        if ((r9 & 4) != 0) {
            r6 = weightData.unitStringRes;
        }
        int r0 = r6;
        if ((r9 & 8) != 0) {
            function1 = weightData.toGram;
        }
        Function1 function13 = function1;
        if ((r9 & 16) != 0) {
            function12 = weightData.toWeight;
        }
        return weightData.copy(intRange, r10, r0, function13, function12);
    }

    public final IntRange component1() {
        return this.range;
    }

    public final int component2() {
        return this.f99default;
    }

    public final int component3() {
        return this.unitStringRes;
    }

    public final Function1<Integer, Integer> component4() {
        return this.toGram;
    }

    public final Function1<Integer, Integer> component5() {
        return this.toWeight;
    }

    public final WeightData copy(IntRange range, int r9, int r10, Function1<? super Integer, Integer> toGram, Function1<? super Integer, Integer> toWeight) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(toGram, "toGram");
        Intrinsics.checkNotNullParameter(toWeight, "toWeight");
        return new WeightData(range, r9, r10, toGram, toWeight);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeightData)) {
            return false;
        }
        WeightData weightData = (WeightData) obj;
        if (Intrinsics.areEqual(this.range, weightData.range) && this.f99default == weightData.f99default && this.unitStringRes == weightData.unitStringRes && Intrinsics.areEqual(this.toGram, weightData.toGram) && Intrinsics.areEqual(this.toWeight, weightData.toWeight)) {
            return true;
        }
        return false;
    }

    public final int getDefault() {
        return this.f99default;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final Function1<Integer, Integer> getToGram() {
        return this.toGram;
    }

    public final Function1<Integer, Integer> getToWeight() {
        return this.toWeight;
    }

    public final int getUnitStringRes() {
        return this.unitStringRes;
    }

    public int hashCode() {
        return this.toWeight.hashCode() + ((this.toGram.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.unitStringRes, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.f99default, this.range.hashCode() * 31, 31), 31)) * 31);
    }

    public String toString() {
        return "WeightData(range=" + this.range + ", default=" + this.f99default + ", unitStringRes=" + this.unitStringRes + ", toGram=" + this.toGram + ", toWeight=" + this.toWeight + ')';
    }
}
