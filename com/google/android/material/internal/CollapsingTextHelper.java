package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.animaconnected.secondo.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TypefaceUtils;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class CollapsingTextHelper {
    public boolean boundsChanged;
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public float collapsedLetterSpacing;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public ColorStateList collapsedTextColor;
    public float collapsedTextWidth;
    public Typeface collapsedTypeface;
    public Typeface collapsedTypefaceBold;
    public Typeface collapsedTypefaceDefault;
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public float currentLetterSpacing;
    public float currentShadowDx;
    public float currentShadowDy;
    public float currentShadowRadius;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFraction;
    public float expandedLetterSpacing;
    public ColorStateList expandedTextColor;
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public Typeface expandedTypefaceBold;
    public Typeface expandedTypefaceDefault;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public StaticLayout textLayout;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public final TextPaint tmpPaint;
    public final View view;
    public int expandedTextGravity = 16;
    public int collapsedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public float collapsedTextSize = 15.0f;

    /* renamed from: com.google.android.material.internal.CollapsingTextHelper$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements CancelableFontCallback.ApplyFont {
        public AnonymousClass1() {
        }
    }

    public CollapsingTextHelper(View view) {
        this.view = view;
        TextPaint textPaint = new TextPaint(R.styleable.AppTheme_statusTopStripeImportant);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        maybeUpdateFontWeightAdjustment(view.getContext().getResources().getConfiguration());
    }

    public static int blendARGB(int r5, float f, int r7) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(r7) * f) + (Color.alpha(r5) * f2)), Math.round((Color.red(r7) * f) + (Color.red(r5) * f2)), Math.round((Color.green(r7) * f) + (Color.green(r5) * f2)), Math.round((Color.blue(r7) * f) + (Color.blue(r5) * f2)));
    }

    public static float lerp(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        return DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f2, f, f3, f);
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean z = true;
        if (ViewCompat.Api17Impl.getLayoutDirection(this.view) != 1) {
            z = false;
        }
        if (z) {
            textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicInternal.isRtl(charSequence.length(), charSequence);
    }

    public final void calculateUsingTextSize(float f, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        float f2;
        float f3;
        boolean z5;
        StaticLayout staticLayout;
        boolean z6;
        boolean z7;
        if (this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f2 = this.collapsedTextSize;
            f3 = this.collapsedLetterSpacing;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.expandedTextSize;
            float f5 = this.expandedLetterSpacing;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z3 = true;
            } else {
                z3 = false;
            }
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this.scale = 1.0f;
            } else {
                this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
            }
            float f6 = this.collapsedTextSize / this.expandedTextSize;
            float f7 = width2 * f6;
            if (!z && f7 > width) {
                width = Math.min(width / f6, width2);
            } else {
                width = width2;
            }
            f2 = f4;
            f3 = f5;
        }
        if (width > 0.0f) {
            if (this.currentTextSize != f2) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.currentLetterSpacing != f3) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z6 && !z7 && !this.boundsChanged && !z3) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.currentTextSize = f2;
            this.currentLetterSpacing = f3;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z3) {
            float f8 = this.currentTextSize;
            TextPaint textPaint = this.textPaint;
            textPaint.setTextSize(f8);
            textPaint.setTypeface(this.currentTypeface);
            textPaint.setLetterSpacing(this.currentLetterSpacing);
            if (this.scale != 1.0f) {
                z5 = true;
            } else {
                z5 = false;
            }
            textPaint.setLinearText(z5);
            boolean calculateIsRtl = calculateIsRtl(this.text);
            this.isRtl = calculateIsRtl;
            try {
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.text, textPaint, (int) width);
                staticLayoutBuilderCompat.ellipsize = TextUtils.TruncateAt.END;
                staticLayoutBuilderCompat.isRtl = calculateIsRtl;
                staticLayoutBuilderCompat.alignment = alignment;
                staticLayoutBuilderCompat.includePad = false;
                staticLayoutBuilderCompat.maxLines = 1;
                staticLayoutBuilderCompat.lineSpacingAdd = 0.0f;
                staticLayoutBuilderCompat.lineSpacingMultiplier = 1.0f;
                staticLayoutBuilderCompat.hyphenationFrequency = 1;
                staticLayout = staticLayoutBuilderCompat.build();
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
                Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
                staticLayout = null;
            }
            staticLayout.getClass();
            this.textLayout = staticLayout;
            this.textToDraw = staticLayout.getText();
        }
    }

    public final float getCollapsedTextHeight() {
        TextPaint textPaint = this.tmpPaint;
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
        return -textPaint.ascent();
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] r1 = this.state;
        if (r1 != null) {
            return colorStateList.getColorForState(r1, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final void maybeUpdateFontWeightAdjustment(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    public final void onBoundsChanged() {
        boolean z;
        Rect rect = this.collapsedBounds;
        if (rect.width() > 0 && rect.height() > 0) {
            Rect rect2 = this.expandedBounds;
            if (rect2.width() > 0 && rect2.height() > 0) {
                z = true;
                this.drawTitle = z;
            }
        }
        z = false;
        this.drawTitle = z;
    }

    public final void recalculate(boolean z) {
        float f;
        StaticLayout staticLayout;
        View view = this.view;
        if ((view.getHeight() > 0 && view.getWidth() > 0) || z) {
            calculateUsingTextSize(1.0f, z);
            CharSequence charSequence = this.textToDraw;
            TextPaint textPaint = this.textPaint;
            if (charSequence != null && (staticLayout = this.textLayout) != null) {
                this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.textToDrawCollapsed;
            float f2 = 0.0f;
            if (charSequence2 != null) {
                this.collapsedTextWidth = textPaint.measureText(charSequence2, 0, charSequence2.length());
            } else {
                this.collapsedTextWidth = 0.0f;
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
            int r6 = absoluteGravity & 112;
            Rect rect = this.collapsedBounds;
            if (r6 != 48) {
                if (r6 != 80) {
                    this.collapsedDrawY = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
                } else {
                    this.collapsedDrawY = textPaint.ascent() + rect.bottom;
                }
            } else {
                this.collapsedDrawY = rect.top;
            }
            int r2 = absoluteGravity & 8388615;
            if (r2 != 1) {
                if (r2 != 5) {
                    this.collapsedDrawX = rect.left;
                } else {
                    this.collapsedDrawX = rect.right - this.collapsedTextWidth;
                }
            } else {
                this.collapsedDrawX = rect.centerX() - (this.collapsedTextWidth / 2.0f);
            }
            calculateUsingTextSize(0.0f, z);
            StaticLayout staticLayout2 = this.textLayout;
            if (staticLayout2 != null) {
                f = staticLayout2.getHeight();
            } else {
                f = 0.0f;
            }
            CharSequence charSequence3 = this.textToDraw;
            if (charSequence3 != null) {
                f2 = textPaint.measureText(charSequence3, 0, charSequence3.length());
            }
            StaticLayout staticLayout3 = this.textLayout;
            if (staticLayout3 != null) {
                staticLayout3.getLineCount();
            }
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            int r4 = absoluteGravity2 & 112;
            Rect rect2 = this.expandedBounds;
            if (r4 != 48) {
                if (r4 != 80) {
                    this.expandedDrawY = rect2.centerY() - (f / 2.0f);
                } else {
                    this.expandedDrawY = textPaint.descent() + (rect2.bottom - f);
                }
            } else {
                this.expandedDrawY = rect2.top;
            }
            int r15 = absoluteGravity2 & 8388615;
            if (r15 != 1) {
                if (r15 != 5) {
                    this.expandedDrawX = rect2.left;
                } else {
                    this.expandedDrawX = rect2.right - f2;
                }
            } else {
                this.expandedDrawX = rect2.centerX() - (f2 / 2.0f);
            }
            Bitmap bitmap = this.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.expandedTitleTexture = null;
            }
            setInterpolatedTextSize(this.expandedFraction);
            float f3 = this.expandedFraction;
            float lerp = lerp(rect2.left, rect.left, f3, this.positionInterpolator);
            RectF rectF = this.currentBounds;
            rectF.left = lerp;
            rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f3, this.positionInterpolator);
            rectF.right = lerp(rect2.right, rect.right, f3, this.positionInterpolator);
            rectF.bottom = lerp(rect2.bottom, rect.bottom, f3, this.positionInterpolator);
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f3, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f3, this.positionInterpolator);
            setInterpolatedTextSize(f3);
            FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            lerp(0.0f, 1.0f, 1.0f - f3, fastOutSlowInInterpolator);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
            lerp(1.0f, 0.0f, f3, fastOutSlowInInterpolator);
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
            ColorStateList colorStateList = this.collapsedTextColor;
            ColorStateList colorStateList2 = this.expandedTextColor;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(blendARGB(getCurrentColor(colorStateList2), f3, getCurrentColor(this.collapsedTextColor)));
            } else {
                textPaint.setColor(getCurrentColor(colorStateList));
            }
            float f4 = this.collapsedLetterSpacing;
            float f5 = this.expandedLetterSpacing;
            if (f4 != f5) {
                textPaint.setLetterSpacing(lerp(f5, f4, f3, fastOutSlowInInterpolator));
            } else {
                textPaint.setLetterSpacing(f4);
            }
            this.currentShadowRadius = lerp(0.0f, this.collapsedShadowRadius, f3, null);
            this.currentShadowDx = lerp(0.0f, this.collapsedShadowDx, f3, null);
            this.currentShadowDy = lerp(0.0f, this.collapsedShadowDy, f3, null);
            textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB(getCurrentColor(null), f3, getCurrentColor(this.collapsedShadowColor)));
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
        }
    }

    public final void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public final boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypefaceDefault != typeface) {
            this.collapsedTypefaceDefault = typeface;
            Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
            this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
            if (maybeCopyWithFontWeightAdjustment == null) {
                maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
            return true;
        }
        return false;
    }

    public final void setExpansionFraction(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.expandedFraction) {
            this.expandedFraction = f;
            float f2 = this.expandedBounds.left;
            Rect rect = this.collapsedBounds;
            float lerp = lerp(f2, rect.left, f, this.positionInterpolator);
            RectF rectF = this.currentBounds;
            rectF.left = lerp;
            rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
            rectF.right = lerp(r1.right, rect.right, f, this.positionInterpolator);
            rectF.bottom = lerp(r1.bottom, rect.bottom, f, this.positionInterpolator);
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
            setInterpolatedTextSize(f);
            FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            lerp(0.0f, 1.0f, 1.0f - f, fastOutSlowInInterpolator);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            View view = this.view;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
            lerp(1.0f, 0.0f, f, fastOutSlowInInterpolator);
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
            ColorStateList colorStateList = this.collapsedTextColor;
            ColorStateList colorStateList2 = this.expandedTextColor;
            TextPaint textPaint = this.textPaint;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(blendARGB(getCurrentColor(colorStateList2), f, getCurrentColor(this.collapsedTextColor)));
            } else {
                textPaint.setColor(getCurrentColor(colorStateList));
            }
            float f3 = this.collapsedLetterSpacing;
            float f4 = this.expandedLetterSpacing;
            if (f3 != f4) {
                textPaint.setLetterSpacing(lerp(f4, f3, f, fastOutSlowInInterpolator));
            } else {
                textPaint.setLetterSpacing(f3);
            }
            this.currentShadowRadius = lerp(0.0f, this.collapsedShadowRadius, f, null);
            this.currentShadowDx = lerp(0.0f, this.collapsedShadowDx, f, null);
            this.currentShadowDy = lerp(0.0f, this.collapsedShadowDy, f, null);
            textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB(getCurrentColor(null), f, getCurrentColor(this.collapsedShadowColor)));
            ViewCompat.Api16Impl.postInvalidateOnAnimation(view);
        }
    }

    public final void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f, false);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.postInvalidateOnAnimation(this.view);
    }

    public final void setTypefaces(Typeface typeface) {
        boolean z;
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        if (this.expandedTypefaceDefault != typeface) {
            this.expandedTypefaceDefault = typeface;
            Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
            this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
            if (maybeCopyWithFontWeightAdjustment == null) {
                maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
            z = true;
        } else {
            z = false;
        }
        if (collapsedTypefaceInternal || z) {
            recalculate(false);
        }
    }
}
