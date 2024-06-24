package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisualTransformation.kt */
/* loaded from: classes.dex */
public final class TransformedText {
    public final OffsetMapping offsetMapping;
    public final AnnotatedString text;

    public TransformedText(AnnotatedString text, OffsetMapping offsetMapping) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        this.text = text;
        this.offsetMapping = offsetMapping;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformedText)) {
            return false;
        }
        TransformedText transformedText = (TransformedText) obj;
        if (Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.offsetMapping.hashCode() + (this.text.hashCode() * 31);
    }

    public final String toString() {
        return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
    }
}
