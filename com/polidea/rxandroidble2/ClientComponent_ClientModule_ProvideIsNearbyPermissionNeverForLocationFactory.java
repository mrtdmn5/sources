package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory implements Provider {
    public final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:            if ((r0.requestedPermissionsFlags[r2] & 65536) == 0) goto L15;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:            r1 = true;     */
    @Override // bleshadow.javax.inject.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get() {
        /*
            r5 = this;
            bleshadow.javax.inject.Provider<android.content.Context> r0 = r5.contextProvider
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            android.content.pm.PackageManager r2 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            r3 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            r2 = r1
        L18:
            java.lang.String[] r3 = r0.requestedPermissions     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            int r4 = r3.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            if (r2 >= r4) goto L3e
            java.lang.String r4 = "android.permission.BLUETOOTH_SCAN"
            r3 = r3[r2]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            boolean r3 = r4.equals(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            if (r3 != 0) goto L2a
            int r2 = r2 + 1
            goto L18
        L2a:
            int[] r0 = r0.requestedPermissionsFlags     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            r0 = r0[r2]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L35
            r2 = 65536(0x10000, float:9.1835E-41)
            r0 = r0 & r2
            if (r0 == 0) goto L3e
            r1 = 1
            goto L3e
        L35:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 6
            java.lang.String r4 = "Could not find application PackageInfo"
            com.polidea.rxandroidble2.internal.RxBleLog.throwShade(r3, r0, r4, r2)
        L3e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory.get():java.lang.Object");
    }
}
