package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter;
import com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanRecordImplNativeWrapper;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.ObservableEmitter;
import io.reactivex.internal.operators.observable.ObservableCreate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class ScanOperationApi21 extends ScanOperation<RxBleInternalScanResult, ScanCallback> {
    public final AndroidScanObjectsConverter androidScanObjectsConverter;
    public final EmulatedScanFilterMatcher emulatedScanFilterMatcher;
    public final InternalScanResultCreator internalScanResultCreator;
    public ObservableEmitter<RxBleInternalScanResult> scanEmitter;
    public final ScanFilter[] scanFilters;
    public final ScanSettings scanSettings;

    public ScanOperationApi21(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, AndroidScanObjectsConverter androidScanObjectsConverter, ScanSettings scanSettings, EmulatedScanFilterMatcher emulatedScanFilterMatcher, ScanFilter[] scanFilterArr) {
        super(rxBleAdapterWrapper);
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettings = scanSettings;
        this.emulatedScanFilterMatcher = emulatedScanFilterMatcher;
        this.scanFilters = scanFilterArr;
        this.androidScanObjectsConverter = androidScanObjectsConverter;
        this.scanEmitter = null;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final Object createScanCallback(ObservableCreate.CreateEmitter createEmitter) {
        this.scanEmitter = createEmitter;
        return new ScanCallback() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperationApi21.1
            @Override // android.bluetooth.le.ScanCallback
            public final void onBatchScanResults(List<ScanResult> list) {
                ObservableEmitter<RxBleInternalScanResult> observableEmitter;
                for (ScanResult scanResult : list) {
                    ScanOperationApi21 scanOperationApi21 = ScanOperationApi21.this;
                    InternalScanResultCreator internalScanResultCreator = scanOperationApi21.internalScanResultCreator;
                    internalScanResultCreator.getClass();
                    RxBleInternalScanResult rxBleInternalScanResult = new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord(), internalScanResultCreator.scanRecordParser), ScanCallbackType.CALLBACK_TYPE_BATCH, internalScanResultCreator.isConnectableChecker.check(scanResult));
                    if (scanOperationApi21.emulatedScanFilterMatcher.matches(rxBleInternalScanResult) && (observableEmitter = scanOperationApi21.scanEmitter) != null) {
                        ((ObservableCreate.CreateEmitter) observableEmitter).onNext(rxBleInternalScanResult);
                    }
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public final void onScanFailed(int r5) {
                ObservableEmitter<RxBleInternalScanResult> observableEmitter = ScanOperationApi21.this.scanEmitter;
                if (observableEmitter != null) {
                    int r3 = 5;
                    if (r5 != 1) {
                        if (r5 != 2) {
                            if (r5 != 3) {
                                if (r5 != 4) {
                                    if (r5 != 5) {
                                        RxBleLog.w("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
                                        r3 = Integer.MAX_VALUE;
                                    } else {
                                        r3 = 9;
                                    }
                                } else {
                                    r3 = 8;
                                }
                            } else {
                                r3 = 7;
                            }
                        } else {
                            r3 = 6;
                        }
                    }
                    ((ObservableCreate.CreateEmitter) observableEmitter).tryOnError(new BleScanException(r3));
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public final void onScanResult(int r17, ScanResult scanResult) {
                ScanCallbackType scanCallbackType;
                ObservableEmitter<RxBleInternalScanResult> observableEmitter;
                byte[] bArr;
                ScanOperationApi21 scanOperationApi21 = ScanOperationApi21.this;
                if (!scanOperationApi21.emulatedScanFilterMatcher.isEmpty && RxBleLog.isAtLeast(3)) {
                    RxBleLog.loggerSetup.getClass();
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    Object[] objArr = new Object[4];
                    objArr[0] = LoggerUtil.commonMacMessage(scanResult.getDevice().getAddress());
                    objArr[1] = scanResult.getDevice().getName();
                    objArr[2] = Integer.valueOf(scanResult.getRssi());
                    if (scanRecord != null) {
                        bArr = scanRecord.getBytes();
                    } else {
                        bArr = null;
                    }
                    objArr[3] = LoggerUtil.bytesToHex(bArr);
                    RxBleLog.d("%s, name=%s, rssi=%d, data=%s", objArr);
                }
                InternalScanResultCreator internalScanResultCreator = scanOperationApi21.internalScanResultCreator;
                internalScanResultCreator.getClass();
                ScanRecordImplNativeWrapper scanRecordImplNativeWrapper = new ScanRecordImplNativeWrapper(scanResult.getScanRecord(), internalScanResultCreator.scanRecordParser);
                BluetoothDevice device = scanResult.getDevice();
                int rssi = scanResult.getRssi();
                long timestampNanos = scanResult.getTimestampNanos();
                if (r17 != 1) {
                    if (r17 != 2) {
                        if (r17 != 4) {
                            RxBleLog.w("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", Integer.valueOf(r17));
                            scanCallbackType = ScanCallbackType.CALLBACK_TYPE_UNKNOWN;
                        } else {
                            scanCallbackType = ScanCallbackType.CALLBACK_TYPE_MATCH_LOST;
                        }
                    } else {
                        scanCallbackType = ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
                    }
                } else {
                    scanCallbackType = ScanCallbackType.CALLBACK_TYPE_ALL_MATCHES;
                }
                RxBleInternalScanResult rxBleInternalScanResult = new RxBleInternalScanResult(device, rssi, timestampNanos, scanRecordImplNativeWrapper, scanCallbackType, internalScanResultCreator.isConnectableChecker.check(scanResult));
                if (scanOperationApi21.emulatedScanFilterMatcher.matches(rxBleInternalScanResult) && (observableEmitter = scanOperationApi21.scanEmitter) != null) {
                    ((ObservableCreate.CreateEmitter) observableEmitter).onNext(rxBleInternalScanResult);
                }
            }
        };
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        boolean z;
        ArrayList arrayList;
        ScanCallback scanCallback2 = scanCallback;
        if (this.emulatedScanFilterMatcher.isEmpty) {
            RxBleLog.d("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        AndroidScanObjectsConverter androidScanObjectsConverter = this.androidScanObjectsConverter;
        androidScanObjectsConverter.getClass();
        ScanFilter[] scanFilterArr = this.scanFilters;
        if (scanFilterArr != null && scanFilterArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            arrayList = new ArrayList(scanFilterArr.length);
            for (ScanFilter scanFilter : scanFilterArr) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                ParcelUuid parcelUuid = scanFilter.mServiceDataUuid;
                if (parcelUuid != null) {
                    builder.setServiceData(parcelUuid, scanFilter.mServiceData, scanFilter.mServiceDataMask);
                }
                String str = scanFilter.mDeviceAddress;
                if (str != null) {
                    builder.setDeviceAddress(str);
                }
                arrayList.add(builder.setDeviceName(scanFilter.mDeviceName).setManufacturerData(scanFilter.mManufacturerId, scanFilter.mManufacturerData, scanFilter.mManufacturerDataMask).setServiceUuid(scanFilter.mServiceUuid, scanFilter.mServiceUuidMask).build());
            }
        } else {
            arrayList = null;
        }
        ScanSettings.Builder builder2 = new ScanSettings.Builder();
        int r0 = androidScanObjectsConverter.deviceSdk;
        com.polidea.rxandroidble2.scan.ScanSettings scanSettings = this.scanSettings;
        if (r0 >= 23) {
            builder2.setCallbackType(scanSettings.mCallbackType).setMatchMode(scanSettings.mMatchMode).setNumOfMatches(scanSettings.mNumOfMatchesPerFilter);
        }
        android.bluetooth.le.ScanSettings build = builder2.setReportDelay(scanSettings.mReportDelayMillis).setScanMode(scanSettings.mScanMode).build();
        BluetoothAdapter bluetoothAdapter = rxBleAdapterWrapper.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.getBluetoothLeScanner().startScan(arrayList, build, scanCallback2);
            return true;
        }
        throw RxBleAdapterWrapper.nullBluetoothAdapter;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.ScanOperation
    public final void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        ScanCallback scanCallback2 = scanCallback;
        BluetoothAdapter bluetoothAdapter = rxBleAdapterWrapper.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                RxBleLog.v("BluetoothAdapter is disabled, calling BluetoothLeScanner.stopScan(ScanCallback) may cause IllegalStateException", new Object[0]);
            } else {
                BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
                if (bluetoothLeScanner == null) {
                    RxBleLog.w("Cannot call BluetoothLeScanner.stopScan(ScanCallback) on 'null' reference; BluetoothAdapter.isEnabled() == %b", Boolean.valueOf(bluetoothAdapter.isEnabled()));
                } else {
                    bluetoothLeScanner.stopScan(scanCallback2);
                }
            }
            ObservableEmitter<RxBleInternalScanResult> observableEmitter = this.scanEmitter;
            if (observableEmitter != null) {
                ((ObservableCreate.CreateEmitter) observableEmitter).onComplete();
                this.scanEmitter = null;
                return;
            }
            return;
        }
        throw RxBleAdapterWrapper.nullBluetoothAdapter;
    }

    public final String toString() {
        boolean z;
        String str;
        String str2;
        com.polidea.rxandroidble2.scan.ScanFilter[] scanFilterArr = this.scanFilters;
        if (scanFilterArr != null && scanFilterArr.length != 0) {
            z = false;
        } else {
            z = true;
        }
        EmulatedScanFilterMatcher emulatedScanFilterMatcher = this.emulatedScanFilterMatcher;
        boolean z2 = emulatedScanFilterMatcher.isEmpty;
        StringBuilder sb = new StringBuilder("ScanOperationApi21{");
        String str3 = "";
        if (z) {
            str = "";
        } else {
            str = "ANY_MUST_MATCH -> nativeFilters=" + Arrays.toString(scanFilterArr);
        }
        sb.append(str);
        if (z || z2) {
            str2 = "";
        } else {
            str2 = " and then ";
        }
        sb.append(str2);
        if (!z2) {
            str3 = "ANY_MUST_MATCH -> " + emulatedScanFilterMatcher;
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str3, '}');
    }
}
