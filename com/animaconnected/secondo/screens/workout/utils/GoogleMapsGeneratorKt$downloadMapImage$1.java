package com.animaconnected.secondo.screens.workout.utils;

import com.animaconnected.secondo.R;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GoogleMapsGenerator.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt", f = "GoogleMapsGenerator.kt", l = {R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 279, 280}, m = "downloadMapImage-CNmA0Ec")
/* loaded from: classes3.dex */
public final class GoogleMapsGeneratorKt$downloadMapImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public GoogleMapsGeneratorKt$downloadMapImage$1(Continuation<? super GoogleMapsGeneratorKt$downloadMapImage$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1032downloadMapImageCNmA0Ec;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1032downloadMapImageCNmA0Ec = GoogleMapsGeneratorKt.m1032downloadMapImageCNmA0Ec(0L, null, 0L, 0, 0, this);
        if (m1032downloadMapImageCNmA0Ec == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m1032downloadMapImageCNmA0Ec;
        }
        return new Result(m1032downloadMapImageCNmA0Ec);
    }
}
