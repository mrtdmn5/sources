package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public final class InternalToExternalScanResultConverter implements Function<RxBleInternalScanResult, ScanResult> {
    public final RxBleDeviceProvider deviceProvider;

    public InternalToExternalScanResultConverter(RxBleDeviceProvider rxBleDeviceProvider) {
        this.deviceProvider = rxBleDeviceProvider;
    }

    @Override // io.reactivex.functions.Function
    public final ScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
        RxBleInternalScanResult rxBleInternalScanResult2 = rxBleInternalScanResult;
        return new ScanResult(this.deviceProvider.getBleDevice(rxBleInternalScanResult2.bluetoothDevice.getAddress()), rxBleInternalScanResult2.rssi, rxBleInternalScanResult2.timestampNanos, rxBleInternalScanResult2.scanCallbackType, rxBleInternalScanResult2.scanRecord, rxBleInternalScanResult2.isConnectable);
    }
}
