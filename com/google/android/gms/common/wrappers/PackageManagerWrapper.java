package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class PackageManagerWrapper {
    public final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    public final ApplicationInfo getApplicationInfo(int r2, String str) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getApplicationInfo(str, r2);
    }

    public final PackageInfo getPackageInfo(int r2, String str) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getPackageInfo(str, r2);
    }

    public final boolean isCallerInstantApp() {
        String nameForUid;
        boolean isInstantApp;
        int callingUid = Binder.getCallingUid();
        int myUid = Process.myUid();
        Context context = this.zza;
        if (callingUid == myUid) {
            return InstantApps.isInstantApp(context);
        }
        if (PlatformVersion.isAtLeastO() && (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) != null) {
            isInstantApp = context.getPackageManager().isInstantApp(nameForUid);
            return isInstantApp;
        }
        return false;
    }
}
