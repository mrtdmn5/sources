package com.polidea.rxandroidble2.internal.util;

/* loaded from: classes3.dex */
public final class LocationServicesStatusApi23 implements LocationServicesStatus {
    public final CheckerLocationProvider checkerLocationProvider;
    public final CheckerScanPermission checkerScanPermission;
    public final int deviceSdk;
    public final boolean isAndroidWear;
    public final int targetSdk;

    public LocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, int r3, int r4, boolean z) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.targetSdk = r3;
        this.deviceSdk = r4;
        this.isAndroidWear = z;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public final boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public final boolean isLocationProviderOk() {
        boolean z;
        if (!this.isAndroidWear && (this.deviceSdk >= 29 || this.targetSdk >= 23)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || this.checkerLocationProvider.isLocationProviderEnabled()) {
            return true;
        }
        return false;
    }
}
