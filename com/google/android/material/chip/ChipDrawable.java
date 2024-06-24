package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] DEFAULT_STATE = {R.attr.state_enabled};
    public static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    public int alpha;
    public boolean checkable;
    public Drawable checkedIcon;
    public ColorStateList checkedIconTint;
    public boolean checkedIconVisible;
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius;
    public float chipEndPadding;
    public Drawable chipIcon;
    public float chipIconSize;
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint;
    public float chipStartPadding;
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    public ColorStateList chipSurfaceColor;
    public Drawable closeIcon;
    public SpannableStringBuilder closeIconContentDescription;
    public float closeIconEndPadding;
    public RippleDrawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    public ColorFilter colorFilter;
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    public int currentChipBackgroundColor;
    public int currentChipStrokeColor;
    public int currentChipSurfaceColor;
    public int currentCompatRippleColor;
    public int currentCompositeSurfaceBackgroundColor;
    public int currentTextColor;
    public int currentTint;
    public WeakReference<Delegate> delegate;
    public final Paint.FontMetrics fontMetrics;
    public boolean hasChipIconTint;
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public final PointF pointF;
    public final RectF rectF;
    public ColorStateList rippleColor;
    public final Path shapePath;
    public boolean shouldDrawText;
    public MotionSpec showMotionSpec;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    public ColorStateList tint;
    public PorterDuffColorFilter tintFilter;
    public PorterDuff.Mode tintMode;
    public TextUtils.TruncateAt truncateAt;
    public boolean useCompatRipple;

    /* loaded from: classes3.dex */
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public ChipDrawable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.kronaby.watch.app.R.attr.chipStyle, 2132083784);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.context = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.text = "";
        textDrawableHelper.textPaint.density = context.getResources().getDisplayMetrics().density;
        int[] r3 = DEFAULT_STATE;
        setState(r3);
        if (!Arrays.equals(this.closeIconStateSet, r3)) {
            this.closeIconStateSet = r3;
            if (showsCloseIcon()) {
                onStateChange(getState(), r3);
            }
        }
        this.shouldDrawText = true;
        closeIconRippleMask.setTint(-1);
    }

    public static void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void applyChildDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat$Api23Impl.setLayoutDirection(drawable, DrawableCompat$Api23Impl.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(this.closeIconStateSet);
            }
            DrawableCompat$Api21Impl.setTintList(drawable, this.closeIconTint);
            return;
        }
        Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            DrawableCompat$Api21Impl.setTintList(drawable2, this.chipIconTint);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF) {
        Drawable drawable;
        Drawable drawable2;
        float f;
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f2 = this.chipStartPadding + this.iconStartPadding;
            if (this.currentChecked) {
                drawable = this.checkedIcon;
            } else {
                drawable = this.chipIcon;
            }
            float f3 = this.chipIconSize;
            if (f3 <= 0.0f && drawable != null) {
                f3 = drawable.getIntrinsicWidth();
            }
            if (DrawableCompat$Api23Impl.getLayoutDirection(this) == 0) {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + f3;
            } else {
                float f5 = rect.right - f2;
                rectF.right = f5;
                rectF.left = f5 - f3;
            }
            if (this.currentChecked) {
                drawable2 = this.checkedIcon;
            } else {
                drawable2 = this.chipIcon;
            }
            float f6 = this.chipIconSize;
            if (f6 <= 0.0f && drawable2 != null) {
                f6 = (float) Math.ceil(ViewUtils.dpToPx(this.context, 24));
                if (drawable2.getIntrinsicHeight() <= f6) {
                    f = drawable2.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f;
                }
            }
            f = f6;
            float exactCenterY2 = rect.exactCenterY() - (f / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f;
        }
    }

    public final float calculateChipIconWidth() {
        Drawable drawable;
        if (!showsChipIcon() && !showsCheckedIcon()) {
            return 0.0f;
        }
        float f = this.iconStartPadding;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f2 = this.chipIconSize;
        if (f2 <= 0.0f && drawable != null) {
            f2 = drawable.getIntrinsicWidth();
        }
        return f2 + f + this.iconEndPadding;
    }

    public final float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int r5;
        int r11;
        RectF rectF;
        int r3;
        int r52;
        int r0;
        RectF rectF2;
        boolean z;
        int r2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (r5 = this.alpha) != 0) {
            if (r5 < 255) {
                r11 = canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, r5);
            } else {
                r11 = 0;
            }
            boolean z2 = this.isShapeThemingEnabled;
            Paint paint = this.chipPaint;
            RectF rectF3 = this.rectF;
            if (!z2) {
                paint.setColor(this.currentChipSurfaceColor);
                paint.setStyle(Paint.Style.FILL);
                rectF3.set(bounds);
                canvas.drawRoundRect(rectF3, getChipCornerRadius(), getChipCornerRadius(), paint);
            }
            if (!this.isShapeThemingEnabled) {
                paint.setColor(this.currentChipBackgroundColor);
                paint.setStyle(Paint.Style.FILL);
                ColorFilter colorFilter = this.colorFilter;
                if (colorFilter == null) {
                    colorFilter = this.tintFilter;
                }
                paint.setColorFilter(colorFilter);
                rectF3.set(bounds);
                canvas.drawRoundRect(rectF3, getChipCornerRadius(), getChipCornerRadius(), paint);
            }
            if (this.isShapeThemingEnabled) {
                super.draw(canvas);
            }
            if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
                paint.setColor(this.currentChipStrokeColor);
                paint.setStyle(Paint.Style.STROKE);
                if (!this.isShapeThemingEnabled) {
                    ColorFilter colorFilter2 = this.colorFilter;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.tintFilter;
                    }
                    paint.setColorFilter(colorFilter2);
                }
                float f = bounds.left;
                float f2 = this.chipStrokeWidth / 2.0f;
                rectF3.set(f + f2, bounds.top + f2, bounds.right - f2, bounds.bottom - f2);
                float f3 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
                canvas.drawRoundRect(rectF3, f3, f3, paint);
            }
            paint.setColor(this.currentCompatRippleColor);
            paint.setStyle(Paint.Style.FILL);
            rectF3.set(bounds);
            if (!this.isShapeThemingEnabled) {
                canvas.drawRoundRect(rectF3, getChipCornerRadius(), getChipCornerRadius(), paint);
            } else {
                RectF rectF4 = new RectF(bounds);
                Path path = this.shapePath;
                ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
                shapeAppearancePathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, materialShapeDrawableState.interpolation, rectF4, this.pathShadowListener, path);
                drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
            }
            if (showsChipIcon()) {
                calculateChipIconBounds(bounds, rectF3);
                float f4 = rectF3.left;
                float f5 = rectF3.top;
                canvas.translate(f4, f5);
                this.chipIcon.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
                this.chipIcon.draw(canvas);
                canvas.translate(-f4, -f5);
            }
            if (showsCheckedIcon()) {
                calculateChipIconBounds(bounds, rectF3);
                float f6 = rectF3.left;
                float f7 = rectF3.top;
                canvas.translate(f6, f7);
                this.checkedIcon.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
                this.checkedIcon.draw(canvas);
                canvas.translate(-f6, -f7);
            }
            if (this.shouldDrawText && this.text != null) {
                PointF pointF = this.pointF;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                CharSequence charSequence = this.text;
                TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
                if (charSequence != null) {
                    float calculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    if (DrawableCompat$Api23Impl.getLayoutDirection(this) == 0) {
                        pointF.x = bounds.left + calculateChipIconWidth;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = bounds.right - calculateChipIconWidth;
                        align = Paint.Align.RIGHT;
                    }
                    float centerY = bounds.centerY();
                    TextPaint textPaint = textDrawableHelper.textPaint;
                    Paint.FontMetrics fontMetrics = this.fontMetrics;
                    textPaint.getFontMetrics(fontMetrics);
                    pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                rectF3.setEmpty();
                if (this.text != null) {
                    float calculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    float calculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                    if (DrawableCompat$Api23Impl.getLayoutDirection(this) == 0) {
                        rectF3.left = bounds.left + calculateChipIconWidth2;
                        rectF3.right = bounds.right - calculateCloseIconWidth;
                    } else {
                        rectF3.left = bounds.left + calculateCloseIconWidth;
                        rectF3.right = bounds.right - calculateChipIconWidth2;
                    }
                    rectF3.top = bounds.top;
                    rectF3.bottom = bounds.bottom;
                }
                TextAppearance textAppearance = textDrawableHelper.textAppearance;
                TextPaint textPaint2 = textDrawableHelper.textPaint;
                if (textAppearance != null) {
                    textPaint2.drawableState = getState();
                    textDrawableHelper.textAppearance.updateDrawState(this.context, textPaint2, textDrawableHelper.fontCallback);
                }
                textPaint2.setTextAlign(align);
                if (Math.round(textDrawableHelper.getTextWidth(this.text.toString())) > Math.round(rectF3.width())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    r2 = canvas.save();
                    canvas.clipRect(rectF3);
                } else {
                    r2 = 0;
                }
                CharSequence charSequence2 = this.text;
                if (z && this.truncateAt != null) {
                    charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF3.width(), this.truncateAt);
                }
                CharSequence charSequence3 = charSequence2;
                int length = charSequence3.length();
                float f8 = pointF.x;
                float f9 = pointF.y;
                rectF = rectF3;
                r3 = r11;
                r52 = 0;
                r0 = 255;
                canvas.drawText(charSequence3, 0, length, f8, f9, textPaint2);
                if (z) {
                    canvas.restoreToCount(r2);
                }
            } else {
                rectF = rectF3;
                r3 = r11;
                r52 = 0;
                r0 = 255;
            }
            if (showsCloseIcon()) {
                rectF.setEmpty();
                if (showsCloseIcon()) {
                    float f10 = this.chipEndPadding + this.closeIconEndPadding;
                    if (DrawableCompat$Api23Impl.getLayoutDirection(this) == 0) {
                        float f11 = bounds.right - f10;
                        rectF2 = rectF;
                        rectF2.right = f11;
                        rectF2.left = f11 - this.closeIconSize;
                    } else {
                        rectF2 = rectF;
                        float f12 = bounds.left + f10;
                        rectF2.left = f12;
                        rectF2.right = f12 + this.closeIconSize;
                    }
                    float exactCenterY = bounds.exactCenterY();
                    float f13 = this.closeIconSize;
                    float f14 = exactCenterY - (f13 / 2.0f);
                    rectF2.top = f14;
                    rectF2.bottom = f14 + f13;
                } else {
                    rectF2 = rectF;
                }
                float f15 = rectF2.left;
                float f16 = rectF2.top;
                canvas.translate(f15, f16);
                this.closeIcon.setBounds(r52, r52, (int) rectF2.width(), (int) rectF2.height());
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
                canvas.translate(-f15, -f16);
            }
            if (this.alpha < r0) {
                canvas.restoreToCount(r3);
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.alpha;
    }

    public final float getChipCornerRadius() {
        if (this.isShapeThemingEnabled) {
            return this.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(getBoundsAsRectF());
        }
        return this.chipCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + this.textDrawableHelper.getTextWidth(this.text.toString()) + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public final void getOutline(Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        }
        outline.setAlpha(this.alpha / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor)) {
            return true;
        }
        if (this.useCompatRipple && isStateful(this.compatRippleColor)) {
            return true;
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        if ((textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.checkedIconVisible && this.checkedIcon != null && this.checkable) || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int r3) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(r3);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= DrawableCompat$Api23Impl.setLayoutDirection(this.chipIcon, r3);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= DrawableCompat$Api23Impl.setLayoutDirection(this.checkedIcon, r3);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= DrawableCompat$Api23Impl.setLayoutDirection(this.closeIcon, r3);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r3) {
        boolean onLevelChange = super.onLevelChange(r3);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(r3);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(r3);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(r3);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final void onSizeChange() {
        Delegate delegate = this.delegate.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] r2) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(r2);
        }
        return onStateChange(r2, this.closeIconStateSet);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        if (this.alpha != r2) {
            this.alpha = r2;
            invalidateSelf();
        }
    }

    public final void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCheckedIconTint(ColorStateList colorStateList) {
        boolean z;
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (this.checkedIconVisible && this.checkedIcon != null && this.checkable) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                DrawableCompat$Api21Impl.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCheckedIconVisible(boolean z) {
        boolean z2;
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Deprecated
    public final void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setChipIcon(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.chipIcon;
        Drawable drawable4 = null;
        if (drawable3 != 0) {
            boolean z = drawable3 instanceof WrappedDrawable;
            drawable2 = drawable3;
            if (z) {
                drawable2 = ((WrappedDrawable) drawable3).getWrappedDrawable();
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable4 = drawable.mutate();
            }
            this.chipIcon = drawable4;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(drawable2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat$Api21Impl.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setChipIconVisible(boolean z) {
        boolean z2;
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public final void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
                if (materialShapeDrawableState.strokeColor != colorStateList) {
                    materialShapeDrawableState.strokeColor = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                this.drawableState.strokeWidth = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCloseIcon(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.closeIcon;
        Drawable drawable4 = null;
        if (drawable3 != 0) {
            boolean z = drawable3 instanceof WrappedDrawable;
            drawable2 = drawable3;
            if (z) {
                drawable2 = ((WrappedDrawable) drawable3).getWrappedDrawable();
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            if (drawable != null) {
                drawable4 = drawable.mutate();
            }
            this.closeIcon = drawable4;
            this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), this.closeIcon, closeIconRippleMask);
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(drawable2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat$Api21Impl.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCloseIconVisible(boolean z) {
        boolean z2;
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public final void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setRippleColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (this.useCompatRipple) {
                colorStateList2 = RippleUtils.sanitizeRippleDrawableColor(colorStateList);
            } else {
                colorStateList2 = null;
            }
            this.compatRippleColor = colorStateList2;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (this.tintMode != mode) {
            this.tintMode = mode;
            ColorStateList colorStateList = this.tint;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            } else {
                porterDuffColorFilter = null;
            }
            this.tintFilter = porterDuffColorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        if (this.checkedIconVisible && this.checkedIcon != null && this.currentChecked) {
            return true;
        }
        return false;
    }

    public final boolean showsChipIcon() {
        if (this.chipIconVisible && this.chipIcon != null) {
            return true;
        }
        return false;
    }

    public final boolean showsCloseIcon() {
        if (this.closeIconVisible && this.closeIcon != null) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final boolean onStateChange(int[] r9, int[] r10) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(r9);
        ColorStateList colorStateList2 = this.chipSurfaceColor;
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(r9, this.currentChipSurfaceColor) : 0);
        boolean z3 = true;
        if (this.currentChipSurfaceColor != compositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipBackgroundColor;
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList3 != null ? colorStateList3.getColorForState(r9, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != compositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int compositeColors = ColorUtils.compositeColors(compositeElevationOverlayIfNeeded2, compositeElevationOverlayIfNeeded);
        if ((this.currentCompositeSurfaceBackgroundColor != compositeColors) | (this.drawableState.fillColor == null)) {
            this.currentCompositeSurfaceBackgroundColor = compositeColors;
            setFillColor(ColorStateList.valueOf(compositeColors));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.chipStrokeColor;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(r9, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState) {
            this.currentChipStrokeColor = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(r9)) ? 0 : this.compatRippleColor.getColorForState(r9, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState2) {
            this.currentCompatRippleColor = colorForState2;
            if (this.useCompatRipple) {
                onStateChange = true;
            }
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        int colorForState3 = (textAppearance == null || (colorStateList = textAppearance.textColor) == null) ? 0 : colorStateList.getColorForState(r9, this.currentTextColor);
        if (this.currentTextColor != colorForState3) {
            this.currentTextColor = colorForState3;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            for (int r0 : state) {
                if (r0 == 16842912) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z4 = z && this.checkable;
        if (this.currentChecked == z4 || this.checkedIcon == null) {
            z2 = false;
        } else {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z4;
            if (calculateChipIconWidth != calculateChipIconWidth()) {
                onStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.tint;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(r9, this.currentTint) : 0;
        if (this.currentTint != colorForState4) {
            this.currentTint = colorForState4;
            ColorStateList colorStateList6 = this.tint;
            PorterDuff.Mode mode = this.tintMode;
            this.tintFilter = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            z3 = onStateChange;
        }
        if (isStateful(this.chipIcon)) {
            z3 |= this.chipIcon.setState(r9);
        }
        if (isStateful(this.checkedIcon)) {
            z3 |= this.checkedIcon.setState(r9);
        }
        if (isStateful(this.closeIcon)) {
            int[] r02 = new int[r9.length + r10.length];
            System.arraycopy(r9, 0, r02, 0, r9.length);
            System.arraycopy(r10, 0, r02, r9.length, r10.length);
            z3 |= this.closeIcon.setState(r02);
        }
        if (isStateful(this.closeIconRipple)) {
            z3 |= this.closeIconRipple.setState(r10);
        }
        if (z3) {
            invalidateSelf();
        }
        if (z2) {
            onSizeChange();
        }
        return z3;
    }

    public static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }
}
