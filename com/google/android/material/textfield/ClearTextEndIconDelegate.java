package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class ClearTextEndIconDelegate extends EndIconDelegate {
    public final AnonymousClass1 clearTextEndIconTextWatcher;
    public final AnonymousClass3 clearTextOnEditTextAttachedListener;
    public final AnonymousClass4 endIconChangedListener;
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;
    public final AnonymousClass2 onFocusChangeListener;

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            textInputLayout.setEndIconVisible(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
            AnonymousClass2 anonymousClass2 = clearTextEndIconDelegate.onFocusChangeListener;
            editText.setOnFocusChangeListener(anonymousClass2);
            clearTextEndIconDelegate.endIconView.setOnFocusChangeListener(anonymousClass2);
            AnonymousClass1 anonymousClass1 = clearTextEndIconDelegate.clearTextEndIconTextWatcher;
            editText.removeTextChangedListener(anonymousClass1);
            editText.addTextChangedListener(anonymousClass1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.textfield.ClearTextEndIconDelegate$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.material.textfield.ClearTextEndIconDelegate$2] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.material.textfield.ClearTextEndIconDelegate$4] */
    public ClearTextEndIconDelegate(TextInputLayout textInputLayout, int r2) {
        super(textInputLayout, r2);
        this.clearTextEndIconTextWatcher = new TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                if (clearTextEndIconDelegate.textInputLayout.getSuffixText() != null) {
                    return;
                }
                clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
            }
        };
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3();
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int r5) {
                final EditText editText = textInputLayout2.getEditText();
                if (editText != null && r5 == 2) {
                    editText.post(new Runnable() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                            ClearTextEndIconDelegate.this.animateIcon(true);
                        }
                    });
                    View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
                    ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                    if (onFocusChangeListener == clearTextEndIconDelegate.onFocusChangeListener) {
                        editText.setOnFocusChangeListener(null);
                    }
                    CheckableImageButton checkableImageButton = clearTextEndIconDelegate.endIconView;
                    if (checkableImageButton.getOnFocusChangeListener() == clearTextEndIconDelegate.onFocusChangeListener) {
                        checkableImageButton.setOnFocusChangeListener(null);
                    }
                }
            }
        };
    }

    public static boolean access$000(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        EditText editText = clearTextEndIconDelegate.textInputLayout.getEditText();
        if (editText != null && ((editText.hasFocus() || clearTextEndIconDelegate.endIconView.hasFocus()) && editText.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    public final void animateIcon(boolean z) {
        boolean z2;
        if (this.textInputLayout.isEndIconVisible() == z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        if (!z) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z2) {
                this.iconOutAnim.end();
            }
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int r0 = this.customEndIcon;
        if (r0 == 0) {
            r0 = R.drawable.mtrl_ic_cancel;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(r0);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        textInputLayout.setEndIconCheckable(false);
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                Editable text = clearTextEndIconDelegate.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                TextInputLayout textInputLayout2 = clearTextEndIconDelegate.textInputLayout;
                IconHelper.refreshIconDrawableState(textInputLayout2, textInputLayout2.endIconView, textInputLayout2.endIconTintList);
            }
        });
        LinkedHashSet<TextInputLayout.OnEditTextAttachedListener> linkedHashSet = textInputLayout.editTextAttachedListeners;
        AnonymousClass3 anonymousClass3 = this.clearTextOnEditTextAttachedListener;
        linkedHashSet.add(anonymousClass3);
        if (textInputLayout.editText != null) {
            anonymousClass3.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.endIconView.setScaleX(floatValue);
                clearTextEndIconDelegate.endIconView.setScaleY(floatValue);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(linearInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iconOutAnim = ofFloat3;
        ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z);
    }
}
