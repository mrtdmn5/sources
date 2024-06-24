package com.animaconnected.secondo.provider.lottie;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Lottie.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.lottie.LottieKt", f = "Lottie.kt", l = {79}, m = "loadLottieAnimation")
/* loaded from: classes3.dex */
public final class LottieKt$loadLottieAnimation$3 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public LottieKt$loadLottieAnimation$3(Continuation<? super LottieKt$loadLottieAnimation$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LottieKt.loadLottieAnimation((Context) null, (LottieFile[]) null, this);
    }
}
