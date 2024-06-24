package com.animaconnected.cloud.util;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public class CloudStatusMobile extends CloudStatus {
    private String mManufacturer;
    private String mModel;
    private String mPlatformName;
    private String mPlatformVersion;

    public CloudStatusMobile(String str, String str2, String str3, String str4) {
        this.mManufacturer = str;
        this.mModel = str2;
        this.mPlatformName = str3;
        this.mPlatformVersion = str4;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getPlatformName() {
        return this.mPlatformName;
    }

    public String getPlatformVersion() {
        return this.mPlatformVersion;
    }

    public void setItemId(String str) {
        this.mPlatformVersion = str;
    }

    public void setManufacturer(String str) {
        this.mManufacturer = str;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public void setPlatformName(String str) {
        this.mPlatformName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloudStatusMobile {mManufacturer: ");
        sb.append(this.mManufacturer);
        sb.append(" mModel: ");
        sb.append(this.mModel);
        sb.append(" mPlatformName: ");
        sb.append(this.mPlatformName);
        sb.append(" mPlatformVersion: ");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.mPlatformVersion, "}");
    }
}
