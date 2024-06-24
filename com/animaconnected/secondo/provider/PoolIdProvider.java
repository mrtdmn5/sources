package com.animaconnected.secondo.provider;

import android.content.SharedPreferences;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.secondo.KronabyApplication;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PoolIdProvider.kt */
/* loaded from: classes3.dex */
public final class PoolIdProvider {
    private static final String KEY_ON_SANDBOX = "onSandbox";
    private static final String POOL_ID_STORAGE = "poolIdStorage";
    public static final String SANDBOX_CRASH_BUCKET = "sandbox-kronaby-device-crash-bucket";
    public static final String SANDBOX_IDENTITY_POOL_ID = "faf654ee-cef3-4061-91bb-280a5a118554";
    public static final String SANDBOX_REGION = "eu-west-1";
    private final SharedPreferences prefs = KronabyApplication.Companion.getContext().getSharedPreferences(POOL_ID_STORAGE, 0);
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PoolIdProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getPoolIdString(Cloud cloudProvider) {
        Intrinsics.checkNotNullParameter(cloudProvider, "cloudProvider");
        return cloudProvider.getPoolId() + " which is sandbox: " + Intrinsics.areEqual("eu-west-1:faf654ee-cef3-4061-91bb-280a5a118554", cloudProvider.getPoolId()) + "\nCrash bucket: " + cloudProvider.getCrashBucket();
    }

    public final boolean isOnSandbox() {
        return this.prefs.getBoolean(KEY_ON_SANDBOX, false);
    }

    public final void setOnSandbox(boolean z) {
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(KEY_ON_SANDBOX, z);
        edit.commit();
    }
}
