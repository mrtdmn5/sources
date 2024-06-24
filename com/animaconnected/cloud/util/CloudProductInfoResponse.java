package com.animaconnected.cloud.util;

import com.animaconnected.cloud.amazon.lambda.GetProductInfoReturn;

/* loaded from: classes.dex */
public class CloudProductInfoResponse {
    private final String mAssetVersion;
    private final String mBackgroundColor;
    private final String mCoreUnit;
    private final String mCoreUnitDisplayName;
    private final String mDescription;
    private final GetProductInfoReturn.DisplayColors mDisplayColors;
    private final String mGlowUrl;
    private final String mGradientColor;
    private final Double mGradientOpacity;
    private final HandsImageUrl mHandsImageUrl;
    private final String mSKU;
    private final Double mShadowOpacity;
    private final String mSkuImageUrl;
    private final String mStrap;
    private final String mThumbnailImageUrl;
    private final Integer mVersion;

    /* loaded from: classes.dex */
    public static class HandsImageUrl {
        private final String mMainHourHandUrl;
        private final String mMainMinHandUrl;
        private final String mSubHourHandUrl;
        private final String mSubMinHandUrl;

        public HandsImageUrl(String str, String str2, String str3, String str4) {
            this.mMainHourHandUrl = str;
            this.mMainMinHandUrl = str2;
            this.mSubHourHandUrl = str3;
            this.mSubMinHandUrl = str4;
        }

        public String getMainHourHandUrl() {
            return this.mMainHourHandUrl;
        }

        public String getMainMinHandUrl() {
            return this.mMainMinHandUrl;
        }

        public String getSubHourHandUrl() {
            return this.mSubHourHandUrl;
        }

        public String getSubMinHandUrl() {
            return this.mSubMinHandUrl;
        }
    }

    public CloudProductInfoResponse(GetProductInfoReturn getProductInfoReturn) {
        this.mSKU = getProductInfoReturn.getSKU();
        this.mCoreUnit = getProductInfoReturn.getCoreUnit();
        this.mCoreUnitDisplayName = getProductInfoReturn.getCoreUnitDisplayName();
        this.mVersion = getProductInfoReturn.getVersion();
        this.mDescription = getProductInfoReturn.getDescription();
        this.mStrap = getProductInfoReturn.getStrap();
        this.mSkuImageUrl = getProductInfoReturn.getSkuImageUrl();
        this.mThumbnailImageUrl = getProductInfoReturn.getThumbnailImageUrl();
        this.mHandsImageUrl = new HandsImageUrl(getProductInfoReturn.getMainHourHandUrl(), getProductInfoReturn.getMainMinHandUrl(), getProductInfoReturn.getSubHourHandUrl(), getProductInfoReturn.getSubMinHandUrl());
        this.mGlowUrl = getProductInfoReturn.getGlowUrl();
        this.mGradientColor = getProductInfoReturn.getGradientColor();
        this.mGradientOpacity = getProductInfoReturn.getGradientOpacity();
        this.mShadowOpacity = getProductInfoReturn.getShadowOpacity();
        this.mBackgroundColor = getProductInfoReturn.getBackgroundColor();
        this.mAssetVersion = getProductInfoReturn.getAssetVersion();
        this.mDisplayColors = getProductInfoReturn.getDisplayColors();
    }

    public String getAssetVersion() {
        return this.mAssetVersion;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public String getCoreUnit() {
        return this.mCoreUnit;
    }

    public String getCoreUnitDisplayName() {
        return this.mCoreUnitDisplayName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public GetProductInfoReturn.DisplayColors getDisplayColors() {
        return this.mDisplayColors;
    }

    public String getGlowUrl() {
        return this.mGlowUrl;
    }

    public String getGradientColor() {
        return this.mGradientColor;
    }

    public Double getGradientOpacity() {
        return this.mGradientOpacity;
    }

    public HandsImageUrl getHands() {
        return this.mHandsImageUrl;
    }

    public String getSKU() {
        return this.mSKU;
    }

    public Double getShadowOpacity() {
        return this.mShadowOpacity;
    }

    public String getSkuImageUrl() {
        return this.mSkuImageUrl;
    }

    public String getStrap() {
        return this.mStrap;
    }

    public String getThumnailImageUrl() {
        return this.mThumbnailImageUrl;
    }

    public Integer getVersion() {
        return this.mVersion;
    }
}
