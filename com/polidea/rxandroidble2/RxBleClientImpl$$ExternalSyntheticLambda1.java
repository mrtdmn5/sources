package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.functions.Consumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda1 implements Consumer {
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        RxBleLog.loggerSetup.getClass();
        RxBleLog.i("%s", (ScanResult) obj);
    }
}
