package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutId.kt */
/* loaded from: classes.dex */
public final class LayoutIdModifier extends Modifier.Node implements ParentDataModifierNode, LayoutIdParentData {
    public Object layoutId;

    public LayoutIdModifier(Object layoutId) {
        Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        this.layoutId = layoutId;
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    public final Object getLayoutId() {
        return this.layoutId;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return this;
    }
}
