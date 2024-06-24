package com.animaconnected.cloud.util;

/* loaded from: classes.dex */
public class CloudProductInfo {
    private final String mBucket;
    private final String mItemId;
    private final String mPlatform = "android";
    private final String mSerialNumber;

    public CloudProductInfo(String str, String str2, String str3) {
        this.mSerialNumber = str;
        this.mItemId = str2;
        this.mBucket = str3;
    }

    public String getBucket() {
        return this.mBucket;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }
}
