package androidx.compose.ui.input.pointer;

import java.util.concurrent.CancellationException;

/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public final class PointerInputResetException extends CancellationException {
    public PointerInputResetException() {
        super("Pointer input was reset");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
