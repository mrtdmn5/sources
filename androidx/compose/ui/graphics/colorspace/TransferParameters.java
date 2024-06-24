package androidx.compose.ui.graphics.colorspace;

import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: TransferParameters.kt */
/* loaded from: classes.dex */
public final class TransferParameters {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public final double gamma;

    public /* synthetic */ TransferParameters(double d, double d2, double d3, double d4, double d5) {
        this(d, d2, d3, d4, d5, 0.0d, 0.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        if (Double.compare(this.gamma, transferParameters.gamma) == 0 && Double.compare(this.a, transferParameters.a) == 0 && Double.compare(this.b, transferParameters.b) == 0 && Double.compare(this.c, transferParameters.c) == 0 && Double.compare(this.d, transferParameters.d) == 0 && Double.compare(this.e, transferParameters.e) == 0 && Double.compare(this.f, transferParameters.f) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Double.hashCode(this.f) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.e, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.d, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.c, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.b, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.a, Double.hashCode(this.gamma) * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:            if ((r2 == 0.0d) == false) goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:            if ((r2 == 0.0d) != false) goto L58;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransferParameters(double r2, double r4, double r6, double r8, double r10, double r12, double r14) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }
}
