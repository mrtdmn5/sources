package androidx.compose.ui.graphics.colorspace;

import com.animaconnected.secondo.screens.campaigns.CampaignFragment;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.utils.animations.AnimationFinishedListener;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda3 implements DoubleFunction, AnimationFinishedListener {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda3(Object obj) {
        this.f$0 = obj;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        TransferParameters function = (TransferParameters) this.f$0;
        Intrinsics.checkNotNullParameter(function, "$function");
        double d2 = function.d;
        double d3 = function.c;
        if (d >= d2 * d3) {
            return (Math.pow(d, 1.0d / function.gamma) - function.b) / function.a;
        }
        return d / d3;
    }

    @Override // com.animaconnected.secondo.utils.animations.AnimationFinishedListener
    public final void onAnimationFinished() {
        CampaignFragment.m841$r8$lambda$ImTpqvWO84nrZKqXmYjCaaGXeI((OnDismissedListener) this.f$0);
    }
}
