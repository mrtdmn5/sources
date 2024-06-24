package io.reactivex.internal.operators.single;

import android.bluetooth.BluetoothGatt;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes.dex */
public final class SingleJust<T> extends Single<T> {
    public final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleJust(BluetoothGatt bluetoothGatt) {
        this.value = bluetoothGatt;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.INSTANCE);
        singleObserver.onSuccess(this.value);
    }
}
