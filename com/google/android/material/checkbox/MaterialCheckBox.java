package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.widget.CompoundButtonCompat$Api21Impl;
import androidx.core.widget.CompoundButtonCompat$Api23Impl;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes3.dex */
public final class MaterialCheckBox extends AppCompatCheckBox {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public boolean centerIfNoTextEnabled;
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.kronaby.watch.app.R.attr.checkboxStyle, 2132083794), attributeSet, com.kronaby.watch.app.R.attr.checkboxStyle);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialCheckBox, com.kronaby.watch.app.R.attr.checkboxStyle, 2132083794, new int[0]);
        if (obtainStyledAttributes.hasValue(0)) {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, MaterialResources.getColorStateList(context2, obtainStyledAttributes, 0));
        }
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(2, false);
        this.centerIfNoTextEnabled = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int color = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorControlActivated, this);
            int color2 = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorSurface, this);
            int color3 = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorOnSurface, this);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{MaterialColors.layer(color2, 1.0f, color), MaterialColors.layer(color2, 0.54f, color3), MaterialColors.layer(color2, 0.38f, color3), MaterialColors.layer(color2, 0.38f, color3)});
        }
        return this.materialThemeColorsTintList;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && CompoundButtonCompat$Api21Impl.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        int r1;
        if (this.centerIfNoTextEnabled && TextUtils.isEmpty(getText()) && (buttonDrawable = CompoundButtonCompat$Api23Impl.getButtonDrawable(this)) != null) {
            if (ViewUtils.isLayoutRtl(this)) {
                r1 = -1;
            } else {
                r1 = 1;
            }
            int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * r1;
            int save = canvas.save();
            canvas.translate(width, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = buttonDrawable.getBounds();
                DrawableCompat$Api21Impl.setHotspotBounds(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.centerIfNoTextEnabled = z;
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, null);
        }
    }
}
