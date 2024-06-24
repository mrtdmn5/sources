package androidx.compose.foundation.layout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Offset.kt */
/* loaded from: classes.dex */
final class OffsetPxElement extends ModifierNodeElement<OffsetPxNode> {
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final Function1<Density, IntOffset> offset;
    public final boolean rtlAware;

    public OffsetPxElement(Function1 offset, OffsetKt$offset$2 offsetKt$offset$2) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.offset = offset;
        this.rtlAware = true;
        this.inspectorInfo = offsetKt$offset$2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final OffsetPxNode create() {
        return new OffsetPxNode(this.rtlAware, this.offset);
    }

    public final boolean equals(Object obj) {
        OffsetPxElement offsetPxElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetPxElement) {
            offsetPxElement = (OffsetPxElement) obj;
        } else {
            offsetPxElement = null;
        }
        if (offsetPxElement == null) {
            return false;
        }
        if (Intrinsics.areEqual(this.offset, offsetPxElement.offset) && this.rtlAware == offsetPxElement.rtlAware) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.rtlAware) + (this.offset.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OffsetPxModifier(offset=");
        sb.append(this.offset);
        sb.append(", rtlAware=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.rtlAware, ')');
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(OffsetPxNode offsetPxNode) {
        OffsetPxNode node = offsetPxNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<Density, IntOffset> function1 = this.offset;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.offset = function1;
        node.rtlAware = this.rtlAware;
    }
}
