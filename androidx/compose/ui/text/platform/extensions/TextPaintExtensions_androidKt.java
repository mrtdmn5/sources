package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.SpanStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPaintExtensions.android.kt */
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        if (spanStyle.fontFamily == null && spanStyle.fontStyle == null && spanStyle.fontWeight == null) {
            return false;
        }
        return true;
    }
}
