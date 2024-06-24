package androidx.compose.ui.graphics;

import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphicsLayerModifier.kt */
/* loaded from: classes.dex */
public final class BlockGraphicsLayerElement extends ModifierNodeElement<BlockGraphicsLayerModifier> {
    public final Function1<GraphicsLayerScope, Unit> block;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockGraphicsLayerElement(Function1<? super GraphicsLayerScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BlockGraphicsLayerModifier create() {
        return new BlockGraphicsLayerModifier(this.block);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BlockGraphicsLayerElement) && Intrinsics.areEqual(this.block, ((BlockGraphicsLayerElement) obj).block)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.block.hashCode();
    }

    public final String toString() {
        return "BlockGraphicsLayerElement(block=" + this.block + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BlockGraphicsLayerModifier blockGraphicsLayerModifier) {
        BlockGraphicsLayerModifier node = blockGraphicsLayerModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<GraphicsLayerScope, Unit> function1 = this.block;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.layerBlock = function1;
        NodeCoordinator nodeCoordinator = DelegatableNodeKt.m441requireCoordinator64DMado(node, 2).wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.updateLayerBlock(true, node.layerBlock);
        }
    }
}
