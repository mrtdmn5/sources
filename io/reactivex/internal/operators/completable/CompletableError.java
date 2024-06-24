package io.reactivex.internal.operators.completable;

import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes.dex */
public final class CompletableError extends Completable {
    public final Throwable error;

    public CompletableError(BleCannotSetCharacteristicNotificationException bleCannotSetCharacteristicNotificationException) {
        this.error = bleCannotSetCharacteristicNotificationException;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.error, completableObserver);
    }
}
