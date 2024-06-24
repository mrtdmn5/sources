package com.animaconnected.widget;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: VerificationCodeInput.kt */
@DebugMetadata(c = "com.animaconnected.widget.VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2", f = "VerificationCodeInput.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    public VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2(Continuation<? super VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
