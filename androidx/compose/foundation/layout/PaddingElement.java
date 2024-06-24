package androidx.compose.foundation.layout;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes.dex */
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    public final float bottom;
    public final float end;
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final boolean rtlAware;
    public final float start;
    public final float top;

    public PaddingElement() {
        throw null;
    }

    public PaddingElement(float f, float f2, float f3, float f4, Function1 function1) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        boolean z = true;
        this.rtlAware = true;
        this.inspectorInfo = function1;
        if ((f < 0.0f && !Dp.m579equalsimpl0(f, Float.NaN)) || ((f2 < 0.0f && !Dp.m579equalsimpl0(f2, Float.NaN)) || ((f3 < 0.0f && !Dp.m579equalsimpl0(f3, Float.NaN)) || (f4 < 0.0f && !Dp.m579equalsimpl0(f4, Float.NaN))))) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware);
    }

    public final boolean equals(Object obj) {
        PaddingElement paddingElement;
        if (obj instanceof PaddingElement) {
            paddingElement = (PaddingElement) obj;
        } else {
            paddingElement = null;
        }
        if (paddingElement == null || !Dp.m579equalsimpl0(this.start, paddingElement.start) || !Dp.m579equalsimpl0(this.top, paddingElement.top) || !Dp.m579equalsimpl0(this.end, paddingElement.end) || !Dp.m579equalsimpl0(this.bottom, paddingElement.bottom) || this.rtlAware != paddingElement.rtlAware) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.rtlAware) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.bottom, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.end, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, Float.hashCode(this.start) * 31, 31), 31), 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(PaddingNode paddingNode) {
        PaddingNode node = paddingNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.start = this.start;
        node.top = this.top;
        node.end = this.end;
        node.bottom = this.bottom;
        node.rtlAware = this.rtlAware;
    }
}
