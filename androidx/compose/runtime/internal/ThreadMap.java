package androidx.compose.runtime.internal;

/* compiled from: ThreadMap.kt */
/* loaded from: classes.dex */
public final class ThreadMap {
    public final long[] keys;
    public final int size;
    public final Object[] values;

    public ThreadMap(int r1, long[] jArr, Object[] objArr) {
        this.size = r1;
        this.keys = jArr;
        this.values = objArr;
    }

    public final int find(long j) {
        int r0 = this.size - 1;
        if (r0 == -1) {
            return -1;
        }
        long[] jArr = this.keys;
        int r3 = 0;
        if (r0 != 0) {
            while (r3 <= r0) {
                int r1 = (r3 + r0) >>> 1;
                long j2 = jArr[r1] - j;
                if (j2 < 0) {
                    r3 = r1 + 1;
                } else if (j2 > 0) {
                    r0 = r1 - 1;
                } else {
                    return r1;
                }
            }
            return -(r3 + 1);
        }
        long j3 = jArr[0];
        if (j3 == j) {
            return 0;
        }
        if (j3 <= j) {
            return -1;
        }
        return -2;
    }

    public final ThreadMap newWith(long j, Object obj) {
        long[] jArr;
        int r7;
        Object[] objArr = this.values;
        int length = objArr.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        while (true) {
            boolean z = true;
            if (r3 >= length) {
                break;
            }
            if (objArr[r3] == null) {
                z = false;
            }
            if (z) {
                r4++;
            }
            r3++;
        }
        int r42 = r4 + 1;
        long[] jArr2 = new long[r42];
        Object[] objArr2 = new Object[r42];
        if (r42 > 1) {
            int r5 = 0;
            while (true) {
                jArr = this.keys;
                r7 = this.size;
                if (r2 >= r42 || r5 >= r7) {
                    break;
                }
                long j2 = jArr[r5];
                Object obj2 = objArr[r5];
                if (j2 > j) {
                    jArr2[r2] = j;
                    objArr2[r2] = obj;
                    r2++;
                    break;
                }
                if (obj2 != null) {
                    jArr2[r2] = j2;
                    objArr2[r2] = obj2;
                    r2++;
                }
                r5++;
            }
            if (r5 == r7) {
                int r0 = r42 - 1;
                jArr2[r0] = j;
                objArr2[r0] = obj;
            } else {
                while (r2 < r42) {
                    long j3 = jArr[r5];
                    Object obj3 = objArr[r5];
                    if (obj3 != null) {
                        jArr2[r2] = j3;
                        objArr2[r2] = obj3;
                        r2++;
                    }
                    r5++;
                }
            }
        } else {
            jArr2[0] = j;
            objArr2[0] = obj;
        }
        return new ThreadMap(r42, jArr2, objArr2);
    }
}
