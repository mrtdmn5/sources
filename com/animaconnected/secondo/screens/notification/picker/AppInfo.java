package com.animaconnected.secondo.screens.notification.picker;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppInfo.kt */
/* loaded from: classes3.dex */
public final class AppInfo {
    public static final int $stable = 8;
    private final Drawable appIcon;
    private final String appName;
    private final boolean isInstalled;
    private String packageName;

    public AppInfo(String appName, String packageName, Drawable appIcon, boolean z) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appIcon, "appIcon");
        this.appName = appName;
        this.packageName = packageName;
        this.appIcon = appIcon;
        this.isInstalled = z;
    }

    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean isInstalled() {
        return this.isInstalled;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }
}
