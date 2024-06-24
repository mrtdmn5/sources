package aws.smithy.kotlin.runtime.io.internal;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import aws.smithy.kotlin.runtime.io.SdkSource;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* compiled from: Convert.kt */
/* loaded from: classes.dex */
public final class OkioSource implements Source {
    public final SdkSource delegate;

    public OkioSource(SdkSource delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.read(new SdkBuffer(sink));
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }
}
