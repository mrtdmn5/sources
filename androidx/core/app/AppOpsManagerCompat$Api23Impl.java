package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat$Api23Impl {
    public static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static int noteProxyOp(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOp(str, str2);
    }

    public static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    public static String permissionToOp(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
