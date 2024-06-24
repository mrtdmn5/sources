package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothAdapter;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes3.dex */
public final class ScanPreconditionsVerifierApi18 implements ScanPreconditionsVerifier {
    public final LocationServicesStatus locationServicesStatus;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;

    public ScanPreconditionsVerifierApi18(RxBleAdapterWrapper rxBleAdapterWrapper, LocationServicesStatus locationServicesStatus) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.locationServicesStatus = locationServicesStatus;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier
    public final void verify(boolean z) {
        boolean z2;
        BluetoothAdapter bluetoothAdapter = this.rxBleAdapterWrapper.bluetoothAdapter;
        boolean z3 = false;
        if (bluetoothAdapter != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                z3 = true;
            }
            if (z3) {
                LocationServicesStatus locationServicesStatus = this.locationServicesStatus;
                if (locationServicesStatus.isLocationPermissionOk()) {
                    if (z && !locationServicesStatus.isLocationProviderOk()) {
                        throw new BleScanException(4);
                    }
                    return;
                }
                throw new BleScanException(3);
            }
            throw new BleScanException(1);
        }
        throw new BleScanException(2);
    }
}
