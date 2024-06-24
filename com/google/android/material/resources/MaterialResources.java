package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes3.dex */
public final class MaterialResources {
    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int r3) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(r3) || (resourceId = typedArray.getResourceId(r3, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(r3) : colorStateList;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int r3) {
        int resourceId;
        Drawable drawable;
        if (typedArray.hasValue(r3) && (resourceId = typedArray.getResourceId(r3, 0)) != 0 && (drawable = AppCompatResources.getDrawable(context, resourceId)) != null) {
            return drawable;
        }
        return typedArray.getDrawable(r3);
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray tintTypedArray, int r3) {
        int resourceId;
        ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(r3) || (resourceId = tintTypedArray.getResourceId(r3, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(r3) : colorStateList;
    }
}
