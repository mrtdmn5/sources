package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23_Factory;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideScanSetupProviderFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
    public final Provider<ScanSetupBuilderImplApi18> scanSetupBuilderProviderForApi18Provider;
    public final Provider<ScanSetupBuilderImplApi21> scanSetupBuilderProviderForApi21Provider;
    public final Provider<ScanSetupBuilderImplApi23> scanSetupBuilderProviderForApi23Provider;

    public ClientComponent_ClientModule_ProvideScanSetupProviderFactory(ScanSetupBuilderImplApi18_Factory scanSetupBuilderImplApi18_Factory, ScanSetupBuilderImplApi21_Factory scanSetupBuilderImplApi21_Factory, ScanSetupBuilderImplApi23_Factory scanSetupBuilderImplApi23_Factory) {
        this.scanSetupBuilderProviderForApi18Provider = scanSetupBuilderImplApi18_Factory;
        this.scanSetupBuilderProviderForApi21Provider = scanSetupBuilderImplApi21_Factory;
        this.scanSetupBuilderProviderForApi23Provider = scanSetupBuilderImplApi23_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ScanSetupBuilderImplApi23 scanSetupBuilderImplApi23;
        int intValue = this.deviceSdkProvider.get().intValue();
        if (intValue < 21) {
            scanSetupBuilderImplApi23 = this.scanSetupBuilderProviderForApi18Provider.get();
        } else if (intValue < 23) {
            scanSetupBuilderImplApi23 = this.scanSetupBuilderProviderForApi21Provider.get();
        } else {
            scanSetupBuilderImplApi23 = this.scanSetupBuilderProviderForApi23Provider.get();
        }
        UnsignedKt.checkNotNullFromProvides(scanSetupBuilderImplApi23);
        return scanSetupBuilderImplApi23;
    }
}
