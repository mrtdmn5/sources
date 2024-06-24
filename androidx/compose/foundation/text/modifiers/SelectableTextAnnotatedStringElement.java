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
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: SelectableTextAnnotatedStringElement.kt */
/* loaded from: classes.dex */
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {
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

    public SelectableTextAnnotatedStringElement(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1 function1, int r6, boolean z, int r8, int r9, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer) {
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
        this.selectionController = selectionController;
        this.color = colorProducer;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final SelectableTextAnnotatedStringNode create() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) obj;
        if (!Intrinsics.areEqual(this.color, selectableTextAnnotatedStringElement.color) || !Intrinsics.areEqual(this.text, selectableTextAnnotatedStringElement.text) || !Intrinsics.areEqual(this.style, selectableTextAnnotatedStringElement.style) || !Intrinsics.areEqual(this.placeholders, selectableTextAnnotatedStringElement.placeholders) || !Intrinsics.areEqual(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver) || !Intrinsics.areEqual(this.onTextLayout, selectableTextAnnotatedStringElement.onTextLayout)) {
            return false;
        }
        if (this.overflow == selectableTextAnnotatedStringElement.overflow) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && Intrinsics.areEqual(this.onPlaceholderLayout, selectableTextAnnotatedStringElement.onPlaceholderLayout) && Intrinsics.areEqual(this.selectionController, selectableTextAnnotatedStringElement.selectionController)) {
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

    public final String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.text) + ", style=" + this.style + ", fontFamilyResolver=" + this.fontFamilyResolver + ", onTextLayout=" + this.onTextLayout + ", overflow=" + ((Object) TextOverflow.m557toStringimpl(this.overflow)) + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", placeholders=" + this.placeholders + ", onPlaceholderLayout=" + this.onPlaceholderLayout + ", selectionController=" + this.selectionController + ", color=" + this.color + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode r14) {
        /*
            r13 = this;
            androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode r14 = (androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode) r14
            java.lang.String r0 = "node"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.Placeholder>> r3 = r13.placeholders
            int r4 = r13.minLines
            int r5 = r13.maxLines
            boolean r6 = r13.softWrap
            int r8 = r13.overflow
            java.lang.String r0 = "text"
            androidx.compose.ui.text.AnnotatedString r1 = r13.text
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "style"
            androidx.compose.ui.text.TextStyle r2 = r13.style
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "fontFamilyResolver"
            androidx.compose.ui.text.font.FontFamily$Resolver r7 = r13.fontFamilyResolver
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r0 = r14.delegate
            r0.getClass()
            androidx.compose.ui.graphics.ColorProducer r9 = r0.overrideColor
            androidx.compose.ui.graphics.ColorProducer r10 = r13.color
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r9)
            r11 = 1
            r9 = r9 ^ r11
            r0.overrideColor = r10
            r10 = 0
            if (r9 != 0) goto L58
            androidx.compose.ui.text.TextStyle r9 = r0.style
            java.lang.String r12 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r12)
            if (r2 == r9) goto L52
            androidx.compose.ui.text.SpanStyle r12 = r2.spanStyle
            androidx.compose.ui.text.SpanStyle r9 = r9.spanStyle
            boolean r9 = r12.hasSameNonLayoutAttributes$ui_text_release(r9)
            if (r9 == 0) goto L50
            goto L52
        L50:
            r9 = r10
            goto L53
        L52:
            r9 = r11
        L53:
            if (r9 != 0) goto L56
            goto L58
        L56:
            r9 = r10
            goto L59
        L58:
            r9 = r11
        L59:
            androidx.compose.ui.text.AnnotatedString r12 = r0.text
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r1)
            if (r12 == 0) goto L63
            r11 = r10
            goto L65
        L63:
            r0.text = r1
        L65:
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = r14.delegate
            boolean r1 = r1.m130updateLayoutRelatedArgsMPT68mk(r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.foundation.text.modifiers.SelectionController r2 = r13.selectionController
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r3 = r13.onTextLayout
            kotlin.jvm.functions.Function1<java.util.List<androidx.compose.ui.geometry.Rect>, kotlin.Unit> r4 = r13.onPlaceholderLayout
            boolean r2 = r0.updateCallbacks(r3, r4, r2)
            r0.doInvalidations(r9, r11, r1, r2)
            androidx.compose.ui.node.LayoutModifierNodeKt.invalidateMeasurement(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement.update(androidx.compose.ui.Modifier$Node):void");
    }
}
