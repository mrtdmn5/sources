package com.animaconnected.secondo.behaviour.distress.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.PermissionProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionCompat.kt */
/* loaded from: classes3.dex */
public final class PermissionCompat {
    public static final int $stable = 0;
    public static final PermissionCompat INSTANCE = new PermissionCompat();

    /* compiled from: PermissionCompat.kt */
    /* loaded from: classes3.dex */
    public interface PermissionHelper {
        private default SharedPreferences getPreferences() {
            return getContext().getSharedPreferences("PermissionHelperStorage", 0);
        }

        private default boolean isPermissionFirstTime(String str) {
            SharedPreferences preferences = getPreferences();
            if (preferences == null) {
                return true;
            }
            return preferences.getBoolean(str, true);
        }

        private default SharedPreferences setPermissionFirstTime(String str) {
            SharedPreferences preferences = getPreferences();
            if (preferences != null) {
                PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(preferences, str, false);
                return preferences;
            }
            return null;
        }

        default boolean arePermissionsNotApproved(String[] permissions) {
            boolean z;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            for (String str : permissions) {
                if (ContextCompat.checkSelfPermission(getContext(), str) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        Context getContext();

        default void requestPermissionOrGoToSettings(String[] permissions, Function1<? super String[], Unit> requestPermissions) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(requestPermissions, "requestPermissions");
            List<String> filterMissingPermissions = PermissionProvider.Companion.filterMissingPermissions(permissions, getContext());
            ArrayList arrayList = new ArrayList();
            for (Object obj : filterMissingPermissions) {
                if (shouldShowRequestPermissionRationale((String) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : filterMissingPermissions) {
                if (isPermissionFirstTime((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList plus = CollectionsKt___CollectionsKt.plus((Iterable) arrayList, (Collection) arrayList2);
            if (!plus.isEmpty()) {
                requestPermissions.invoke(plus.toArray(new String[0]));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    setPermissionFirstTime((String) it.next());
                }
                return;
            }
            showAppSettings();
        }

        boolean shouldShowRequestPermissionRationale(String str);

        void showAppSettings();
    }

    /* compiled from: PermissionCompat.kt */
    /* loaded from: classes3.dex */
    public static final class PermissionWrapperActivity implements PermissionHelper {
        public static final int $stable = 8;
        private final Activity activity;
        private Context context;

        public PermissionWrapperActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
            Context applicationContext = activity.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.context = applicationContext;
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public Context getContext() {
            return this.context;
        }

        public void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public boolean shouldShowRequestPermissionRationale(String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            return ActivityCompat.shouldShowRequestPermissionRationale(this.activity, permission);
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public void showAppSettings() {
            PermissionCompat.INSTANCE.showAppSettings(this.activity);
        }
    }

    /* compiled from: PermissionCompat.kt */
    /* loaded from: classes3.dex */
    public static final class PermissionWrapperFragment implements PermissionHelper {
        public static final int $stable = 8;
        private Context context;
        private final Fragment fragment;

        public PermissionWrapperFragment(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            Context requireContext = fragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.context = requireContext;
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public Context getContext() {
            return this.context;
        }

        public void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public boolean shouldShowRequestPermissionRationale(String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            return this.fragment.shouldShowRequestPermissionRationale(permission);
        }

        @Override // com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat.PermissionHelper
        public void showAppSettings() {
            PermissionCompat.INSTANCE.showAppSettings(this.fragment);
        }
    }

    private PermissionCompat() {
    }

    public static final PermissionWrapperActivity create(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new PermissionWrapperActivity(activity);
    }

    public static final boolean isPermissionGranted(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public final void showAppSettings(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivityForResult(intent, 0);
    }

    public static final PermissionWrapperFragment create(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new PermissionWrapperFragment(fragment);
    }

    public final boolean isPermissionGranted(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(KronabyApplication.Companion.getContext(), permission) == 0;
    }

    public final void showAppSettings(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context context = fragment.getContext();
        intent.setData(Uri.fromParts("package", context != null ? context.getPackageName() : null, null));
        fragment.startActivityForResult(intent, 0);
    }
}
