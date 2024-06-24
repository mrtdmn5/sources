package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public EmojiCompatInitCallback mEmojiCompatInitCallback;
    public boolean mHasThumbTint;
    public boolean mHasThumbTintMode;
    public boolean mHasTrackTint;
    public boolean mHasTrackTintMode;
    public final int mMinFlingVelocity;
    public StaticLayout mOffLayout;
    public StaticLayout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    public boolean mShowText;
    public boolean mSplitTrack;
    public int mSwitchBottom;
    public int mSwitchHeight;
    public int mSwitchLeft;
    public int mSwitchMinWidth;
    public int mSwitchPadding;
    public int mSwitchRight;
    public int mSwitchTop;
    public AllCapsTransformationMethod mSwitchTransformationMethod;
    public int mSwitchWidth;
    public final Rect mTempRect;
    public ColorStateList mTextColors;
    public CharSequence mTextOff;
    public CharSequence mTextOffTransformed;
    public CharSequence mTextOn;
    public CharSequence mTextOnTransformed;
    public final TextPaint mTextPaint;
    public Drawable mThumbDrawable;
    public float mThumbPosition;
    public int mThumbTextPadding;
    public ColorStateList mThumbTintList;
    public PorterDuff.Mode mThumbTintMode;
    public int mThumbWidth;
    public int mTouchMode;
    public final int mTouchSlop;
    public float mTouchX;
    public float mTouchY;
    public Drawable mTrackDrawable;
    public ColorStateList mTrackTintList;
    public PorterDuff.Mode mTrackTintMode;
    public final VelocityTracker mVelocityTracker;
    public static final AnonymousClass1 THUMB_POS = new Property<SwitchCompat, Float>() { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        public final Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        @Override // android.util.Property
        public final void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    /* loaded from: classes.dex */
    public static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {
        public final WeakReference mOuterWeakRef;

        public EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.mOuterWeakRef = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onFailed() {
            SwitchCompat switchCompat = (SwitchCompat) this.mOuterWeakRef.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            SwitchCompat switchCompat = (SwitchCompat) this.mOuterWeakRef.get();
            if (switchCompat != null) {
                switchCompat.onEmojiCompatInitializedForSwitchText();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.kronaby.watch.app.R.attr.switchStyle);
        Typeface typeface;
        Typeface create;
        int r7;
        int resourceId;
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] r8 = R$styleable.SwitchCompat;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r8, com.kronaby.watch.app.R.attr.switchStyle, 0);
        TintTypedArray tintTypedArray = new TintTypedArray(context, obtainStyledAttributes);
        ViewCompat.saveAttributeDataForStyleable(this, context, r8, attributeSet, obtainStyledAttributes, com.kronaby.watch.app.R.attr.switchStyle);
        Drawable drawable = tintTypedArray.getDrawable(2);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = tintTypedArray.getDrawable(11);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        setTextOnInternal(tintTypedArray.getText(0));
        setTextOffInternal(tintTypedArray.getText(1));
        this.mShowText = tintTypedArray.getBoolean(3, true);
        this.mThumbTextPadding = tintTypedArray.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = tintTypedArray.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = tintTypedArray.getDimensionPixelSize(6, 0);
        this.mSplitTrack = tintTypedArray.getBoolean(4, false);
        ColorStateList colorStateList = tintTypedArray.getColorStateList(9);
        if (colorStateList != null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(tintTypedArray.getInt(10, -1), null);
        if (this.mThumbTintMode != parseTintMode) {
            this.mThumbTintMode = parseTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateList2 = tintTypedArray.getColorStateList(12);
        if (colorStateList2 != null) {
            this.mTrackTintList = colorStateList2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(tintTypedArray.getInt(13, -1), null);
        if (this.mTrackTintMode != parseTintMode2) {
            this.mTrackTintMode = parseTintMode2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId2 = tintTypedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId2, R$styleable.TextAppearance);
            ColorStateList colorStateList3 = (!obtainStyledAttributes2.hasValue(3) || (resourceId = obtainStyledAttributes2.getResourceId(3, 0)) == 0 || (colorStateList3 = AppCompatResources.getColorStateList(context, resourceId)) == null) ? obtainStyledAttributes2.getColorStateList(3) : colorStateList3;
            if (colorStateList3 != null) {
                this.mTextColors = colorStateList3;
            } else {
                this.mTextColors = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int r10 = obtainStyledAttributes2.getInt(1, -1);
            int r9 = obtainStyledAttributes2.getInt(2, -1);
            if (r10 != 1) {
                if (r10 != 2) {
                    if (r10 != 3) {
                        typeface = null;
                    } else {
                        typeface = Typeface.MONOSPACE;
                    }
                } else {
                    typeface = Typeface.SERIF;
                }
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            if (r9 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(r9);
                } else {
                    create = Typeface.create(typeface, r9);
                }
                setSwitchTypeface(create);
                if (create != null) {
                    r7 = create.getStyle();
                } else {
                    r7 = 0;
                }
                int r72 = (~r7) & r9;
                textPaint.setFakeBoldText((r72 & 1) != 0);
                textPaint.setTextSkewX((r72 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes2.getBoolean(14, false)) {
                this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
            } else {
                this.mSwitchTransformationMethod = null;
            }
            setTextOnInternal(this.mTextOn);
            setTextOffInternal(this.mTextOff);
            obtainStyledAttributes2.recycle();
        }
        new AppCompatTextHelper(this).loadFromAttributes(attributeSet, com.kronaby.watch.app.R.attr.switchStyle);
        tintTypedArray.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, com.kronaby.watch.app.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.mThumbPosition;
        } else {
            f = this.mThumbPosition;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            Rect rect2 = this.mTempRect;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.mThumbDrawable;
            if (drawable2 != null) {
                rect = DrawableUtils.getOpticalBounds(drawable2);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.mTextOff = charSequence;
        AppCompatEmojiTextHelper emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod wrapTransformationMethod = emojiTextViewHelper.mEmojiTextViewHelper.mHelper.wrapTransformationMethod(this.mSwitchTransformationMethod);
        if (wrapTransformationMethod != null) {
            charSequence = wrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.mTextOffTransformed = charSequence;
        this.mOffLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.mTextOn = charSequence;
        AppCompatEmojiTextHelper emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod wrapTransformationMethod = emojiTextViewHelper.mEmojiTextViewHelper.mHelper.wrapTransformationMethod(this.mSwitchTransformationMethod);
        if (wrapTransformationMethod != null) {
            charSequence = wrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.mTextOnTransformed = charSequence;
        this.mOnLayout = null;
        if (this.mShowText) {
            setupEmojiCompatLoadCallback();
        }
    }

    public final void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                Drawable mutate = drawable.mutate();
                this.mThumbDrawable = mutate;
                if (this.mHasThumbTint) {
                    DrawableCompat$Api21Impl.setTintList(mutate, this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
                }
                if (this.mThumbDrawable.isStateful()) {
                    this.mThumbDrawable.setState(getDrawableState());
                }
            }
        }
    }

    public final void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            if (this.mHasTrackTint || this.mHasTrackTintMode) {
                Drawable mutate = drawable.mutate();
                this.mTrackDrawable = mutate;
                if (this.mHasTrackTint) {
                    DrawableCompat$Api21Impl.setTintList(mutate, this.mTrackTintList);
                }
                if (this.mHasTrackTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
                }
                if (this.mTrackDrawable.isStateful()) {
                    this.mTrackDrawable.setState(getDrawableState());
                }
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect;
        int r6;
        int r5;
        int r0 = this.mSwitchLeft;
        int r1 = this.mSwitchTop;
        int r2 = this.mSwitchRight;
        int r3 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + r0;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        Rect rect2 = this.mTempRect;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int r62 = rect2.left;
            thumbOffset += r62;
            if (rect != null) {
                int r8 = rect.left;
                if (r8 > r62) {
                    r0 += r8 - r62;
                }
                int r63 = rect.top;
                int r82 = rect2.top;
                if (r63 > r82) {
                    r6 = (r63 - r82) + r1;
                } else {
                    r6 = r1;
                }
                int r83 = rect.right;
                int r9 = rect2.right;
                if (r83 > r9) {
                    r2 -= r83 - r9;
                }
                int r52 = rect.bottom;
                int r84 = rect2.bottom;
                if (r52 > r84) {
                    r5 = r3 - (r52 - r84);
                    this.mTrackDrawable.setBounds(r0, r6, r2, r5);
                }
            } else {
                r6 = r1;
            }
            r5 = r3;
            this.mTrackDrawable.setBounds(r0, r6, r2, r5);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int r02 = thumbOffset - rect2.left;
            int r4 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(r02, r1, r4, r3);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat$Api21Impl.setHotspotBounds(background, r02, r1, r4, r3);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setHotspot(drawable, f, f2);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            DrawableCompat$Api21Impl.setHotspot(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.mSwitchPadding;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    public final StaticLayout makeLayout(CharSequence charSequence) {
        int r0;
        TextPaint textPaint = this.mTextPaint;
        if (charSequence != null) {
            r0 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
        } else {
            r0 = 0;
        }
        return new StaticLayout(charSequence, textPaint, r0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(r2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.mTrackDrawable;
        Rect rect = this.mTempRect;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchBottom;
        int r22 = r2 + rect.top;
        int r32 = r3 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mSplitTrack && drawable2 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            staticLayout = this.mOnLayout;
        } else {
            staticLayout = this.mOffLayout;
        }
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            TextPaint textPaint = this.mTextPaint;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((r22 + r32) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public final void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.mTextOn;
            } else {
                charSequence = this.mTextOff;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int r3, int r4, int r5, int r6) {
        int r52;
        int width;
        int r2;
        int r53;
        int r32;
        super.onLayout(z, r3, r4, r5, r6);
        int r33 = 0;
        if (this.mThumbDrawable != null) {
            Drawable drawable = this.mTrackDrawable;
            Rect rect = this.mTempRect;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            r52 = Math.max(0, opticalBounds.left - rect.left);
            r33 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            r52 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            r2 = getPaddingLeft() + r52;
            width = ((this.mSwitchWidth + r2) - r52) - r33;
        } else {
            width = (getWidth() - getPaddingRight()) - r33;
            r2 = (width - this.mSwitchWidth) + r52 + r33;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                r32 = getPaddingTop();
                r53 = this.mSwitchHeight + r32;
            } else {
                r53 = getHeight() - getPaddingBottom();
                r32 = r53 - this.mSwitchHeight;
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int r34 = this.mSwitchHeight;
            int r54 = height - (r34 / 2);
            r53 = r34 + r54;
            r32 = r54;
        }
        this.mSwitchLeft = r2;
        this.mSwitchTop = r32;
        this.mSwitchBottom = r53;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0;
        int r3;
        int r5;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOnTransformed);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOffTransformed);
            }
        }
        Drawable drawable = this.mThumbDrawable;
        int r1 = 0;
        Rect rect = this.mTempRect;
        if (drawable != null) {
            drawable.getPadding(rect);
            r0 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            r3 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            r0 = 0;
            r3 = 0;
        }
        if (this.mShowText) {
            r5 = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
        } else {
            r5 = 0;
        }
        this.mThumbWidth = Math.max(r5, r0);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            r1 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int r02 = rect.left;
        int r2 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            r02 = Math.max(r02, opticalBounds.left);
            r2 = Math.max(r2, opticalBounds.right);
        }
        int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + r02 + r2);
        int max2 = Math.max(r1, r3);
        this.mSwitchWidth = max;
        this.mSwitchHeight = max2;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.mTextOn;
        } else {
            charSequence = this.mTextOff;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:            if (r1 != 3) goto L84;     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.mTextOn;
                if (obj == null) {
                    obj = getResources().getString(com.kronaby.watch.app.R.string.abc_capital_on);
                }
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                new ViewCompat.AnonymousClass3().set(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj2 = this.mTextOff;
            if (obj2 == null) {
                obj2 = getResources().getString(com.kronaby.watch.app.R.string.abc_capital_off);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            new ViewCompat.AnonymousClass3().set(this, obj2);
        }
        float f = 1.0f;
        if (getWindowToken() != null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isLaidOut(this)) {
                if (!isChecked) {
                    f = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, f);
                this.mPositionAnimator = ofFloat;
                ofFloat.setDuration(250L);
                this.mPositionAnimator.setAutoCancel(true);
                this.mPositionAnimator.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (!isChecked) {
            f = 0.0f;
        }
        setThumbPosition(f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().getFilters(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.mShowText != z) {
            this.mShowText = z;
            requestLayout();
            if (z) {
                setupEmojiCompatLoadCallback();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.mSplitTrack = z;
        invalidate();
    }

    public void setSwitchMinWidth(int r1) {
        this.mSwitchMinWidth = r1;
        requestLayout();
    }

    public void setSwitchPadding(int r1) {
        this.mSwitchPadding = r1;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.mTextPaint;
        if ((textPaint.getTypeface() != null && !textPaint.getTypeface().equals(typeface)) || (textPaint.getTypeface() == null && typeface != null)) {
            textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.mTextOff;
            if (obj == null) {
                obj = getResources().getString(com.kronaby.watch.app.R.string.abc_capital_off);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            new ViewCompat.AnonymousClass3().set(this, obj);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.mTextOn;
            if (obj == null) {
                obj = getResources().getString(com.kronaby.watch.app.R.string.abc_capital_on);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            new ViewCompat.AnonymousClass3().set(this, obj);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.mThumbPosition = f;
        invalidate();
    }

    public void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setThumbTextPadding(int r1) {
        this.mThumbTextPadding = r1;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public final void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null && this.mAppCompatEmojiTextHelper.mEmojiTextViewHelper.mHelper.isEnabled() && EmojiCompat.isConfigured()) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            int loadState = emojiCompat.getLoadState();
            if (loadState == 3 || loadState == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.mEmojiCompatInitCallback = emojiCompatInitCallback;
                emojiCompat.registerInitCallback(emojiCompatInitCallback);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
            return false;
        }
        return true;
    }
}
