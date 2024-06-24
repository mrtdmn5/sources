package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.exceptions.BleException;
import io.reactivex.Observable;

/* loaded from: classes3.dex */
public interface DisconnectionRouterOutput {
    Observable<BleException> asValueOnlyObservable();
}
