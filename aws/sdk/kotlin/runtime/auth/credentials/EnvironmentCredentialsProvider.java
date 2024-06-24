package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import kotlin.jvm.functions.Function1;

/* compiled from: EnvironmentCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class EnvironmentCredentialsProvider implements CloseableCredentialsProvider {
    public final Function1<String, String> getEnv;

    /* JADX WARN: Multi-variable type inference failed */
    public EnvironmentCredentialsProvider(Function1<? super String, String> function1) {
        this.getEnv = function1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
