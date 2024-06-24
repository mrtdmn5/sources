package com.google.android.material.motion;

/* loaded from: classes3.dex */
public final class MotionUtils {
    public static float getControlPoint(int r2, String[] strArr) {
        float parseFloat = Float.parseFloat(strArr[r2]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static boolean isEasingType(String str, String str2) {
        if (str.startsWith(str2.concat("(")) && str.endsWith(")")) {
            return true;
        }
        return false;
    }
}
