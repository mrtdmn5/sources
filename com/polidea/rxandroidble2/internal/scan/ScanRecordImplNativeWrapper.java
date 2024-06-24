package com.polidea.rxandroidble2.internal.scan;

import android.os.Build;
import android.os.ParcelUuid;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.ScanRecord;
import java.util.List;

/* loaded from: classes3.dex */
public final class ScanRecordImplNativeWrapper implements ScanRecord {
    public final android.bluetooth.le.ScanRecord nativeScanRecord;
    public final ScanRecordParser scanRecordParser;

    public ScanRecordImplNativeWrapper(android.bluetooth.le.ScanRecord scanRecord, ScanRecordParser scanRecordParser) {
        this.nativeScanRecord = scanRecord;
        this.scanRecordParser = scanRecordParser;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getBytes() {
        return this.nativeScanRecord.getBytes();
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final String getDeviceName() {
        return this.nativeScanRecord.getDeviceName();
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getManufacturerSpecificData(int r2) {
        return this.nativeScanRecord.getManufacturerSpecificData(r2);
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getServiceData(ParcelUuid parcelUuid) {
        return this.nativeScanRecord.getServiceData(parcelUuid);
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final List<ParcelUuid> getServiceSolicitationUuids() {
        List<ParcelUuid> serviceSolicitationUuids;
        int r0 = Build.VERSION.SDK_INT;
        android.bluetooth.le.ScanRecord scanRecord = this.nativeScanRecord;
        if (r0 >= 29) {
            serviceSolicitationUuids = scanRecord.getServiceSolicitationUuids();
            return serviceSolicitationUuids;
        }
        byte[] bytes = scanRecord.getBytes();
        this.scanRecordParser.getClass();
        return ScanRecordParser.parseFromBytes(bytes).serviceSolicitationUuids;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final List<ParcelUuid> getServiceUuids() {
        return this.nativeScanRecord.getServiceUuids();
    }
}
