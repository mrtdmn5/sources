package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnGloballyPositionedModifier.kt */
/* loaded from: classes.dex */
public final class OnGloballyPositionedNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public Function1<? super LayoutCoordinates, Unit> callback;

    public OnGloballyPositionedNode(Function1<? super LayoutCoordinates, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.callback.invoke(nodeCoordinator);
    }
}
