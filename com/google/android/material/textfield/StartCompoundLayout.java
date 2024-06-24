package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.MarginLayoutParamsCompat$Api17Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class StartCompoundLayout extends LinearLayout {
    public boolean hintExpanded;
    public CharSequence prefixText;
    public final AppCompatTextView prefixTextView;
    public View.OnLongClickListener startIconOnLongClickListener;
    public ColorStateList startIconTintList;
    public PorterDuff.Mode startIconTintMode;
    public final CheckableImageButton startIconView;
    public final TextInputLayout textInputLayout;

    public StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.textInputLayout = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.startIconView = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.prefixTextView = appCompatTextView;
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            MarginLayoutParamsCompat$Api17Impl.setMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(null);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
        this.startIconOnLongClickListener = null;
        checkableImageButton.setOnLongClickListener(null);
        IconHelper.setIconClickable(checkableImageButton, null);
        if (tintTypedArray.hasValue(62)) {
            this.startIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, 62);
        }
        if (tintTypedArray.hasValue(63)) {
            this.startIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(63, -1), null);
        }
        if (tintTypedArray.hasValue(61)) {
            setStartIconDrawable(tintTypedArray.getDrawable(61));
            if (tintTypedArray.hasValue(60) && checkableImageButton.getContentDescription() != (text = tintTypedArray.getText(60))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(tintTypedArray.getBoolean(59, true));
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api19Impl.setAccessibilityLiveRegion(appCompatTextView, 1);
        appCompatTextView.setTextAppearance(tintTypedArray.getResourceId(55, 0));
        if (tintTypedArray.hasValue(56)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(56));
        }
        CharSequence text2 = tintTypedArray.getText(54);
        this.prefixText = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        updateVisibility();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        updatePrefixTextViewPadding();
    }

    public final void setStartIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.startIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.startIconTintList;
            PorterDuff.Mode mode = this.startIconTintMode;
            TextInputLayout textInputLayout = this.textInputLayout;
            IconHelper.applyIconTint(textInputLayout, checkableImageButton, colorStateList, mode);
            setStartIconVisible(true);
            IconHelper.refreshIconDrawableState(textInputLayout, checkableImageButton, this.startIconTintList);
            return;
        }
        setStartIconVisible(false);
        View.OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(null);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
        this.startIconOnLongClickListener = null;
        checkableImageButton.setOnLongClickListener(null);
        IconHelper.setIconClickable(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void setStartIconVisible(boolean z) {
        boolean z2;
        CheckableImageButton checkableImageButton = this.startIconView;
        int r2 = 0;
        if (checkableImageButton.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            if (!z) {
                r2 = 8;
            }
            checkableImageButton.setVisibility(r2);
            updatePrefixTextViewPadding();
            updateVisibility();
        }
    }

    public final void updatePrefixTextViewPadding() {
        boolean z;
        EditText editText = this.textInputLayout.editText;
        if (editText == null) {
            return;
        }
        int r2 = 0;
        if (this.startIconView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            r2 = ViewCompat.Api17Impl.getPaddingStart(editText);
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api17Impl.setPaddingRelative(this.prefixTextView, r2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void updateVisibility() {
        int r0;
        boolean z;
        int r1 = 8;
        if (this.prefixText != null && !this.hintExpanded) {
            r0 = 0;
        } else {
            r0 = 8;
        }
        if (this.startIconView.getVisibility() != 0 && r0 != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            r1 = 0;
        }
        setVisibility(r1);
        this.prefixTextView.setVisibility(r0);
        this.textInputLayout.updateDummyDrawables();
    }
}
