package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;

/* compiled from: InternalMutatorMutex.kt */
/* loaded from: classes.dex */
public final class MutationInterruptedException extends CancellationException {
    public MutationInterruptedException() {
        super("Mutation interrupted");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
