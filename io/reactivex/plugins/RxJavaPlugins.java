package io.reactivex.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class RxJavaPlugins {
    public static volatile Consumer<? super Throwable> errorHandler;

    public static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            ObjectHelper.requireNonNull(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static void onError(Throwable th) {
        boolean z;
        Consumer<? super Throwable> consumer = errorHandler;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            if ((th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                th = new UndeliverableException(th);
            }
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        th.printStackTrace();
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static void onSchedule(Runnable runnable) {
        if (runnable != null) {
        } else {
            throw new NullPointerException("run is null");
        }
    }
}
