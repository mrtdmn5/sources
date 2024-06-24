package com.polidea.rxandroidble2.internal;

import com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentBuilder;
import com.polidea.rxandroidble2.RxBleDevice;

/* loaded from: classes3.dex */
public interface DeviceComponent {

    /* loaded from: classes3.dex */
    public interface Builder {
        DaggerClientComponent$DeviceComponentBuilder macAddress(String str);
    }

    RxBleDevice provideDevice();
}
