package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class LayoutWeightNode extends Modifier.Node implements ParentDataModifierNode {
    public boolean fill;
    public float weight;

    public LayoutWeightNode(float f, boolean z) {
        this.weight = f;
        this.fill = z;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        RowColumnParentData rowColumnParentData;
        Intrinsics.checkNotNullParameter(density, "<this>");
        if (obj instanceof RowColumnParentData) {
            rowColumnParentData = (RowColumnParentData) obj;
        } else {
            rowColumnParentData = null;
        }
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0);
        }
        rowColumnParentData.weight = this.weight;
        rowColumnParentData.fill = this.fill;
        return rowColumnParentData;
    }
}
