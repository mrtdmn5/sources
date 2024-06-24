package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$WordTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static AccessibilityIterators$WordTextSegmentIterator instance;
    public BreakIterator impl;

    public AccessibilityIterators$WordTextSegmentIterator(Locale locale) {
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
        this.impl = wordInstance;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] following(int r6) {
        boolean z;
        if (getText().length() <= 0 || r6 >= getText().length()) {
            return null;
        }
        if (r6 < 0) {
            r6 = 0;
        }
        while (!isLetterOrDigit(r6)) {
            if (isLetterOrDigit(r6) && (r6 == 0 || !isLetterOrDigit(r6 - 1))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                r6 = breakIterator.following(r6);
                if (r6 == -1) {
                    return null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                throw null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 != null) {
            int following = breakIterator2.following(r6);
            if (following == -1 || !isEndBoundary(following)) {
                return null;
            }
            return getRange(r6, following);
        }
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        throw null;
    }

    public final void initialize(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        BreakIterator breakIterator = this.impl;
        if (breakIterator != null) {
            breakIterator.setText(text);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            throw null;
        }
    }

    public final boolean isEndBoundary(int r2) {
        if (r2 > 0 && isLetterOrDigit(r2 - 1) && (r2 == getText().length() || !isLetterOrDigit(r2))) {
            return true;
        }
        return false;
    }

    public final boolean isLetterOrDigit(int r2) {
        if (r2 >= 0 && r2 < getText().length()) {
            return Character.isLetterOrDigit(getText().codePointAt(r2));
        }
        return false;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] preceding(int r5) {
        boolean z;
        int length = getText().length();
        if (length <= 0 || r5 <= 0) {
            return null;
        }
        if (r5 > length) {
            r5 = length;
        }
        while (r5 > 0 && !isLetterOrDigit(r5 - 1) && !isEndBoundary(r5)) {
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                r5 = breakIterator.preceding(r5);
                if (r5 == -1) {
                    return null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                throw null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 != null) {
            int preceding = breakIterator2.preceding(r5);
            if (preceding != -1) {
                if (isLetterOrDigit(preceding) && (preceding == 0 || !isLetterOrDigit(preceding - 1))) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return getRange(preceding, r5);
                }
            }
            return null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        throw null;
    }
}
