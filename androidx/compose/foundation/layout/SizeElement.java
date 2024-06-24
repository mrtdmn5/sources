package androidx.compose.foundation.layout;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class SizeElement extends ModifierNodeElement<SizeNode> {
    public final boolean enforceIncoming;
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final float maxHeight;
    public final float maxWidth;
    public final float minHeight;
    public final float minWidth;

    public SizeElement() {
        throw null;
    }

    public SizeElement(float f, float f2, float f3, float f4, boolean z) {
        InspectableValueKt$NoInspectorInfo$1 inspectorInfo = InspectableValueKt.NoInspectorInfo;
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
        this.inspectorInfo = inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        if (Dp.m579equalsimpl0(this.minWidth, sizeElement.minWidth) && Dp.m579equalsimpl0(this.minHeight, sizeElement.minHeight) && Dp.m579equalsimpl0(this.maxWidth, sizeElement.maxWidth) && Dp.m579equalsimpl0(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.enforceIncoming) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.maxHeight, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.maxWidth, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.minHeight, Float.hashCode(this.minWidth) * 31, 31), 31), 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(SizeNode sizeNode) {
        SizeNode node = sizeNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.minWidth = this.minWidth;
        node.minHeight = this.minHeight;
        node.maxWidth = this.maxWidth;
        node.maxHeight = this.maxHeight;
        node.enforceIncoming = this.enforceIncoming;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, int r14) {
        this((r14 & 1) != 0 ? Float.NaN : f, (r14 & 2) != 0 ? Float.NaN : f2, (r14 & 4) != 0 ? Float.NaN : f3, (r14 & 8) != 0 ? Float.NaN : f4, z);
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
    }
}
