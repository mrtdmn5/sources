package com.animaconnected.secondo.provider.productinfo;

import com.animaconnected.cloud.amazon.lambda.GetProductInfoReturn;
import com.animaconnected.cloud.util.CloudProductInfoResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProductInfoStorage.kt */
/* loaded from: classes3.dex */
public final class ProductInfoStorageKt {
    public static final ProductInfoData toProductInfoData(CloudProductInfoResponse cloudProductInfoResponse) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(cloudProductInfoResponse, "<this>");
        ProductInfoData productInfoData = new ProductInfoData();
        productInfoData.setDataVersion(2);
        productInfoData.sku = cloudProductInfoResponse.getSKU();
        productInfoData.setCoreUnit(cloudProductInfoResponse.getCoreUnit());
        productInfoData.setCoreUnitDisplayName(cloudProductInfoResponse.getCoreUnitDisplayName());
        productInfoData.setVersion(cloudProductInfoResponse.getVersion());
        productInfoData.setDescription(cloudProductInfoResponse.getDescription());
        productInfoData.setStrap(cloudProductInfoResponse.getStrap());
        productInfoData.setSkuUrl(cloudProductInfoResponse.getSkuImageUrl());
        productInfoData.setThumbnailUrl(cloudProductInfoResponse.getThumnailImageUrl());
        CloudProductInfoResponse.HandsImageUrl hands = cloudProductInfoResponse.getHands();
        productInfoData.setMainHourHandUrl(hands.getMainHourHandUrl());
        productInfoData.setMainMinHandUrl(hands.getMainMinHandUrl());
        productInfoData.setSubHourHandUrl(hands.getSubHourHandUrl());
        productInfoData.setSubMinHandUrl(hands.getSubMinHandUrl());
        productInfoData.setGlowUrl(cloudProductInfoResponse.getGlowUrl());
        productInfoData.gradientColor = cloudProductInfoResponse.getGradientColor();
        productInfoData.gradientOpacity = cloudProductInfoResponse.getGradientOpacity();
        productInfoData.shadowOpacity = cloudProductInfoResponse.getShadowOpacity();
        productInfoData.backgroundColor = cloudProductInfoResponse.getBackgroundColor();
        productInfoData.assetVersion = cloudProductInfoResponse.getAssetVersion();
        GetProductInfoReturn.DisplayColors displayColors = cloudProductInfoResponse.getDisplayColors();
        String str3 = null;
        if (displayColors != null) {
            str = displayColors.background;
        } else {
            str = null;
        }
        productInfoData.setDisplayBackgroundColor(str);
        GetProductInfoReturn.DisplayColors displayColors2 = cloudProductInfoResponse.getDisplayColors();
        if (displayColors2 != null) {
            str2 = displayColors2.foreground;
        } else {
            str2 = null;
        }
        productInfoData.setDisplayForegroundColor(str2);
        GetProductInfoReturn.DisplayColors displayColors3 = cloudProductInfoResponse.getDisplayColors();
        if (displayColors3 != null) {
            str3 = displayColors3.highlight;
        }
        productInfoData.setDisplayHighlightColor(str3);
        return productInfoData;
    }
}
