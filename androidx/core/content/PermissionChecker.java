package androidx.core.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat$Api23Impl;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class PermissionChecker {
    public static int checkSelfPermission(Context context, String str) {
        boolean z;
        int noteProxyOpNoThrow;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat$Api23Impl.permissionToOp(str);
        if (permissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int myUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            if (myUid2 == myUid && ObjectsCompat$Api19Impl.equals(packageName2, packageName)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager systemService = AppOpsManagerCompat$Api29Impl.getSystemService(context);
                    noteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, permissionToOp, Binder.getCallingUid(), packageName);
                    if (noteProxyOpNoThrow == 0) {
                        noteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, permissionToOp, myUid, AppOpsManagerCompat$Api29Impl.getOpPackageName(context));
                    }
                } else {
                    noteProxyOpNoThrow = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), permissionToOp, packageName);
                }
            } else {
                noteProxyOpNoThrow = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), permissionToOp, packageName);
            }
            if (noteProxyOpNoThrow != 0) {
                return -2;
            }
        }
        return 0;
    }
}
