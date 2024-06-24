package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public WeakReference<View> anchorViewRef;
    public final Rect badgeBounds;
    public float badgeCenterX;
    public float badgeCenterY;
    public final WeakReference<Context> contextRef;
    public float cornerRadius;
    public WeakReference<FrameLayout> customBadgeParentRef;
    public float halfBadgeHeight;
    public float halfBadgeWidth;
    public int maxBadgeNumber;
    public final MaterialShapeDrawable shapeDrawable;
    public final BadgeState state;
    public final TextDrawableHelper textDrawableHelper;

    public BadgeDrawable(Context context) {
        FrameLayout frameLayout;
        TextAppearance textAppearance;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.contextRef = weakReference;
        ThemeEnforcement.checkTheme(context, ThemeEnforcement.MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
        this.badgeBounds = new Rect();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.shapeDrawable = materialShapeDrawable;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        TextPaint textPaint = textDrawableHelper.textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        Context context3 = weakReference.get();
        if (context3 != null && textDrawableHelper.textAppearance != (textAppearance = new TextAppearance(context3, 2132083286)) && (context2 = weakReference.get()) != null) {
            textDrawableHelper.setTextAppearance(textAppearance, context2);
            updateCenterAndBounds();
        }
        BadgeState badgeState = new BadgeState(context);
        this.state = badgeState;
        BadgeState.State state = badgeState.currentState;
        this.maxBadgeNumber = ((int) Math.pow(10.0d, state.maxCharacterCount - 1.0d)) - 1;
        textDrawableHelper.textWidthDirty = true;
        updateCenterAndBounds();
        invalidateSelf();
        textDrawableHelper.textWidthDirty = true;
        updateCenterAndBounds();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(state.backgroundColor.intValue());
        if (materialShapeDrawable.drawableState.fillColor != valueOf) {
            materialShapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(state.badgeTextColor.intValue());
        invalidateSelf();
        WeakReference<View> weakReference2 = this.anchorViewRef;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = this.anchorViewRef.get();
            WeakReference<FrameLayout> weakReference3 = this.customBadgeParentRef;
            if (weakReference3 != null) {
                frameLayout = weakReference3.get();
            } else {
                frameLayout = null;
            }
            updateBadgeCoordinates(view, frameLayout);
        }
        updateCenterAndBounds();
        setVisible(state.isVisible.booleanValue(), false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                Rect rect = new Rect();
                String badgeText = getBadgeText();
                TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
                textDrawableHelper.textPaint.getTextBounds(badgeText, 0, badgeText.length(), rect);
                canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), textDrawableHelper.textPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.state.currentState.alpha;
    }

    public final String getBadgeText() {
        int number = getNumber();
        int r1 = this.maxBadgeNumber;
        BadgeState badgeState = this.state;
        if (number <= r1) {
            return NumberFormat.getInstance(badgeState.currentState.numberLocale).format(getNumber());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(badgeState.currentState.numberLocale, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.maxBadgeNumber), "+");
    }

    public final FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public final int getNumber() {
        if (hasNumber()) {
            return this.state.currentState.number;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final boolean hasNumber() {
        if (this.state.currentState.number != -1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r3) {
        BadgeState badgeState = this.state;
        badgeState.overridingState.alpha = r3;
        badgeState.currentState.alpha = r3;
        this.textDrawableHelper.textPaint.setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        this.customBadgeParentRef = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public final void updateCenterAndBounds() {
        View view;
        int intValue;
        int r6;
        int intValue2;
        float f;
        float f2;
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            Rect rect2 = this.badgeBounds;
            rect.set(rect2);
            Rect rect3 = new Rect();
            view.getDrawingRect(rect3);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null) {
                frameLayout.offsetDescendantRectToMyCoords(view, rect3);
            }
            boolean hasNumber = hasNumber();
            BadgeState badgeState = this.state;
            if (hasNumber) {
                intValue = badgeState.currentState.verticalOffsetWithText.intValue();
            } else {
                intValue = badgeState.currentState.verticalOffsetWithoutText.intValue();
            }
            int intValue3 = badgeState.currentState.additionalVerticalOffset.intValue() + intValue;
            BadgeState.State state = badgeState.currentState;
            int intValue4 = state.badgeGravity.intValue();
            if (intValue4 != 8388691 && intValue4 != 8388693) {
                this.badgeCenterY = rect3.top + intValue3;
            } else {
                this.badgeCenterY = rect3.bottom - intValue3;
            }
            int number = getNumber();
            float f3 = badgeState.badgeWithTextRadius;
            if (number <= 9) {
                if (!hasNumber()) {
                    f3 = badgeState.badgeRadius;
                }
                this.cornerRadius = f3;
                this.halfBadgeHeight = f3;
                this.halfBadgeWidth = f3;
            } else {
                this.cornerRadius = f3;
                this.halfBadgeHeight = f3;
                this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + badgeState.badgeWidePadding;
            }
            Resources resources = context.getResources();
            if (hasNumber()) {
                r6 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
            } else {
                r6 = R.dimen.mtrl_badge_horizontal_edge_offset;
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(r6);
            if (hasNumber()) {
                intValue2 = state.horizontalOffsetWithText.intValue();
            } else {
                intValue2 = state.horizontalOffsetWithoutText.intValue();
            }
            int intValue5 = state.additionalHorizontalOffset.intValue() + intValue2;
            int intValue6 = state.badgeGravity.intValue();
            if (intValue6 != 8388659 && intValue6 != 8388691) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api17Impl.getLayoutDirection(view) == 0) {
                    f2 = ((rect3.right + this.halfBadgeWidth) - dimensionPixelSize) - intValue5;
                } else {
                    f2 = (rect3.left - this.halfBadgeWidth) + dimensionPixelSize + intValue5;
                }
                this.badgeCenterX = f2;
            } else {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api17Impl.getLayoutDirection(view) == 0) {
                    f = (rect3.left - this.halfBadgeWidth) + dimensionPixelSize + intValue5;
                } else {
                    f = ((rect3.right + this.halfBadgeWidth) - dimensionPixelSize) - intValue5;
                }
                this.badgeCenterX = f;
            }
            float f4 = this.badgeCenterX;
            float f5 = this.badgeCenterY;
            float f6 = this.halfBadgeWidth;
            float f7 = this.halfBadgeHeight;
            rect2.set((int) (f4 - f6), (int) (f5 - f7), (int) (f4 + f6), (int) (f5 + f7));
            float f8 = this.cornerRadius;
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            materialShapeDrawable.setShapeAppearanceModel(materialShapeDrawable.drawableState.shapeAppearanceModel.withCornerSize(f8));
            if (!rect.equals(rect2)) {
                materialShapeDrawable.setBounds(rect2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
