package kotlinx.datetime.internal;

/* compiled from: math.kt */
/* loaded from: classes4.dex */
public final class MathKt {
    public static final int clampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x002e, code lost:            if ((r13 / r25) != r23) goto L11;     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlinx.datetime.internal.DivRemResult multiplyAndDivide(long r23, long r25, long r27) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.MathKt.multiplyAndDivide(long, long, long):kotlinx.datetime.internal.DivRemResult");
    }
}
