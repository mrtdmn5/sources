package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
public final class FocusedBoundsNode extends Modifier.Node implements ModifierLocalModifierNode, GlobalPositionAwareModifierNode {
    public boolean isFocused;
    public LayoutCoordinates layoutCoordinates;

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        Function1 function1;
        this.layoutCoordinates = nodeCoordinator;
        if (!this.isFocused) {
            return;
        }
        Function1 function12 = null;
        if (nodeCoordinator.isAttached()) {
            LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
            if (layoutCoordinates != null && layoutCoordinates.isAttached()) {
                if (this.isAttached) {
                    function12 = (Function1) getCurrent(FocusedBoundsKt.ModifierLocalFocusedBoundsObserver);
                }
                if (function12 != null) {
                    function12.invoke(this.layoutCoordinates);
                    return;
                }
                return;
            }
            return;
        }
        if (this.isAttached) {
            function1 = (Function1) getCurrent(FocusedBoundsKt.ModifierLocalFocusedBoundsObserver);
        } else {
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(null);
        }
    }
}
