package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public final AnonymousClass3 accessibilityDelegate;
    public AccessibilityManager accessibilityManager;
    public final AnonymousClass4 dropdownMenuOnEditTextAttachedListener;
    public long dropdownPopupActivatedAt;
    public boolean dropdownPopupDirty;

    @SuppressLint({"ClickableViewAccessibility"})
    public final AnonymousClass5 endIconChangedListener;
    public final AnonymousClass1 exposedDropdownEndIconTextWatcher;
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked;
    public final AnonymousClass2 onFocusChangeListener;
    public MaterialShapeDrawable outlinedPopupBackground;

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass4() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            if (editText instanceof AutoCompleteTextView) {
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                final DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                int boxBackgroundMode = dropdownMenuEndIconDelegate.textInputLayout.getBoxBackgroundMode();
                if (boxBackgroundMode == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.outlinedPopupBackground);
                } else if (boxBackgroundMode == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.filledPopupBackground);
                }
                dropdownMenuEndIconDelegate.addRippleEffect(autoCompleteTextView);
                autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean z;
                        if (motionEvent.getAction() == 1) {
                            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                            dropdownMenuEndIconDelegate2.getClass();
                            long currentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt;
                            if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                dropdownMenuEndIconDelegate2.dropdownPopupDirty = false;
                            }
                            DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate2, autoCompleteTextView);
                            dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                            dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                        }
                        return false;
                    }
                });
                autoCompleteTextView.setOnFocusChangeListener(dropdownMenuEndIconDelegate.onFocusChangeListener);
                autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
                    @Override // android.widget.AutoCompleteTextView.OnDismissListener
                    public final void onDismiss() {
                        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                        dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                        dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                        dropdownMenuEndIconDelegate2.setEndIconChecked(false);
                    }
                });
                boolean z = false;
                autoCompleteTextView.setThreshold(0);
                AnonymousClass1 anonymousClass1 = dropdownMenuEndIconDelegate.exposedDropdownEndIconTextWatcher;
                autoCompleteTextView.removeTextChangedListener(anonymousClass1);
                autoCompleteTextView.addTextChangedListener(anonymousClass1);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (autoCompleteTextView.getKeyListener() != null) {
                    z = true;
                }
                if (!z && dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled()) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.setImportantForAccessibility(dropdownMenuEndIconDelegate.endIconView, 2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(dropdownMenuEndIconDelegate.accessibilityDelegate);
                textInputLayout.setEndIconVisible(true);
                return;
            }
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$5] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$2] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$3] */
    public DropdownMenuEndIconDelegate(TextInputLayout textInputLayout, int r2) {
        super(textInputLayout, r2);
        this.exposedDropdownEndIconTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                boolean z;
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                EditText editText = dropdownMenuEndIconDelegate.textInputLayout.getEditText();
                if (editText instanceof AutoCompleteTextView) {
                    final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                    if (dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled()) {
                        if (autoCompleteTextView.getKeyListener() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && !dropdownMenuEndIconDelegate.endIconView.hasFocus()) {
                            autoCompleteTextView.dismissDropDown();
                        }
                    }
                    autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean isPopupShowing = autoCompleteTextView.isPopupShowing();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            DropdownMenuEndIconDelegate.this.setEndIconChecked(isPopupShowing);
                            DropdownMenuEndIconDelegate.this.dropdownPopupDirty = isPopupShowing;
                        }
                    });
                    return;
                }
                throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.textInputLayout.setEndIconActivated(z);
                if (!z) {
                    dropdownMenuEndIconDelegate.setEndIconChecked(false);
                    dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
                }
            }
        };
        this.accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(textInputLayout) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                boolean z;
                boolean booleanProperty;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (DropdownMenuEndIconDelegate.this.textInputLayout.getEditText().getKeyListener() != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    booleanProperty = accessibilityNodeInfoCompat.mInfo.isShowingHintText();
                } else {
                    booleanProperty = accessibilityNodeInfoCompat.getBooleanProperty(4);
                }
                if (booleanProperty) {
                    accessibilityNodeInfoCompat.setHintText(null);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                boolean z;
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                EditText editText = dropdownMenuEndIconDelegate.textInputLayout.getEditText();
                if (editText instanceof AutoCompleteTextView) {
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                    if (accessibilityEvent.getEventType() == 1 && dropdownMenuEndIconDelegate.accessibilityManager.isEnabled()) {
                        if (dropdownMenuEndIconDelegate.textInputLayout.getEditText().getKeyListener() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate, autoCompleteTextView);
                            dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                            dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = System.currentTimeMillis();
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
            }
        };
        this.dropdownMenuOnEditTextAttachedListener = new AnonymousClass4();
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int r4) {
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout2.getEditText();
                if (autoCompleteTextView != null && r4 == 3) {
                    autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                        }
                    });
                    if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
                        autoCompleteTextView.setOnFocusChangeListener(null);
                    }
                    autoCompleteTextView.setOnTouchListener(null);
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        };
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    public static void access$500(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        boolean z;
        if (autoCompleteTextView == null) {
            dropdownMenuEndIconDelegate.getClass();
            return;
        }
        dropdownMenuEndIconDelegate.getClass();
        long currentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate.dropdownPopupActivatedAt;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
        }
        if (!dropdownMenuEndIconDelegate.dropdownPopupDirty) {
            dropdownMenuEndIconDelegate.setEndIconChecked(!dropdownMenuEndIconDelegate.isEndIconChecked);
            if (dropdownMenuEndIconDelegate.isEndIconChecked) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
    }

    public final void addRippleEffect(AutoCompleteTextView autoCompleteTextView) {
        boolean z;
        if (autoCompleteTextView.getKeyListener() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        int boxBackgroundMode = textInputLayout.getBoxBackgroundMode();
        MaterialShapeDrawable boxBackground = textInputLayout.getBoxBackground();
        int color = MaterialColors.getColor(R.attr.colorControlHighlight, autoCompleteTextView);
        int[][] r7 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            int color2 = MaterialColors.getColor(R.attr.colorSurface, autoCompleteTextView);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
            int layer = MaterialColors.layer(color, 0.1f, color2);
            materialShapeDrawable.setFillColor(new ColorStateList(r7, new int[]{layer, 0}));
            materialShapeDrawable.setTint(color2);
            ColorStateList colorStateList = new ColorStateList(r7, new int[]{layer, color2});
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
            materialShapeDrawable2.setTint(-1);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground});
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.setBackground(autoCompleteTextView, layerDrawable);
            return;
        }
        if (boxBackgroundMode == 1) {
            int boxBackgroundColor = textInputLayout.getBoxBackgroundColor();
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(r7, new int[]{MaterialColors.layer(color, 0.1f, boxBackgroundColor), boxBackgroundColor}), boxBackground, boxBackground);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.setBackground(autoCompleteTextView, rippleDrawable);
        }
    }

    public final MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int r6) {
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.setTopLeftCornerSize(f);
        builder.setTopRightCornerSize(f);
        builder.bottomLeftCornerSize = new AbsoluteCornerSize(f2);
        builder.bottomRightCornerSize = new AbsoluteCornerSize(f2);
        ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel(builder);
        Paint paint = MaterialShapeDrawable.clearPaint;
        Context context = this.context;
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(R.attr.colorSurface, context, "MaterialShapeDrawable");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        materialShapeDrawable.setElevation(f3);
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        materialShapeDrawable.drawableState.padding.set(0, r6, 0, r6);
        materialShapeDrawable.invalidateSelf();
        return materialShapeDrawable;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        Context context = this.context;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        int r1 = this.customEndIcon;
        if (r1 == 0) {
            r1 = R.drawable.mtrl_dropdown_arrow;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(r1);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate, (AutoCompleteTextView) dropdownMenuEndIconDelegate.textInputLayout.getEditText());
            }
        });
        LinkedHashSet<TextInputLayout.OnEditTextAttachedListener> linkedHashSet = textInputLayout.editTextAttachedListeners;
        AnonymousClass4 anonymousClass4 = this.dropdownMenuOnEditTextAttachedListener;
        linkedHashSet.add(anonymousClass4);
        if (textInputLayout.editText != null) {
            anonymousClass4.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.setDuration(67);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeInAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.setDuration(50);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeOutAnim = ofFloat2;
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.endIconView.setChecked(dropdownMenuEndIconDelegate.isEndIconChecked);
                dropdownMenuEndIconDelegate.fadeInAnim.start();
            }
        });
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                boolean z2;
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                if (dropdownMenuEndIconDelegate.textInputLayout.getEditText() != null) {
                    int r2 = 1;
                    if (dropdownMenuEndIconDelegate.textInputLayout.getEditText().getKeyListener() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if (z) {
                            r2 = 2;
                        }
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api16Impl.setImportantForAccessibility(dropdownMenuEndIconDelegate.endIconView, r2);
                    }
                }
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean isBoxBackgroundModeSupported(int r1) {
        if (r1 != 0) {
            return true;
        }
        return false;
    }

    public final void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }
}
