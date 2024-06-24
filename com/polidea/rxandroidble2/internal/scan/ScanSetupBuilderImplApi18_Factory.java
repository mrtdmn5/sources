package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes3.dex */
public final class ScanSetupBuilderImplApi18_Factory implements Provider {
    public final Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    public final Provider<ScanSettingsEmulator> scanSettingsEmulatorProvider;

    public ScanSetupBuilderImplApi18_Factory(Provider provider, Provider provider2, ScanSettingsEmulator_Factory scanSettingsEmulator_Factory) {
        this.rxBleAdapterWrapperProvider = provider;
        this.internalScanResultCreatorProvider = provider2;
        this.scanSettingsEmulatorProvider = scanSettingsEmulator_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanSetupBuilderImplApi18(this.rxBleAdapterWrapperProvider.get(), this.internalScanResultCreatorProvider.get(), this.scanSettingsEmulatorProvider.get());
    }
}
