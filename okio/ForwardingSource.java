package okio;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForwardingSource.kt */
/* loaded from: classes4.dex */
public abstract class ForwardingSource implements Source {
    public final Source delegate;

    public ForwardingSource(Source delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.delegate.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
