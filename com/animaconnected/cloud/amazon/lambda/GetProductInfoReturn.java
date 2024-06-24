package com.animaconnected.cloud.amazon.lambda;

/* loaded from: classes.dex */
public class GetProductInfoReturn {
    private String SKU;
    private String asset_version;
    private String background_color;
    private String core_unit;
    private String core_unit_display_name;
    private String description;
    private DisplayColors display_colors;
    private String glow;
    private String gradient_color;
    private Double gradient_opacity;
    private Hands hands;
    private Double shadow_opacity;
    private String sku_image;
    private String strap;
    private String thumbnail_image;
    private Integer version;

    /* loaded from: classes.dex */
    public static class DisplayColors {
        public String background;
        public String foreground;
        public String highlight;
    }

    /* loaded from: classes.dex */
    public static class Hands {
        private String main_hr;
        private String main_min;
        private String sub_hr;
        private String sub_min;
    }

    public String getAssetVersion() {
        return this.asset_version;
    }

    public String getBackgroundColor() {
        return this.background_color;
    }

    public String getCoreUnit() {
        return this.core_unit;
    }

    public String getCoreUnitDisplayName() {
        return this.core_unit_display_name;
    }

    public String getDescription() {
        return this.description;
    }

    public DisplayColors getDisplayColors() {
        return this.display_colors;
    }

    public String getGlowUrl() {
        return this.glow;
    }

    public String getGradientColor() {
        return this.gradient_color;
    }

    public Double getGradientOpacity() {
        return this.gradient_opacity;
    }

    public String getMainHourHandUrl() {
        return this.hands.main_hr;
    }

    public String getMainMinHandUrl() {
        return this.hands.main_min;
    }

    public String getSKU() {
        return this.SKU;
    }

    public Double getShadowOpacity() {
        return this.shadow_opacity;
    }

    public String getSkuImageUrl() {
        return this.sku_image;
    }

    public String getStrap() {
        return this.strap;
    }

    public String getSubHourHandUrl() {
        return this.hands.sub_hr;
    }

    public String getSubMinHandUrl() {
        return this.hands.sub_min;
    }

    public String getThumbnailImageUrl() {
        return this.thumbnail_image;
    }

    public Integer getVersion() {
        return this.version;
    }
}
