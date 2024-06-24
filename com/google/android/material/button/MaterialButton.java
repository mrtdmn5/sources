package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public boolean broadcasting;
    public boolean checked;
    public Drawable icon;
    public int iconGravity;
    public int iconLeft;
    public int iconPadding;
    public int iconSize;
    public ColorStateList iconTint;
    public PorterDuff.Mode iconTintMode;
    public int iconTop;
    public final MaterialButtonHelper materialButtonHelper;
    public final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    public OnPressedChangeListener onPressedChangeListenerInternal;

    /* loaded from: classes3.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged();
    }

    /* loaded from: classes3.dex */
    public interface OnPressedChangeListener {
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public boolean checked;

        /* renamed from: com.google.android.material.button.MaterialButton$SavedState$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.kronaby.watch.app.R.attr.materialButtonStyle, 2132083770), attributeSet, com.kronaby.watch.app.R.attr.materialButtonStyle);
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialButton, com.kronaby.watch.app.R.attr.materialButtonStyle, 2132083770, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        this.iconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, 14);
        this.icon = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, 10);
        this.iconGravity = obtainStyledAttributes.getInteger(11, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(13, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, new ShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, com.kronaby.watch.app.R.attr.materialButtonStyle, 2132083770)));
        this.materialButtonHelper = materialButtonHelper;
        materialButtonHelper.insetLeft = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        materialButtonHelper.insetRight = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        materialButtonHelper.insetTop = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        materialButtonHelper.insetBottom = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
        if (obtainStyledAttributes.hasValue(8)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, -1);
            materialButtonHelper.cornerRadius = dimensionPixelSize;
            materialButtonHelper.setShapeAppearanceModel(materialButtonHelper.shapeAppearanceModel.withCornerSize(dimensionPixelSize));
            materialButtonHelper.cornerRadiusSet = true;
        }
        materialButtonHelper.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(20, 0);
        materialButtonHelper.backgroundTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        materialButtonHelper.backgroundTint = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, 6);
        materialButtonHelper.strokeColor = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, 19);
        materialButtonHelper.rippleColor = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, 16);
        materialButtonHelper.checkable = obtainStyledAttributes.getBoolean(5, false);
        materialButtonHelper.elevation = obtainStyledAttributes.getDimensionPixelSize(9, 0);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int paddingStart = ViewCompat.Api17Impl.getPaddingStart(this);
        int paddingTop = getPaddingTop();
        int paddingEnd = ViewCompat.Api17Impl.getPaddingEnd(this);
        int paddingBottom = getPaddingBottom();
        if (obtainStyledAttributes.hasValue(0)) {
            materialButtonHelper.backgroundOverwritten = true;
            setSupportBackgroundTintList(materialButtonHelper.backgroundTint);
            setSupportBackgroundTintMode(materialButtonHelper.backgroundTintMode);
        } else {
            materialButtonHelper.updateBackground();
        }
        ViewCompat.Api17Impl.setPaddingRelative(this, paddingStart + materialButtonHelper.insetLeft, paddingTop + materialButtonHelper.insetTop, paddingEnd + materialButtonHelper.insetRight, paddingBottom + materialButtonHelper.insetBottom);
        obtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }

    private String getA11yClassName() {
        boolean z;
        Class cls;
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && materialButtonHelper.checkable) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.cornerRadius;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.insetBottom;
    }

    public int getInsetTop() {
        return this.materialButtonHelper.insetTop;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.shapeAppearanceModel;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeColor;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeWidth;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTint;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTintMode;
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.checked;
    }

    public final boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && !materialButtonHelper.backgroundOverwritten) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            zzav.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r2) {
        boolean z;
        int[] onCreateDrawableState = super.onCreateDrawableState(r2 + 2);
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && materialButtonHelper.checkable) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && materialButtonHelper.checkable) {
            z = true;
        } else {
            z = false;
        }
        accessibilityNodeInfo.setCheckable(z);
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
        super.onTextChanged(charSequence, r2, r3, r4);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final void resetIconDrawable() {
        boolean z;
        boolean z2;
        int r0 = this.iconGravity;
        boolean z3 = false;
        if (r0 != 1 && r0 != 2) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            TextViewCompat.Api17Impl.setCompoundDrawablesRelative(this, this.icon, null, null, null);
            return;
        }
        if (r0 != 3 && r0 != 4) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            TextViewCompat.Api17Impl.setCompoundDrawablesRelative(this, null, null, this.icon, null);
            return;
        }
        if (r0 == 16 || r0 == 32) {
            z3 = true;
        }
        if (z3) {
            TextViewCompat.Api17Impl.setCompoundDrawablesRelative(this, null, this.icon, null, null);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r4) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.getMaterialShapeDrawable(false) != null) {
                materialButtonHelper.getMaterialShapeDrawable(false).setTint(r4);
                return;
            }
            return;
        }
        super.setBackgroundColor(r4);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (isUsingOriginalBackground()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
                materialButtonHelper.backgroundOverwritten = true;
                ColorStateList colorStateList = materialButtonHelper.backgroundTint;
                MaterialButton materialButton = materialButtonHelper.materialButton;
                materialButton.setSupportBackgroundTintList(colorStateList);
                materialButton.setSupportBackgroundTintMode(materialButtonHelper.backgroundTintMode);
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int r2) {
        Drawable drawable;
        if (r2 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), r2);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.checkable = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        boolean z2;
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && materialButtonHelper.checkable) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && isEnabled() && this.checked != z) {
            this.checked = z;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z3 = this.checked;
                if (!materialButtonToggleGroup.skipCheckedStateTracker) {
                    materialButtonToggleGroup.checkInternal(getId(), z3);
                }
            }
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged();
            }
            this.broadcasting = false;
        }
    }

    public void setCornerRadius(int r3) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (!materialButtonHelper.cornerRadiusSet || materialButtonHelper.cornerRadius != r3) {
                materialButtonHelper.cornerRadius = r3;
                materialButtonHelper.cornerRadiusSet = true;
                materialButtonHelper.setShapeAppearanceModel(materialButtonHelper.shapeAppearanceModel.withCornerSize(r3));
            }
        }
    }

    public void setCornerRadiusResource(int r2) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(r2));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable(false).setElevation(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int r2) {
        if (this.iconGravity != r2) {
            this.iconGravity = r2;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int r2) {
        if (this.iconPadding != r2) {
            this.iconPadding = r2;
            setCompoundDrawablePadding(r2);
        }
    }

    public void setIconResource(int r2) {
        Drawable drawable;
        if (r2 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), r2);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int r2) {
        if (r2 >= 0) {
            if (this.iconSize != r2) {
                this.iconSize = r2;
                updateIcon(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int r2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setInsetBottom(int r3) {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        materialButtonHelper.setVerticalInsets(materialButtonHelper.insetTop, r3);
    }

    public void setInsetTop(int r3) {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        materialButtonHelper.setVerticalInsets(r3, materialButtonHelper.insetBottom);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.rippleColor != colorStateList) {
                materialButtonHelper.rippleColor = colorStateList;
                MaterialButton materialButton = materialButtonHelper.materialButton;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int r2) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.shouldDrawSurfaceColorStroke = z;
            materialButtonHelper.updateStroke();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.strokeColor != colorStateList) {
                materialButtonHelper.strokeColor = colorStateList;
                materialButtonHelper.updateStroke();
            }
        }
    }

    public void setStrokeColorResource(int r2) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), r2));
        }
    }

    public void setStrokeWidth(int r3) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.strokeWidth != r3) {
                materialButtonHelper.strokeWidth = r3;
                materialButtonHelper.updateStroke();
            }
        }
    }

    public void setStrokeWidthResource(int r2) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(r2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.backgroundTint != colorStateList) {
                materialButtonHelper.backgroundTint = colorStateList;
                if (materialButtonHelper.getMaterialShapeDrawable(false) != null) {
                    DrawableCompat$Api21Impl.setTintList(materialButtonHelper.getMaterialShapeDrawable(false), materialButtonHelper.backgroundTint);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.backgroundTintMode != mode) {
                materialButtonHelper.backgroundTintMode = mode;
                if (materialButtonHelper.getMaterialShapeDrawable(false) != null && materialButtonHelper.backgroundTintMode != null) {
                    DrawableCompat$Api21Impl.setTintMode(materialButtonHelper.getMaterialShapeDrawable(false), materialButtonHelper.backgroundTintMode);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public void setTextAlignment(int r2) {
        super.setTextAlignment(r2);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.checked);
    }

    public final void updateIcon(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        Drawable drawable = this.icon;
        boolean z5 = true;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.icon = mutate;
            DrawableCompat$Api21Impl.setTintList(mutate, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                DrawableCompat$Api21Impl.setTintMode(this.icon, mode);
            }
            int r0 = this.iconSize;
            if (r0 == 0) {
                r0 = this.icon.getIntrinsicWidth();
            }
            int r2 = this.iconSize;
            if (r2 == 0) {
                r2 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int r4 = this.iconLeft;
            int r5 = this.iconTop;
            drawable2.setBounds(r4, r5, r0 + r4, r2 + r5);
            this.icon.setVisible(true, z);
        }
        if (z) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.Api17Impl.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int r52 = this.iconGravity;
        if (r52 != 1 && r52 != 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || drawable3 == this.icon) {
            if (r52 != 3 && r52 != 4) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3 || drawable5 == this.icon) {
                if (r52 != 16 && r52 != 32) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!z4 || drawable4 == this.icon) {
                    z5 = false;
                }
            }
        }
        if (z5) {
            resetIconDrawable();
        }
    }

    public final void updateIconPosition(int r8, int r9) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.icon != null && getLayout() != null) {
            int r0 = this.iconGravity;
            boolean z4 = true;
            if (r0 != 1 && r0 != 2) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (r0 != 3 && r0 != 4) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3) {
                    if (r0 != 16 && r0 != 32) {
                        z4 = false;
                    }
                    if (z4) {
                        this.iconLeft = 0;
                        if (r0 == 16) {
                            this.iconTop = 0;
                            updateIcon(false);
                            return;
                        }
                        int r82 = this.iconSize;
                        if (r82 == 0) {
                            r82 = this.icon.getIntrinsicHeight();
                        }
                        int textHeight = (((((r9 - getTextHeight()) - getPaddingTop()) - r82) - this.iconPadding) - getPaddingBottom()) / 2;
                        if (this.iconTop != textHeight) {
                            this.iconTop = textHeight;
                            updateIcon(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            this.iconTop = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int r02 = this.iconGravity;
            if (r02 != 1 && r02 != 3 && ((r02 != 2 || actualTextAlignment != Layout.Alignment.ALIGN_NORMAL) && (r02 != 4 || actualTextAlignment != Layout.Alignment.ALIGN_OPPOSITE))) {
                int r03 = this.iconSize;
                if (r03 == 0) {
                    r03 = this.icon.getIntrinsicWidth();
                }
                int textWidth = r8 - getTextWidth();
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                int paddingEnd = (((textWidth - ViewCompat.Api17Impl.getPaddingEnd(this)) - r03) - this.iconPadding) - ViewCompat.Api17Impl.getPaddingStart(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    paddingEnd /= 2;
                }
                if (ViewCompat.Api17Impl.getLayoutDirection(this) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.iconGravity != 4) {
                    z4 = false;
                }
                if (z2 != z4) {
                    paddingEnd = -paddingEnd;
                }
                if (this.iconLeft != paddingEnd) {
                    this.iconLeft = paddingEnd;
                    updateIcon(false);
                    return;
                }
                return;
            }
            this.iconLeft = 0;
            updateIcon(false);
        }
    }
}
