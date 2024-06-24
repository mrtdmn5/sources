package com.animaconnected.secondo.utils;

import android.content.Context;
import com.animaconnected.bluetooth.device.scanner.BrandFilter;
import com.animaconnected.bluetooth.util.BrandId;

/* loaded from: classes3.dex */
public final class BrandUtils {
    private static final String APP_ID = "kronaby";
    private static final BrandId BRAND_ID = BrandId.Kronaby;

    public static String getAppId() {
        return "kronaby";
    }

    public static BrandFilter getBrandFilter() {
        return new BrandFilter(BRAND_ID, true);
    }

    public static String getCustomerSupportEmail(Context context) {
        return "support@kronaby.com";
    }
}
