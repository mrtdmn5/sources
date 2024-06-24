package androidx.compose.ui.graphics.colorspace;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ColorSpaces$$ExternalSyntheticLambda1 implements DoubleFunction {
    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        double d2;
        double d3;
        if (d < 0.0d) {
            d2 = -d;
        } else {
            d2 = d;
        }
        if (d2 >= 0.04045d) {
            d3 = Math.pow((0.9478672985781991d * d2) + 0.05213270142180095d, 2.4d);
        } else {
            d3 = d2 * 0.07739938080495357d;
        }
        return Math.copySign(d3, d);
    }
}
