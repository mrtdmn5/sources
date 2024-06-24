package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat$Api17Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public ValueAnimator animator;
    public boolean areCornerRadiiRtl;
    public MaterialShapeDrawable boxBackground;
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public int boxStrokeWidthDefaultPx;
    public int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderlineDefault;
    public MaterialShapeDrawable boxUnderlineFocused;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    public ColorStateList counterTextColor;
    public AppCompatTextView counterView;
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public int defaultStrokeColor;
    public int disabledColor;
    public int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    public ColorDrawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    public final SparseArray<EndIconDelegate> endIconDelegates;
    public final FrameLayout endIconFrame;
    public int endIconMode;
    public View.OnLongClickListener endIconOnLongClickListener;
    public ColorStateList endIconTintList;
    public PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public final LinearLayout endLayout;
    public View.OnLongClickListener errorIconOnLongClickListener;
    public ColorStateList errorIconTintList;
    public PorterDuff.Mode errorIconTintMode;
    public final CheckableImageButton errorIconView;
    public boolean expandedHintEnabled;
    public int focusedFilledBackgroundColor;
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    public int hoveredFilledBackgroundColor;
    public int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController;
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public int maxEms;
    public int maxWidth;
    public int minEms;
    public int minWidth;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean placeholderEnabled;
    public Fade placeholderFadeIn;
    public Fade placeholderFadeOut;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    public ColorStateList placeholderTextColor;
    public AppCompatTextView placeholderTextView;
    public boolean restoringSavedState;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorDrawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public final StartCompoundLayout startLayout;
    public ColorStateList strokeErrorColor;
    public CharSequence suffixText;
    public final AppCompatTextView suffixTextView;
    public final Rect tmpBoundsRect;
    public final Rect tmpRect;
    public final RectF tmpRectF;
    public Typeface typeface;

    /* renamed from: com.google.android.material.textfield.TextInputLayout$2 */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.endIconView.performClick();
            textInputLayout.endIconView.jumpDrawablesToCurrentState();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$3 */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextInputLayout.this.editText.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$4 */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence;
            boolean z;
            String str;
            View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            TextInputLayout textInputLayout = this.layout;
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean z2 = !TextUtils.isEmpty(charSequence);
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !textInputLayout.hintExpanded;
            boolean z5 = !TextUtils.isEmpty(error);
            if (!z5 && TextUtils.isEmpty(counterOverflowDescription)) {
                z = false;
            } else {
                z = true;
            }
            if (z3) {
                str = hint.toString();
            } else {
                str = "";
            }
            StartCompoundLayout startCompoundLayout = textInputLayout.startLayout;
            AppCompatTextView appCompatTextView = startCompoundLayout.prefixTextView;
            if (appCompatTextView.getVisibility() == 0) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView);
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            } else {
                accessibilityNodeInfo.setTraversalAfter(startCompoundLayout.startIconView);
            }
            if (z2) {
                accessibilityNodeInfoCompat.setText(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (z4 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                int r7 = Build.VERSION.SDK_INT;
                if (r7 >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (z2) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                boolean z6 = true ^ z2;
                if (r7 >= 26) {
                    accessibilityNodeInfo.setShowingHintText(z6);
                } else {
                    accessibilityNodeInfoCompat.setBooleanProperty(4, z6);
                }
            }
            if (charSequence == null || charSequence.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
            if (z) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfo.setError(error);
            }
            AppCompatTextView appCompatTextView2 = textInputLayout.indicatorViewController.helperTextView;
            if (appCompatTextView2 != null) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    /* loaded from: classes3.dex */
    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int r2);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public CharSequence error;
        public CharSequence helperText;
        public CharSequence hintText;
        public boolean isEndIconChecked;
        public CharSequence placeholderText;

        /* renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$1 */
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
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + " hint=" + ((Object) this.hintText) + " helperText=" + ((Object) this.helperText) + " placeholderText=" + ((Object) this.placeholderText) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            TextUtils.writeToParcel(this.error, parcel, r3);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, r3);
            TextUtils.writeToParcel(this.helperText, parcel, r3);
            TextUtils.writeToParcel(this.placeholderText, parcel, r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v93 */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.textInputStyle, 2132083612), attributeSet, R.attr.textInputStyle);
        int r5;
        ?? r2;
        View view;
        int r3;
        this.minEms = -1;
        this.maxEms = -1;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        SparseArray<EndIconDelegate> sparseArray = new SparseArray<>();
        this.endIconDelegates = sparseArray;
        this.endIconChangedListeners = new LinkedHashSet<>();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.endLayout = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.suffixTextView = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater from = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(R.layout.design_text_input_end_icon, (ViewGroup) linearLayout, false);
        this.errorIconView = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) from.inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.endIconView = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper.textSizeInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        collapsingTextHelper.positionInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        if (collapsingTextHelper.collapsedTextGravity != 8388659) {
            collapsingTextHelper.collapsedTextGravity = 8388659;
            collapsingTextHelper.recalculate(false);
        }
        int[] r8 = R$styleable.TextInputLayout;
        ThemeEnforcement.checkCompatibleTheme(context2, attributeSet, R.attr.textInputStyle, 2132083612);
        ThemeEnforcement.checkTextAppearance(context2, attributeSet, r8, R.attr.textInputStyle, 2132083612, 22, 20, 35, 40, 44);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, r8, R.attr.textInputStyle, 2132083612);
        TintTypedArray tintTypedArray = new TintTypedArray(context2, obtainStyledAttributes);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, tintTypedArray);
        this.startLayout = startCompoundLayout;
        this.hintEnabled = tintTypedArray.getBoolean(43, true);
        setHint(tintTypedArray.getText(4));
        this.hintAnimationEnabled = tintTypedArray.getBoolean(42, true);
        this.expandedHintEnabled = tintTypedArray.getBoolean(37, true);
        if (tintTypedArray.hasValue(6)) {
            r5 = -1;
            setMinEms(tintTypedArray.getInt(6, -1));
        } else {
            r5 = -1;
            if (tintTypedArray.hasValue(3)) {
                setMinWidth(tintTypedArray.getDimensionPixelSize(3, -1));
            }
        }
        if (tintTypedArray.hasValue(5)) {
            setMaxEms(tintTypedArray.getInt(5, r5));
        } else if (tintTypedArray.hasValue(2)) {
            setMaxWidth(tintTypedArray.getDimensionPixelSize(2, r5));
        }
        this.shapeAppearanceModel = new ShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, R.attr.textInputStyle, 2132083612));
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = tintTypedArray.getDimensionPixelOffset(9, 0);
        this.boxStrokeWidthDefaultPx = tintTypedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = tintTypedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        if (dimension >= 0.0f) {
            builder.setTopLeftCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.setTopRightCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.bottomRightCornerSize = new AbsoluteCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(dimension4);
        }
        this.shapeAppearanceModel = new ShapeAppearanceModel(builder);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, tintTypedArray, 7);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateList2 = AppCompatResources.getColorStateList(context2, R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (tintTypedArray.hasValue(1)) {
            ColorStateList colorStateList3 = tintTypedArray.getColorStateList(1);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, tintTypedArray, 14);
        this.focusedStrokeColor = obtainStyledAttributes.getColor(14, 0);
        Object obj = ContextCompat.sLock;
        this.defaultStrokeColor = ContextCompat.Api23Impl.getColor(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.Api23Impl.getColor(context2, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.Api23Impl.getColor(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        if (tintTypedArray.hasValue(15)) {
            setBoxStrokeErrorColor(MaterialResources.getColorStateList(context2, tintTypedArray, 15));
        }
        if (tintTypedArray.getResourceId(44, -1) != -1) {
            r2 = 0;
            setHintTextAppearance(tintTypedArray.getResourceId(44, 0));
        } else {
            r2 = 0;
        }
        int resourceId = tintTypedArray.getResourceId(35, r2);
        CharSequence text = tintTypedArray.getText(30);
        boolean z = tintTypedArray.getBoolean(31, r2);
        checkableImageButton.setId(R.id.text_input_error_icon);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            MarginLayoutParamsCompat$Api17Impl.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r2);
        }
        if (tintTypedArray.hasValue(33)) {
            this.errorIconTintList = MaterialResources.getColorStateList(context2, tintTypedArray, 33);
        }
        if (tintTypedArray.hasValue(34)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(34, -1), null);
        }
        if (tintTypedArray.hasValue(32)) {
            setErrorIconDrawable(tintTypedArray.getDrawable(32));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setImportantForAccessibility(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = tintTypedArray.getResourceId(40, 0);
        boolean z2 = tintTypedArray.getBoolean(39, false);
        CharSequence text2 = tintTypedArray.getText(38);
        int resourceId3 = tintTypedArray.getResourceId(52, 0);
        CharSequence text3 = tintTypedArray.getText(51);
        int resourceId4 = tintTypedArray.getResourceId(65, 0);
        CharSequence text4 = tintTypedArray.getText(64);
        boolean z3 = tintTypedArray.getBoolean(18, false);
        setCounterMaxLength(tintTypedArray.getInt(19, -1));
        this.counterTextAppearance = tintTypedArray.getResourceId(22, 0);
        this.counterOverflowTextAppearance = tintTypedArray.getResourceId(20, 0);
        setBoxBackgroundMode(tintTypedArray.getInt(8, 0));
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            MarginLayoutParamsCompat$Api17Impl.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        int resourceId5 = tintTypedArray.getResourceId(26, 0);
        sparseArray.append(-1, new CustomEndIconDelegate(this, resourceId5));
        sparseArray.append(0, new NoEndIconDelegate(this));
        if (resourceId5 == 0) {
            view = startCompoundLayout;
            r3 = tintTypedArray.getResourceId(47, 0);
        } else {
            view = startCompoundLayout;
            r3 = resourceId5;
        }
        sparseArray.append(1, new PasswordToggleEndIconDelegate(this, r3));
        sparseArray.append(2, new ClearTextEndIconDelegate(this, resourceId5));
        sparseArray.append(3, new DropdownMenuEndIconDelegate(this, resourceId5));
        if (!tintTypedArray.hasValue(48)) {
            if (tintTypedArray.hasValue(28)) {
                this.endIconTintList = MaterialResources.getColorStateList(context2, tintTypedArray, 28);
            }
            if (tintTypedArray.hasValue(29)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(29, -1), null);
            }
        }
        if (tintTypedArray.hasValue(27)) {
            setEndIconMode(tintTypedArray.getInt(27, 0));
            if (tintTypedArray.hasValue(25)) {
                setEndIconContentDescription(tintTypedArray.getText(25));
            }
            setEndIconCheckable(tintTypedArray.getBoolean(24, true));
        } else if (tintTypedArray.hasValue(48)) {
            if (tintTypedArray.hasValue(49)) {
                this.endIconTintList = MaterialResources.getColorStateList(context2, tintTypedArray, 49);
            }
            if (tintTypedArray.hasValue(50)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(50, -1), null);
            }
            setEndIconMode(tintTypedArray.getBoolean(48, false) ? 1 : 0);
            setEndIconContentDescription(tintTypedArray.getText(46));
        }
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.Api19Impl.setAccessibilityLiveRegion(appCompatTextView, 1);
        setErrorContentDescription(text);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setSuffixTextAppearance(resourceId4);
        if (tintTypedArray.hasValue(36)) {
            setErrorTextColor(tintTypedArray.getColorStateList(36));
        }
        if (tintTypedArray.hasValue(41)) {
            setHelperTextColor(tintTypedArray.getColorStateList(41));
        }
        if (tintTypedArray.hasValue(45)) {
            setHintTextColor(tintTypedArray.getColorStateList(45));
        }
        if (tintTypedArray.hasValue(23)) {
            setCounterTextColor(tintTypedArray.getColorStateList(23));
        }
        if (tintTypedArray.hasValue(21)) {
            setCounterOverflowTextColor(tintTypedArray.getColorStateList(21));
        }
        if (tintTypedArray.hasValue(53)) {
            setPlaceholderTextColor(tintTypedArray.getColorStateList(53));
        }
        if (tintTypedArray.hasValue(66)) {
            setSuffixTextColor(tintTypedArray.getColorStateList(66));
        }
        setEnabled(tintTypedArray.getBoolean(0, true));
        tintTypedArray.recycle();
        ViewCompat.Api16Impl.setImportantForAccessibility(this, 2);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 26 && r1 >= 26) {
            ViewCompat.Api26Impl.setImportantForAutofill(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(view);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
        setSuffixText(text4);
    }

    private EndIconDelegate getEndIconDelegate() {
        SparseArray<EndIconDelegate> sparseArray = this.endIconDelegates;
        EndIconDelegate endIconDelegate = sparseArray.get(this.endIconMode);
        if (endIconDelegate == null) {
            return sparseArray.get(0);
        }
        return endIconDelegate;
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        boolean z;
        CheckableImageButton checkableImageButton = this.errorIconView;
        if (checkableImageButton.getVisibility() == 0) {
            return checkableImageButton;
        }
        if (this.endIconMode != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            View childAt = viewGroup.getChildAt(r1);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText;
            int r0 = this.minEms;
            if (r0 != -1) {
                setMinEms(r0);
            } else {
                setMinWidth(this.minWidth);
            }
            int r02 = this.maxEms;
            if (r02 != -1) {
                setMaxEms(r02);
            } else {
                setMaxWidth(this.maxWidth);
            }
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            Typeface typeface = this.editText.getTypeface();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            collapsingTextHelper.setTypefaces(typeface);
            float textSize = this.editText.getTextSize();
            if (collapsingTextHelper.expandedTextSize != textSize) {
                collapsingTextHelper.expandedTextSize = textSize;
                collapsingTextHelper.recalculate(false);
            }
            float letterSpacing = this.editText.getLetterSpacing();
            if (collapsingTextHelper.expandedLetterSpacing != letterSpacing) {
                collapsingTextHelper.expandedLetterSpacing = letterSpacing;
                collapsingTextHelper.recalculate(false);
            }
            int gravity = this.editText.getGravity();
            int r2 = (gravity & (-113)) | 48;
            if (collapsingTextHelper.collapsedTextGravity != r2) {
                collapsingTextHelper.collapsedTextGravity = r2;
                collapsingTextHelper.recalculate(false);
            }
            if (collapsingTextHelper.expandedTextGravity != gravity) {
                collapsingTextHelper.expandedTextGravity = gravity;
                collapsingTextHelper.recalculate(false);
            }
            this.editText.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
                public AnonymousClass1() {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                    if (textInputLayout.counterEnabled) {
                        textInputLayout.updateCounter(editable.length());
                    }
                    if (textInputLayout.placeholderEnabled) {
                        textInputLayout.updatePlaceholderText(editable.length());
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint = this.editText.getHint();
                    this.originalHint = hint;
                    setHint(hint);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEditTextAttached(this);
            }
            updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (charSequence == null || !TextUtils.equals(collapsingTextHelper.text, charSequence)) {
                collapsingTextHelper.text = charSequence;
                collapsingTextHelper.textToDraw = null;
                Bitmap bitmap = collapsingTextHelper.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    collapsingTextHelper.expandedTitleTexture = null;
                }
                collapsingTextHelper.recalculate(false);
            }
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean z;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean hasOnClickListeners = ViewCompat.Api15Impl.hasOnClickListeners(checkableImageButton);
        boolean z2 = false;
        int r2 = 1;
        if (onLongClickListener != null) {
            z = true;
        } else {
            z = false;
        }
        if (hasOnClickListeners || z) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        if (!z2) {
            r2 = 2;
        }
        ViewCompat.Api16Impl.setImportantForAccessibility(checkableImageButton, r2);
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView != null) {
                this.inputFrame.addView(appCompatTextView);
                this.placeholderTextView.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r3, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            FrameLayout frameLayout = this.inputFrame;
            frameLayout.addView(view, layoutParams2);
            frameLayout.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, r3, layoutParams);
    }

    public final void animateToExpansionFraction(float f) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper.expandedFraction == f) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.4
                public AnonymousClass4() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.animator.setFloatValues(collapsingTextHelper.expandedFraction, f);
        this.animator.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyBoxAttributes() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.applyBoxAttributes():void");
    }

    public final int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int r0 = this.boxBackgroundMode;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (r0 != 0) {
            if (r0 != 2) {
                return 0;
            }
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        } else {
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight();
        }
        return (int) collapsedTextHeight;
    }

    public final boolean cutoutEnabled() {
        if (this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int r7) {
        EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, r7);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, r7);
                return;
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, r7);
        onProvideAutofillVirtualStructure(viewStructure, r7);
        FrameLayout frameLayout = this.inputFrame;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int r2 = 0; r2 < frameLayout.getChildCount(); r2++) {
            View childAt = frameLayout.getChildAt(r2);
            ViewStructure newChild = viewStructure.newChild(r2);
            childAt.dispatchProvideAutofillStructure(newChild, r7);
            if (childAt == this.editText) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        super.draw(canvas);
        boolean z = this.hintEnabled;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (z) {
            collapsingTextHelper.getClass();
            int save = canvas.save();
            if (collapsingTextHelper.textToDraw != null && collapsingTextHelper.drawTitle) {
                collapsingTextHelper.textPaint.setTextSize(collapsingTextHelper.currentTextSize);
                float f = collapsingTextHelper.currentDrawX;
                float f2 = collapsingTextHelper.currentDrawY;
                float f3 = collapsingTextHelper.scale;
                if (f3 != 1.0f) {
                    canvas.scale(f3, f3, f, f2);
                }
                canvas.translate(f, f2);
                collapsingTextHelper.textLayout.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.boxUnderlineFocused != null && (materialShapeDrawable = this.boxUnderlineDefault) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.editText.isFocused()) {
                Rect bounds = this.boxUnderlineFocused.getBounds();
                Rect bounds2 = this.boxUnderlineDefault.getBounds();
                float f4 = collapsingTextHelper.expandedFraction;
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.lerp(centerX, f4, bounds2.left);
                bounds.right = AnimationUtils.lerp(centerX, f4, bounds2.right);
                this.boxUnderlineFocused.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        boolean z2;
        boolean z3;
        if (this.inDrawableStateChanged) {
            return;
        }
        boolean z4 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            collapsingTextHelper.state = drawableState;
            ColorStateList colorStateList2 = collapsingTextHelper.collapsedTextColor;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = collapsingTextHelper.expandedTextColor) != null && colorStateList.isStateful())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                collapsingTextHelper.recalculate(false);
                z3 = true;
            } else {
                z3 = false;
            }
            z = z3 | false;
        } else {
            z = false;
        }
        if (this.editText != null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!ViewCompat.Api19Impl.isLaidOut(this) || !isEnabled()) {
                z4 = false;
            }
            updateLabelState(z4, false);
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (z) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        if (editText != null) {
            return calculateLabelMarginTop() + getPaddingTop() + editText.getBaseline();
        }
        return super.getBaseline();
    }

    public MaterialShapeDrawable getBoxBackground() {
        int r0 = this.boxBackgroundMode;
        if (r0 != 1 && r0 != 2) {
            throw new IllegalStateException();
        }
        return this.boxBackground;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        if (isLayoutRtl) {
            return this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        if (isLayoutRtl) {
            return this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        if (isLayoutRtl) {
            return this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        if (isLayoutRtl) {
            return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.counterEnabled && this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorEnabled) {
            return indicatorViewController.errorText;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.errorViewContentDescription;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.helperTextEnabled) {
            return indicatorViewController.helperText;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        return collapsingTextHelper.getCurrentColor(collapsingTextHelper.collapsedTextColor);
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public final int getLabelLeftBoundAlightWithPrefix(int r2, boolean z) {
        int compoundPaddingLeft = this.editText.getCompoundPaddingLeft() + r2;
        if (getPrefixText() != null && !z) {
            return (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
        }
        return compoundPaddingLeft;
    }

    public final int getLabelRightBoundAlignedWithSuffix(int r2, boolean z) {
        int compoundPaddingRight = r2 - this.editText.getCompoundPaddingRight();
        if (getPrefixText() != null && z) {
            return compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
        }
        return compoundPaddingRight;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.startLayout.prefixText;
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.prefixTextView.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.prefixTextView;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.startIconView.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public final boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void onApplyBoxBackgroundMode() {
        boolean z;
        boolean z2;
        int r0 = this.boxBackgroundMode;
        boolean z3 = true;
        if (r0 != 0) {
            if (r0 != 1) {
                if (r0 == 2) {
                    if (this.hintEnabled && !(this.boxBackground instanceof CutoutDrawable)) {
                        this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
                    } else {
                        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
                    }
                    this.boxUnderlineDefault = null;
                    this.boxUnderlineFocused = null;
                } else {
                    throw new IllegalArgumentException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
                }
            } else {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
                this.boxUnderlineDefault = new MaterialShapeDrawable();
                this.boxUnderlineFocused = new MaterialShapeDrawable();
            }
        } else {
            this.boxBackground = null;
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        }
        EditText editText = this.editText;
        if (editText != null && this.boxBackground != null && editText.getBackground() == null && this.boxBackgroundMode != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            EditText editText2 = this.editText;
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.setBackground(editText2, materialShapeDrawable);
        }
        updateTextInputBoxState();
        if (this.boxBackgroundMode == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (getContext().getResources().getConfiguration().fontScale < 2.0f) {
                z3 = false;
            }
            if (z3) {
                EditText editText3 = this.editText;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api17Impl.setPaddingRelative(editText3, ViewCompat.Api17Impl.getPaddingStart(editText3), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.Api17Impl.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText4 = this.editText;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api17Impl.setPaddingRelative(editText4, ViewCompat.Api17Impl.getPaddingStart(editText4), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.Api17Impl.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r8, int r9, int r10, int r11) {
        boolean z2;
        boolean z3;
        int compoundPaddingTop;
        boolean z4;
        int compoundPaddingBottom;
        boolean z5;
        super.onLayout(z, r8, r9, r10, r11);
        EditText editText = this.editText;
        if (editText != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
            if (materialShapeDrawable != null) {
                int r92 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, r92 - this.boxStrokeWidthDefaultPx, rect.right, r92);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.boxUnderlineFocused;
            if (materialShapeDrawable2 != null) {
                int r93 = rect.bottom;
                materialShapeDrawable2.setBounds(rect.left, r93 - this.boxStrokeWidthFocusedPx, rect.right, r93);
            }
            if (this.hintEnabled) {
                float textSize = this.editText.getTextSize();
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                if (collapsingTextHelper.expandedTextSize != textSize) {
                    collapsingTextHelper.expandedTextSize = textSize;
                    collapsingTextHelper.recalculate(false);
                }
                int gravity = this.editText.getGravity();
                int r102 = (gravity & (-113)) | 48;
                if (collapsingTextHelper.collapsedTextGravity != r102) {
                    collapsingTextHelper.collapsedTextGravity = r102;
                    collapsingTextHelper.recalculate(false);
                }
                if (collapsingTextHelper.expandedTextGravity != gravity) {
                    collapsingTextHelper.expandedTextGravity = gravity;
                    collapsingTextHelper.recalculate(false);
                }
                if (this.editText != null) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    int r103 = rect.bottom;
                    Rect rect2 = this.tmpBoundsRect;
                    rect2.bottom = r103;
                    int r104 = this.boxBackgroundMode;
                    if (r104 != 1) {
                        if (r104 != 2) {
                            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, isLayoutRtl);
                            rect2.top = getPaddingTop();
                            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, isLayoutRtl);
                        } else {
                            rect2.left = this.editText.getPaddingLeft() + rect.left;
                            rect2.top = rect.top - calculateLabelMarginTop();
                            rect2.right = rect.right - this.editText.getPaddingRight();
                        }
                    } else {
                        rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, isLayoutRtl);
                        rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                        rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, isLayoutRtl);
                    }
                    int r7 = rect2.left;
                    int r105 = rect2.top;
                    int r2 = rect2.right;
                    int r3 = rect2.bottom;
                    Rect rect3 = collapsingTextHelper.collapsedBounds;
                    if (rect3.left == r7 && rect3.top == r105 && rect3.right == r2 && rect3.bottom == r3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        rect3.set(r7, r105, r2, r3);
                        collapsingTextHelper.boundsChanged = true;
                        collapsingTextHelper.onBoundsChanged();
                    }
                    if (this.editText != null) {
                        TextPaint textPaint = collapsingTextHelper.tmpPaint;
                        textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                        textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                        textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                        float f = -textPaint.ascent();
                        rect2.left = this.editText.getCompoundPaddingLeft() + rect.left;
                        if (this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            compoundPaddingTop = (int) (rect.centerY() - (f / 2.0f));
                        } else {
                            compoundPaddingTop = rect.top + this.editText.getCompoundPaddingTop();
                        }
                        rect2.top = compoundPaddingTop;
                        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                        if (this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            compoundPaddingBottom = (int) (rect2.top + f);
                        } else {
                            compoundPaddingBottom = rect.bottom - this.editText.getCompoundPaddingBottom();
                        }
                        rect2.bottom = compoundPaddingBottom;
                        int r82 = rect2.left;
                        int r106 = rect2.top;
                        int r0 = rect2.right;
                        Rect rect4 = collapsingTextHelper.expandedBounds;
                        if (rect4.left == r82 && rect4.top == r106 && rect4.right == r0 && rect4.bottom == compoundPaddingBottom) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            rect4.set(r82, r106, r0, compoundPaddingBottom);
                            collapsingTextHelper.boundsChanged = true;
                            collapsingTextHelper.onBoundsChanged();
                        }
                        collapsingTextHelper.recalculate(false);
                        if (cutoutEnabled() && !this.hintExpanded) {
                            openCutout();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        boolean z;
        EditText editText;
        int max;
        super.onMeasure(r4, r5);
        if (this.editText != null && this.editText.getMeasuredHeight() < (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            this.editText.setMinimumHeight(max);
            z = true;
        } else {
            z = false;
        }
        boolean updateDummyDrawables = updateDummyDrawables();
        if (z || updateDummyDrawables) {
            this.editText.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        if (this.placeholderTextView != null && (editText = this.editText) != null) {
            this.placeholderTextView.setGravity(editText.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
        updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.endIconView.performClick();
                    textInputLayout.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r6) {
        boolean z;
        float f;
        float f2;
        float f3;
        float f4;
        super.onRtlPropertiesChanged(r6);
        boolean z2 = false;
        if (r6 == 1) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = this.areCornerRadiiRtl;
        if (z != z3) {
            if (z && !z3) {
                z2 = true;
            }
            CornerSize cornerSize = this.shapeAppearanceModel.topLeftCornerSize;
            RectF rectF = this.tmpRectF;
            float cornerSize2 = cornerSize.getCornerSize(rectF);
            float cornerSize3 = this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
            float cornerSize4 = this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
            float cornerSize5 = this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
            if (z2) {
                f = cornerSize2;
            } else {
                f = cornerSize3;
            }
            if (z2) {
                cornerSize2 = cornerSize3;
            }
            if (z2) {
                f2 = cornerSize4;
            } else {
                f2 = cornerSize5;
            }
            if (z2) {
                cornerSize4 = cornerSize5;
            }
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            this.areCornerRadiiRtl = isLayoutRtl;
            if (isLayoutRtl) {
                f3 = cornerSize2;
            } else {
                f3 = f;
            }
            if (!isLayoutRtl) {
                f = cornerSize2;
            }
            if (isLayoutRtl) {
                f4 = cornerSize4;
            } else {
                f4 = f2;
            }
            if (!isLayoutRtl) {
                f2 = cornerSize4;
            }
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            if (materialShapeDrawable != null && materialShapeDrawable.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF()) == f3) {
                MaterialShapeDrawable materialShapeDrawable2 = this.boxBackground;
                if (materialShapeDrawable2.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable2.getBoundsAsRectF()) == f) {
                    MaterialShapeDrawable materialShapeDrawable3 = this.boxBackground;
                    if (materialShapeDrawable3.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable3.getBoundsAsRectF()) == f4) {
                        MaterialShapeDrawable materialShapeDrawable4 = this.boxBackground;
                        if (materialShapeDrawable4.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable4.getBoundsAsRectF()) == f2) {
                            return;
                        }
                    }
                }
            }
            ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
            shapeAppearanceModel.getClass();
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
            builder.setTopLeftCornerSize(f3);
            builder.setTopRightCornerSize(f);
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(f4);
            builder.bottomRightCornerSize = new AbsoluteCornerSize(f2);
            this.shapeAppearanceModel = new ShapeAppearanceModel(builder);
            applyBoxAttributes();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        boolean z2 = true;
        if (this.endIconMode != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !this.endIconView.isChecked()) {
            z2 = false;
        }
        savedState.isEndIconChecked = z2;
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    public final void openCutout() {
        float f;
        float f2;
        float f3;
        float f4;
        int r1;
        int r11;
        if (!cutoutEnabled()) {
            return;
        }
        RectF rectF = this.tmpRectF;
        int width = this.editText.getWidth();
        int gravity = this.editText.getGravity();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean calculateIsRtl = collapsingTextHelper.calculateIsRtl(collapsingTextHelper.text);
        collapsingTextHelper.isRtl = calculateIsRtl;
        Rect rect = collapsingTextHelper.collapsedBounds;
        if (gravity != 17 && (gravity & 7) != 1) {
            if ((gravity & 8388613) != 8388613 && (gravity & 5) != 5) {
                if (calculateIsRtl) {
                    f = rect.right;
                    f2 = collapsingTextHelper.collapsedTextWidth;
                } else {
                    r11 = rect.left;
                    f3 = r11;
                }
            } else if (calculateIsRtl) {
                r11 = rect.left;
                f3 = r11;
            } else {
                f = rect.right;
                f2 = collapsingTextHelper.collapsedTextWidth;
            }
            rectF.left = f3;
            float f5 = rect.top;
            rectF.top = f5;
            if (gravity == 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) != 8388613 && (gravity & 5) != 5) {
                    if (calculateIsRtl) {
                        r1 = rect.right;
                        f4 = r1;
                    } else {
                        f4 = collapsingTextHelper.collapsedTextWidth + f3;
                    }
                } else if (calculateIsRtl) {
                    f4 = collapsingTextHelper.collapsedTextWidth + f3;
                } else {
                    r1 = rect.right;
                    f4 = r1;
                }
            } else {
                f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
            }
            rectF.right = f4;
            rectF.bottom = collapsingTextHelper.getCollapsedTextHeight() + f5;
            float f6 = rectF.left;
            float f7 = this.boxLabelCutoutPaddingPx;
            rectF.left = f6 - f7;
            rectF.right += f7;
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.boxStrokeWidthPx);
            CutoutDrawable cutoutDrawable = (CutoutDrawable) this.boxBackground;
            cutoutDrawable.getClass();
            cutoutDrawable.setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
        f = width / 2.0f;
        f2 = collapsingTextHelper.collapsedTextWidth / 2.0f;
        f3 = f - f2;
        rectF.left = f3;
        float f52 = rect.top;
        rectF.top = f52;
        if (gravity == 17) {
        }
        f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
        rectF.right = f4;
        rectF.bottom = collapsingTextHelper.getCollapsedTextHeight() + f52;
        float f62 = rectF.left;
        float f72 = this.boxLabelCutoutPaddingPx;
        rectF.left = f62 - f72;
        rectF.right += f72;
        rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.boxStrokeWidthPx);
        CutoutDrawable cutoutDrawable2 = (CutoutDrawable) this.boxBackground;
        cutoutDrawable2.getClass();
        cutoutDrawable2.setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void setBoxBackgroundColor(int r2) {
        if (this.boxBackgroundColor != r2) {
            this.boxBackgroundColor = r2;
            this.defaultFilledBackgroundColor = r2;
            this.focusedFilledBackgroundColor = r2;
            this.hoveredFilledBackgroundColor = r2;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int r3) {
        Context context = getContext();
        Object obj = ContextCompat.sLock;
        setBoxBackgroundColor(ContextCompat.Api23Impl.getColor(context, r3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int r2) {
        if (r2 == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = r2;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCollapsedPaddingTop(int r1) {
        this.boxCollapsedPaddingTopPx = r1;
    }

    public void setBoxStrokeColor(int r2) {
        if (this.focusedStrokeColor != r2) {
            this.focusedStrokeColor = r2;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int r1) {
        this.boxStrokeWidthDefaultPx = r1;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int r1) {
        this.boxStrokeWidthFocusedPx = r1;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int r2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidthResource(int r2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r2));
    }

    public void setCounterEnabled(boolean z) {
        int length;
        if (this.counterEnabled != z) {
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                indicatorViewController.addIndicator(this.counterView, 2);
                MarginLayoutParamsCompat$Api17Impl.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                if (this.counterView != null) {
                    EditText editText = this.editText;
                    if (editText == null) {
                        length = 0;
                    } else {
                        length = editText.getText().length();
                    }
                    updateCounter(length);
                }
            } else {
                indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int r2) {
        int length;
        if (this.counterMaxLength != r2) {
            if (r2 > 0) {
                this.counterMaxLength = r2;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled && this.counterView != null) {
                EditText editText = this.editText;
                if (editText == null) {
                    length = 0;
                } else {
                    length = editText.getText().length();
                }
                updateCounter(length);
            }
        }
    }

    public void setCounterOverflowTextAppearance(int r2) {
        if (this.counterOverflowTextAppearance != r2) {
            this.counterOverflowTextAppearance = r2;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int r2) {
        if (this.counterTextAppearance != r2) {
            this.counterTextAppearance = r2;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int r2) {
        setEndIconContentDescription(r2 != 0 ? getResources().getText(r2) : null);
    }

    public void setEndIconDrawable(int r2) {
        setEndIconDrawable(r2 != 0 ? AppCompatResources.getDrawable(getContext(), r2) : null);
    }

    public void setEndIconMode(int r4) {
        boolean z;
        int r0 = this.endIconMode;
        if (r0 == r4) {
            return;
        }
        this.endIconMode = r4;
        Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, r0);
        }
        if (r4 != 0) {
            z = true;
        } else {
            z = false;
        }
        setEndIconVisible(z);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + r4);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.endIconOnLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            IconHelper.applyIconTint(this, this.endIconView, colorStateList, this.endIconTintMode);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        int r2;
        if (isEndIconVisible() != z) {
            if (z) {
                r2 = 0;
            } else {
                r2 = 8;
            }
            this.endIconView.setVisibility(r2);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!indicatorViewController.errorEnabled) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            indicatorViewController.cancelCaptionAnimator();
            indicatorViewController.errorText = charSequence;
            indicatorViewController.errorView.setText(charSequence);
            int r1 = indicatorViewController.captionDisplayed;
            if (r1 != 1) {
                indicatorViewController.captionToShow = 1;
            }
            indicatorViewController.updateCaptionViewsVisibility(r1, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.errorView, charSequence));
            return;
        }
        indicatorViewController.hideError();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewContentDescription = charSequence;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorEnabled != z) {
            indicatorViewController.cancelCaptionAnimator();
            TextInputLayout textInputLayout = indicatorViewController.textInputView;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context);
                indicatorViewController.errorView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                indicatorViewController.errorView.setTextAlignment(5);
                Typeface typeface = indicatorViewController.typeface;
                if (typeface != null) {
                    indicatorViewController.errorView.setTypeface(typeface);
                }
                int r3 = indicatorViewController.errorTextAppearance;
                indicatorViewController.errorTextAppearance = r3;
                AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
                if (appCompatTextView2 != null) {
                    textInputLayout.setTextAppearanceCompatWithErrorFallback(appCompatTextView2, r3);
                }
                ColorStateList colorStateList = indicatorViewController.errorViewTextColor;
                indicatorViewController.errorViewTextColor = colorStateList;
                AppCompatTextView appCompatTextView3 = indicatorViewController.errorView;
                if (appCompatTextView3 != null && colorStateList != null) {
                    appCompatTextView3.setTextColor(colorStateList);
                }
                CharSequence charSequence = indicatorViewController.errorViewContentDescription;
                indicatorViewController.errorViewContentDescription = charSequence;
                AppCompatTextView appCompatTextView4 = indicatorViewController.errorView;
                if (appCompatTextView4 != null) {
                    appCompatTextView4.setContentDescription(charSequence);
                }
                indicatorViewController.errorView.setVisibility(4);
                AppCompatTextView appCompatTextView5 = indicatorViewController.errorView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api19Impl.setAccessibilityLiveRegion(appCompatTextView5, 1);
                indicatorViewController.addIndicator(indicatorViewController.errorView, 0);
            } else {
                indicatorViewController.hideError();
                indicatorViewController.removeIndicator(indicatorViewController.errorView, 0);
                indicatorViewController.errorView = null;
                textInputLayout.updateEditTextBackground();
                textInputLayout.updateTextInputBoxState();
            }
            indicatorViewController.errorEnabled = z;
        }
    }

    public void setErrorIconDrawable(int r2) {
        setErrorIconDrawable(r2 != 0 ? AppCompatResources.getDrawable(getContext(), r2) : null);
        IconHelper.refreshIconDrawableState(this, this.errorIconView, this.errorIconTintList);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.errorIconOnLongClickListener;
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.errorIconTintList != colorStateList) {
            this.errorIconTintList = colorStateList;
            IconHelper.applyIconTint(this, this.errorIconView, colorStateList, this.errorIconTintMode);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.errorIconTintMode != mode) {
            this.errorIconTintMode = mode;
            IconHelper.applyIconTint(this, this.errorIconView, this.errorIconTintList, mode);
        }
    }

    public void setErrorTextAppearance(int r3) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorTextAppearance = r3;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView, r3);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (isEmpty) {
            if (indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(true);
        }
        indicatorViewController.cancelCaptionAnimator();
        indicatorViewController.helperText = charSequence;
        indicatorViewController.helperTextView.setText(charSequence);
        int r0 = indicatorViewController.captionDisplayed;
        if (r0 != 2) {
            indicatorViewController.captionToShow = 2;
        }
        indicatorViewController.updateCaptionViewsVisibility(r0, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        final IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.helperTextEnabled != z) {
            indicatorViewController.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context);
                indicatorViewController.helperTextView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                indicatorViewController.helperTextView.setTextAlignment(5);
                Typeface typeface = indicatorViewController.typeface;
                if (typeface != null) {
                    indicatorViewController.helperTextView.setTypeface(typeface);
                }
                indicatorViewController.helperTextView.setVisibility(4);
                AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api19Impl.setAccessibilityLiveRegion(appCompatTextView2, 1);
                int r2 = indicatorViewController.helperTextTextAppearance;
                indicatorViewController.helperTextTextAppearance = r2;
                AppCompatTextView appCompatTextView3 = indicatorViewController.helperTextView;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setTextAppearance(r2);
                }
                ColorStateList colorStateList = indicatorViewController.helperTextViewTextColor;
                indicatorViewController.helperTextViewTextColor = colorStateList;
                AppCompatTextView appCompatTextView4 = indicatorViewController.helperTextView;
                if (appCompatTextView4 != null && colorStateList != null) {
                    appCompatTextView4.setTextColor(colorStateList);
                }
                indicatorViewController.addIndicator(indicatorViewController.helperTextView, 1);
                indicatorViewController.helperTextView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                    @Override // android.view.View.AccessibilityDelegate
                    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                        EditText editText = IndicatorViewController.this.textInputView.getEditText();
                        if (editText != null) {
                            accessibilityNodeInfo.setLabeledBy(editText);
                        }
                    }
                });
            } else {
                indicatorViewController.cancelCaptionAnimator();
                int r22 = indicatorViewController.captionDisplayed;
                if (r22 == 2) {
                    indicatorViewController.captionToShow = 0;
                }
                indicatorViewController.updateCaptionViewsVisibility(r22, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, ""));
                indicatorViewController.removeIndicator(indicatorViewController.helperTextView, 1);
                indicatorViewController.helperTextView = null;
                TextInputLayout textInputLayout = indicatorViewController.textInputView;
                textInputLayout.updateEditTextBackground();
                textInputLayout.updateTextInputBoxState();
            }
            indicatorViewController.helperTextEnabled = z;
        }
    }

    public void setHelperTextTextAppearance(int r2) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextTextAppearance = r2;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(r2);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!z) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int r6) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        View view = collapsingTextHelper.view;
        TextAppearance textAppearance = new TextAppearance(view.getContext(), r6);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            collapsingTextHelper.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            collapsingTextHelper.collapsedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            collapsingTextHelper.collapsedShadowColor = colorStateList2;
        }
        collapsingTextHelper.collapsedShadowDx = textAppearance.shadowDx;
        collapsingTextHelper.collapsedShadowDy = textAppearance.shadowDy;
        collapsingTextHelper.collapsedShadowRadius = textAppearance.shadowRadius;
        collapsingTextHelper.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = collapsingTextHelper.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        CollapsingTextHelper.AnonymousClass1 anonymousClass1 = new CollapsingTextHelper.AnonymousClass1();
        textAppearance.createFallbackFont();
        collapsingTextHelper.collapsedFontCallback = new CancelableFontCallback(anonymousClass1, textAppearance.font);
        textAppearance.getFontAsync(view.getContext(), collapsingTextHelper.collapsedFontCallback);
        collapsingTextHelper.recalculate(false);
        this.focusedTextColor = collapsingTextHelper.collapsedTextColor;
        if (this.editText != null) {
            updateLabelState(false, false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
    }

    public void setMaxEms(int r3) {
        this.maxEms = r3;
        EditText editText = this.editText;
        if (editText != null && r3 != -1) {
            editText.setMaxEms(r3);
        }
    }

    public void setMaxWidth(int r3) {
        this.maxWidth = r3;
        EditText editText = this.editText;
        if (editText != null && r3 != -1) {
            editText.setMaxWidth(r3);
        }
    }

    public void setMaxWidthResource(int r2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public void setMinEms(int r3) {
        this.minEms = r3;
        EditText editText = this.editText;
        if (editText != null && r3 != -1) {
            editText.setMinEms(r3);
        }
    }

    public void setMinWidth(int r3) {
        this.minWidth = r3;
        EditText editText = this.editText;
        if (editText != null && r3 != -1) {
            editText.setMinWidth(r3);
        }
    }

    public void setMinWidthResource(int r2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int r2) {
        setPasswordVisibilityToggleContentDescription(r2 != 0 ? getResources().getText(r2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int r2) {
        setPasswordVisibilityToggleDrawable(r2 != 0 ? AppCompatResources.getDrawable(getContext(), r2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        IconHelper.applyIconTint(this, this.endIconView, colorStateList, this.endIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.placeholderTextView == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.setImportantForAccessibility(appCompatTextView2, 2);
            Fade fade = new Fade();
            fade.mDuration = 87L;
            LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
            fade.mInterpolator = linearInterpolator;
            this.placeholderFadeIn = fade;
            fade.mStartDelay = 67L;
            Fade fade2 = new Fade();
            fade2.mDuration = 87L;
            fade2.mInterpolator = linearInterpolator;
            this.placeholderFadeOut = fade2;
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
        }
        int r1 = 0;
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        EditText editText = this.editText;
        if (editText != null) {
            r1 = editText.getText().length();
        }
        updatePlaceholderText(r1);
    }

    public void setPlaceholderTextAppearance(int r2) {
        this.placeholderTextAppearance = r2;
        AppCompatTextView appCompatTextView = this.placeholderTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(r2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView != null && colorStateList != null) {
                appCompatTextView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        CharSequence charSequence2;
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        startCompoundLayout.prefixText = charSequence2;
        startCompoundLayout.prefixTextView.setText(charSequence);
        startCompoundLayout.updateVisibility();
    }

    public void setPrefixTextAppearance(int r2) {
        this.startLayout.prefixTextView.setTextAppearance(r2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.startLayout.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startLayout.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.startLayout.startIconView;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int r2) {
        setStartIconDrawable(r2 != 0 ? AppCompatResources.getDrawable(getContext(), r2) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        View.OnLongClickListener onLongClickListener = startCompoundLayout.startIconOnLongClickListener;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.startIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintList != colorStateList) {
            startCompoundLayout.startIconTintList = colorStateList;
            IconHelper.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, colorStateList, startCompoundLayout.startIconTintMode);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintMode != mode) {
            startCompoundLayout.startIconTintMode = mode;
            IconHelper.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.startLayout.setStartIconVisible(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.suffixText = charSequence2;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(int r2) {
        this.suffixTextView.setTextAppearance(r2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public final void setTextAppearanceCompatWithErrorFallback(TextView textView, int r4) {
        boolean z = true;
        try {
            textView.setTextAppearance(r4);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            textView.setTextAppearance(2132083161);
            Context context = getContext();
            Object obj = ContextCompat.sLock;
            textView.setTextColor(ContextCompat.Api23Impl.getColor(context, R.color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (typeface != indicatorViewController.typeface) {
                indicatorViewController.typeface = typeface;
                AppCompatTextView appCompatTextView = indicatorViewController.errorView;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.counterView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void updateCounter(int r10) {
        boolean z;
        int r7;
        BidiFormatter bidiFormatter;
        boolean z2 = this.counterOverflowed;
        int r1 = this.counterMaxLength;
        String str = null;
        if (r1 == -1) {
            this.counterView.setText(String.valueOf(r10));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            boolean z3 = true;
            if (r10 > r1) {
                z = true;
            } else {
                z = false;
            }
            this.counterOverflowed = z;
            Context context = getContext();
            AppCompatTextView appCompatTextView = this.counterView;
            int r6 = this.counterMaxLength;
            if (this.counterOverflowed) {
                r7 = R.string.character_counter_overflowed_content_description;
            } else {
                r7 = R.string.character_counter_content_description;
            }
            appCompatTextView.setContentDescription(context.getString(r7, Integer.valueOf(r10), Integer.valueOf(r6)));
            if (z2 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            String str2 = BidiFormatter.LRM_STRING;
            Locale locale = Locale.getDefault();
            int r5 = TextUtilsCompat.$r8$clinit;
            if (TextUtilsCompat.Api17Impl.getLayoutDirectionFromLocale(locale) != 1) {
                z3 = false;
            }
            if (z3) {
                bidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
            } else {
                bidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
            }
            AppCompatTextView appCompatTextView2 = this.counterView;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(r10), Integer.valueOf(this.counterMaxLength));
            if (string == null) {
                bidiFormatter.getClass();
            } else {
                str = bidiFormatter.unicodeWrap(string, bidiFormatter.mDefaultTextDirectionHeuristicCompat).toString();
            }
            appCompatTextView2.setText(str);
        }
        if (this.editText != null && z2 != this.counterOverflowed) {
            updateLabelState(false, false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public final void updateCounterTextAppearanceAndColor() {
        int r1;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.counterView;
        if (appCompatTextView != null) {
            if (this.counterOverflowed) {
                r1 = this.counterOverflowTextAppearance;
            } else {
                r1 = this.counterTextAppearance;
            }
            setTextAppearanceCompatWithErrorFallback(appCompatTextView, r1);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:            if (isEndIconVisible() != false) goto L111;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:            if (r10.suffixText != null) goto L111;     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean updateDummyDrawables() {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    public final void updateEditTextBackground() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorShouldBeShown()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            background.clearColorFilter();
            this.editText.refreshDrawableState();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateEndLayoutVisibility() {
        /*
            r6 = this;
            com.google.android.material.internal.CheckableImageButton r0 = r6.endIconView
            int r0 = r0.getVisibility()
            com.google.android.material.internal.CheckableImageButton r1 = r6.errorIconView
            r2 = 1
            r3 = 8
            r4 = 0
            if (r0 != 0) goto L1b
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r4
        L17:
            if (r0 != 0) goto L1b
            r0 = r4
            goto L1c
        L1b:
            r0 = r3
        L1c:
            android.widget.FrameLayout r5 = r6.endIconFrame
            r5.setVisibility(r0)
            java.lang.CharSequence r0 = r6.suffixText
            if (r0 == 0) goto L2b
            boolean r0 = r6.hintExpanded
            if (r0 != 0) goto L2b
            r0 = r4
            goto L2c
        L2b:
            r0 = r3
        L2c:
            boolean r5 = r6.isEndIconVisible()
            if (r5 != 0) goto L41
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L3a
            r1 = r2
            goto L3b
        L3a:
            r1 = r4
        L3b:
            if (r1 != 0) goto L41
            if (r0 != 0) goto L40
            goto L41
        L40:
            r2 = r4
        L41:
            if (r2 == 0) goto L44
            r3 = r4
        L44:
            android.widget.LinearLayout r0 = r6.endLayout
            r0.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateEndLayoutVisibility():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateErrorIconVisibility() {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.getErrorIconDrawable()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L16
            com.google.android.material.textfield.IndicatorViewController r0 = r4.indicatorViewController
            boolean r3 = r0.errorEnabled
            if (r3 == 0) goto L16
            boolean r0 = r0.errorShouldBeShown()
            if (r0 == 0) goto L16
            r0 = r1
            goto L17
        L16:
            r0 = r2
        L17:
            if (r0 == 0) goto L1b
            r0 = r2
            goto L1d
        L1b:
            r0 = 8
        L1d:
            com.google.android.material.internal.CheckableImageButton r3 = r4.errorIconView
            r3.setVisibility(r0)
            r4.updateEndLayoutVisibility()
            r4.updateSuffixTextViewPadding()
            int r0 = r4.endIconMode
            if (r0 == 0) goto L2d
            goto L2e
        L2d:
            r1 = r2
        L2e:
            if (r1 != 0) goto L33
            r4.updateDummyDrawables()
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateErrorIconVisibility():void");
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            FrameLayout frameLayout = this.inputFrame;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                frameLayout.requestLayout();
            }
        }
    }

    public final void updateLabelState(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        ColorStateList colorStateList2;
        int length;
        int r0;
        boolean isEnabled = isEnabled();
        EditText editText = this.editText;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z3 = true;
        } else {
            z3 = false;
        }
        EditText editText2 = this.editText;
        if (editText2 != null && editText2.hasFocus()) {
            z4 = true;
        } else {
            z4 = false;
        }
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        boolean errorShouldBeShown = indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList3 = this.defaultHintTextColor;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (colorStateList3 != null) {
            collapsingTextHelper.setCollapsedTextColor(colorStateList3);
            ColorStateList colorStateList4 = this.defaultHintTextColor;
            if (collapsingTextHelper.expandedTextColor != colorStateList4) {
                collapsingTextHelper.expandedTextColor = colorStateList4;
                collapsingTextHelper.recalculate(false);
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList5 = this.defaultHintTextColor;
            if (colorStateList5 != null) {
                r0 = colorStateList5.getColorForState(new int[]{-16842910}, this.disabledColor);
            } else {
                r0 = this.disabledColor;
            }
            collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(r0));
            ColorStateList valueOf = ColorStateList.valueOf(r0);
            if (collapsingTextHelper.expandedTextColor != valueOf) {
                collapsingTextHelper.expandedTextColor = valueOf;
                collapsingTextHelper.recalculate(false);
            }
        } else if (errorShouldBeShown) {
            AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
            if (appCompatTextView2 != null) {
                colorStateList2 = appCompatTextView2.getTextColors();
            } else {
                colorStateList2 = null;
            }
            collapsingTextHelper.setCollapsedTextColor(colorStateList2);
        } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            collapsingTextHelper.setCollapsedTextColor(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (!z3 && this.expandedHintEnabled && (!isEnabled() || !z4)) {
            if (z2 || !this.hintExpanded) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.animator.cancel();
                }
                if (z && this.hintAnimationEnabled) {
                    animateToExpansionFraction(0.0f);
                } else {
                    collapsingTextHelper.setExpansionFraction(0.0f);
                }
                if (cutoutEnabled() && (!((CutoutDrawable) this.boxBackground).cutoutBounds.isEmpty()) && cutoutEnabled()) {
                    ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                }
                this.hintExpanded = true;
                AppCompatTextView appCompatTextView3 = this.placeholderTextView;
                if (appCompatTextView3 != null && this.placeholderEnabled) {
                    appCompatTextView3.setText((CharSequence) null);
                    TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
                    this.placeholderTextView.setVisibility(4);
                }
                startCompoundLayout.hintExpanded = true;
                startCompoundLayout.updateVisibility();
                updateSuffixTextVisibility();
                return;
            }
            return;
        }
        if (z2 || this.hintExpanded) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (z && this.hintAnimationEnabled) {
                animateToExpansionFraction(1.0f);
            } else {
                collapsingTextHelper.setExpansionFraction(1.0f);
            }
            this.hintExpanded = false;
            if (cutoutEnabled()) {
                openCutout();
            }
            EditText editText3 = this.editText;
            if (editText3 == null) {
                length = 0;
            } else {
                length = editText3.getText().length();
            }
            updatePlaceholderText(length);
            startCompoundLayout.hintExpanded = false;
            startCompoundLayout.updateVisibility();
            updateSuffixTextVisibility();
        }
    }

    public final void updatePlaceholderText(int r3) {
        FrameLayout frameLayout = this.inputFrame;
        if (r3 == 0 && !this.hintExpanded) {
            if (this.placeholderTextView != null && this.placeholderEnabled && !TextUtils.isEmpty(this.placeholderText)) {
                this.placeholderTextView.setText(this.placeholderText);
                TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeIn);
                this.placeholderTextView.setVisibility(0);
                this.placeholderTextView.bringToFront();
                announceForAccessibility(this.placeholderText);
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView = this.placeholderTextView;
        if (appCompatTextView != null && this.placeholderEnabled) {
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
        }
    }

    public final void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    public final void updateSuffixTextViewPadding() {
        boolean z;
        if (this.editText == null) {
            return;
        }
        int r1 = 0;
        if (!isEndIconVisible()) {
            if (this.errorIconView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                EditText editText = this.editText;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                r1 = ViewCompat.Api17Impl.getPaddingEnd(editText);
            }
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = this.editText.getPaddingTop();
        int paddingBottom = this.editText.getPaddingBottom();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api17Impl.setPaddingRelative(this.suffixTextView, dimensionPixelSize, paddingTop, r1, paddingBottom);
    }

    public final void updateSuffixTextVisibility() {
        int r2;
        AppCompatTextView appCompatTextView = this.suffixTextView;
        int visibility = appCompatTextView.getVisibility();
        boolean z = false;
        if (this.suffixText != null && !this.hintExpanded) {
            r2 = 0;
        } else {
            r2 = 8;
        }
        if (visibility != r2) {
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            if (r2 == 0) {
                z = true;
            }
            endIconDelegate.onSuffixVisibilityChanged(z);
        }
        updateEndLayoutVisibility();
        appCompatTextView.setVisibility(r2);
        updateDummyDrawables();
    }

    public final void updateTextInputBoxState() {
        boolean z;
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z2 = false;
            if (!isFocused() && ((editText2 = this.editText) == null || !editText2.hasFocus())) {
                z = false;
            } else {
                z = true;
            }
            if (isHovered() || ((editText = this.editText) != null && editText.isHovered())) {
                z2 = true;
            }
            boolean isEnabled = isEnabled();
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (!isEnabled) {
                this.boxStrokeColor = this.disabledColor;
            } else if (indicatorViewController.errorShouldBeShown()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z, z2);
                } else {
                    this.boxStrokeColor = indicatorViewController.getErrorViewCurrentTextColor();
                }
            } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z, z2);
                } else {
                    this.boxStrokeColor = appCompatTextView.getCurrentTextColor();
                }
            } else if (z) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z2) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
            updateErrorIconVisibility();
            IconHelper.refreshIconDrawableState(this, this.errorIconView, this.errorIconTintList);
            StartCompoundLayout startCompoundLayout = this.startLayout;
            IconHelper.refreshIconDrawableState(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList);
            ColorStateList colorStateList = this.endIconTintList;
            CheckableImageButton checkableImageButton = this.endIconView;
            IconHelper.refreshIconDrawableState(this, checkableImageButton, colorStateList);
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            endIconDelegate.getClass();
            if (endIconDelegate instanceof DropdownMenuEndIconDelegate) {
                if (indicatorViewController.errorShouldBeShown() && getEndIconDrawable() != null) {
                    Drawable mutate = getEndIconDrawable().mutate();
                    DrawableCompat$Api21Impl.setTint(mutate, indicatorViewController.getErrorViewCurrentTextColor());
                    checkableImageButton.setImageDrawable(mutate);
                } else {
                    IconHelper.applyIconTint(this, checkableImageButton, this.endIconTintList, this.endIconTintMode);
                }
            }
            if (this.boxBackgroundMode == 2) {
                int r3 = this.boxStrokeWidthPx;
                if (z && isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                }
                if (this.boxStrokeWidthPx != r3 && cutoutEnabled() && !this.hintExpanded) {
                    if (cutoutEnabled()) {
                        ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    openCutout();
                }
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z2 && !z) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this, checkableImageButton, this.endIconTintList, this.endIconTintMode);
            IconHelper.refreshIconDrawableState(this, checkableImageButton, this.endIconTintList);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startLayout.setStartIconDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setImageDrawable(drawable);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this, checkableImageButton, this.errorIconTintList, this.errorIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setHint(int r2) {
        setHint(r2 != 0 ? getResources().getText(r2) : null);
    }

    public void setStartIconContentDescription(int r2) {
        setStartIconContentDescription(r2 != 0 ? getResources().getText(r2) : null);
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TextWatcher {
        public AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
            if (textInputLayout.counterEnabled) {
                textInputLayout.updateCounter(editable.length());
            }
            if (textInputLayout.placeholderEnabled) {
                textInputLayout.updatePlaceholderText(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
        }
    }
}
