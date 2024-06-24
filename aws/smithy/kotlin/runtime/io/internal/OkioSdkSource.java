package aws.smithy.kotlin.runtime.io.internal;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import aws.smithy.kotlin.runtime.io.SdkSource;
import okio.BufferedSource;
import okio.Source;

/* compiled from: Convert.kt */
/* loaded from: classes.dex */
public final class OkioSdkSource implements SdkSource {
    public final Source delegate;

    public OkioSdkSource(BufferedSource bufferedSource) {
        this.delegate = bufferedSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSource
    public final long read(SdkBuffer sdkBuffer) {
        return this.delegate.read(sdkBuffer.inner, 8192L);
    }
}
