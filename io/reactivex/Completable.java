package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public abstract class Completable implements CompletableSource {
    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        if (observableSource != null) {
            return new CompletableAndThenObservable(this, observableSource);
        }
        throw new NullPointerException("next is null");
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        if (completableObserver != null) {
            try {
                subscribeActual(completableObserver);
                return;
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        throw new NullPointerException("observer is null");
    }

    public abstract void subscribeActual(CompletableObserver completableObserver);
}
