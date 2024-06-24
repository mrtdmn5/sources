package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoView.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewChildNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public final BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1 defaultParent = new BringIntoViewParent() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1
        @Override // androidx.compose.foundation.relocation.BringIntoViewParent
        public final Object bringChildIntoView(LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super Unit> continuation) {
            Rect rect;
            View view = (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(CompositionLocalConsumerModifierNode.this, AndroidCompositionLocals_androidKt.LocalView);
            long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
            Rect invoke = function0.invoke();
            if (invoke != null) {
                rect = invoke.m270translatek4lQ0M(positionInRoot);
            } else {
                rect = null;
            }
            if (rect != null) {
                view.requestRectangleOnScreen(new android.graphics.Rect((int) rect.left, (int) rect.top, (int) rect.right, (int) rect.bottom), false);
            }
            return Unit.INSTANCE;
        }
    };
    public LayoutCoordinates layoutCoordinates;

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(NodeCoordinator coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
    }
}
