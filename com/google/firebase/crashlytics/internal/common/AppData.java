package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class AppData {
    public final String buildId;
    public final List<BuildIdInfo> buildIdInfoList;
    public final DevelopmentPlatformProvider developmentPlatformProvider;
    public final String googleAppId;
    public final String installerPackageName;
    public final String packageName;
    public final String versionCode;
    public final String versionName;

    public AppData(String str, String str2, ArrayList arrayList, String str3, String str4, String str5, String str6, DevelopmentPlatformProvider developmentPlatformProvider) {
        this.googleAppId = str;
        this.buildId = str2;
        this.buildIdInfoList = arrayList;
        this.installerPackageName = str3;
        this.packageName = str4;
        this.versionCode = str5;
        this.versionName = str6;
        this.developmentPlatformProvider = developmentPlatformProvider;
    }
}
