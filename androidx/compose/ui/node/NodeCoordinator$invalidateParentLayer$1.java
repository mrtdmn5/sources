package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class NodeCoordinator$invalidateParentLayer$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ NodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NodeCoordinator$invalidateParentLayer$1(NodeCoordinator nodeCoordinator) {
        super(0);
        this.this$0 = nodeCoordinator;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        NodeCoordinator nodeCoordinator = this.this$0.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
        return Unit.INSTANCE;
    }
}
