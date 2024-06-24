package com.google.android.material.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes3.dex */
public final class RippleUtils {
    public static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    public static final int[] SELECTED_PRESSED_STATE_SET = {R.attr.state_selected, R.attr.state_pressed};
    public static final int[] SELECTED_STATE_SET = {R.attr.state_selected};
    public static final int[] ENABLED_PRESSED_STATE_SET = {R.attr.state_enabled, R.attr.state_pressed};

    public static int getColorForState(ColorStateList colorStateList, int[] r2) {
        int r1;
        if (colorStateList != null) {
            r1 = colorStateList.getColorForState(r2, colorStateList.getDefaultColor());
        } else {
            r1 = 0;
        }
        return ColorUtils.setAlphaComponent(r1, Math.min(Color.alpha(r1) * 2, 255));
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
                Log.w("RippleUtils", "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(int[] r8) {
        boolean z = false;
        boolean z2 = false;
        for (int r6 : r8) {
            if (r6 == 16842910) {
                z = true;
            } else if (r6 == 16842908 || r6 == 16842919 || r6 == 16843623) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
