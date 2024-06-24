package io.reactivex;

import io.reactivex.exceptions.Exceptions;

/* loaded from: classes3.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    @Override // io.reactivex.MaybeSource
    public final void subscribe(MaybeObserver<? super T> maybeObserver) {
        try {
            subscribeActual(maybeObserver);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(MaybeObserver<? super T> maybeObserver);
}
