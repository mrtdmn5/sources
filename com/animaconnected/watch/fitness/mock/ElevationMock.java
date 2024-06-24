package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ElevationMock.kt */
/* loaded from: classes3.dex */
public final class ElevationMock {
    private int baseElevation;
    private int elevationRange;
    private int initialElevation;
    private int maxDelta;
    private int minDelta;
    private Function0<Integer> nextElevationValue;
    private final Random random;

    public ElevationMock() {
        XorWowRandom xorWowRandom = new XorWowRandom(42, 0);
        this.random = xorWowRandom;
        this.baseElevation = 1000;
        this.elevationRange = 200;
        this.minDelta = -50;
        this.maxDelta = 50;
        this.initialElevation = xorWowRandom.nextInt(0, 1000) + this.elevationRange;
        this.nextElevationValue = new Function0<Integer>() { // from class: com.animaconnected.watch.fitness.mock.ElevationMock$nextElevationValue$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int r1;
                Random random;
                int r3;
                int r4;
                int r0;
                ElevationMock elevationMock = ElevationMock.this;
                r1 = elevationMock.initialElevation;
                random = ElevationMock.this.random;
                r3 = ElevationMock.this.minDelta;
                r4 = ElevationMock.this.maxDelta;
                elevationMock.initialElevation = RangesKt___RangesKt.coerceIn(random.nextInt(r3, r4), 0, 9000000) + r1;
                r0 = ElevationMock.this.initialElevation;
                return Integer.valueOf(r0);
            }
        };
    }

    public final List<PointEntry> generateElevationData(int r9) {
        boolean z = false;
        IntRange until = RangesKt___RangesKt.until(0, r9);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new PointEntry(new Known(this.nextElevationValue.invoke().intValue(), z, 2, (DefaultConstructorMarker) null), String.valueOf(nextInt), String.valueOf(nextInt), false));
        }
        return arrayList;
    }

    public final int getBaseElevation() {
        return this.baseElevation;
    }

    public final int getElevationRange() {
        return this.elevationRange;
    }

    public final Function0<Integer> getNextElevationValue() {
        return this.nextElevationValue;
    }

    public final void setBaseElevation(int r2) {
        this.baseElevation = r2;
        this.initialElevation = this.random.nextInt(r2) + this.elevationRange;
    }

    public final void setElevationRange(int r3) {
        this.elevationRange = r3;
        this.initialElevation = this.random.nextInt(this.baseElevation) + r3;
    }

    public final void setNextElevationValue(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.nextElevationValue = function0;
    }
}
