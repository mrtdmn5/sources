package androidx.compose.ui.graphics.colorspace;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ColorSpaces$$ExternalSyntheticLambda0 implements DoubleFunction {
    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        double d2;
        double d3;
        if (d < 0.0d) {
            d2 = -d;
        } else {
            d2 = d;
        }
        if (d2 >= 0.0031308049535603718d) {
            d2 = Math.pow(d2, 0.4166666666666667d) - 0.05213270142180095d;
            d3 = 0.9478672985781991d;
        } else {
            d3 = 0.07739938080495357d;
        }
        return Math.copySign(d2 / d3, d);
    }
}
