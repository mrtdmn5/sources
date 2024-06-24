package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifierNode.kt */
/* loaded from: classes.dex */
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        if (drawModifierNode.getNode().isAttached) {
            DelegatableNodeKt.m441requireCoordinator64DMado(drawModifierNode, 1).invalidateLayer();
        }
    }
}
