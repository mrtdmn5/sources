package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi21;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.ObservableTransformer;

/* loaded from: classes3.dex */
public final class ScanSetupBuilderImplApi23 implements ScanSetupBuilder {
    public final AndroidScanObjectsConverter androidScanObjectsConverter;
    public final InternalScanResultCreator internalScanResultCreator;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    public final ScanSettingsEmulator scanSettingsEmulator;

    public ScanSetupBuilderImplApi23(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator, AndroidScanObjectsConverter androidScanObjectsConverter) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettingsEmulator = scanSettingsEmulator;
        this.androidScanObjectsConverter = androidScanObjectsConverter;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder
    public final ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        boolean z;
        ScanSettings scanSettings2;
        boolean z2 = true;
        boolean z3 = true;
        for (ScanFilter scanFilter : scanFilterArr) {
            z3 &= scanFilter.equals(ScanFilter.EMPTY);
        }
        boolean z4 = !z3;
        int r5 = scanSettings.mCallbackType;
        if (r5 != 1) {
            z = true;
        } else {
            z = false;
        }
        ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> observableTransformer = ObservableUtil.IDENTITY_TRANSFORMER;
        if (!z || z4) {
            z2 = false;
        }
        if (z2) {
            RxBleLog.d("ScanSettings.callbackType != CALLBACK_TYPE_ALL_MATCHES but no (or only empty) filters are specified. Falling back to callbackType emulation.", new Object[0]);
            observableTransformer = this.scanSettingsEmulator.emulateCallbackType(r5);
            scanSettings2 = new ScanSettings(scanSettings.mScanMode, 1, scanSettings.mReportDelayMillis, scanSettings.mMatchMode, scanSettings.mNumOfMatchesPerFilter, scanSettings.mShouldCheckLocationProviderState);
        } else {
            scanSettings2 = scanSettings;
        }
        return new ScanSetup(new ScanOperationApi21(this.rxBleAdapterWrapper, this.internalScanResultCreator, this.androidScanObjectsConverter, scanSettings2, new EmulatedScanFilterMatcher(new ScanFilterInterface[0]), scanFilterArr), observableTransformer);
    }
}
