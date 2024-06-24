package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.text.TextLayoutResult;

/* compiled from: SelectionController.kt */
/* loaded from: classes.dex */
public final class StaticTextSelectionParams {
    public static final StaticTextSelectionParams Empty = new StaticTextSelectionParams(null, null);
    public final LayoutCoordinates layoutCoordinates;
    public final TextLayoutResult textLayoutResult;

    public StaticTextSelectionParams(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        this.layoutCoordinates = layoutCoordinates;
        this.textLayoutResult = textLayoutResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.layout.LayoutCoordinates] */
    public static StaticTextSelectionParams copy$default(StaticTextSelectionParams staticTextSelectionParams, NodeCoordinator nodeCoordinator, TextLayoutResult textLayoutResult, int r4) {
        NodeCoordinator nodeCoordinator2 = nodeCoordinator;
        if ((r4 & 1) != 0) {
            nodeCoordinator2 = staticTextSelectionParams.layoutCoordinates;
        }
        if ((r4 & 2) != 0) {
            textLayoutResult = staticTextSelectionParams.textLayoutResult;
        }
        staticTextSelectionParams.getClass();
        return new StaticTextSelectionParams(nodeCoordinator2, textLayoutResult);
    }
}
