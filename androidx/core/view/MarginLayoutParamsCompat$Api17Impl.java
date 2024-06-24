package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat$Api17Impl {
    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int r1) {
        marginLayoutParams.resolveLayoutDirection(r1);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int r1) {
        marginLayoutParams.setLayoutDirection(r1);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int r1) {
        marginLayoutParams.setMarginEnd(r1);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int r1) {
        marginLayoutParams.setMarginStart(r1);
    }
}
