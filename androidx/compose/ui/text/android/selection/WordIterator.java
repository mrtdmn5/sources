package androidx.compose.ui.text.android.selection;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordIterator.kt */
/* loaded from: classes.dex */
public final class WordIterator {
    public final CharSequence charSequence;
    public final int end;
    public final BreakIterator iterator;
    public final int start;

    /* compiled from: WordIterator.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static boolean isPunctuation$ui_text_release(int r1) {
            int type = Character.getType(r1);
            if (type != 23 && type != 20 && type != 22 && type != 30 && type != 29 && type != 24 && type != 21) {
                return false;
            }
            return true;
        }
    }

    public WordIterator(CharSequence charSequence, int r5, Locale locale) {
        boolean z;
        this.charSequence = charSequence;
        if (charSequence.length() >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r5 >= 0 && r5 <= charSequence.length()) {
                BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
                Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
                this.iterator = wordInstance;
                this.start = Math.max(0, -50);
                this.end = Math.min(charSequence.length(), r5 + 50);
                wordInstance.setText(new CharSequenceCharacterIterator(r5, charSequence));
                return;
            }
            throw new IllegalArgumentException("input end index is outside the CharSequence".toString());
        }
        throw new IllegalArgumentException("input start index is outside the CharSequence".toString());
    }

    public final void checkOffsetIsValid(int r6) {
        boolean z = false;
        int r1 = this.start;
        int r2 = this.end;
        if (r6 <= r2 && r1 <= r6) {
            z = true;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(AndroidWindowInsets$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Invalid offset: ", r6, ". Valid range is [", r1, " , "), r2, ']').toString());
        }
    }

    public final boolean isAfterLetterOrDigit(int r5) {
        boolean z;
        int r0 = this.start + 1;
        if (r5 <= this.end && r0 <= r5) {
            z = true;
        } else {
            z = false;
        }
        if (z && Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, r5))) {
            return true;
        }
        return false;
    }

    public final boolean isAfterPunctuation(int r5) {
        boolean z = true;
        int r0 = this.start + 1;
        if (r5 > this.end || r0 > r5) {
            z = false;
        }
        if (!z) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, r5));
    }

    public final boolean isOnLetterOrDigit(int r4) {
        boolean z;
        if (r4 < this.end && this.start <= r4) {
            z = true;
        } else {
            z = false;
        }
        if (z && Character.isLetterOrDigit(Character.codePointAt(this.charSequence, r4))) {
            return true;
        }
        return false;
    }

    public final boolean isOnPunctuation(int r3) {
        boolean z;
        if (r3 < this.end && this.start <= r3) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, r3));
    }
}
