package com.polidea.rxandroidble2.scan;

import android.os.ParcelUuid;
import java.util.List;

/* loaded from: classes3.dex */
public interface ScanRecord {
    byte[] getBytes();

    String getDeviceName();

    byte[] getManufacturerSpecificData(int r1);

    byte[] getServiceData(ParcelUuid parcelUuid);

    List<ParcelUuid> getServiceSolicitationUuids();

    List<ParcelUuid> getServiceUuids();
}
