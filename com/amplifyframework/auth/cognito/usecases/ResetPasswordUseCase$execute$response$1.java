package com.amplifyframework.auth.cognito.usecases;

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import com.amplifyframework.auth.cognito.helpers.AuthHelper;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthResetPasswordOptions;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResetPasswordUseCase.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$response$1", f = "ResetPasswordUseCase.kt", l = {104}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ResetPasswordUseCase$execute$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ForgotPasswordResponse>, Object> {
    final /* synthetic */ String $encodedContextData;
    final /* synthetic */ AuthResetPasswordOptions $options;
    final /* synthetic */ String $pinpointEndpointId;
    final /* synthetic */ String $username;
    int label;
    final /* synthetic */ ResetPasswordUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordUseCase$execute$response$1(ResetPasswordUseCase resetPasswordUseCase, String str, AuthResetPasswordOptions authResetPasswordOptions, String str2, String str3, Continuation<? super ResetPasswordUseCase$execute$response$1> continuation) {
        super(2, continuation);
        this.this$0 = resetPasswordUseCase;
        this.$username = str;
        this.$options = authResetPasswordOptions;
        this.$encodedContextData = str2;
        this.$pinpointEndpointId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPasswordUseCase$execute$response$1(this.this$0, this.$username, this.$options, this.$encodedContextData, this.$pinpointEndpointId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CognitoIdentityProviderClient cognitoIdentityProviderClient;
        AWSCognitoAuthResetPasswordOptions aWSCognitoAuthResetPasswordOptions;
        Map<String, String> map;
        String str;
        String str2;
        String str3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            cognitoIdentityProviderClient = this.this$0.cognitoIdentityProviderClient;
            String str4 = this.$username;
            AuthResetPasswordOptions authResetPasswordOptions = this.$options;
            ResetPasswordUseCase resetPasswordUseCase = this.this$0;
            final String str5 = this.$encodedContextData;
            final String str6 = this.$pinpointEndpointId;
            ForgotPasswordRequest.Builder builder = new ForgotPasswordRequest.Builder();
            builder.username = str4;
            if (authResetPasswordOptions instanceof AWSCognitoAuthResetPasswordOptions) {
                aWSCognitoAuthResetPasswordOptions = (AWSCognitoAuthResetPasswordOptions) authResetPasswordOptions;
            } else {
                aWSCognitoAuthResetPasswordOptions = null;
            }
            if (aWSCognitoAuthResetPasswordOptions == null || (map = aWSCognitoAuthResetPasswordOptions.getMetadata()) == null) {
                map = EmptyMap.INSTANCE;
            }
            builder.clientMetadata = map;
            str = resetPasswordUseCase.appClientId;
            builder.clientId = str;
            AuthHelper.Companion companion = AuthHelper.Companion;
            str2 = resetPasswordUseCase.appClientId;
            str3 = resetPasswordUseCase.appClientSecret;
            builder.secretHash = companion.getSecretHash(str4, str2, str3);
            if (str5 != null) {
                Function1<UserContextDataType.Builder, Unit> function1 = new Function1<UserContextDataType.Builder, Unit>() { // from class: com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$response$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(UserContextDataType.Builder builder2) {
                        invoke2(builder2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(UserContextDataType.Builder userContextData) {
                        Intrinsics.checkNotNullParameter(userContextData, "$this$userContextData");
                        userContextData.encodedData = str5;
                    }
                };
                UserContextDataType.Builder builder2 = new UserContextDataType.Builder();
                function1.invoke(builder2);
                builder.userContextData = new UserContextDataType(builder2);
            }
            if (str6 != null) {
                Function1<AnalyticsMetadataType.Builder, Unit> function12 = new Function1<AnalyticsMetadataType.Builder, Unit>() { // from class: com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$response$1$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnalyticsMetadataType.Builder builder3) {
                        invoke2(builder3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnalyticsMetadataType.Builder invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        invoke.analyticsEndpointId = str6;
                    }
                };
                AnalyticsMetadataType.Builder builder3 = new AnalyticsMetadataType.Builder();
                function12.invoke(builder3);
                builder.analyticsMetadata = new AnalyticsMetadataType(builder3);
            }
            ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest(builder);
            this.label = 1;
            obj = cognitoIdentityProviderClient.forgotPassword(forgotPasswordRequest, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ForgotPasswordResponse> continuation) {
        return ((ResetPasswordUseCase$execute$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
