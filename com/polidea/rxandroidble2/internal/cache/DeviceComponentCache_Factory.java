package com.polidea.rxandroidble2.internal.cache;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DeviceComponentCache_Factory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final DeviceComponentCache_Factory INSTANCE = new DeviceComponentCache_Factory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new DeviceComponentCache();
    }
}
