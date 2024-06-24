package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;

/* compiled from: DefaultChainCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class StsWebIdentityProvider implements CloseableCredentialsProvider {
    public final PlatformProvider platformProvider;

    public StsWebIdentityProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        this.platformProvider = platformProvider;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
