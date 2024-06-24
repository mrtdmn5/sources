package androidx.compose.ui.text;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: TextLayoutResult.kt */
/* loaded from: classes.dex */
public final class TextLayoutInput {
    public final long constraints;
    public final Density density;
    public final FontFamily.Resolver fontFamilyResolver;
    public final LayoutDirection layoutDirection;
    public final int maxLines;
    public final int overflow;
    public final List<AnnotatedString.Range<Placeholder>> placeholders;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextLayoutInput() {
        throw null;
    }

    public TextLayoutInput(AnnotatedString text, TextStyle style, List placeholders, int r5, boolean z, int r7, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long j) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.placeholders = placeholders;
        this.maxLines = r5;
        this.softWrap = z;
        this.overflow = r7;
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.fontFamilyResolver = fontFamilyResolver;
        this.constraints = j;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        if (!Intrinsics.areEqual(this.text, textLayoutInput.text) || !Intrinsics.areEqual(this.style, textLayoutInput.style) || !Intrinsics.areEqual(this.placeholders, textLayoutInput.placeholders) || this.maxLines != textLayoutInput.maxLines || this.softWrap != textLayoutInput.softWrap) {
            return false;
        }
        if (this.overflow == textLayoutInput.overflow) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(this.density, textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual(this.fontFamilyResolver, textLayoutInput.fontFamilyResolver) && Constraints.m559equalsimpl0(this.constraints, textLayoutInput.constraints)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.constraints) + ((this.fontFamilyResolver.hashCode() + ((this.layoutDirection.hashCode() + ((this.density.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.overflow, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.softWrap, (VectorGroup$$ExternalSyntheticOutline0.m(this.placeholders, (this.style.hashCode() + (this.text.hashCode() * 31)) * 31, 31) + this.maxLines) * 31, 31), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TextLayoutInput(text=" + ((Object) this.text) + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + ((Object) TextOverflow.m557toStringimpl(this.overflow)) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + ((Object) Constraints.m568toStringimpl(this.constraints)) + ')';
    }
}
