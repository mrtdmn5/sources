package com.polidea.rxandroidble2.scan;

import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;

/* loaded from: classes3.dex */
public final class ScanResult {
    public final RxBleDevice bleDevice;
    public final ScanCallbackType callbackType;
    public final IsConnectable isConnectable;
    public final int rssi;
    public final ScanRecord scanRecord;
    public final long timestampNanos;

    public ScanResult(RxBleDevice rxBleDevice, int r2, long j, ScanCallbackType scanCallbackType, ScanRecord scanRecord, IsConnectable isConnectable) {
        this.bleDevice = rxBleDevice;
        this.rssi = r2;
        this.timestampNanos = j;
        this.callbackType = scanCallbackType;
        this.scanRecord = scanRecord;
        this.isConnectable = isConnectable;
    }

    public final String toString() {
        return "ScanResult{bleDevice=" + this.bleDevice + ", rssi=" + this.rssi + ", timestampNanos=" + this.timestampNanos + ", callbackType=" + this.callbackType + ", scanRecord=" + LoggerUtil.bytesToHex(this.scanRecord.getBytes()) + ", isConnectable=" + this.isConnectable + '}';
    }
}
