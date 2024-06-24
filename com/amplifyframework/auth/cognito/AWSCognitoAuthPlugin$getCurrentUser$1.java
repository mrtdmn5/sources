package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUser;
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
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$getCurrentUser$1", f = "AWSCognitoAuthPlugin.kt", l = {712}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin$getCurrentUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<AuthUser> $onSuccess;
    int label;
    final /* synthetic */ AWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthPlugin$getCurrentUser$1(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, Consumer<AuthUser> consumer, Consumer<AuthException> consumer2, Continuation<? super AWSCognitoAuthPlugin$getCurrentUser$1> continuation) {
        super(2, continuation);
        this.this$0 = aWSCognitoAuthPlugin;
        this.$onSuccess = consumer;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSCognitoAuthPlugin$getCurrentUser$1(this.this$0, this.$onSuccess, this.$onError, continuation);
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
                this.label = 1;
                obj = queueFacade.getCurrentUser(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.$onSuccess.accept((AuthUser) obj);
        } catch (Exception e) {
            Consumer<AuthException> consumer = this.$onError;
            authException = this.this$0.toAuthException(e);
            consumer.accept(authException);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSCognitoAuthPlugin$getCurrentUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
