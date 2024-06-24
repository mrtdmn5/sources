package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class PrecomputedTextCompat implements Spannable {
    @Override // java.lang.CharSequence
    public final char charAt(int r1) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int r4, int r5, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            PrecomputedTextCompat$$ExternalSyntheticApiModelOutline2.m(r4, r5, cls);
            throw null;
        }
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int r1, int r2, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                PrecomputedTextCompat$$ExternalSyntheticApiModelOutline0.m(obj);
                throw null;
            }
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int r5, int r6, int r7) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                PrecomputedTextCompat$$ExternalSyntheticApiModelOutline1.m(obj, r5, r6, r7);
                throw null;
            }
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r1, int r2) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        throw null;
    }

    /* loaded from: classes.dex */
    public static final class Params {
        public final int mBreakStrategy;
        public final int mHyphenationFrequency;
        public final TextPaint mPaint;
        public final TextDirectionHeuristic mTextDir;

        public Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int r5, int r6) {
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            if (Build.VERSION.SDK_INT >= 29) {
                breakStrategy = PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline9.m(textPaint).setBreakStrategy(r5);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(r6);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                textDirection.build();
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = r5;
            this.mHyphenationFrequency = r6;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (equalsWithoutTextDirection(params) && this.mTextDir == params.mTextDir) {
                return true;
            }
            return false;
        }

        public final boolean equalsWithoutTextDirection(Params params) {
            if (this.mBreakStrategy != params.mBreakStrategy || this.mHyphenationFrequency != params.mHyphenationFrequency) {
                return false;
            }
            TextPaint textPaint = this.mPaint;
            if (textPaint.getTextSize() != params.mPaint.getTextSize()) {
                return false;
            }
            float textScaleX = textPaint.getTextScaleX();
            TextPaint textPaint2 = params.mPaint;
            if (textScaleX != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags() || !textPaint.getTextLocales().equals(textPaint2.getTextLocales())) {
                return false;
            }
            if (textPaint.getTypeface() == null) {
                if (textPaint2.getTypeface() != null) {
                    return false;
                }
                return true;
            }
            if (!textPaint.getTypeface().equals(textPaint2.getTypeface())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            TextPaint textPaint = this.mPaint;
            return ObjectsCompat$Api19Impl.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
        }

        public final String toString() {
            String fontVariationSettings;
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder("textSize=");
            TextPaint textPaint = this.mPaint;
            sb2.append(textPaint.getTextSize());
            sb.append(sb2.toString());
            sb.append(", textScaleX=" + textPaint.getTextScaleX());
            sb.append(", textSkewX=" + textPaint.getTextSkewX());
            int r1 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
            sb.append(", textLocale=" + textPaint.getTextLocales());
            sb.append(", typeface=" + textPaint.getTypeface());
            if (r1 >= 26) {
                StringBuilder sb3 = new StringBuilder(", variationSettings=");
                fontVariationSettings = textPaint.getFontVariationSettings();
                sb3.append(fontVariationSettings);
                sb.append(sb3.toString());
            }
            sb.append(", textDir=" + this.mTextDir);
            sb.append(", breakStrategy=" + this.mBreakStrategy);
            sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb.append("}");
            return sb.toString();
        }

        public Params(PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.mPaint = textPaint;
            textDirection = params.getTextDirection();
            this.mTextDir = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.mBreakStrategy = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.mHyphenationFrequency = hyphenationFrequency;
        }
    }
}
