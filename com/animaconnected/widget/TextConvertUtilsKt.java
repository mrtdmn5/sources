package com.animaconnected.widget;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextConvertUtils.kt */
/* loaded from: classes3.dex */
public final class TextConvertUtilsKt {
    public static final AnnotatedString toAnnotatedText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) valueOf.getSpans(0, valueOf.length(), CharacterStyle.class);
        AnnotatedString.Builder builder = new AnnotatedString.Builder();
        String text = charSequence.toString();
        Intrinsics.checkNotNullParameter(text, "text");
        builder.text.append(text);
        Intrinsics.checkNotNull(characterStyleArr);
        for (CharacterStyle characterStyle : characterStyleArr) {
            int spanStart = valueOf.getSpanStart(characterStyle);
            int spanEnd = valueOf.getSpanEnd(characterStyle);
            if (characterStyle instanceof UnderlineSpan) {
                builder.addStyle(new SpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.Underline, null, 61439), spanStart, spanEnd);
            } else {
                boolean z = characterStyle instanceof StyleSpan;
                if (z && ((StyleSpan) characterStyle).getStyle() == 1) {
                    builder.addStyle(new SpanStyle(0L, 0L, FontWeight.Bold, null, null, null, null, 0L, null, null, null, 0L, null, null, 65531), spanStart, spanEnd);
                } else if (z && ((StyleSpan) characterStyle).getStyle() == 2) {
                    builder.addStyle(new SpanStyle(0L, 0L, null, new FontStyle(1), null, null, null, 0L, null, null, null, 0L, null, null, 65527), spanStart, spanEnd);
                }
            }
        }
        return builder.toAnnotatedString();
    }
}
