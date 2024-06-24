package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import io.reactivex.functions.Predicate;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda2 implements Predicate {
    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object obj) {
        if (((RxBleAdapterStateObservable.BleAdapterState) obj) != RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
            return true;
        }
        return false;
    }
}
