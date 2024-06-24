package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.gms.location.zzae;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.MaterialResources;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class IndicatorViewController {
    public Animator captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public int captionToShow;
    public final float captionTranslationYPx;
    public final Context context;
    public boolean errorEnabled;
    public CharSequence errorText;
    public int errorTextAppearance;
    public AppCompatTextView errorView;
    public CharSequence errorViewContentDescription;
    public ColorStateList errorViewTextColor;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    public AppCompatTextView helperTextView;
    public ColorStateList helperTextViewTextColor;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        this.context = textInputLayout.getContext();
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = r0.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public final void addIndicator(TextView textView, int r8) {
        boolean z;
        if (this.indicatorArea == null && this.captionArea == null) {
            Context context = this.context;
            LinearLayout linearLayout = new LinearLayout(context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.indicatorArea;
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.captionArea = new FrameLayout(context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (r8 != 0 && r8 != 1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
        } else {
            this.indicatorArea.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    public final void adjustIndicatorPadding() {
        boolean z;
        LinearLayout linearLayout = this.indicatorArea;
        TextInputLayout textInputLayout = this.textInputView;
        if (linearLayout != null && textInputLayout.getEditText() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            EditText editText = textInputLayout.getEditText();
            Context context = this.context;
            boolean isFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(context);
            LinearLayout linearLayout2 = this.indicatorArea;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            int paddingStart = ViewCompat.Api17Impl.getPaddingStart(editText);
            if (isFontScaleAtLeast1_3) {
                paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
            if (isFontScaleAtLeast1_3) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
            }
            int paddingEnd = ViewCompat.Api17Impl.getPaddingEnd(editText);
            if (isFontScaleAtLeast1_3) {
                paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            ViewCompat.Api17Impl.setPaddingRelative(linearLayout2, paddingStart, dimensionPixelSize, paddingEnd, 0);
        }
    }

    public final void cancelCaptionAnimator() {
        Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void createCaptionAnimators(ArrayList arrayList, boolean z, TextView textView, int r8, int r9, int r10) {
        boolean z2;
        float f;
        if (textView != null && z) {
            if (r8 == r10 || r8 == r9) {
                if (r10 == r8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                arrayList.add(ofFloat);
                if (r10 == r8) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    public final boolean errorShouldBeShown() {
        if (this.captionToShow == 1 && this.errorView != null && !TextUtils.isEmpty(this.errorText)) {
            return true;
        }
        return false;
    }

    public final TextView getCaptionViewFromDisplayState(int r2) {
        if (r2 != 1) {
            if (r2 != 2) {
                return null;
            }
            return this.helperTextView;
        }
        return this.errorView;
    }

    public final int getErrorViewCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.errorView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public final void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (this.helperTextEnabled && !TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 2;
            } else {
                this.captionToShow = 0;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
    }

    public final void removeIndicator(TextView textView, int r4) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.indicatorArea;
        if (linearLayout == null) {
            return;
        }
        boolean z = true;
        if (r4 != 0 && r4 != 1) {
            z = false;
        }
        if (z && (frameLayout = this.captionArea) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int r3 = this.indicatorsAdded - 1;
        this.indicatorsAdded = r3;
        LinearLayout linearLayout2 = this.indicatorArea;
        if (r3 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean shouldAnimateCaptionView(TextView textView, CharSequence charSequence) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        TextInputLayout textInputLayout = this.textInputView;
        if (ViewCompat.Api19Impl.isLaidOut(textInputLayout) && textInputLayout.isEnabled() && (this.captionToShow != this.captionDisplayed || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    public final void updateCaptionViewsVisibility(final int r15, final int r16, boolean z) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        if (r15 == r16) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, r15, r16);
            createCaptionAnimators(arrayList, this.errorEnabled, this.errorView, 1, r15, r16);
            zzae.playTogether(animatorSet, arrayList);
            final TextView captionViewFromDisplayState3 = getCaptionViewFromDisplayState(r15);
            final TextView captionViewFromDisplayState4 = getCaptionViewFromDisplayState(r16);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    AppCompatTextView appCompatTextView;
                    int r4 = r16;
                    IndicatorViewController indicatorViewController = IndicatorViewController.this;
                    indicatorViewController.captionDisplayed = r4;
                    indicatorViewController.captionAnimator = null;
                    TextView textView = captionViewFromDisplayState3;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (r15 == 1 && (appCompatTextView = indicatorViewController.errorView) != null) {
                            appCompatTextView.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = captionViewFromDisplayState4;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        textView2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    TextView textView = captionViewFromDisplayState4;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else if (r15 != r16) {
            if (r16 != 0 && (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(r16)) != null) {
                captionViewFromDisplayState2.setVisibility(0);
                captionViewFromDisplayState2.setAlpha(1.0f);
            }
            if (r15 != 0 && (captionViewFromDisplayState = getCaptionViewFromDisplayState(r15)) != null) {
                captionViewFromDisplayState.setVisibility(4);
                if (r15 == 1) {
                    captionViewFromDisplayState.setText((CharSequence) null);
                }
            }
            this.captionDisplayed = r16;
        }
        TextInputLayout textInputLayout = this.textInputView;
        textInputLayout.updateEditTextBackground();
        textInputLayout.updateLabelState(z, false);
        textInputLayout.updateTextInputBoxState();
    }
}
