package io.ktor.websocket;

import kotlinx.coroutines.CopyableThrowable;

/* compiled from: FrameTooBigException.kt */
/* loaded from: classes3.dex */
public final class FrameTooBigException extends Exception implements CopyableThrowable<FrameTooBigException> {
    public final long frameSize;

    public FrameTooBigException(long j) {
        this.frameSize = j;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final FrameTooBigException createCopy() {
        FrameTooBigException frameTooBigException = new FrameTooBigException(this.frameSize);
        frameTooBigException.initCause(this);
        return frameTooBigException;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Frame is too big: " + this.frameSize;
    }
}
