package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class DaggerClientComponent$ConnectionComponentBuilder implements ConnectionComponent.Builder {
    public Boolean autoConnect;
    public final DaggerClientComponent$ClientComponentImpl clientComponentImpl;
    public final DaggerClientComponent$DeviceComponentImpl deviceComponentImpl;
    public Timeout operationTimeout;
    public Boolean suppressOperationChecks;

    public DaggerClientComponent$ConnectionComponentBuilder(DaggerClientComponent$ClientComponentImpl daggerClientComponent$ClientComponentImpl, DaggerClientComponent$DeviceComponentImpl daggerClientComponent$DeviceComponentImpl) {
        this.clientComponentImpl = daggerClientComponent$ClientComponentImpl;
        this.deviceComponentImpl = daggerClientComponent$DeviceComponentImpl;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
    public final DaggerClientComponent$ConnectionComponentBuilder autoConnect(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        valueOf.getClass();
        this.autoConnect = valueOf;
        return this;
    }

    public final DaggerClientComponent$ConnectionComponentImpl build() {
        UnsignedKt.checkBuilderRequirement(Boolean.class, this.autoConnect);
        UnsignedKt.checkBuilderRequirement(Boolean.class, this.suppressOperationChecks);
        UnsignedKt.checkBuilderRequirement(Timeout.class, this.operationTimeout);
        return new DaggerClientComponent$ConnectionComponentImpl(this.clientComponentImpl, this.deviceComponentImpl, this.autoConnect, this.suppressOperationChecks, this.operationTimeout);
    }

    public final DaggerClientComponent$ConnectionComponentBuilder suppressOperationChecks(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        valueOf.getClass();
        this.suppressOperationChecks = valueOf;
        return this;
    }
}
