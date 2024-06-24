package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class HorizontalAlignNode extends Modifier.Node implements ParentDataModifierNode {
    public Alignment.Horizontal horizontal;

    public HorizontalAlignNode(Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        this.horizontal = horizontal;
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
        int r2 = CrossAxisAlignment.$r8$clinit;
        Alignment.Horizontal horizontal = this.horizontal;
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        rowColumnParentData.crossAxisAlignment = new CrossAxisAlignment.HorizontalCrossAxisAlignment(horizontal);
        return rowColumnParentData;
    }
}
