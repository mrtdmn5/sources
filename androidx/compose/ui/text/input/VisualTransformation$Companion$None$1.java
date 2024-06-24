package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisualTransformation.kt */
/* loaded from: classes.dex */
public final class VisualTransformation$Companion$None$1 implements VisualTransformation {
    public static final VisualTransformation$Companion$None$1 INSTANCE = new VisualTransformation$Companion$None$1();

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public final TransformedText filter(AnnotatedString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TransformedText(text, OffsetMapping.Companion.Identity);
    }
}
