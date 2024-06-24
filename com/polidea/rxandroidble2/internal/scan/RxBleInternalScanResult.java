package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import com.polidea.rxandroidble2.scan.ScanRecord;

/* loaded from: classes3.dex */
public final class RxBleInternalScanResult {
    public final BluetoothDevice bluetoothDevice;
    public final IsConnectable isConnectable;
    public final int rssi;
    public final ScanCallbackType scanCallbackType;
    public final ScanRecord scanRecord;
    public final long timestampNanos;

    public RxBleInternalScanResult(BluetoothDevice bluetoothDevice, int r2, long j, ScanRecord scanRecord, ScanCallbackType scanCallbackType, IsConnectable isConnectable) {
        this.bluetoothDevice = bluetoothDevice;
        this.rssi = r2;
        this.timestampNanos = j;
        this.scanRecord = scanRecord;
        this.scanCallbackType = scanCallbackType;
        this.isConnectable = isConnectable;
    }
}
