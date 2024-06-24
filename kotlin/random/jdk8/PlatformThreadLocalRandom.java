package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.AbstractPlatformRandom
    public final Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(current, "current(...)");
        return current;
    }

    @Override // kotlin.random.Random
    public final double nextDouble(double d) {
        return ThreadLocalRandom.current().nextDouble(d);
    }

    @Override // kotlin.random.Random
    public final int nextInt(int r2, int r3) {
        return ThreadLocalRandom.current().nextInt(r2, r3);
    }

    @Override // kotlin.random.Random
    public final long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // kotlin.random.Random
    public final long nextLong$1(long j) {
        return ThreadLocalRandom.current().nextLong(0L, j);
    }
}
