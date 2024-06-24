package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class EditorInfoCompat {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence) {
            editorInfo.setInitialSurroundingSubText(charSequence, 0);
        }
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        int r2;
        int r0;
        boolean z;
        int r4;
        CharSequence subSequence;
        int r02 = Build.VERSION.SDK_INT;
        if (r02 >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence);
            return;
        }
        charSequence.getClass();
        if (r02 >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence);
            return;
        }
        int r03 = editorInfo.initialSelStart;
        int r1 = editorInfo.initialSelEnd;
        if (r03 > r1) {
            r2 = r1 + 0;
        } else {
            r2 = r03 + 0;
        }
        if (r03 > r1) {
            r0 = r03 - 0;
        } else {
            r0 = r1 + 0;
        }
        int length = charSequence.length();
        if (r2 >= 0 && r0 <= length) {
            int r5 = editorInfo.inputType & 4095;
            if (r5 != 129 && r5 != 225 && r5 != 18) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                setSurroundingText(editorInfo, null, 0, 0);
                return;
            }
            if (length <= 2048) {
                setSurroundingText(editorInfo, charSequence, r2, r0);
                return;
            }
            int r12 = r0 - r2;
            if (r12 > 1024) {
                r4 = 0;
            } else {
                r4 = r12;
            }
            int r6 = 2048 - r4;
            int min = Math.min(charSequence.length() - r0, r6 - Math.min(r2, (int) (r6 * 0.8d)));
            int min2 = Math.min(r2, r6 - min);
            int r22 = r2 - min2;
            if (Character.isLowSurrogate(charSequence.charAt(r22))) {
                r22++;
                min2--;
            }
            if (Character.isHighSurrogate(charSequence.charAt((r0 + min) - 1))) {
                min--;
            }
            int r8 = min2 + r4 + min;
            if (r4 != r12) {
                subSequence = TextUtils.concat(charSequence.subSequence(r22, r22 + min2), charSequence.subSequence(r0, min + r0));
            } else {
                subSequence = charSequence.subSequence(r22, r8 + r22);
            }
            int r62 = min2 + 0;
            setSurroundingText(editorInfo, subSequence, r62, r4 + r62);
            return;
        }
        setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int r4, int r5) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", r4);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", r5);
    }
}
