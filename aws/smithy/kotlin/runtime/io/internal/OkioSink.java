package aws.smithy.kotlin.runtime.io.internal;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import aws.smithy.kotlin.runtime.io.SdkSink;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* compiled from: Convert.kt */
/* loaded from: classes.dex */
public final class OkioSink implements Sink {
    public final SdkSink delegate;

    public OkioSink(SdkSink sdkSink) {
        this.delegate = sdkSink;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(new SdkBuffer(source), j);
    }
}
