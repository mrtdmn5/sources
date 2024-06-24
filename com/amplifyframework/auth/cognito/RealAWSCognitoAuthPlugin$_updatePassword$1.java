package com.amplifyframework.auth.cognito;

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordRequest;
import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_updatePassword$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1284, 1292}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$_updatePassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newPassword;
    final /* synthetic */ String $oldPassword;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Action $onSuccess;
    int label;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$_updatePassword$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Action action, Consumer<AuthException> consumer, String str, String str2, Continuation<? super RealAWSCognitoAuthPlugin$_updatePassword$1> continuation) {
        super(2, continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
        this.$onSuccess = action;
        this.$onError = consumer;
        this.$oldPassword = str;
        this.$newPassword = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealAWSCognitoAuthPlugin$_updatePassword$1(this.this$0, this.$onSuccess, this.$onError, this.$oldPassword, this.$newPassword, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthEnvironment authEnvironment;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
        } catch (Exception e) {
            this.$onError.accept(CognitoAuthExceptionConverter.Companion.lookup(e, e.toString()));
        }
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.$onSuccess.call();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
            this.label = 1;
            obj = realAWSCognitoAuthPlugin.getSession(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        final AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult = ((AWSCognitoAuthSession) obj).getUserPoolTokensResult();
        final String str = this.$oldPassword;
        final String str2 = this.$newPassword;
        Function1<ChangePasswordRequest.Builder, Unit> function1 = new Function1<ChangePasswordRequest.Builder, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_updatePassword$1$changePasswordRequest$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChangePasswordRequest.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChangePasswordRequest.Builder invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                invoke.previousPassword = str;
                invoke.proposedPassword = str2;
                AWSCognitoUserPoolTokens value = userPoolTokensResult.getValue();
                invoke.accessToken = value != null ? value.getAccessToken() : null;
            }
        };
        ChangePasswordRequest.Builder builder = new ChangePasswordRequest.Builder();
        function1.invoke(builder);
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(builder);
        authEnvironment = this.this$0.authEnvironment;
        CognitoIdentityProviderClient cognitoIdentityProviderClient = authEnvironment.getCognitoAuthService().getCognitoIdentityProviderClient();
        if (cognitoIdentityProviderClient != null) {
            this.label = 2;
            obj = cognitoIdentityProviderClient.changePassword(changePasswordRequest, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$onSuccess.call();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RealAWSCognitoAuthPlugin$_updatePassword$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
