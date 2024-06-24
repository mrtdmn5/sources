package com.animaconnected.cloud.util;

import com.animaconnected.info.FirmwareVariant;

/* loaded from: classes.dex */
public class CloudStatusDevice extends CloudStatus {
    private Boolean mAlwaysSendLatest;
    private String mHwVersion;
    private String mItemId;
    private String mSerialNumber;
    private String mSwVersion;
    private final String mUpdateType;
    private final FirmwareVariant mVariant;

    public CloudStatusDevice(String str, String str2, String str3, String str4, String str5, FirmwareVariant firmwareVariant) {
        this.mItemId = str;
        this.mSerialNumber = str2;
        this.mHwVersion = str3;
        this.mSwVersion = str4;
        this.mAlwaysSendLatest = Boolean.FALSE;
        this.mUpdateType = str5;
        this.mVariant = firmwareVariant;
    }

    public boolean getAlwaysSendLatest() {
        return this.mAlwaysSendLatest.booleanValue();
    }

    public FirmwareVariant getFirmwareVariant() {
        return this.mVariant;
    }

    public String getHwVersion() {
        return this.mHwVersion;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    public String getSwVersion() {
        return this.mSwVersion;
    }

    public String getUpdateType() {
        return this.mUpdateType;
    }

    public void setAlwaysSendLatest(boolean z) {
        this.mAlwaysSendLatest = Boolean.valueOf(z);
    }

    public void setHwVersion(String str) {
        this.mHwVersion = str;
    }

    public void setItemId(String str) {
        this.mItemId = str;
    }

    public void setSerialNumber(String str) {
        this.mSerialNumber = str;
    }

    public void setSwVersion(String str) {
        this.mSwVersion = str;
    }

    public String toString() {
        return "CloudStatusDevice {mItemId: " + this.mItemId + " mSerialNumber: " + this.mSerialNumber + " mHwVersion: " + this.mHwVersion + " mSwVersion: " + this.mSwVersion + " mAlwaysSendLatest: " + this.mAlwaysSendLatest + " mUpdateType: " + this.mUpdateType + " mVariant: " + this.mVariant + "}";
    }

    public CloudStatusDevice(String str, String str2, FirmwareVariant firmwareVariant) {
        this(str, "", "", "", str2, firmwareVariant);
    }
}
