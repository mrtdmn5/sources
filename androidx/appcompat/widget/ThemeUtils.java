package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public final class ThemeUtils {
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public static final int[] FOCUSED_STATE_SET = {R.attr.state_focused};
    public static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] TEMP_ARRAY = new int[1];

    public static void checkAppCompatTheme(Context context, View view) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int getDisabledThemeAttrColor(Context context, int r5) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, r5);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f = typedValue.getFloat();
        return ColorUtils.setAlphaComponent(getThemeAttrColor(context, r5), Math.round(Color.alpha(r4) * f));
    }

    public static int getThemeAttrColor(Context context, int r3) {
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, r0);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int r3) {
        ColorStateList colorStateList;
        int resourceId;
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, r0);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
