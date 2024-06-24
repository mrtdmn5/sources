package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.scan.IsConnectable;

/* loaded from: classes3.dex */
public interface IsConnectableChecker {
    IsConnectable check(ScanResult scanResult);
}
