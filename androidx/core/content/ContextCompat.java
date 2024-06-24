package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.File;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ContextCompat {
    public static final Object sLock = new Object();
    public static final Object sSync = new Object();

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static void startActivities(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        public static void startActivity(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        public static File[] getExternalCacheDirs(Context context) {
            return context.getExternalCacheDirs();
        }

        public static File[] getExternalFilesDirs(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        public static File[] getObbDirs(Context context) {
            return context.getObbDirs();
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable getDrawable(Context context, int r1) {
            return context.getDrawable(r1);
        }

        public static File getNoBackupFilesDir(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static int getColor(Context context, int r1) {
            return context.getColor(r1);
        }

        public static <T> T getSystemService(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static String getSystemServiceName(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        public static File getDataDir(Context context) {
            return context.getDataDir();
        }

        public static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int r11) {
            if ((r11 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, r11 & 1);
        }

        public static ComponentName startForegroundService(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class Api33Impl {
        public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int r5) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, r5);
        }
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                if (NotificationManagerCompat.Api24Impl.areNotificationsEnabled(new NotificationManagerCompat(context).mNotificationManager)) {
                    return 0;
                }
                return -1;
            }
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static String obtainAndCheckReceiverPermission(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (PermissionChecker.checkSelfPermission(context, str) == 0) {
            return str;
        }
        throw new RuntimeException(zzav$$ExternalSyntheticOutline0.m("Permission ", str, " is required by your application to receive broadcasts, please add it to your manifest"));
    }

    public static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int r9) {
        int r0 = r9 & 1;
        if (r0 != 0 && (r9 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (r0 != 0) {
            r9 |= 2;
        }
        int r5 = r9;
        int r92 = r5 & 2;
        if (r92 == 0 && (r5 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (r92 != 0 && (r5 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        int r93 = Build.VERSION.SDK_INT;
        if (r93 >= 33) {
            Api33Impl.registerReceiver(context, broadcastReceiver, intentFilter, null, null, r5);
            return;
        }
        if (r93 >= 26) {
            Api26Impl.registerReceiver(context, broadcastReceiver, intentFilter, null, null, r5);
        } else if ((r5 & 4) != 0) {
            context.registerReceiver(broadcastReceiver, intentFilter, obtainAndCheckReceiverPermission(context), null);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null);
        }
    }
}
