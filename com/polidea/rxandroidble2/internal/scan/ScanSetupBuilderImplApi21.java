package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.operations.ScanOperationApi21;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;

/* loaded from: classes3.dex */
public final class ScanSetupBuilderImplApi21 implements ScanSetupBuilder {
    public final AndroidScanObjectsConverter androidScanObjectsConverter;
    public final InternalScanResultCreator internalScanResultCreator;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    public final ScanSettingsEmulator scanSettingsEmulator;

    public ScanSetupBuilderImplApi21(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator, AndroidScanObjectsConverter androidScanObjectsConverter) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettingsEmulator = scanSettingsEmulator;
        this.androidScanObjectsConverter = androidScanObjectsConverter;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder
    public final ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        return new ScanSetup(new ScanOperationApi21(this.rxBleAdapterWrapper, this.internalScanResultCreator, this.androidScanObjectsConverter, scanSettings, new EmulatedScanFilterMatcher(scanFilterArr), null), this.scanSettingsEmulator.emulateCallbackType(scanSettings.mCallbackType));
    }
}
