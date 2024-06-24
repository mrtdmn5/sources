package androidx.compose.foundation;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Background.kt */
/* loaded from: classes.dex */
public final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {
    public final float alpha;
    public final Brush brush;
    public final long color;
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final Shape shape;

    public BackgroundElement() {
        throw null;
    }

    public BackgroundElement(long j, Shape shape) {
        InspectableValueKt$NoInspectorInfo$1 inspectorInfo = InspectableValueKt.NoInspectorInfo;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.color = j;
        this.brush = null;
        this.alpha = 1.0f;
        this.shape = shape;
        this.inspectorInfo = inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape);
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement;
        boolean z;
        if (obj instanceof BackgroundElement) {
            backgroundElement = (BackgroundElement) obj;
        } else {
            backgroundElement = null;
        }
        if (backgroundElement == null || !Color.m317equalsimpl0(this.color, backgroundElement.color) || !Intrinsics.areEqual(this.brush, backgroundElement.brush)) {
            return false;
        }
        if (this.alpha == backgroundElement.alpha) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !Intrinsics.areEqual(this.shape, backgroundElement.shape)) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r1;
        int r0 = Color.$r8$clinit;
        int hashCode = Long.hashCode(this.color) * 31;
        Brush brush = this.brush;
        if (brush != null) {
            r1 = brush.hashCode();
        } else {
            r1 = 0;
        }
        return this.shape.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.alpha, (hashCode + r1) * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BackgroundNode backgroundNode) {
        BackgroundNode node = backgroundNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.color = this.color;
        node.brush = this.brush;
        node.alpha = this.alpha;
        Shape shape = this.shape;
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        node.shape = shape;
    }
}
