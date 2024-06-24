package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.internal.operators.observable.ObservableDefer;

/* loaded from: classes3.dex */
public abstract class RxBleClient {

    /* loaded from: classes3.dex */
    public enum State {
        BLUETOOTH_NOT_AVAILABLE,
        LOCATION_PERMISSION_NOT_GRANTED,
        BLUETOOTH_NOT_ENABLED,
        LOCATION_SERVICES_NOT_ENABLED,
        READY
    }

    public abstract RxBleDevice getBleDevice(String str);

    public abstract ObservableDefer scanBleDevices(ScanSettings scanSettings, ScanFilter... scanFilterArr);
}
