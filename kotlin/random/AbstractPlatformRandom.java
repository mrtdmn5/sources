package kotlin.random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes.dex */
public abstract class AbstractPlatformRandom extends Random {
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public final int nextBits(int r3) {
        return ((-r3) >> 31) & (getImpl().nextInt() >>> (32 - r3));
    }

    @Override // kotlin.random.Random
    public final double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // kotlin.random.Random
    public final float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // kotlin.random.Random
    public final int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public final long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public final int nextInt(int r2) {
        return getImpl().nextInt(r2);
    }
}
