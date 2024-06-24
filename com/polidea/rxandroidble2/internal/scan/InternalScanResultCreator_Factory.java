package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser_Factory;

/* loaded from: classes3.dex */
public final class InternalScanResultCreator_Factory implements Provider {
    public final Provider<IsConnectableChecker> isConnectableCheckerProvider;
    public final Provider<ScanRecordParser> scanRecordParserProvider = ScanRecordParser_Factory.InstanceHolder.INSTANCE;

    public InternalScanResultCreator_Factory(Provider provider) {
        this.isConnectableCheckerProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new InternalScanResultCreator(this.scanRecordParserProvider.get(), this.isConnectableCheckerProvider.get());
    }
}
