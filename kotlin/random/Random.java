package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.random.jdk8.PlatformThreadLocalRandom;

/* compiled from: Random.kt */
/* loaded from: classes.dex */
public abstract class Random {
    public static final Default Default = new Default(0);
    public static final AbstractPlatformRandom defaultRandom;

    static {
        AbstractPlatformRandom fallbackThreadLocalRandom;
        boolean z = false;
        PlatformImplementationsKt.IMPLEMENTATIONS.getClass();
        Integer num = JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion;
        if (num == null || num.intValue() >= 34) {
            z = true;
        }
        if (z) {
            fallbackThreadLocalRandom = new PlatformThreadLocalRandom();
        } else {
            fallbackThreadLocalRandom = new FallbackThreadLocalRandom();
        }
        defaultRandom = fallbackThreadLocalRandom;
    }

    public abstract int nextBits(int r1);

    public double nextDouble() {
        return ((nextBits(26) << 27) + nextBits(27)) / 9.007199254740992E15d;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double nextDouble$1(double r9) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto La
            r2 = r3
            goto Lb
        La:
            r2 = r4
        Lb:
            if (r2 == 0) goto L56
            double r5 = r9 - r0
            boolean r2 = java.lang.Double.isInfinite(r5)
            if (r2 == 0) goto L45
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 != 0) goto L23
            boolean r2 = java.lang.Double.isNaN(r0)
            if (r2 != 0) goto L23
            r2 = r3
            goto L24
        L23:
            r2 = r4
        L24:
            if (r2 == 0) goto L45
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L33
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L33
            goto L34
        L33:
            r3 = r4
        L34:
            if (r3 == 0) goto L45
            double r2 = r8.nextDouble()
            r4 = 2
            double r4 = (double) r4
            double r6 = r9 / r4
            double r4 = r0 / r4
            double r6 = r6 - r4
            double r6 = r6 * r2
            double r0 = r0 + r6
            double r0 = r0 + r6
            goto L4b
        L45:
            double r2 = r8.nextDouble()
            double r2 = r2 * r5
            double r0 = r0 + r2
        L4b:
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 < 0) goto L55
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r0 = java.lang.Math.nextAfter(r9, r0)
        L55:
            return r0
        L56:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            java.lang.String r9 = kotlin.random.RandomKt.boundsErrorMessage(r0, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble$1(double):double");
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public abstract int nextInt();

    public int nextInt(int r2) {
        return nextInt(0, r2);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public long nextLong$1(long j) {
        boolean z;
        long nextLong;
        boolean z2;
        long nextLong2;
        long j2;
        long j3;
        int nextInt;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            long j4 = j - 0;
            if (j4 > 0) {
                if (((-j4) & j4) == j4) {
                    int r10 = (int) j4;
                    int r2 = (int) (j4 >>> 32);
                    if (r10 != 0) {
                        nextInt = nextBits(31 - Integer.numberOfLeadingZeros(r10));
                    } else if (r2 == 1) {
                        nextInt = nextInt();
                    } else {
                        j3 = (nextBits(31 - Integer.numberOfLeadingZeros(r2)) << 32) + (nextInt() & 4294967295L);
                        return 0 + j3;
                    }
                    j3 = nextInt & 4294967295L;
                    return 0 + j3;
                }
                do {
                    nextLong2 = nextLong() >>> 1;
                    j2 = nextLong2 % j4;
                } while ((j4 - 1) + (nextLong2 - j2) < 0);
                j3 = j2;
                return 0 + j3;
            }
            do {
                nextLong = nextLong();
                if (0 <= nextLong && nextLong < j) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } while (!z2);
            return nextLong;
        }
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(0L, Long.valueOf(j)).toString());
    }

    /* compiled from: Random.kt */
    /* loaded from: classes.dex */
    public static final class Default extends Random implements Serializable {
        public Default(int r1) {
        }

        @Override // kotlin.random.Random
        public final int nextBits(int r2) {
            return Random.defaultRandom.nextBits(r2);
        }

        @Override // kotlin.random.Random
        public final double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public final double nextDouble$1(double d) {
            return Random.defaultRandom.nextDouble$1(d);
        }

        @Override // kotlin.random.Random
        public final float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public final int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public final long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public final long nextLong$1(long j) {
            return Random.defaultRandom.nextLong$1(j);
        }

        @Override // kotlin.random.Random
        public final double nextDouble(double d) {
            return Random.defaultRandom.nextDouble(d);
        }

        @Override // kotlin.random.Random
        public final int nextInt(int r2) {
            return Random.defaultRandom.nextInt(r2);
        }

        @Override // kotlin.random.Random
        public final long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        public final int nextInt(int r2, int r3) {
            return Random.defaultRandom.nextInt(r2, r3);
        }
    }

    public double nextDouble(double d) {
        return nextDouble$1(d);
    }

    public int nextInt(int r5, int r6) {
        int nextInt;
        int r0;
        int r62;
        int nextInt2;
        if (!(r6 > r5)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(Integer.valueOf(r5), Integer.valueOf(r6)).toString());
        }
        int r2 = r6 - r5;
        if (r2 > 0 || r2 == Integer.MIN_VALUE) {
            if (((-r2) & r2) == r2) {
                r62 = nextBits(31 - Integer.numberOfLeadingZeros(r2));
                return r5 + r62;
            }
            do {
                nextInt = nextInt() >>> 1;
                r0 = nextInt % r2;
            } while ((r2 - 1) + (nextInt - r0) < 0);
            r62 = r0;
            return r5 + r62;
        }
        do {
            nextInt2 = nextInt();
        } while (!(r5 <= nextInt2 && nextInt2 < r6));
        return nextInt2;
    }

    public long nextLong(long j) {
        return nextLong$1(j);
    }
}
