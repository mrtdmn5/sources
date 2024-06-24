package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.scan.IsConnectable;

/* loaded from: classes3.dex */
public final class IsConnectableCheckerApi26 implements IsConnectableChecker {
    @Override // com.polidea.rxandroidble2.internal.scan.IsConnectableChecker
    public final IsConnectable check(ScanResult scanResult) {
        boolean isConnectable;
        isConnectable = scanResult.isConnectable();
        if (isConnectable) {
            return IsConnectable.CONNECTABLE;
        }
        return IsConnectable.NOT_CONNECTABLE;
    }
}
