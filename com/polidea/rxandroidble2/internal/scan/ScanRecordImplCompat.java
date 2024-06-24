package com.polidea.rxandroidble2.internal.scan;

import android.os.ParcelUuid;
import android.util.SparseArray;
import com.polidea.rxandroidble2.scan.ScanRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ScanRecordImplCompat implements ScanRecord {
    public final byte[] bytes;
    public final String deviceName;
    public final SparseArray<byte[]> manufacturerSpecificData;
    public final Map<ParcelUuid, byte[]> serviceData;
    public final List<ParcelUuid> serviceSolicitationUuids;
    public final List<ParcelUuid> serviceUuids;

    public ScanRecordImplCompat(ArrayList arrayList, ArrayList arrayList2, SparseArray sparseArray, HashMap hashMap, String str, byte[] bArr) {
        this.serviceUuids = arrayList;
        this.serviceSolicitationUuids = arrayList2;
        this.manufacturerSpecificData = sparseArray;
        this.serviceData = hashMap;
        this.deviceName = str;
        this.bytes = bArr;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getBytes() {
        return this.bytes;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getManufacturerSpecificData(int r2) {
        return this.manufacturerSpecificData.get(r2);
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final byte[] getServiceData(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.serviceData.get(parcelUuid);
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final List<ParcelUuid> getServiceSolicitationUuids() {
        return this.serviceSolicitationUuids;
    }

    @Override // com.polidea.rxandroidble2.scan.ScanRecord
    public final List<ParcelUuid> getServiceUuids() {
        return this.serviceUuids;
    }
}
