package kotlin.random;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 implStorage = new FallbackThreadLocalRandom$implStorage$1();

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        java.util.Random random = this.implStorage.get();
        Intrinsics.checkNotNullExpressionValue(random, "get(...)");
        return random;
    }
}
