package io.reactivex.internal.util;

/* loaded from: classes.dex */
public final class ExceptionHelper {
    public static final Termination TERMINATED = new Termination();

    public static RuntimeException wrapOrThrow(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }

    /* loaded from: classes.dex */
    public static final class Termination extends Throwable {
        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }
    }
}
