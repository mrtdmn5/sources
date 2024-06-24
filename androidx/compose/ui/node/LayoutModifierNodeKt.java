package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNode.kt */
/* loaded from: classes.dex */
public final class LayoutModifierNodeKt {
    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        DelegatableNodeKt.m441requireCoordinator64DMado(layoutModifierNode, 2).invalidateLayer();
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui_release();
    }
}
