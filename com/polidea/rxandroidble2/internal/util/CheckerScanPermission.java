package com.polidea.rxandroidble2.internal.util;

import android.os.Process;

/* loaded from: classes3.dex */
public final class CheckerScanPermission {
    public final CheckerPermission checkerPermission;
    public final String[][] scanPermissions;

    public CheckerScanPermission(CheckerPermission checkerPermission, String[][] strArr) {
        this.checkerPermission = checkerPermission;
        this.scanPermissions = strArr;
    }

    public final boolean isScanRuntimePermissionGranted() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        for (String[] strArr : this.scanPermissions) {
            CheckerPermission checkerPermission = this.checkerPermission;
            checkerPermission.getClass();
            int length = strArr.length;
            int r9 = 0;
            while (true) {
                if (r9 < length) {
                    String str = strArr[r9];
                    if (str != null) {
                        if (checkerPermission.context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                        r9++;
                    } else {
                        throw new IllegalArgumentException("permission is null");
                    }
                } else {
                    z = false;
                    break;
                }
            }
            z3 &= z;
        }
        return z3;
    }
}
