package com.animaconnected.widget;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.DpSize;
import com.animaconnected.widget.ImageLoadingState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: SessionCard.kt */
@DebugMetadata(c = "com.animaconnected.widget.SessionCardKt$AllSessionCardsError$1$1$1", f = "SessionCard.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SessionCardKt$AllSessionCardsError$1$1$1 extends SuspendLambda implements Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> {
    int label;

    public SessionCardKt$AllSessionCardsError$1$1$1(Continuation<? super SessionCardKt$AllSessionCardsError$1$1$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(DpSize dpSize, Color color, Continuation<? super ImageLoadingState> continuation) {
        return m1627invokeeO5JflE(dpSize.packedValue, color.value, continuation);
    }

    /* renamed from: invoke-eO5JflE, reason: not valid java name */
    public final Object m1627invokeeO5JflE(long j, long j2, Continuation<? super ImageLoadingState> continuation) {
        return new SessionCardKt$AllSessionCardsError$1$1$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new ImageLoadingState.Error(new NullPointerException());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
