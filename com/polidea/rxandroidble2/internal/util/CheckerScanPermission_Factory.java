package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory;

/* loaded from: classes3.dex */
public final class CheckerScanPermission_Factory implements Provider {
    public final Provider<CheckerPermission> checkerPermissionProvider;
    public final Provider<String[][]> scanPermissionsProvider;

    public CheckerScanPermission_Factory(Provider provider, ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory clientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory) {
        this.checkerPermissionProvider = provider;
        this.scanPermissionsProvider = clientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new CheckerScanPermission(this.checkerPermissionProvider.get(), this.scanPermissionsProvider.get());
    }
}
