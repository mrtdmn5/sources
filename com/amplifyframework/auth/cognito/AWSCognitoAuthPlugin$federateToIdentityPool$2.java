package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.options.FederateToIdentityPoolOptions;
import com.amplifyframework.auth.cognito.result.FederateToIdentityPoolResult;
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
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$federateToIdentityPool$2", f = "AWSCognitoAuthPlugin.kt", l = {803}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin$federateToIdentityPool$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthProvider $authProvider;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<FederateToIdentityPoolResult> $onSuccess;
    final /* synthetic */ FederateToIdentityPoolOptions $options;
    final /* synthetic */ String $providerToken;
    int label;
    final /* synthetic */ AWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthPlugin$federateToIdentityPool$2(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, String str, AuthProvider authProvider, FederateToIdentityPoolOptions federateToIdentityPoolOptions, Consumer<FederateToIdentityPoolResult> consumer, Consumer<AuthException> consumer2, Continuation<? super AWSCognitoAuthPlugin$federateToIdentityPool$2> continuation) {
        super(2, continuation);
        this.this$0 = aWSCognitoAuthPlugin;
        this.$providerToken = str;
        this.$authProvider = authProvider;
        this.$options = federateToIdentityPoolOptions;
        this.$onSuccess = consumer;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSCognitoAuthPlugin$federateToIdentityPool$2(this.this$0, this.$providerToken, this.$authProvider, this.$options, this.$onSuccess, this.$onError, continuation);
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
                String str = this.$providerToken;
                AuthProvider authProvider = this.$authProvider;
                FederateToIdentityPoolOptions federateToIdentityPoolOptions = this.$options;
                this.label = 1;
                obj = queueFacade.federateToIdentityPool(str, authProvider, federateToIdentityPoolOptions, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.$onSuccess.accept((FederateToIdentityPoolResult) obj);
        } catch (Exception e) {
            Consumer<AuthException> consumer = this.$onError;
            authException = this.this$0.toAuthException(e);
            consumer.accept(authException);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSCognitoAuthPlugin$federateToIdentityPool$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
