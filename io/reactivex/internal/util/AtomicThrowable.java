package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    public final boolean addThrowable(Throwable th) {
        boolean z;
        Throwable compositeException;
        ExceptionHelper.Termination termination = ExceptionHelper.TERMINATED;
        do {
            Throwable th2 = get();
            z = false;
            if (th2 == ExceptionHelper.TERMINATED) {
                return false;
            }
            if (th2 == null) {
                compositeException = th;
            } else {
                compositeException = new CompositeException(th2, th);
            }
            while (true) {
                if (compareAndSet(th2, compositeException)) {
                    z = true;
                    break;
                }
                if (get() != th2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    public final Throwable terminate() {
        ExceptionHelper.Termination termination = ExceptionHelper.TERMINATED;
        Throwable th = get();
        ExceptionHelper.Termination termination2 = ExceptionHelper.TERMINATED;
        if (th != termination2) {
            return getAndSet(termination2);
        }
        return th;
    }
}
