package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Box.kt */
/* loaded from: classes.dex */
public final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {
    public Alignment alignment;
    public boolean matchParentSize;

    public BoxChildDataNode(Alignment alignment, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.alignment = alignment;
        this.matchParentSize = z;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return this;
    }
}
