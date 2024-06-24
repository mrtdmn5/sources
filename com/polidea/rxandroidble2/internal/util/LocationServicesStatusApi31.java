package com.polidea.rxandroidble2.internal.util;

import android.annotation.TargetApi;

@TargetApi(31)
/* loaded from: classes3.dex */
public final class LocationServicesStatusApi31 implements LocationServicesStatus {
    public final CheckerLocationProvider checkerLocationProvider;
    public final CheckerScanPermission checkerScanPermission;
    public final boolean isAndroidWear;
    public final boolean isNearbyPermissionNeverForLoc;

    public LocationServicesStatusApi31(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, boolean z, boolean z2) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.isAndroidWear = z;
        this.isNearbyPermissionNeverForLoc = z2;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public final boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public final boolean isLocationProviderOk() {
        boolean z;
        if (this.isAndroidWear) {
            z = false;
        } else {
            z = !this.isNearbyPermissionNeverForLoc;
        }
        if (z && !this.checkerLocationProvider.isLocationProviderEnabled()) {
            return false;
        }
        return true;
    }
}
