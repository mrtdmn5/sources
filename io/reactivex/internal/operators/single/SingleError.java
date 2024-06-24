package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SingleError<T> extends Single<T> {
    public final Callable<? extends Throwable> errorSupplier;

    public SingleError(Functions.JustValue justValue) {
        this.errorSupplier = justValue;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            Throwable call = this.errorSupplier.call();
            ObjectHelper.requireNonNull(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = call;
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, singleObserver);
    }
}
