package com.amplifyframework.auth.cognito.usecases;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResetPasswordUseCase.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase", f = "ResetPasswordUseCase.kt", l = {53, 70, 83}, m = "execute")
/* loaded from: classes.dex */
public final class ResetPasswordUseCase$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResetPasswordUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordUseCase$execute$1(ResetPasswordUseCase resetPasswordUseCase, Continuation<? super ResetPasswordUseCase$execute$1> continuation) {
        super(continuation);
        this.this$0 = resetPasswordUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, null, null, null, this);
    }
}
