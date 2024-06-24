package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda3(Context context, String str, String str2) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = str2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LottieCompositionFactory.fromAssetSync(this.f$0, this.f$1, this.f$2);
    }
}
