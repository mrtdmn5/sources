package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifierNode.kt */
/* loaded from: classes.dex */
public final class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        requireLayoutNode._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(requireLayoutNode).onSemanticsChange();
    }
}
