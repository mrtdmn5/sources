package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: TextStringSimpleElement.kt */
/* loaded from: classes.dex */
public final class TextStringSimpleElement extends ModifierNodeElement<TextStringSimpleNode> {
    public final ColorProducer color;
    public final FontFamily.Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final int overflow;
    public final boolean softWrap;
    public final TextStyle style;
    public final String text;

    public TextStringSimpleElement(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int r5, boolean z, int r7, int r8, ColorProducer colorProducer) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = r5;
        this.softWrap = z;
        this.maxLines = r7;
        this.minLines = r8;
        this.color = colorProducer;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final TextStringSimpleNode create() {
        return new TextStringSimpleNode(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.color);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        if (!Intrinsics.areEqual(this.color, textStringSimpleElement.color) || !Intrinsics.areEqual(this.text, textStringSimpleElement.text) || !Intrinsics.areEqual(this.style, textStringSimpleElement.style) || !Intrinsics.areEqual(this.fontFamilyResolver, textStringSimpleElement.fontFamilyResolver)) {
            return false;
        }
        if (this.overflow == textStringSimpleElement.overflow) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.softWrap == textStringSimpleElement.softWrap && this.maxLines == textStringSimpleElement.maxLines && this.minLines == textStringSimpleElement.minLines) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r1;
        int m = (((JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.softWrap, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.overflow, (this.fontFamilyResolver.hashCode() + ((this.style.hashCode() + (this.text.hashCode() * 31)) * 31)) * 31, 31), 31) + this.maxLines) * 31) + this.minLines) * 31;
        ColorProducer colorProducer = this.color;
        if (colorProducer != null) {
            r1 = colorProducer.hashCode();
        } else {
            r1 = 0;
        }
        return m + r1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004d  */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.compose.foundation.text.modifiers.TextStringSimpleNode r13) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleElement.update(androidx.compose.ui.Modifier$Node):void");
    }
}
