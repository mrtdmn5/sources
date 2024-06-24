package com.animaconnected.secondo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public class AppUtils {
    @SuppressLint({"InlinedApi"})
    public static int getPendingIntentFlag() {
        return 67108864;
    }

    public static String getVersion(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.versionName);
            sb.append(" (");
            return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, packageInfo.versionCode, ")");
        }
        return "Unknown version";
    }
}
