package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
    public final Provider<ScanPreconditionsVerifierApi18> scanPreconditionVerifierForApi18Provider;
    public final Provider<ScanPreconditionsVerifierApi24> scanPreconditionVerifierForApi24Provider;

    public ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory(Provider provider, Provider provider2) {
        this.scanPreconditionVerifierForApi18Provider = provider;
        this.scanPreconditionVerifierForApi24Provider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ScanPreconditionsVerifierApi24 scanPreconditionsVerifierApi24;
        if (this.deviceSdkProvider.get().intValue() < 24) {
            scanPreconditionsVerifierApi24 = this.scanPreconditionVerifierForApi18Provider.get();
        } else {
            scanPreconditionsVerifierApi24 = this.scanPreconditionVerifierForApi24Provider.get();
        }
        UnsignedKt.checkNotNullFromProvides(scanPreconditionsVerifierApi24);
        return scanPreconditionsVerifierApi24;
    }
}
