package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class DaggerClientComponent$DeviceComponentBuilder implements DeviceComponent.Builder {
    public final DaggerClientComponent$ClientComponentImpl clientComponentImpl;
    public String macAddress;

    public DaggerClientComponent$DeviceComponentBuilder(DaggerClientComponent$ClientComponentImpl daggerClientComponent$ClientComponentImpl) {
        this.clientComponentImpl = daggerClientComponent$ClientComponentImpl;
    }

    public final DaggerClientComponent$DeviceComponentImpl build() {
        UnsignedKt.checkBuilderRequirement(String.class, this.macAddress);
        return new DaggerClientComponent$DeviceComponentImpl(this.clientComponentImpl, this.macAddress);
    }

    @Override // com.polidea.rxandroidble2.internal.DeviceComponent.Builder
    public final DaggerClientComponent$DeviceComponentBuilder macAddress(String str) {
        str.getClass();
        this.macAddress = str;
        return this;
    }
}
