package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import io.reactivex.internal.operators.observable.ObservableCreate;

/* loaded from: classes3.dex */
public final class ScanOperationApi18 extends ScanOperation<RxBleInternalScanResult, BluetoothAdapter.LeScanCallback> {
    public final EmulatedScanFilterMatcher scanFilterMatcher;
    public final InternalScanResultCreator scanResultCreator;

    public ScanOperationApi18(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, EmulatedScanFilterMatcher emulatedScanFilterMatcher) {
        super(rxBleAdapterWrapper);
        this.scanResultCreator = internalScanResultCreator;
        this.scanFilterMatcher = emulatedScanFilterMatcher;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final Object createScanCallback(final ObservableCreate.CreateEmitter createEmitter) {
        return new BluetoothAdapter.LeScanCallback() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperationApi18.1
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public final void onLeScan(BluetoothDevice bluetoothDevice, int r12, byte[] bArr) {
                ScanOperationApi18 scanOperationApi18 = ScanOperationApi18.this;
                if (!scanOperationApi18.scanFilterMatcher.isEmpty && RxBleLog.isAtLeast(3)) {
                    RxBleLog.loggerSetup.getClass();
                    RxBleLog.d("%s, name=%s, rssi=%d, data=%s", LoggerUtil.commonMacMessage(bluetoothDevice.getAddress()), bluetoothDevice.getName(), Integer.valueOf(r12), LoggerUtil.bytesToHex(bArr));
                }
                scanOperationApi18.scanResultCreator.scanRecordParser.getClass();
                RxBleInternalScanResult rxBleInternalScanResult = new RxBleInternalScanResult(bluetoothDevice, r12, System.nanoTime(), ScanRecordParser.parseFromBytes(bArr), ScanCallbackType.CALLBACK_TYPE_UNSPECIFIED, IsConnectable.LEGACY_UNKNOWN);
                if (scanOperationApi18.scanFilterMatcher.matches(rxBleInternalScanResult)) {
                    ((ObservableCreate.CreateEmitter) createEmitter).onNext(rxBleInternalScanResult);
                }
            }
        };
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter.LeScanCallback leScanCallback2 = leScanCallback;
        if (this.scanFilterMatcher.isEmpty) {
            RxBleLog.d("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        BluetoothAdapter bluetoothAdapter = rxBleAdapterWrapper.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.startLeScan(leScanCallback2);
        }
        throw RxBleAdapterWrapper.nullBluetoothAdapter;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter.LeScanCallback leScanCallback2 = leScanCallback;
        BluetoothAdapter bluetoothAdapter = rxBleAdapterWrapper.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(leScanCallback2);
            return;
        }
        throw RxBleAdapterWrapper.nullBluetoothAdapter;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ScanOperationApi18{");
        EmulatedScanFilterMatcher emulatedScanFilterMatcher = this.scanFilterMatcher;
        if (emulatedScanFilterMatcher.isEmpty) {
            str = "";
        } else {
            str = "ANY_MUST_MATCH -> " + emulatedScanFilterMatcher;
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str, '}');
    }
}
