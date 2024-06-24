package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class AppCompatBackgroundHelper {
    public TintInfo mBackgroundTint;
    public TintInfo mInternalBackgroundTint;
    public TintInfo mTmpInfo;
    public final View mView;
    public int mBackgroundResId = -1;
    public final AppCompatDrawableManager mDrawableManager = AppCompatDrawableManager.get();

    public AppCompatBackgroundHelper(View view) {
        this.mView = view;
    }

    public final void applySupportBackgroundTint() {
        boolean z;
        View view = this.mView;
        Drawable background = view.getBackground();
        if (background != null) {
            boolean z2 = false;
            if (this.mInternalBackgroundTint != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.mTmpInfo == null) {
                    this.mTmpInfo = new TintInfo();
                }
                TintInfo tintInfo = this.mTmpInfo;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ColorStateList backgroundTintList = ViewCompat.Api21Impl.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.Api21Impl.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = backgroundTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.tintDrawable(background, tintInfo, view.getDrawableState());
                    z2 = true;
                }
                if (z2) {
                    return;
                }
            }
            TintInfo tintInfo2 = this.mBackgroundTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo2, view.getDrawableState());
                return;
            }
            TintInfo tintInfo3 = this.mInternalBackgroundTint;
            if (tintInfo3 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList getSupportBackgroundTintList() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public final PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int r10) {
        ColorStateList tintList;
        View view = this.mView;
        Context context = view.getContext();
        int[] r4 = R$styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, r4, r10);
        View view2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), r4, attributeSet, obtainStyledAttributes.mWrapped, r10);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                this.mBackgroundResId = obtainStyledAttributes.getResourceId(0, -1);
                AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
                Context context2 = view.getContext();
                int r3 = this.mBackgroundResId;
                synchronized (appCompatDrawableManager) {
                    tintList = appCompatDrawableManager.mResourceManager.getTintList(context2, r3);
                }
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (obtainStyledAttributes.hasValue(1)) {
                ViewCompat.Api21Impl.setBackgroundTintList(view, obtainStyledAttributes.getColorStateList(1));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                ViewCompat.Api21Impl.setBackgroundTintMode(view, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(2, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void onSetBackgroundDrawable() {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public final void onSetBackgroundResource(int r4) {
        ColorStateList colorStateList;
        this.mBackgroundResId = r4;
        AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        if (appCompatDrawableManager != null) {
            Context context = this.mView.getContext();
            synchronized (appCompatDrawableManager) {
                colorStateList = appCompatDrawableManager.mResourceManager.getTintList(context, r4);
            }
        } else {
            colorStateList = null;
        }
        setInternalBackgroundTint(colorStateList);
        applySupportBackgroundTint();
    }

    public final void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
