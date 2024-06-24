package kotlin.random;

import java.io.Serializable;

/* compiled from: XorWowRandom.kt */
/* loaded from: classes.dex */
public final class XorWowRandom extends Random implements Serializable {
    public int addend;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public XorWowRandom(int r4, int r5) {
        boolean z;
        int r0 = ~r4;
        this.x = r4;
        this.y = r5;
        this.z = 0;
        this.w = 0;
        this.v = r0;
        this.addend = (r4 << 10) ^ (r5 >>> 4);
        if ((r4 | r5 | 0 | 0 | r0) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            for (int r2 = 0; r2 < 64; r2++) {
                nextInt();
            }
            return;
        }
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    @Override // kotlin.random.Random
    public final int nextBits(int r3) {
        return ((-r3) >> 31) & (nextInt() >>> (32 - r3));
    }

    @Override // kotlin.random.Random
    public final int nextInt() {
        int r0 = this.x;
        int r02 = r0 ^ (r0 >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int r1 = this.v;
        this.w = r1;
        int r03 = ((r02 ^ (r02 << 1)) ^ r1) ^ (r1 << 4);
        this.v = r03;
        int r12 = this.addend + 362437;
        this.addend = r12;
        return r03 + r12;
    }
}
