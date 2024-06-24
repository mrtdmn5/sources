package com.amplifyframework.auth.cognito.usecases;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResetPasswordUseCase.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$3", f = "ResetPasswordUseCase.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ResetPasswordUseCase$execute$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $ex;
    final /* synthetic */ Consumer<AuthException> $onError;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordUseCase$execute$3(Consumer<AuthException> consumer, Exception exc, Continuation<? super ResetPasswordUseCase$execute$3> continuation) {
        super(2, continuation);
        this.$onError = consumer;
        this.$ex = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPasswordUseCase$execute$3(this.$onError, this.$ex, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onError.accept(CognitoAuthExceptionConverter.Companion.lookup(this.$ex, AmplifyException.REPORT_BUG_TO_AWS_SUGGESTION));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResetPasswordUseCase$execute$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
