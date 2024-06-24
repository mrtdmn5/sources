package io.reactivex.internal.operators.maybe;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes.dex */
public final class MaybeError<T> extends Maybe<T> {
    public final Throwable error;

    public MaybeError(BleScanException bleScanException) {
        this.error = bleScanException;
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.INSTANCE);
        maybeObserver.onError(this.error);
    }
}
