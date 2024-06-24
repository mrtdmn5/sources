package com.airbnb.lottie.compose;

import com.animaconnected.secondo.R;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: rememberLottieComposition.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt", f = "rememberLottieComposition.kt", l = {125, 126, R.styleable.AppTheme_statusTextH5}, m = "lottieComposition")
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt$lottieComposition$1 extends ContinuationImpl {
    public Object L$0;
    public String L$1;
    public String L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RememberLottieCompositionKt.access$lottieComposition(null, null, null, null, null, null, this);
    }
}
