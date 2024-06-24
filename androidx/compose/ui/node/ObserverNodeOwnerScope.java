package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObserverModifierNode.kt */
/* loaded from: classes.dex */
public final class ObserverNodeOwnerScope implements OwnerScope {
    public static final ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 OnObserveReadsChanged = ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1.INSTANCE;
    public final ObserverModifierNode observerNode;

    public ObserverNodeOwnerScope(ObserverModifierNode observerNode) {
        Intrinsics.checkNotNullParameter(observerNode, "observerNode");
        this.observerNode = observerNode;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.observerNode.getNode().isAttached;
    }
}
