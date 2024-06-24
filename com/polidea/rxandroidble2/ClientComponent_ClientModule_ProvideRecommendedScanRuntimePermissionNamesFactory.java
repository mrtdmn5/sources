package com.polidea.rxandroidble2;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDeviceSdkFactory;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory implements Provider {
    public final Provider<Integer> deviceSdkProvider = ClientComponent_ClientModule_ProvideDeviceSdkFactory.InstanceHolder.INSTANCE;
    public final Provider<Boolean> isNearbyServicesNeverForLocationProvider;
    public final Provider<Integer> targetSdkProvider;

    public ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(Provider provider, Provider provider2) {
        this.targetSdkProvider = provider;
        this.isNearbyServicesNeverForLocationProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        String[][] strArr;
        int intValue = this.deviceSdkProvider.get().intValue();
        int intValue2 = this.targetSdkProvider.get().intValue();
        boolean booleanValue = this.isNearbyServicesNeverForLocationProvider.get().booleanValue();
        int min = Math.min(intValue, intValue2);
        if (min < 23) {
            return new String[0];
        }
        if (min < 29) {
            return new String[][]{new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}};
        }
        if (min < 31) {
            return new String[][]{new String[]{"android.permission.ACCESS_FINE_LOCATION"}};
        }
        if (booleanValue) {
            strArr = new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}};
        } else {
            strArr = new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}, new String[]{"android.permission.ACCESS_FINE_LOCATION"}};
        }
        return strArr;
    }
}
