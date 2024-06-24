package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat$Api21Impl;

/* loaded from: classes.dex */
public final class AppCompatImageHelper {
    public TintInfo mImageTint;
    public int mLevel = 0;
    public final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    public final void applySupportImageTint() {
        TintInfo tintInfo;
        ImageView imageView = this.mView;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null && (tintInfo = this.mImageTint) != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, imageView.getDrawableState());
        }
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int r10) {
        int resourceId;
        ImageView imageView = this.mView;
        Context context = imageView.getContext();
        int[] r2 = R$styleable.AppCompatImageView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, r2, r10);
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), r2, attributeSet, obtainStyledAttributes.mWrapped, r10);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(1, -1)) != -1 && (drawable = AppCompatResources.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (obtainStyledAttributes.hasValue(2)) {
                ImageViewCompat$Api21Impl.setImageTintList(imageView, obtainStyledAttributes.getColorStateList(2));
            }
            if (obtainStyledAttributes.hasValue(3)) {
                ImageViewCompat$Api21Impl.setImageTintMode(imageView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(3, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setImageResource(int r3) {
        ImageView imageView = this.mView;
        if (r3 != 0) {
            Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), r3);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        applySupportImageTint();
    }
}
