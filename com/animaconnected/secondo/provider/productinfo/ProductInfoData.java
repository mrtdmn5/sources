package com.animaconnected.secondo.provider.productinfo;

import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProductInfoData.kt */
/* loaded from: classes3.dex */
public final class ProductInfoData {
    public static final int DATA_VERSION = 2;

    @SerializedName("assetVersion")
    public String assetVersion;

    @SerializedName("backgroundColor")
    public String backgroundColor;

    @SerializedName("coreUnit")
    private String coreUnit;

    @SerializedName("coreUnitDisplayName")
    private String coreUnitDisplayName;

    @SerializedName("dataVersion")
    private Integer dataVersion;

    @SerializedName(DetailBottomDialog.keyDescription)
    private String description;

    @SerializedName("displayBackgroundColor")
    private String displayBackgroundColor = "";

    @SerializedName("displayForegroundColor")
    private String displayForegroundColor = "";

    @SerializedName("displayHighlightColor")
    private String displayHighlightColor = "";

    @SerializedName("glowUrl")
    private String glowUrl;

    @SerializedName("gradientColor")
    public String gradientColor;

    @SerializedName("gradientOpacity")
    public Double gradientOpacity;

    @SerializedName("mainHourHandUrl")
    private String mainHourHandUrl;

    @SerializedName("mainMinHandUrl")
    private String mainMinHandUrl;

    @SerializedName("shadowOpacity")
    public Double shadowOpacity;

    @SerializedName("sku")
    public String sku;

    @SerializedName("skuUrl")
    private String skuUrl;

    @SerializedName("strap")
    private String strap;

    @SerializedName("subHourHandUrl")
    private String subHourHandUrl;

    @SerializedName("subMinHandUrl")
    private String subMinHandUrl;

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    @SerializedName(AnalyticsConstants.KEY_VERSION)
    private Integer version;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ProductInfoData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getCoreUnit() {
        return this.coreUnit;
    }

    public final String getCoreUnitDisplayName() {
        return this.coreUnitDisplayName;
    }

    public final Integer getDataVersion() {
        return this.dataVersion;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayBackgroundColor() {
        return this.displayBackgroundColor;
    }

    public final String getDisplayForegroundColor() {
        return this.displayForegroundColor;
    }

    public final String getDisplayHighlightColor() {
        return this.displayHighlightColor;
    }

    public final String getGlowUrl() {
        return this.glowUrl;
    }

    public final String getMainHourHandUrl() {
        return this.mainHourHandUrl;
    }

    public final String getMainMinHandUrl() {
        return this.mainMinHandUrl;
    }

    public final String getSkuUrl() {
        return this.skuUrl;
    }

    public final String getStrap() {
        return this.strap;
    }

    public final String getSubHourHandUrl() {
        return this.subHourHandUrl;
    }

    public final String getSubMinHandUrl() {
        return this.subMinHandUrl;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final boolean isDataUpToDate() {
        Integer num = this.dataVersion;
        if (num != null && num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public final void setCoreUnit(String str) {
        this.coreUnit = str;
    }

    public final void setCoreUnitDisplayName(String str) {
        this.coreUnitDisplayName = str;
    }

    public final void setDataVersion(Integer num) {
        this.dataVersion = num;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDisplayBackgroundColor(String str) {
        this.displayBackgroundColor = str;
    }

    public final void setDisplayForegroundColor(String str) {
        this.displayForegroundColor = str;
    }

    public final void setDisplayHighlightColor(String str) {
        this.displayHighlightColor = str;
    }

    public final void setGlowUrl(String str) {
        this.glowUrl = str;
    }

    public final void setMainHourHandUrl(String str) {
        this.mainHourHandUrl = str;
    }

    public final void setMainMinHandUrl(String str) {
        this.mainMinHandUrl = str;
    }

    public final void setSkuUrl(String str) {
        this.skuUrl = str;
    }

    public final void setStrap(String str) {
        this.strap = str;
    }

    public final void setSubHourHandUrl(String str) {
        this.subHourHandUrl = str;
    }

    public final void setSubMinHandUrl(String str) {
        this.subMinHandUrl = str;
    }

    public final void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public final void setVersion(Integer num) {
        this.version = num;
    }
}
