package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* compiled from: EcsCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class EcsCredentialsProvider implements CloseableCredentialsProvider {
    public final HttpClientEngine httpClientEngine;
    public final boolean manageEngine = false;
    public final PlatformEnvironProvider platformProvider;

    public EcsCredentialsProvider(PlatformEnvironProvider platformEnvironProvider, HttpClientEngine httpClientEngine) {
        this.platformProvider = platformEnvironProvider;
        this.httpClientEngine = httpClientEngine;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.manageEngine) {
            MagicApiIntrinsics.closeIfCloseable(this.httpClientEngine);
        }
    }
}
