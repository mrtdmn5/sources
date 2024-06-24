package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class UnprecomputeTextOnModificationSpannable implements Spannable {
    public Spannable mDelegate;
    public boolean mSafeToWrite = false;

    /* loaded from: classes.dex */
    public static class PrecomputedTextDetector {
        public boolean isPrecomputedText(Spannable spannable) {
            return spannable instanceof PrecomputedTextCompat;
        }
    }

    /* loaded from: classes.dex */
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        public final boolean isPrecomputedText(Spannable spannable) {
            if (!UnprecomputeTextOnModificationSpannable$PrecomputedTextDetector_28$$ExternalSyntheticApiModelOutline0.m(spannable) && !(spannable instanceof PrecomputedTextCompat)) {
                return false;
            }
            return true;
        }
    }

    public UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.mDelegate = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r2) {
        return this.mDelegate.charAt(r2);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.mDelegate.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.mDelegate.codePoints();
    }

    public final void ensureSafeWrites() {
        PrecomputedTextDetector precomputedTextDetector_28;
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite) {
            if (Build.VERSION.SDK_INT < 28) {
                precomputedTextDetector_28 = new PrecomputedTextDetector();
            } else {
                precomputedTextDetector_28 = new PrecomputedTextDetector_28();
            }
            if (precomputedTextDetector_28.isPrecomputedText(spannable)) {
                this.mDelegate = new SpannableString(spannable);
            }
        }
        this.mSafeToWrite = true;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int r2, int r3, Class<T> cls) {
        return (T[]) this.mDelegate.getSpans(r2, r3, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int r2, int r3, Class cls) {
        return this.mDelegate.nextSpanTransition(r2, r3, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int r3, int r4, int r5) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, r3, r4, r5);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r2, int r3) {
        return this.mDelegate.subSequence(r2, r3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.mDelegate.toString();
    }

    public UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }
}
