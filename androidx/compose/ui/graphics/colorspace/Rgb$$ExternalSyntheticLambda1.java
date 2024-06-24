package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda1 implements DoubleFunction {
    public final /* synthetic */ Rgb f$0;

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        Rgb this$0 = this.f$0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.eotfOrig.invoke(RangesKt___RangesKt.coerceIn(d, this$0.min, this$0.max));
    }
}
