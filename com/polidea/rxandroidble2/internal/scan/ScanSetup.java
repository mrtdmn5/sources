package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.operations.Operation;
import com.polidea.rxandroidble2.internal.operations.ScanOperation;
import io.reactivex.ObservableTransformer;

/* loaded from: classes3.dex */
public final class ScanSetup {
    public final Operation<RxBleInternalScanResult> scanOperation;
    public final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> scanOperationBehaviourEmulatorTransformer;

    public ScanSetup(ScanOperation scanOperation, ObservableTransformer observableTransformer) {
        this.scanOperation = scanOperation;
        this.scanOperationBehaviourEmulatorTransformer = observableTransformer;
    }
}
