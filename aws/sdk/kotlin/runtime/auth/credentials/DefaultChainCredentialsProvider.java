package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderChain;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SystemDefaultProvider;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* compiled from: DefaultChainCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class DefaultChainCredentialsProvider implements CloseableCredentialsProvider {
    public final HttpClientEngine engine;
    public final boolean manageEngine;
    public final PlatformProvider platformProvider;
    public final CachedCredentialsProvider provider;

    public DefaultChainCredentialsProvider(CloseableHttpClientEngine closeableHttpClientEngine, String str) {
        PlatformProvider.Companion.getClass();
        SystemDefaultProvider platformProvider = PlatformProvider.Companion.System;
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.platformProvider = platformProvider;
        this.manageEngine = false;
        this.engine = closeableHttpClientEngine;
        this.provider = new CachedCredentialsProvider(new CredentialsProviderChain(new EnvironmentCredentialsProvider(new DefaultChainCredentialsProvider$chain$1(platformProvider)), new ProfileCredentialsProvider(closeableHttpClientEngine, platformProvider, null), new StsWebIdentityProvider(platformProvider, closeableHttpClientEngine), new EcsCredentialsProvider(platformProvider, closeableHttpClientEngine), new ImdsCredentialsProvider(null, LazyKt__LazyJVMKt.lazy(new Function0<ImdsClient>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider$chain$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ImdsClient invoke() {
                final DefaultChainCredentialsProvider defaultChainCredentialsProvider = DefaultChainCredentialsProvider.this;
                Function1<ImdsClient.Builder, Unit> function1 = new Function1<ImdsClient.Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider$chain$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImdsClient.Builder builder) {
                        ImdsClient.Builder invoke = builder;
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        DefaultChainCredentialsProvider defaultChainCredentialsProvider2 = DefaultChainCredentialsProvider.this;
                        PlatformProvider platformProvider2 = defaultChainCredentialsProvider2.platformProvider;
                        Intrinsics.checkNotNullParameter(platformProvider2, "<set-?>");
                        invoke.platformProvider = platformProvider2;
                        invoke.engine = defaultChainCredentialsProvider2.engine;
                        return Unit.INSTANCE;
                    }
                };
                ImdsClient.Builder builder = new ImdsClient.Builder();
                function1.invoke(builder);
                return new ImdsClient(builder);
            }
        }), platformProvider, 9)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.provider.close();
        if (this.manageEngine) {
            MagicApiIntrinsics.closeIfCloseable(this.engine);
        }
    }
}
