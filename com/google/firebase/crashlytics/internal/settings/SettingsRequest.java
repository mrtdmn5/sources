package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

/* loaded from: classes3.dex */
public final class SettingsRequest {
    public final String buildVersion;
    public final String deviceModel;
    public final String displayVersion;
    public final String googleAppId;
    public final InstallIdProvider installIdProvider;
    public final String instanceId;
    public final String osBuildVersion;
    public final String osDisplayVersion;
    public final int source;

    public SettingsRequest(String str, String str2, String str3, String str4, IdManager idManager, String str5, String str6, String str7, int r9) {
        this.googleAppId = str;
        this.deviceModel = str2;
        this.osBuildVersion = str3;
        this.osDisplayVersion = str4;
        this.installIdProvider = idManager;
        this.instanceId = str5;
        this.displayVersion = str6;
        this.buildVersion = str7;
        this.source = r9;
    }
}
