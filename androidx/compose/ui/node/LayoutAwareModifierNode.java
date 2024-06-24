package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutAwareModifierNode.kt */
/* loaded from: classes.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    default void onPlaced(NodeCoordinator coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
    }

    /* renamed from: onRemeasured-ozmzZPI */
    default void mo440onRemeasuredozmzZPI(long j) {
    }
}
