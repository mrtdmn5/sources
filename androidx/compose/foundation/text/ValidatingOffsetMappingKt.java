package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValidatingOffsetMapping.kt */
/* loaded from: classes.dex */
public final class ValidatingOffsetMappingKt {
    public static final ValidatingOffsetMapping ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.Companion.Identity, 0, 0);

    public static final TransformedText filterWithValidation(VisualTransformation visualTransformation, AnnotatedString text) {
        Intrinsics.checkNotNullParameter(visualTransformation, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        TransformedText filter = visualTransformation.filter(text);
        return new TransformedText(filter.text, new ValidatingOffsetMapping(filter.offsetMapping, text.length(), filter.text.length()));
    }
}
