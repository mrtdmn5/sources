package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: TextAnnotatedStringElement.kt */
/* loaded from: classes.dex */
public final class TextAnnotatedStringElement extends ModifierNodeElement<TextAnnotatedStringNode> {
    public final ColorProducer color;
    public final FontFamily.Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final Function1<List<Rect>, Unit> onPlaceholderLayout;
    public final Function1<TextLayoutResult, Unit> onTextLayout;
    public final int overflow;
    public final List<AnnotatedString.Range<Placeholder>> placeholders;
    public final SelectionController selectionController;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextAnnotatedStringElement(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1 function1, int r6, boolean z, int r8, int r9, List list, Function1 function12, ColorProducer colorProducer) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.onTextLayout = function1;
        this.overflow = r6;
        this.softWrap = z;
        this.maxLines = r8;
        this.minLines = r9;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.selectionController = null;
        this.color = colorProducer;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final TextAnnotatedStringNode create() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        if (!Intrinsics.areEqual(this.color, textAnnotatedStringElement.color) || !Intrinsics.areEqual(this.text, textAnnotatedStringElement.text) || !Intrinsics.areEqual(this.style, textAnnotatedStringElement.style) || !Intrinsics.areEqual(this.placeholders, textAnnotatedStringElement.placeholders) || !Intrinsics.areEqual(this.fontFamilyResolver, textAnnotatedStringElement.fontFamilyResolver) || !Intrinsics.areEqual(this.onTextLayout, textAnnotatedStringElement.onTextLayout)) {
            return false;
        }
        if (this.overflow == textAnnotatedStringElement.overflow) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines && Intrinsics.areEqual(this.onPlaceholderLayout, textAnnotatedStringElement.onPlaceholderLayout) && Intrinsics.areEqual(this.selectionController, textAnnotatedStringElement.selectionController)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r2;
        int r22;
        int r23;
        int r24;
        int hashCode = (this.fontFamilyResolver.hashCode() + ((this.style.hashCode() + (this.text.hashCode() * 31)) * 31)) * 31;
        int r1 = 0;
        Function1<TextLayoutResult, Unit> function1 = this.onTextLayout;
        if (function1 != null) {
            r2 = function1.hashCode();
        } else {
            r2 = 0;
        }
        int m = (((JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.softWrap, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.overflow, (hashCode + r2) * 31, 31), 31) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        if (list != null) {
            r22 = list.hashCode();
        } else {
            r22 = 0;
        }
        int r0 = (m + r22) * 31;
        Function1<List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        if (function12 != null) {
            r23 = function12.hashCode();
        } else {
            r23 = 0;
        }
        int r02 = (r0 + r23) * 31;
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            r24 = selectionController.hashCode();
        } else {
            r24 = 0;
        }
        int r03 = (r02 + r24) * 31;
        ColorProducer colorProducer = this.color;
        if (colorProducer != null) {
            r1 = colorProducer.hashCode();
        }
        return r03 + r1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r11) {
        /*
            r10 = this;
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r11 = (androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode) r11
            java.lang.String r0 = "node"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "style"
            androidx.compose.ui.text.TextStyle r1 = r10.style
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.graphics.ColorProducer r0 = r11.overrideColor
            androidx.compose.ui.graphics.ColorProducer r2 = r10.color
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            r3 = 1
            r0 = r0 ^ r3
            r11.overrideColor = r2
            r2 = 0
            if (r0 != 0) goto L3a
            androidx.compose.ui.text.TextStyle r0 = r11.style
            java.lang.String r4 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            if (r1 == r0) goto L34
            androidx.compose.ui.text.SpanStyle r1 = r1.spanStyle
            androidx.compose.ui.text.SpanStyle r0 = r0.spanStyle
            boolean r0 = r1.hasSameNonLayoutAttributes$ui_text_release(r0)
            if (r0 == 0) goto L32
            goto L34
        L32:
            r0 = r2
            goto L35
        L34:
            r0 = r3
        L35:
            if (r0 != 0) goto L38
            goto L3a
        L38:
            r8 = r2
            goto L3b
        L3a:
            r8 = r3
        L3b:
            java.lang.String r0 = "text"
            androidx.compose.ui.text.AnnotatedString r1 = r10.text
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.text.AnnotatedString r0 = r11.text
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L4d
            r9 = r2
            goto L50
        L4d:
            r11.text = r1
            r9 = r3
        L50:
            androidx.compose.ui.text.TextStyle r1 = r10.style
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.Placeholder>> r2 = r10.placeholders
            int r3 = r10.minLines
            int r4 = r10.maxLines
            boolean r5 = r10.softWrap
            androidx.compose.ui.text.font.FontFamily$Resolver r6 = r10.fontFamilyResolver
            int r7 = r10.overflow
            r0 = r11
            boolean r0 = r0.m130updateLayoutRelatedArgsMPT68mk(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r1 = r10.onTextLayout
            kotlin.jvm.functions.Function1<java.util.List<androidx.compose.ui.geometry.Rect>, kotlin.Unit> r2 = r10.onPlaceholderLayout
            androidx.compose.foundation.text.modifiers.SelectionController r3 = r10.selectionController
            boolean r1 = r11.updateCallbacks(r1, r2, r3)
            r11.doInvalidations(r8, r9, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement.update(androidx.compose.ui.Modifier$Node):void");
    }
}
