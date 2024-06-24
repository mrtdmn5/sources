package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeError;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda3 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return new MaybeError(new BleScanException(1));
    }
}
