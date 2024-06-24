package aws.sdk.kotlin.services.cognitoidentityprovider;

import aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProvider;
import aws.sdk.kotlin.runtime.http.retries.AwsDefaultRetryPolicy;
import aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.DefaultEndpointProvider;
import aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmSignUpResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeleteUserRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeleteUserResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GlobalSignOutResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.RevokeTokenRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.RevokeTokenResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateDeviceStatusResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeResponse;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerKt;
import aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkLogMode;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.internal.ManagedHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.tracing.DefaultTracer;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CognitoIdentityProviderClient.kt */
/* loaded from: classes.dex */
public interface CognitoIdentityProviderClient extends SdkClient {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: CognitoIdentityProviderClient.kt */
    /* loaded from: classes.dex */
    public static final class Builder extends AbstractSdkClientBuilder<Config, Config.Builder, CognitoIdentityProviderClient> {
        public final Config.Builder config = new Config.Builder();

        @Override // aws.smithy.kotlin.runtime.client.SdkClient.Builder
        public final SdkClientConfig.Builder getConfig() {
            return this.config;
        }

        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder
        public final CognitoIdentityProviderClient newClient(Config config) {
            Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "config");
            return new DefaultCognitoIdentityProviderClient(config2);
        }
    }

    /* compiled from: CognitoIdentityProviderClient.kt */
    /* loaded from: classes.dex */
    public static final class Config implements SdkClientConfig {
        public final CloseableCredentialsProvider credentialsProvider;
        public final EndpointProvider<EndpointParameters> endpointProvider;
        public final CloseableHttpClientEngine httpClientEngine;
        public final ArrayList interceptors;
        public final String region;
        public final AwsDefaultRetryPolicy retryPolicy;
        public final StandardRetryStrategy retryStrategy;
        public final SdkLogMode.Default sdkLogMode;
        public final DefaultAwsSignerImpl signer;
        public final DefaultTracer tracer;

        /* compiled from: CognitoIdentityProviderClient.kt */
        /* loaded from: classes.dex */
        public static final class Builder implements SdkClientConfig.Builder<Config> {
            public EndpointProvider<EndpointParameters> endpointProvider;
            public String region;
            public final ArrayList interceptors = new ArrayList();
            public final SdkLogMode.Default sdkLogMode = SdkLogMode.Default.INSTANCE;

            @Override // aws.smithy.kotlin.runtime.util.Buildable
            public final Object build() {
                return new Config(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProvider] */
        /* JADX WARN: Type inference failed for: r1v3, types: [aws.smithy.kotlin.runtime.http.engine.internal.ManagedHttpClientEngine] */
        public Config(Builder builder) {
            builder.getClass();
            OkHttpEngine okHttpEngine = new OkHttpEngine();
            okHttpEngine = okHttpEngine instanceof ManagedHttpClientEngine ? okHttpEngine : new ManagedHttpClientEngine(okHttpEngine);
            this.httpClientEngine = okHttpEngine;
            String str = builder.region;
            if (str != null) {
                this.region = str;
                DefaultChainCredentialsProvider defaultChainCredentialsProvider = new DefaultChainCredentialsProvider(okHttpEngine, str);
                this.credentialsProvider = defaultChainCredentialsProvider instanceof ManagedCredentialsProvider ? defaultChainCredentialsProvider : new ManagedCredentialsProvider(defaultChainCredentialsProvider);
                EndpointProvider<EndpointParameters> endpointProvider = builder.endpointProvider;
                this.endpointProvider = endpointProvider == null ? new DefaultEndpointProvider() : endpointProvider;
                this.interceptors = builder.interceptors;
                this.retryPolicy = AwsDefaultRetryPolicy.INSTANCE;
                this.retryStrategy = new StandardRetryStrategy(0);
                this.sdkLogMode = builder.sdkLogMode;
                this.signer = DefaultAwsSignerKt.DefaultAwsSigner;
                this.tracer = new DefaultTracer("Cognito Identity Provider");
                return;
            }
            throw new IllegalArgumentException("region is a required configuration property".toString());
        }
    }

    Object changePassword(ChangePasswordRequest changePasswordRequest, Continuation<? super ChangePasswordResponse> continuation);

    Object confirmDevice(ConfirmDeviceRequest confirmDeviceRequest, Continuation<? super ConfirmDeviceResponse> continuation);

    Object confirmForgotPassword(ConfirmForgotPasswordRequest confirmForgotPasswordRequest, Continuation<? super ConfirmForgotPasswordResponse> continuation);

    Object confirmSignUp(ConfirmSignUpRequest confirmSignUpRequest, Continuation<? super ConfirmSignUpResponse> continuation);

    Object deleteUser(DeleteUserRequest deleteUserRequest, Continuation<? super DeleteUserResponse> continuation);

    Object forgotPassword(ForgotPasswordRequest forgotPasswordRequest, Continuation<? super ForgotPasswordResponse> continuation);

    Object getUser(GetUserRequest getUserRequest, Continuation<? super GetUserResponse> continuation);

    Object getUserAttributeVerificationCode(GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest, Continuation<? super GetUserAttributeVerificationCodeResponse> continuation);

    Object globalSignOut(GlobalSignOutRequest globalSignOutRequest, Continuation<? super GlobalSignOutResponse> continuation);

    Object initiateAuth(InitiateAuthRequest initiateAuthRequest, Continuation<? super InitiateAuthResponse> continuation);

    Object listDevices(ListDevicesRequest listDevicesRequest, Continuation<? super ListDevicesResponse> continuation);

    Object resendConfirmationCode(ResendConfirmationCodeRequest resendConfirmationCodeRequest, Continuation<? super ResendConfirmationCodeResponse> continuation);

    Object respondToAuthChallenge(RespondToAuthChallengeRequest respondToAuthChallengeRequest, Continuation<? super RespondToAuthChallengeResponse> continuation);

    Object revokeToken(RevokeTokenRequest revokeTokenRequest, Continuation<? super RevokeTokenResponse> continuation);

    Object signUp(SignUpRequest signUpRequest, Continuation<? super SignUpResponse> continuation);

    Object updateDeviceStatus(UpdateDeviceStatusRequest updateDeviceStatusRequest, Continuation<? super UpdateDeviceStatusResponse> continuation);

    Object updateUserAttributes(UpdateUserAttributesRequest updateUserAttributesRequest, Continuation<? super UpdateUserAttributesResponse> continuation);

    Object verifyUserAttribute(VerifyUserAttributeRequest verifyUserAttributeRequest, Continuation<? super VerifyUserAttributeResponse> continuation);
}
