package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat$Api29Impl {
    public static int checkOpNoThrow(AppOpsManager appOpsManager, String str, int r2, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, r2, str2);
    }

    public static String getOpPackageName(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager getSystemService(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
