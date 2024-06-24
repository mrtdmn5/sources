package aws.smithy.kotlin.runtime.io.internal;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import aws.smithy.kotlin.runtime.io.SdkSink;
import kotlin.jvm.internal.Intrinsics;
import okio.Sink;

/* compiled from: Convert.kt */
/* loaded from: classes.dex */
public final class OkioSdkSink implements SdkSink {
    public final Sink delegate;

    public OkioSdkSink(Sink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void flush() {
        this.delegate.flush();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void write(SdkBuffer sdkBuffer, long j) {
        this.delegate.write(sdkBuffer.inner, j);
    }
}
