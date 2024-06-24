package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes3.dex */
public final class BackgroundScannerImpl_Factory implements Provider {
    public final Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
    public final Provider<InternalToExternalScanResultConverter> internalToExternalScanResultConverterProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    public final Provider<AndroidScanObjectsConverter> scanObjectsConverterProvider;

    public BackgroundScannerImpl_Factory(Provider<RxBleAdapterWrapper> provider, Provider<AndroidScanObjectsConverter> provider2, Provider<InternalScanResultCreator> provider3, Provider<InternalToExternalScanResultConverter> provider4) {
        this.rxBleAdapterWrapperProvider = provider;
        this.scanObjectsConverterProvider = provider2;
        this.internalScanResultCreatorProvider = provider3;
        this.internalToExternalScanResultConverterProvider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        this.rxBleAdapterWrapperProvider.get();
        this.scanObjectsConverterProvider.get();
        this.internalScanResultCreatorProvider.get();
        this.internalToExternalScanResultConverterProvider.get();
        return new BackgroundScannerImpl();
    }
}
