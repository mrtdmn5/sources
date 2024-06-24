package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectableTextAnnotatedStringNode.kt */
/* loaded from: classes.dex */
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {
    public final TextAnnotatedStringNode delegate;
    public final SelectionController selectionController;

    public SelectableTextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1 function1, int r21, boolean z, int r23, int r24, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.selectionController = selectionController;
        TextAnnotatedStringNode textAnnotatedStringNode = new TextAnnotatedStringNode(text, style, fontFamilyResolver, function1, r21, z, r23, r24, list, function12, selectionController, colorProducer);
        delegate(textAnnotatedStringNode);
        this.delegate = textAnnotatedStringNode;
        if (selectionController != null) {
        } else {
            throw new IllegalArgumentException("Do not use SelectionCapableStaticTextModifier unless selectionController != null".toString());
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        textAnnotatedStringNode.draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        return textAnnotatedStringNode.maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        return textAnnotatedStringNode.maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        return textAnnotatedStringNode.mo31measure3p2s80s(measure, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        return textAnnotatedStringNode.minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, r4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        textAnnotatedStringNode.getClass();
        return textAnnotatedStringNode.minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, r4);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.params = StaticTextSelectionParams.copy$default(selectionController.params, nodeCoordinator, null, 2);
        }
    }
}
