package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class CompletableFromAction extends Completable {
    public final Action run;

    public CompletableFromAction(Action action) {
        this.run = action;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        RunnableDisposable runnableDisposable = new RunnableDisposable(Functions.EMPTY_RUNNABLE);
        completableObserver.onSubscribe(runnableDisposable);
        try {
            this.run.run();
            if (!runnableDisposable.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!runnableDisposable.isDisposed()) {
                completableObserver.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
