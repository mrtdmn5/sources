package aws.sdk.kotlin.services.cognitoidentity;

import aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProvider;
import aws.sdk.kotlin.runtime.http.retries.AwsDefaultRetryPolicy;
import aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityResponse;
import aws.sdk.kotlin.services.cognitoidentity.model.GetIdRequest;
import aws.sdk.kotlin.services.cognitoidentity.model.GetIdResponse;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerImpl;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerKt;
import aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkLogMode;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.internal.ManagedHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.tracing.DefaultTracer;
import io.ktor.utils.io.internal.UtilsKt;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CognitoIdentityClient.kt */
/* loaded from: classes.dex */
public interface CognitoIdentityClient extends SdkClient {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: CognitoIdentityClient.kt */
    /* loaded from: classes.dex */
    public static final class Builder extends AbstractSdkClientBuilder<Config, Config.Builder, CognitoIdentityClient> {
        public final Config.Builder config = new Config.Builder();

        @Override // aws.smithy.kotlin.runtime.client.SdkClient.Builder
        public final SdkClientConfig.Builder getConfig() {
            return this.config;
        }

        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder
        public final CognitoIdentityClient newClient(Config config) {
            Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "config");
            return new DefaultCognitoIdentityClient(config2);
        }
    }

    /* compiled from: CognitoIdentityClient.kt */
    /* loaded from: classes.dex */
    public static final class Config implements SdkClientConfig {
        public final CloseableCredentialsProvider credentialsProvider;
        public final UtilsKt endpointProvider;
        public final CloseableHttpClientEngine httpClientEngine;
        public final ArrayList interceptors;
        public final String region;
        public final AwsDefaultRetryPolicy retryPolicy;
        public final StandardRetryStrategy retryStrategy;
        public final SdkLogMode.Default sdkLogMode;
        public final DefaultAwsSignerImpl signer;
        public final DefaultTracer tracer;

        /* compiled from: CognitoIdentityClient.kt */
        /* loaded from: classes.dex */
        public static final class Builder implements SdkClientConfig.Builder<Config> {
            public String region;
            public final ArrayList interceptors = new ArrayList();
            public final SdkLogMode.Default sdkLogMode = SdkLogMode.Default.INSTANCE;

            @Override // aws.smithy.kotlin.runtime.util.Buildable
            public final Object build() {
                return new Config(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProvider] */
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
                this.endpointProvider = new UtilsKt();
                this.interceptors = builder.interceptors;
                this.retryPolicy = AwsDefaultRetryPolicy.INSTANCE;
                this.retryStrategy = new StandardRetryStrategy(0);
                this.sdkLogMode = builder.sdkLogMode;
                this.signer = DefaultAwsSignerKt.DefaultAwsSigner;
                this.tracer = new DefaultTracer("Cognito Identity");
                return;
            }
            throw new IllegalArgumentException("region is a required configuration property".toString());
        }
    }

    Object getCredentialsForIdentity(GetCredentialsForIdentityRequest getCredentialsForIdentityRequest, Continuation<? super GetCredentialsForIdentityResponse> continuation);

    Object getId(GetIdRequest getIdRequest, Continuation<? super GetIdResponse> continuation);
}
