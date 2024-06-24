package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;

/* compiled from: OnPlacedModifier.kt */
/* loaded from: classes.dex */
public interface OnPlacedModifier extends Modifier.Element {
    void onPlaced(NodeCoordinator nodeCoordinator);
}
