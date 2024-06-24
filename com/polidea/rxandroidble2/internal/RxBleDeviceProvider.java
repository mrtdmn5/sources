package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.DaggerClientComponent$DeviceComponentImpl;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;

/* loaded from: classes3.dex */
public final class RxBleDeviceProvider {
    public final DeviceComponentCache cachedDeviceComponents;
    public final Provider<DeviceComponent.Builder> deviceComponentBuilder;

    public RxBleDeviceProvider(DeviceComponentCache deviceComponentCache, Provider<DeviceComponent.Builder> provider) {
        this.cachedDeviceComponents = deviceComponentCache;
        this.deviceComponentBuilder = provider;
    }

    public final RxBleDevice getBleDevice(String str) {
        DeviceComponent deviceComponent = this.cachedDeviceComponents.get((Object) str);
        if (deviceComponent != null) {
            return deviceComponent.provideDevice();
        }
        synchronized (this.cachedDeviceComponents) {
            DeviceComponent deviceComponent2 = this.cachedDeviceComponents.get((Object) str);
            if (deviceComponent2 != null) {
                return deviceComponent2.provideDevice();
            }
            DaggerClientComponent$DeviceComponentImpl build = this.deviceComponentBuilder.get().macAddress(str).build();
            RxBleDevice provideDevice = build.provideDevice();
            this.cachedDeviceComponents.put(str, build);
            return provideDevice;
        }
    }
}
