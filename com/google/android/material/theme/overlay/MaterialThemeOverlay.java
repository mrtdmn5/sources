package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: classes3.dex */
public final class MaterialThemeOverlay {
    public static final int[] ANDROID_THEME_OVERLAY_ATTRS = {R.attr.theme, com.kronaby.watch.app.R.attr.theme};
    public static final int[] MATERIAL_THEME_OVERLAY_ATTR = {com.kronaby.watch.app.R.attr.materialThemeOverlay};

    public static Context wrap(Context context, AttributeSet attributeSet, int r4, int r5) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MATERIAL_THEME_OVERLAY_ATTR, r4, r5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).mThemeResource == resourceId) {
            z = true;
        } else {
            z = false;
        }
        if (resourceId != 0 && !z) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, resourceId);
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
            int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
            int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
            obtainStyledAttributes2.recycle();
            if (resourceId2 == 0) {
                resourceId2 = resourceId3;
            }
            if (resourceId2 != 0) {
                contextThemeWrapper.getTheme().applyStyle(resourceId2, true);
            }
            return contextThemeWrapper;
        }
        return context;
    }
}
