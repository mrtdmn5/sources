package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes3.dex */
public final class ScanSetupBuilderImplApi21_Factory implements Provider {
    public final Provider<AndroidScanObjectsConverter> androidScanObjectsConverterProvider;
    public final Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    public final Provider<ScanSettingsEmulator> scanSettingsEmulatorProvider;

    public ScanSetupBuilderImplApi21_Factory(Provider provider, Provider provider2, ScanSettingsEmulator_Factory scanSettingsEmulator_Factory, AndroidScanObjectsConverter_Factory androidScanObjectsConverter_Factory) {
        this.rxBleAdapterWrapperProvider = provider;
        this.internalScanResultCreatorProvider = provider2;
        this.scanSettingsEmulatorProvider = scanSettingsEmulator_Factory;
        this.androidScanObjectsConverterProvider = androidScanObjectsConverter_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanSetupBuilderImplApi21(this.rxBleAdapterWrapperProvider.get(), this.internalScanResultCreatorProvider.get(), this.scanSettingsEmulatorProvider.get(), this.androidScanObjectsConverterProvider.get());
    }
}
