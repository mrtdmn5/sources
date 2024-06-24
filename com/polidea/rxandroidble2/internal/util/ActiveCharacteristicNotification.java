package com.polidea.rxandroidble2.internal.util;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableRefCount;

/* loaded from: classes3.dex */
public final class ActiveCharacteristicNotification {
    public final boolean isIndication;
    public final Observable<Observable<byte[]>> notificationObservable;

    public ActiveCharacteristicNotification(ObservableRefCount observableRefCount, boolean z) {
        this.notificationObservable = observableRefCount;
        this.isIndication = z;
    }
}
