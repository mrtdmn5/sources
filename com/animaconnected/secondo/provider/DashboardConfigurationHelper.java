package com.animaconnected.secondo.provider;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes3.dex */
public class DashboardConfigurationHelper {
    private static final int MIN_DASHBOARD_BUTTONS_HEIGHT_DP = 264;

    public static int getDashboardButtonsHeightPx(Resources resources) {
        int r0 = (int) (resources.getConfiguration().screenHeightDp * 0.4f);
        if (r0 < MIN_DASHBOARD_BUTTONS_HEIGHT_DP) {
            r0 = MIN_DASHBOARD_BUTTONS_HEIGHT_DP;
        }
        return (int) TypedValue.applyDimension(1, r0, resources.getDisplayMetrics());
    }
}
