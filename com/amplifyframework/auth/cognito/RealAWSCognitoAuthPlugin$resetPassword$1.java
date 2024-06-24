package com.amplifyframework.auth.cognito;

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resetPassword$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1164, 1170}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$resetPassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appClient;
    final /* synthetic */ CognitoIdentityProviderClient $cognitoIdentityProviderClient;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<AuthResetPasswordResult> $onSuccess;
    final /* synthetic */ AuthResetPasswordOptions $options;
    final /* synthetic */ String $username;
    int label;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$resetPassword$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, String str, CognitoIdentityProviderClient cognitoIdentityProviderClient, String str2, AuthResetPasswordOptions authResetPasswordOptions, Consumer<AuthResetPasswordResult> consumer, Consumer<AuthException> consumer2, Continuation<? super RealAWSCognitoAuthPlugin$resetPassword$1> continuation) {
        super(2, continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
        this.$username = str;
        this.$cognitoIdentityProviderClient = cognitoIdentityProviderClient;
        this.$appClient = str2;
        this.$options = authResetPasswordOptions;
        this.$onSuccess = consumer;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealAWSCognitoAuthPlugin$resetPassword$1(this.this$0, this.$username, this.$cognitoIdentityProviderClient, this.$appClient, this.$options, this.$onSuccess, this.$onError, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthEnvironment authEnvironment;
        AuthEnvironment authEnvironment2;
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            authEnvironment = this.this$0.authEnvironment;
            String str2 = this.$username;
            this.label = 1;
            obj = authEnvironment.getUserContextData(str2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        String str3 = (String) obj;
        authEnvironment2 = this.this$0.authEnvironment;
        String pinpointEndpointId = authEnvironment2.getPinpointEndpointId();
        CognitoIdentityProviderClient cognitoIdentityProviderClient = this.$cognitoIdentityProviderClient;
        String str4 = this.$appClient;
        UserPoolConfiguration userPool = this.this$0.configuration.getUserPool();
        if (userPool != null) {
            str = userPool.getAppClientSecret();
        } else {
            str = null;
        }
        ResetPasswordUseCase resetPasswordUseCase = new ResetPasswordUseCase(cognitoIdentityProviderClient, str4, str);
        String str5 = this.$username;
        AuthResetPasswordOptions authResetPasswordOptions = this.$options;
        Consumer<AuthResetPasswordResult> consumer = this.$onSuccess;
        Consumer<AuthException> consumer2 = this.$onError;
        this.label = 2;
        if (resetPasswordUseCase.execute(str5, authResetPasswordOptions, str3, pinpointEndpointId, consumer, consumer2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RealAWSCognitoAuthPlugin$resetPassword$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
