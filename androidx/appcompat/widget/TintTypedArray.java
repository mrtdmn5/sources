package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class TintTypedArray {
    public final Context mContext;
    public TypedValue mTypedValue;
    public final TypedArray mWrapped;

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] r4, int r5) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, r4, r5, 0));
    }

    public final boolean getBoolean(int r2, boolean z) {
        return this.mWrapped.getBoolean(r2, z);
    }

    public final ColorStateList getColorStateList(int r4) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = this.mWrapped;
        if (typedArray.hasValue(r4) && (resourceId = typedArray.getResourceId(r4, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) != null) {
            return colorStateList;
        }
        return typedArray.getColorStateList(r4);
    }

    public final int getDimensionPixelOffset(int r2, int r3) {
        return this.mWrapped.getDimensionPixelOffset(r2, r3);
    }

    public final int getDimensionPixelSize(int r2, int r3) {
        return this.mWrapped.getDimensionPixelSize(r2, r3);
    }

    public final Drawable getDrawable(int r3) {
        int resourceId;
        TypedArray typedArray = this.mWrapped;
        if (typedArray.hasValue(r3) && (resourceId = typedArray.getResourceId(r3, 0)) != 0) {
            return AppCompatResources.getDrawable(this.mContext, resourceId);
        }
        return typedArray.getDrawable(r3);
    }

    public final Drawable getDrawableIfKnown(int r5) {
        int resourceId;
        Drawable drawable;
        if (this.mWrapped.hasValue(r5) && (resourceId = this.mWrapped.getResourceId(r5, 0)) != 0) {
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            Context context = this.mContext;
            synchronized (appCompatDrawableManager) {
                drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
            }
            return drawable;
        }
        return null;
    }

    public final Typeface getFont(int r10, int r11, AppCompatTextHelper.AnonymousClass1 anonymousClass1) {
        int resourceId = this.mWrapped.getResourceId(r10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
        Context context = this.mContext;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, resourceId, typedValue, r11, anonymousClass1, true, false);
    }

    public final int getInt(int r2, int r3) {
        return this.mWrapped.getInt(r2, r3);
    }

    public final int getResourceId(int r2, int r3) {
        return this.mWrapped.getResourceId(r2, r3);
    }

    public final String getString(int r2) {
        return this.mWrapped.getString(r2);
    }

    public final CharSequence getText(int r2) {
        return this.mWrapped.getText(r2);
    }

    public final boolean hasValue(int r2) {
        return this.mWrapped.hasValue(r2);
    }

    public final void recycle() {
        this.mWrapped.recycle();
    }
}
