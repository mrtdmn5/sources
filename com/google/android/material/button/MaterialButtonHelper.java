package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class MaterialButtonHelper {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean checkable;
    public int cornerRadius;
    public int elevation;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    public MaterialShapeDrawable maskDrawable;
    public final MaterialButton materialButton;
    public ColorStateList rippleColor;
    public RippleDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorStateList strokeColor;
    public int strokeWidth;
    public boolean shouldDrawSurfaceColorStroke = false;
    public boolean backgroundOverwritten = false;
    public boolean cornerRadiusSet = false;

    public MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    public final Shapeable getMaskDrawable() {
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 1) {
            if (this.rippleDrawable.getNumberOfLayers() > 2) {
                return (Shapeable) this.rippleDrawable.getDrawable(2);
            }
            return (Shapeable) this.rippleDrawable.getDrawable(1);
        }
        return null;
    }

    public final MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 0) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return null;
    }

    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        if (getMaterialShapeDrawable(false) != null) {
            getMaterialShapeDrawable(false).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaterialShapeDrawable(true) != null) {
            getMaterialShapeDrawable(true).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final void setVerticalInsets(int r9, int r10) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        MaterialButton materialButton = this.materialButton;
        int paddingStart = ViewCompat.Api17Impl.getPaddingStart(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.Api17Impl.getPaddingEnd(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int r5 = this.insetTop;
        int r6 = this.insetBottom;
        this.insetBottom = r10;
        this.insetTop = r9;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        ViewCompat.Api17Impl.setPaddingRelative(materialButton, paddingStart, (paddingTop + r9) - r5, paddingEnd, (paddingBottom + r10) - r6);
    }

    public final void updateBackground() {
        int r5;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        MaterialButton materialButton = this.materialButton;
        materialShapeDrawable.initializeElevationOverlay(materialButton.getContext());
        DrawableCompat$Api21Impl.setTintList(materialShapeDrawable, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat$Api21Impl.setTintMode(materialShapeDrawable, mode);
        }
        float f = this.strokeWidth;
        ColorStateList colorStateList = this.strokeColor;
        materialShapeDrawable.drawableState.strokeWidth = f;
        materialShapeDrawable.invalidateSelf();
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            materialShapeDrawable.onStateChange(materialShapeDrawable.getState());
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        float f2 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke) {
            r5 = MaterialColors.getColor(R.attr.colorSurface, materialButton);
        } else {
            r5 = 0;
        }
        materialShapeDrawable2.drawableState.strokeWidth = f2;
        materialShapeDrawable2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(r5);
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState2 = materialShapeDrawable2.drawableState;
        if (materialShapeDrawableState2.strokeColor != valueOf) {
            materialShapeDrawableState2.strokeColor = valueOf;
            materialShapeDrawable2.onStateChange(materialShapeDrawable2.getState());
        }
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = materialShapeDrawable3;
        DrawableCompat$Api21Impl.setTint(materialShapeDrawable3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.insetLeft, this.insetTop, this.insetRight, this.insetBottom), this.maskDrawable);
        this.rippleDrawable = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawable4 = getMaterialShapeDrawable(false);
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setElevation(this.elevation);
        }
    }

    public final void updateStroke() {
        int r0 = 0;
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable(false);
        MaterialShapeDrawable materialShapeDrawable2 = getMaterialShapeDrawable(true);
        if (materialShapeDrawable != null) {
            float f = this.strokeWidth;
            ColorStateList colorStateList = this.strokeColor;
            materialShapeDrawable.drawableState.strokeWidth = f;
            materialShapeDrawable.invalidateSelf();
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.strokeColor != colorStateList) {
                materialShapeDrawableState.strokeColor = colorStateList;
                materialShapeDrawable.onStateChange(materialShapeDrawable.getState());
            }
            if (materialShapeDrawable2 != null) {
                float f2 = this.strokeWidth;
                if (this.shouldDrawSurfaceColorStroke) {
                    r0 = MaterialColors.getColor(R.attr.colorSurface, this.materialButton);
                }
                materialShapeDrawable2.drawableState.strokeWidth = f2;
                materialShapeDrawable2.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(r0);
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState2 = materialShapeDrawable2.drawableState;
                if (materialShapeDrawableState2.strokeColor != valueOf) {
                    materialShapeDrawableState2.strokeColor = valueOf;
                    materialShapeDrawable2.onStateChange(materialShapeDrawable2.getState());
                }
            }
        }
    }
}
