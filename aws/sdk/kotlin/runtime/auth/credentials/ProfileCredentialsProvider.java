package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class ProfileCredentialsProvider implements CloseableCredentialsProvider {
    public final HttpClientEngine httpClientEngine;
    public final Map<String, CloseableCredentialsProvider> namedProviders;
    public final PlatformProvider platformProvider;

    public ProfileCredentialsProvider(HttpClientEngine httpClientEngine, PlatformProvider platformProvider, String str) {
        this.platformProvider = platformProvider;
        this.httpClientEngine = httpClientEngine;
        this.namedProviders = MapsKt__MapsKt.mapOf(new Pair("Environment", new EnvironmentCredentialsProvider(new ProfileCredentialsProvider$namedProviders$1(platformProvider))), new Pair("Ec2InstanceMetadata", new ImdsCredentialsProvider(str, LazyKt__LazyJVMKt.lazy(new Function0<ImdsClient>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$namedProviders$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ImdsClient invoke() {
                final ProfileCredentialsProvider profileCredentialsProvider = ProfileCredentialsProvider.this;
                Function1<ImdsClient.Builder, Unit> function1 = new Function1<ImdsClient.Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$namedProviders$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImdsClient.Builder builder) {
                        ImdsClient.Builder invoke = builder;
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        ProfileCredentialsProvider profileCredentialsProvider2 = ProfileCredentialsProvider.this;
                        PlatformProvider platformProvider2 = profileCredentialsProvider2.platformProvider;
                        Intrinsics.checkNotNullParameter(platformProvider2, "<set-?>");
                        invoke.platformProvider = platformProvider2;
                        invoke.engine = profileCredentialsProvider2.httpClientEngine;
                        return Unit.INSTANCE;
                    }
                };
                ImdsClient.Builder builder = new ImdsClient.Builder();
                function1.invoke(builder);
                return new ImdsClient(builder);
            }
        }), platformProvider, 8)), new Pair("EcsContainer", new EcsCredentialsProvider(platformProvider, httpClientEngine)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CloseableCredentialsProvider closeableCredentialsProvider;
        Iterator<Map.Entry<String, CloseableCredentialsProvider>> it = this.namedProviders.entrySet().iterator();
        while (it.hasNext()) {
            CloseableCredentialsProvider value = it.next().getValue();
            if (value instanceof Closeable) {
                closeableCredentialsProvider = value;
            } else {
                closeableCredentialsProvider = null;
            }
            if (closeableCredentialsProvider != null) {
                closeableCredentialsProvider.close();
            }
        }
    }
}
