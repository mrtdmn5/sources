package com.animaconnected.watch.provider.demo;

import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: DemoDataGenerator.kt */
/* loaded from: classes3.dex */
public final class DemoDataGeneratorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final double normal(Random random, double d, double d2) {
        float nextFloat = random.nextFloat();
        return (Math.cos(random.nextFloat() * 6.283185307179586d) * ((float) Math.sqrt((-2) * ((float) Math.log(nextFloat)))) * d2) + d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int normalClampedInt(Random random, IntRange intRange) {
        int r0 = intRange.last;
        int r1 = intRange.first;
        return RangesKt___RangesKt.coerceIn((int) (normal(random, (r1 + r0) / 2.0d, (r0 - r1) / 2.0d) + 0.5d), intRange);
    }
}
