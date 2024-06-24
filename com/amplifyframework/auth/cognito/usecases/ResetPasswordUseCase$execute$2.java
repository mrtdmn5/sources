package com.amplifyframework.auth.cognito.usecases;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse;
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.auth.result.step.AuthNextResetPasswordStep;
import com.amplifyframework.auth.result.step.AuthResetPasswordStep;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResetPasswordUseCase.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$2", f = "ResetPasswordUseCase.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ResetPasswordUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<AuthResetPasswordResult> $onSuccess;
    final /* synthetic */ ForgotPasswordResponse $response;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordUseCase$execute$2(Consumer<AuthResetPasswordResult> consumer, ForgotPasswordResponse forgotPasswordResponse, Continuation<? super ResetPasswordUseCase$execute$2> continuation) {
        super(2, continuation);
        this.$onSuccess = consumer;
        this.$response = forgotPasswordResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPasswordUseCase$execute$2(this.$onSuccess, this.$response, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onSuccess.accept(new AuthResetPasswordResult(false, new AuthNextResetPasswordStep(AuthResetPasswordStep.CONFIRM_RESET_PASSWORD_WITH_CODE, EmptyMap.INSTANCE, ResetPasswordUseCaseKt.toAuthCodeDeliveryDetails(this.$response.codeDeliveryDetails))));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResetPasswordUseCase$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
