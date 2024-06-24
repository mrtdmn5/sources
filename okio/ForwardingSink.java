package okio;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes4.dex */
public abstract class ForwardingSink implements Sink {
    public final Sink delegate;

    public ForwardingSink(Sink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.delegate.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
