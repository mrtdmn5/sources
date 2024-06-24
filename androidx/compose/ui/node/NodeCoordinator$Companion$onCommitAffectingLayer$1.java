package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class NodeCoordinator$Companion$onCommitAffectingLayer$1 extends Lambda implements Function1<NodeCoordinator, Unit> {
    public static final NodeCoordinator$Companion$onCommitAffectingLayer$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayer$1();

    public NodeCoordinator$Companion$onCommitAffectingLayer$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(NodeCoordinator nodeCoordinator) {
        NodeCoordinator coordinator = nodeCoordinator;
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        OwnedLayer ownedLayer = coordinator.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
        return Unit.INSTANCE;
    }
}
