package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;

/* compiled from: ByteBufferChannelInternals.kt */
/* loaded from: classes3.dex */
public final class ClosedElement {
    public static final ClosedElement EmptyCause = new ClosedElement(null);
    public final Throwable cause;

    public ClosedElement(Throwable th) {
        this.cause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.cause;
        if (th == null) {
            return new ClosedWriteChannelException("The channel was closed");
        }
        return th;
    }

    public final String toString() {
        return "Closed[" + getSendException() + ']';
    }
}
