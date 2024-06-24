package androidx.compose.runtime;

import java.util.concurrent.CancellationException;

/* compiled from: Effects.kt */
/* loaded from: classes.dex */
public final class LeftCompositionCancellationException extends CancellationException {
    public LeftCompositionCancellationException() {
        super("The coroutine scope left the composition");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
