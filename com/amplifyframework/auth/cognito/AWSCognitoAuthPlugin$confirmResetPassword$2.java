package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$confirmResetPassword$2", f = "AWSCognitoAuthPlugin.kt", l = {539}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin$confirmResetPassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $confirmationCode;
    final /* synthetic */ String $newPassword;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Action $onSuccess;
    final /* synthetic */ String $username;
    int label;
    final /* synthetic */ AWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthPlugin$confirmResetPassword$2(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, String str, String str2, String str3, Action action, Consumer<AuthException> consumer, Continuation<? super AWSCognitoAuthPlugin$confirmResetPassword$2> continuation) {
        super(2, continuation);
        this.this$0 = aWSCognitoAuthPlugin;
        this.$username = str;
        this.$newPassword = str2;
        this.$confirmationCode = str3;
        this.$onSuccess = action;
        this.$onError = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSCognitoAuthPlugin$confirmResetPassword$2(this.this$0, this.$username, this.$newPassword, this.$confirmationCode, this.$onSuccess, this.$onError, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthException authException;
        KotlinAuthFacadeInternal queueFacade;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                queueFacade = this.this$0.getQueueFacade();
                String str = this.$username;
                String str2 = this.$newPassword;
                String str3 = this.$confirmationCode;
                this.label = 1;
                if (queueFacade.confirmResetPassword(str, str2, str3, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.$onSuccess.call();
        } catch (Exception e) {
            Consumer<AuthException> consumer = this.$onError;
            authException = this.this$0.toAuthException(e);
            consumer.accept(authException);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSCognitoAuthPlugin$confirmResetPassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
