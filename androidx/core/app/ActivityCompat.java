package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class ActivityCompat extends ContextCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static void finishAffinity(Activity activity) {
            activity.finishAffinity();
        }

        public static void startActivityForResult(Activity activity, Intent intent, int r2, Bundle bundle) {
            activity.startActivityForResult(intent, r2, bundle);
        }

        public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int r2, Intent intent, int r4, int r5, int r6, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, r2, intent, r4, r5, r6, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void setEnterSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void setExitSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static void onSharedElementsReady(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void requestPermissions(Activity activity, String[] strArr, int r2) {
            activity.requestPermissions(strArr, r2);
        }

        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static <T> T requireViewById(Activity activity, int r1) {
            return (T) activity.requireViewById(r1);
        }
    }

    /* loaded from: classes.dex */
    public static class Api31Impl {
        public static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Api32Impl {
        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r1);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (r0 >= 32) {
            return Api32Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        if (r0 == 31) {
            return Api31Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        return Api23Impl.shouldShowRequestPermissionRationale(activity, str);
    }
}
