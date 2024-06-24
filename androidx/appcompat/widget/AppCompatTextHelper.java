package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public TintInfo mDrawableBottomTint;
    public TintInfo mDrawableEndTint;
    public TintInfo mDrawableLeftTint;
    public TintInfo mDrawableRightTint;
    public TintInfo mDrawableStartTint;
    public TintInfo mDrawableTint;
    public TintInfo mDrawableTopTint;
    public Typeface mFontTypeface;
    public final TextView mView;
    public int mStyle = 0;
    public int mFontWeight = -1;

    /* renamed from: androidx.appcompat.widget.AppCompatTextHelper$2 */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int val$style;
        public final /* synthetic */ TextView val$textView;
        public final /* synthetic */ Typeface val$typeface;

        public AnonymousClass2(TextView textView, Typeface typeface, int r3) {
            r1 = textView;
            r2 = typeface;
            r3 = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r1.setTypeface(r2, r3);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    public static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int r3) {
        ColorStateList tintList;
        synchronized (appCompatDrawableManager) {
            tintList = appCompatDrawableManager.mResourceManager.getTintList(context, r3);
        }
        if (tintList != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = tintList;
            return tintInfo;
        }
        return null;
    }

    public final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    public final void applyCompoundDrawablesTints() {
        TintInfo tintInfo = this.mDrawableLeftTint;
        TextView textView = this.mView;
        if (tintInfo != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    @SuppressLint({"NewApi"})
    public final void loadFromAttributes(AttributeSet attributeSet, int r27) {
        boolean z;
        boolean z2;
        String str;
        String str2;
        float f;
        float f2;
        float f3;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        int r4;
        Paint.FontMetricsInt fontMetricsInt;
        int autoSizeStepGranularity;
        int r8;
        int resourceId;
        int r6;
        TextView textView = this.mView;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] r3 = R$styleable.AppCompatTextHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, r3, r27);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), r3, attributeSet, obtainStyledAttributes.mWrapped, r27);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(4, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(2, 0));
        }
        int r2 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(5, 0));
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(6, 0));
        }
        obtainStyledAttributes.recycle();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] r12 = R$styleable.TextAppearance;
        if (resourceId2 != -1) {
            TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(resourceId2, r12));
            if (!z3 && tintTypedArray.hasValue(14)) {
                z = tintTypedArray.getBoolean(14, false);
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            updateTypefaceAndStyle(context, tintTypedArray);
            if (tintTypedArray.hasValue(15)) {
                str = tintTypedArray.getString(15);
                r6 = 26;
            } else {
                r6 = 26;
                str = null;
            }
            if (r2 >= r6 && tintTypedArray.hasValue(13)) {
                str2 = tintTypedArray.getString(13);
            } else {
                str2 = null;
            }
            tintTypedArray.recycle();
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
        }
        TintTypedArray tintTypedArray2 = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, r12, r27, 0));
        if (!z3 && tintTypedArray2.hasValue(14)) {
            z = tintTypedArray2.getBoolean(14, false);
            z2 = true;
        }
        if (tintTypedArray2.hasValue(15)) {
            str = tintTypedArray2.getString(15);
        }
        if (r2 >= 26 && tintTypedArray2.hasValue(13)) {
            str2 = tintTypedArray2.getString(13);
        }
        String str3 = str2;
        if (r2 >= 28 && tintTypedArray2.hasValue(0) && tintTypedArray2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, tintTypedArray2);
        tintTypedArray2.recycle();
        if (!z3 && z2) {
            textView.setAllCaps(z);
        }
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                textView.setTypeface(typeface, this.mStyle);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str3 != null) {
            textView.setFontVariationSettings(str3);
        }
        if (str != null) {
            textView.setTextLocales(LocaleList.forLanguageTags(str));
        }
        int[] r122 = R$styleable.AppCompatTextView;
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        Context context2 = appCompatTextViewAutoSizeHelper.mContext;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, r122, r27, 0);
        TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), r122, attributeSet, obtainStyledAttributes2, r27);
        if (obtainStyledAttributes2.hasValue(5)) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = obtainStyledAttributes2.getInt(5, 0);
        }
        if (obtainStyledAttributes2.hasValue(4)) {
            f = obtainStyledAttributes2.getDimension(4, -1.0f);
        } else {
            f = -1.0f;
        }
        if (obtainStyledAttributes2.hasValue(2)) {
            f2 = obtainStyledAttributes2.getDimension(2, -1.0f);
        } else {
            f2 = -1.0f;
        }
        if (obtainStyledAttributes2.hasValue(1)) {
            f3 = obtainStyledAttributes2.getDimension(1, -1.0f);
        } else {
            f3 = -1.0f;
        }
        if (obtainStyledAttributes2.hasValue(3) && (resourceId = obtainStyledAttributes2.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes2.getResources().obtainTypedArray(resourceId);
            int length = obtainTypedArray.length();
            int[] r13 = new int[length];
            if (length > 0) {
                for (int r42 = 0; r42 < length; r42++) {
                    r13[r42] = obtainTypedArray.getDimensionPixelSize(r42, -1);
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(r13);
                appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes2.recycle();
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
                if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    if (f2 == -1.0f) {
                        r8 = 2;
                        f2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    } else {
                        r8 = 2;
                    }
                    if (f3 == -1.0f) {
                        f3 = TypedValue.applyDimension(r8, 112.0f, displayMetrics);
                    }
                    if (f == -1.0f) {
                        f = 1.0f;
                    }
                    appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(f2, f3, f);
                }
                appCompatTextViewAutoSizeHelper.setupAutoSizeText();
            }
        } else {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
        }
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0) {
            int[] r1 = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
            if (r1.length > 0) {
                autoSizeStepGranularity = textView.getAutoSizeStepGranularity();
                if (autoSizeStepGranularity != -1.0f) {
                    textView.setAutoSizeTextTypeUniformWithConfiguration(Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx), 0);
                } else {
                    textView.setAutoSizeTextTypeUniformWithPresetSizes(r1, 0);
                }
            }
        }
        TintTypedArray tintTypedArray3 = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, r122));
        int resourceId3 = tintTypedArray3.getResourceId(8, -1);
        if (resourceId3 != -1) {
            drawable = appCompatDrawableManager.getDrawable(context, resourceId3);
        } else {
            drawable = null;
        }
        int resourceId4 = tintTypedArray3.getResourceId(13, -1);
        if (resourceId4 != -1) {
            drawable2 = appCompatDrawableManager.getDrawable(context, resourceId4);
        } else {
            drawable2 = null;
        }
        int resourceId5 = tintTypedArray3.getResourceId(9, -1);
        if (resourceId5 != -1) {
            drawable3 = appCompatDrawableManager.getDrawable(context, resourceId5);
        } else {
            drawable3 = null;
        }
        int resourceId6 = tintTypedArray3.getResourceId(6, -1);
        if (resourceId6 != -1) {
            drawable4 = appCompatDrawableManager.getDrawable(context, resourceId6);
        } else {
            drawable4 = null;
        }
        int resourceId7 = tintTypedArray3.getResourceId(10, -1);
        if (resourceId7 != -1) {
            drawable5 = appCompatDrawableManager.getDrawable(context, resourceId7);
        } else {
            drawable5 = null;
        }
        int resourceId8 = tintTypedArray3.getResourceId(7, -1);
        if (resourceId8 != -1) {
            drawable6 = appCompatDrawableManager.getDrawable(context, resourceId8);
        } else {
            drawable6 = null;
        }
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
                Drawable drawable7 = compoundDrawablesRelative[0];
                if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                    Drawable[] compoundDrawables = textView.getCompoundDrawables();
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                } else {
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative[3];
                    }
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                }
            }
        } else {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative2[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative2[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        }
        if (tintTypedArray3.hasValue(11)) {
            TextViewCompat.Api23Impl.setCompoundDrawableTintList(textView, tintTypedArray3.getColorStateList(11));
        }
        if (tintTypedArray3.hasValue(12)) {
            r4 = -1;
            fontMetricsInt = null;
            TextViewCompat.Api23Impl.setCompoundDrawableTintMode(textView, DrawableUtils.parseTintMode(tintTypedArray3.getInt(12, -1), null));
        } else {
            r4 = -1;
            fontMetricsInt = null;
        }
        int dimensionPixelSize = tintTypedArray3.getDimensionPixelSize(15, r4);
        int dimensionPixelSize2 = tintTypedArray3.getDimensionPixelSize(18, r4);
        int dimensionPixelSize3 = tintTypedArray3.getDimensionPixelSize(19, r4);
        tintTypedArray3.recycle();
        if (dimensionPixelSize != r4) {
            TextViewCompat.setFirstBaselineToTopHeight(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != r4) {
            TextViewCompat.setLastBaselineToBottomHeight(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != r4) {
            Preconditions.checkArgumentNonnegative(dimensionPixelSize3);
            if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(fontMetricsInt)) {
                textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
            }
        }
    }

    public final void onSetTextAppearance(Context context, int r6) {
        String string;
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(r6, R$styleable.TextAppearance));
        boolean hasValue = tintTypedArray.hasValue(14);
        TextView textView = this.mView;
        if (hasValue) {
            textView.setAllCaps(tintTypedArray.getBoolean(14, false));
        }
        int r62 = Build.VERSION.SDK_INT;
        if (tintTypedArray.hasValue(0) && tintTypedArray.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, tintTypedArray);
        if (r62 >= 26 && tintTypedArray.hasValue(13) && (string = tintTypedArray.getString(13)) != null) {
            textView.setFontVariationSettings(string);
        }
        tintTypedArray.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    public final void setAutoSizeTextTypeUniformWithConfiguration(int r3, int r4, int r5, int r6) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r6, r3, displayMetrics), TypedValue.applyDimension(r6, r4, displayMetrics), TypedValue.applyDimension(r6, r5, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] r7, int r8) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = r7.length;
            if (length > 0) {
                int[] r3 = new int[length];
                if (r8 == 0) {
                    r3 = Arrays.copyOf(r7, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int r2 = 0; r2 < length; r2++) {
                        r3[r2] = Math.round(TypedValue.applyDimension(r8, r7[r2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(r3);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r7));
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeWithDefaults(int r5) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            if (r5 != 0) {
                if (r5 == 1) {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                        appCompatTextViewAutoSizeHelper.autoSizeText();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unknown auto-size text type: ", r5));
            }
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
            appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
            appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
        }
    }

    public final void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        Typeface create;
        boolean z;
        boolean z2;
        Typeface create2;
        this.mStyle = tintTypedArray.getInt(2, this.mStyle);
        int r0 = Build.VERSION.SDK_INT;
        boolean z3 = false;
        if (r0 >= 28) {
            int r5 = tintTypedArray.getInt(11, -1);
            this.mFontWeight = r5;
            if (r5 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        int r52 = 10;
        if (!tintTypedArray.hasValue(10) && !tintTypedArray.hasValue(12)) {
            if (tintTypedArray.hasValue(1)) {
                this.mAsyncFontPending = false;
                int r11 = tintTypedArray.getInt(1, 1);
                if (r11 != 1) {
                    if (r11 != 2) {
                        if (r11 == 3) {
                            this.mFontTypeface = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                }
                this.mFontTypeface = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.mFontTypeface = null;
        if (tintTypedArray.hasValue(12)) {
            r52 = 12;
        }
        int r6 = this.mFontWeight;
        int r7 = this.mStyle;
        if (!context.isRestricted()) {
            try {
                Typeface font = tintTypedArray.getFont(r52, this.mStyle, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    public final /* synthetic */ int val$fontWeight;
                    public final /* synthetic */ int val$style;
                    public final /* synthetic */ WeakReference val$textViewWeak;

                    public AnonymousClass1(int r62, int r72, WeakReference weakReference) {
                        r2 = r62;
                        r3 = r72;
                        r4 = weakReference;
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public final void onFontRetrieved(Typeface typeface) {
                        int r1;
                        boolean z4;
                        if (Build.VERSION.SDK_INT >= 28 && (r1 = r2) != -1) {
                            if ((r3 & 2) != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            typeface = Typeface.create(typeface, r1, z4);
                        }
                        AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                        if (appCompatTextHelper.mAsyncFontPending) {
                            appCompatTextHelper.mFontTypeface = typeface;
                            TextView textView = (TextView) r4.get();
                            if (textView != null) {
                                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                if (ViewCompat.Api19Impl.isAttachedToWindow(textView)) {
                                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                                        public final /* synthetic */ int val$style;
                                        public final /* synthetic */ TextView val$textView;
                                        public final /* synthetic */ Typeface val$typeface;

                                        public AnonymousClass2(TextView textView2, Typeface typeface2, int r3) {
                                            r1 = textView2;
                                            r2 = typeface2;
                                            r3 = r3;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            r1.setTypeface(r2, r3);
                                        }
                                    });
                                } else {
                                    textView2.setTypeface(typeface2, appCompatTextHelper.mStyle);
                                }
                            }
                        }
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public final void onFontRetrievalFailed(int r1) {
                    }
                });
                if (font != null) {
                    if (r0 >= 28 && this.mFontWeight != -1) {
                        Typeface create3 = Typeface.create(font, 0);
                        int r02 = this.mFontWeight;
                        if ((this.mStyle & 2) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        create2 = Typeface.create(create3, r02, z2);
                        this.mFontTypeface = create2;
                    } else {
                        this.mFontTypeface = font;
                    }
                }
                if (this.mFontTypeface == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.mAsyncFontPending = z;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface == null && (string = tintTypedArray.getString(r52)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                Typeface create4 = Typeface.create(string, 0);
                int r12 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z3 = true;
                }
                create = Typeface.create(create4, r12, z3);
                this.mFontTypeface = create;
                return;
            }
            this.mFontTypeface = Typeface.create(string, this.mStyle);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatTextHelper$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends ResourcesCompat.FontCallback {
        public final /* synthetic */ int val$fontWeight;
        public final /* synthetic */ int val$style;
        public final /* synthetic */ WeakReference val$textViewWeak;

        public AnonymousClass1(int r62, int r72, WeakReference weakReference) {
            r2 = r62;
            r3 = r72;
            r4 = weakReference;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public final void onFontRetrieved(Typeface typeface2) {
            int r1;
            boolean z4;
            if (Build.VERSION.SDK_INT >= 28 && (r1 = r2) != -1) {
                if ((r3 & 2) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                typeface2 = Typeface.create(typeface2, r1, z4);
            }
            AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
            if (appCompatTextHelper.mAsyncFontPending) {
                appCompatTextHelper.mFontTypeface = typeface2;
                TextView textView2 = (TextView) r4.get();
                if (textView2 != null) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (ViewCompat.Api19Impl.isAttachedToWindow(textView2)) {
                        textView2.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                            public final /* synthetic */ int val$style;
                            public final /* synthetic */ TextView val$textView;
                            public final /* synthetic */ Typeface val$typeface;

                            public AnonymousClass2(TextView textView22, Typeface typeface22, int r3) {
                                r1 = textView22;
                                r2 = typeface22;
                                r3 = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                r1.setTypeface(r2, r3);
                            }
                        });
                    } else {
                        textView22.setTypeface(typeface22, appCompatTextHelper.mStyle);
                    }
                }
            }
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public final void onFontRetrievalFailed(int r1) {
        }
    }
}
