package kotlin.text;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import kotlin.ranges.IntRange;

/* compiled from: Char.kt */
/* loaded from: classes.dex */
public class CharsKt__CharKt {
    public static final void checkRadix(int r5) {
        if (new IntRange(2, 36).contains(r5)) {
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("radix ", r5, " was not in valid range ");
        m.append(new IntRange(2, 36));
        throw new IllegalArgumentException(m.toString());
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static final boolean isWhitespace(char c) {
        if (!Character.isWhitespace(c) && !Character.isSpaceChar(c)) {
            return false;
        }
        return true;
    }
}
