package com.amplifyframework.auth.cognito.asf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplicationDataCollector.kt */
/* loaded from: classes.dex */
public final class ApplicationDataCollector implements DataCollector {
    private static final int ALL_FLAGS_OFF = 0;
    public static final String APP_NAME = "ApplicationName";
    public static final String APP_TARGET_SDK = "ApplicationTargetSdk";
    public static final String APP_VERSION = "ApplicationVersion";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ApplicationDataCollector";

    /* compiled from: ApplicationDataCollector.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String getAppName(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private final String getAppTargetSdk(Context context) {
        return String.valueOf(context.getApplicationInfo().targetSdkVersion);
    }

    @SuppressLint({"WrongConstant"})
    private final String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(TAG, "Unable to get app version. Provided package name could not be found.");
            return "";
        }
    }

    @Override // com.amplifyframework.auth.cognito.asf.DataCollector
    public Map<String, String> collect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MapsKt__MapsKt.mapOf(new Pair(APP_NAME, getAppName(context)), new Pair(APP_TARGET_SDK, getAppTargetSdk(context)), new Pair(APP_VERSION, getAppVersion(context)));
    }
}
