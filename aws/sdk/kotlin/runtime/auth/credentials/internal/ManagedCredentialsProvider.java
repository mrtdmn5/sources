package aws.sdk.kotlin.runtime.auth.credentials.internal;

import aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.io.SdkManagedCloseable;

/* compiled from: ManagedCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class ManagedCredentialsProvider extends SdkManagedCloseable implements CloseableCredentialsProvider {
    public final CloseableCredentialsProvider delegate;

    public ManagedCredentialsProvider(DefaultChainCredentialsProvider defaultChainCredentialsProvider) {
        super(defaultChainCredentialsProvider);
        this.delegate = defaultChainCredentialsProvider;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }
}
