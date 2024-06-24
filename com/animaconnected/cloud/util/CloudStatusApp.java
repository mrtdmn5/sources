package com.animaconnected.cloud.util;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public class CloudStatusApp extends CloudStatus {
    private final String mApplicationVariant;
    private String mName;
    private String mVersion;
    private String mVersionCode;
    private String mVersionName;

    public CloudStatusApp(String str, String str2, String str3, String str4, String str5) {
        this.mName = str;
        this.mVersion = str2;
        this.mVersionCode = str3;
        this.mVersionName = str4;
        this.mApplicationVariant = str5;
    }

    public String getApplicationVariant() {
        return this.mApplicationVariant;
    }

    public String getName() {
        return this.mName;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public void setVersionCode(String str) {
        this.mVersionCode = str;
    }

    public void setVersionName(String str) {
        this.mVersionName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloudStatusApp {mName: ");
        sb.append(this.mName);
        sb.append(" mVersion: ");
        sb.append(this.mVersion);
        sb.append(" mVersionCode: ");
        sb.append(this.mVersionCode);
        sb.append(" mVersionName: ");
        sb.append(this.mVersionName);
        sb.append(" mApplicationVariant: ");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.mApplicationVariant, "}");
    }
}
