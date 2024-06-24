package com.animaconnected.secondo.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionProvider.kt */
/* loaded from: classes3.dex */
public final class PermissionProvider {
    private final Context context;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PermissionProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"InlinedApi"})
        public final List<String> filterMissingPermissions(String[] permissions, Context context) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            for (String str : permissions) {
                if (Intrinsics.areEqual(str, "android.permission.ACCESS_NOTIFICATION_POLICY") && !NotificationUtil.isEnabled(context)) {
                    arrayList.add(str);
                } else if (!PermissionCompat.isPermissionGranted(context, str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && arrayList.size() > 1) {
                arrayList.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
            return arrayList;
        }

        public final boolean isLocationPermission(String[] permissions) {
            boolean z;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            for (String str : permissions) {
                if (!Intrinsics.areEqual(str, "android.permission.ACCESS_FINE_LOCATION") && !Intrinsics.areEqual(str, "android.permission.ACCESS_COARSE_LOCATION") && !Intrinsics.areEqual(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    public PermissionProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean arePermissionsGranted(String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        for (String str : permissions) {
            if (!PermissionCompat.isPermissionGranted(this.context, str)) {
                return false;
            }
        }
        return true;
    }
}
