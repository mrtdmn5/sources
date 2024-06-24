package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1;
import aws.sdk.kotlin.runtime.config.imds.EndpointConfiguration;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.middleware.UserAgent;
import aws.smithy.kotlin.runtime.client.SdkLogMode;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineConfig;
import aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.operation.SdkOperationExecution;
import aws.smithy.kotlin.runtime.http.operation.UnitSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.MiddlewareLambda;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public final class ImdsClient implements InstanceMetadataProvider {
    public final HttpClientEngine engine;
    public final SdkHttpClient httpClient;
    public final boolean manageEngine;
    public final PlatformProvider platformProvider;
    public final ResolveEndpoint<Unit> resolveEndpointMiddleware;
    public final SdkLogMode.Default sdkLogMode;
    public final TokenMiddleware tokenMiddleware;
    public final UserAgent userAgentMiddleware;

    /* compiled from: ImdsClient.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.imds.ImdsClient$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends Lambda implements Function1<HttpClientEngineConfig.Builder, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(HttpClientEngineConfig.Builder builder) {
            HttpClientEngineConfig.Builder DefaultHttpEngine = builder;
            Intrinsics.checkNotNullParameter(DefaultHttpEngine, "$this$DefaultHttpEngine");
            int r0 = Duration.$r8$clinit;
            DurationUnit durationUnit = DurationUnit.SECONDS;
            DefaultHttpEngine.connectTimeout = DurationKt.toDuration(1, durationUnit);
            DefaultHttpEngine.socketReadTimeout = DurationKt.toDuration(1, durationUnit);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ImdsClient.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public final Clock.System clock;
        public HttpClientEngine engine;
        public PlatformProvider platformProvider;
        public final SdkLogMode.Default sdkLogMode;
        public final long tokenTtl;
        public final int maxRetries = 3;
        public final EndpointConfiguration.Default endpointConfiguration = EndpointConfiguration.Default.INSTANCE;

        public Builder() {
            int r0 = Duration.$r8$clinit;
            this.tokenTtl = DurationKt.toDuration(21600, DurationUnit.SECONDS);
            this.sdkLogMode = SdkLogMode.Default.INSTANCE;
            this.clock = Clock.System.INSTANCE;
            PlatformProvider.Companion.getClass();
            this.platformProvider = PlatformProvider.Companion.System;
        }
    }

    public ImdsClient(Builder builder) {
        boolean z;
        EndpointConfiguration.Default r0 = builder.endpointConfiguration;
        Clock.System system = builder.clock;
        PlatformProvider platformProvider = builder.platformProvider;
        this.platformProvider = platformProvider;
        this.sdkLogMode = builder.sdkLogMode;
        HttpClientEngine httpClientEngine = builder.engine;
        if (httpClientEngine == null) {
            z = true;
        } else {
            z = false;
        }
        this.manageEngine = z;
        if (builder.maxRetries > 0) {
            if (httpClientEngine == null) {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
                if (anonymousClass2 != null) {
                    OkHttpEngineConfig.Builder builder2 = new OkHttpEngineConfig.Builder();
                    anonymousClass2.invoke(builder2);
                    httpClientEngine = new OkHttpEngine(new OkHttpEngineConfig(builder2));
                } else {
                    httpClientEngine = new OkHttpEngine();
                }
            }
            this.engine = httpClientEngine;
            SdkHttpClient sdkHttpClient = new SdkHttpClient(httpClientEngine);
            this.httpClient = sdkHttpClient;
            this.resolveEndpointMiddleware = new ResolveEndpoint<>(new ImdsEndpointProvider(platformProvider, r0), Unit.INSTANCE);
            this.userAgentMiddleware = new UserAgent(AwsUserAgentMetadata.Companion.fromEnvironment(new ApiMetadata("imds", "unknown")));
            this.tokenMiddleware = new TokenMiddleware(sdkHttpClient, builder.tokenTtl, system);
            return;
        }
        throw new IllegalArgumentException("maxRetries must be greater than zero".toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.manageEngine) {
            MagicApiIntrinsics.closeIfCloseable(this.engine);
        }
    }

    @Override // aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider
    public final Object get(ImdsCredentialsProvider$loadProfile$1 imdsCredentialsProvider$loadProfile$1) {
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(String.class));
        sdkHttpOperationBuilder.serializer = UnitSerializer.INSTANCE;
        sdkHttpOperationBuilder.deserializer = new ImdsClient$get$op$1$1();
        HttpOperationContext.Builder builder = sdkHttpOperationBuilder.context;
        builder.setOperationName("/latest/meta-data/iam/security-credentials");
        builder.setService("imds");
        builder.set(SetsKt__SetsKt.LogMode, this.sdkLogMode);
        SdkHttpOperation<?, ?> build = sdkHttpOperationBuilder.build();
        ImdsRetryPolicy imdsRetryPolicy = new ImdsRetryPolicy();
        SdkOperationExecution<?, ?> sdkOperationExecution = build.execution;
        sdkOperationExecution.getClass();
        sdkOperationExecution.retryPolicy = imdsRetryPolicy;
        ResolveEndpoint<Unit> middleware = this.resolveEndpointMiddleware;
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(build);
        UserAgent middleware2 = this.userAgentMiddleware;
        Intrinsics.checkNotNullParameter(middleware2, "middleware");
        middleware2.install(build);
        TokenMiddleware middleware3 = this.tokenMiddleware;
        Intrinsics.checkNotNullParameter(middleware3, "middleware");
        middleware3.install(build);
        Phase.Order order = Phase.Order.Before;
        ImdsClient$get$2 imdsClient$get$2 = new ImdsClient$get$2("/latest/meta-data/iam/security-credentials", null);
        Phase<OperationRequest<HttpRequestBuilder>, ?> phase = sdkOperationExecution.mutate;
        phase.getClass();
        Intrinsics.checkNotNullParameter(order, "order");
        phase.register(new MiddlewareLambda(imdsClient$get$2), order);
        return SdkHttpOperationKt.roundTrip(build, this.httpClient, Unit.INSTANCE, imdsCredentialsProvider$loadProfile$1);
    }
}
