package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;

/* loaded from: classes.dex */
public final class PackageManagerHelper {
    public static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    public static void setComponentEnabled(Context context, Class<?> klazz, boolean enabled) {
        int r9;
        Object obj;
        String str = "enabled";
        String str2 = TAG;
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, klazz.getName());
            if (enabled) {
                r9 = 1;
            } else {
                r9 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, r9, 1);
            Logger logger = Logger.get();
            Object[] objArr = new Object[2];
            objArr[0] = klazz.getName();
            if (enabled) {
                obj = "enabled";
            } else {
                obj = "disabled";
            }
            objArr[1] = obj;
            logger.debug(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e) {
            Logger logger2 = Logger.get();
            Object[] objArr2 = new Object[2];
            objArr2[0] = klazz.getName();
            if (!enabled) {
                str = "disabled";
            }
            objArr2[1] = str;
            logger2.debug(str2, String.format("%s could not be %s", objArr2), e);
        }
    }
}
