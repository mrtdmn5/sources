package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CheckerConnectPermission_Factory implements Provider {
    public final Provider<CheckerPermission> checkerPermissionProvider;
    public final Provider<String[][]> connectPermissionsProvider;

    public CheckerConnectPermission_Factory(Provider<CheckerPermission> provider, Provider<String[][]> provider2) {
        this.checkerPermissionProvider = provider;
        this.connectPermissionsProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        this.checkerPermissionProvider.get();
        this.connectPermissionsProvider.get();
        return new CheckerConnectPermission();
    }
}
