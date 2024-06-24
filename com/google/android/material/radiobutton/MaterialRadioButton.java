package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat$Api21Impl;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes3.dex */
public final class MaterialRadioButton extends AppCompatRadioButton {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.kronaby.watch.app.R.attr.radioButtonStyle, 2132083795), attributeSet);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialRadioButton, com.kronaby.watch.app.R.attr.radioButtonStyle, 2132083795, new int[0]);
        if (obtainStyledAttributes.hasValue(0)) {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, MaterialResources.getColorStateList(context2, obtainStyledAttributes, 0));
        }
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int color = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorControlActivated, this);
            int color2 = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorOnSurface, this);
            int color3 = MaterialColors.getColor(com.kronaby.watch.app.R.attr.colorSurface, this);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{MaterialColors.layer(color3, 1.0f, color), MaterialColors.layer(color3, 0.54f, color2), MaterialColors.layer(color3, 0.38f, color2), MaterialColors.layer(color3, 0.38f, color2)});
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

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, null);
        }
    }
}
