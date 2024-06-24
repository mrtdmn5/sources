package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Border.kt */
/* loaded from: classes.dex */
public final class BorderModifierNodeElement extends ModifierNodeElement<BorderModifierNode> {
    public final Brush brush;
    public final Shape shape;
    public final float width;

    public BorderModifierNodeElement(float f, Brush brush, Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.width = f;
        this.brush = brush;
        this.shape = shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BorderModifierNode create() {
        return new BorderModifierNode(this.width, this.brush, this.shape);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        if (Dp.m579equalsimpl0(this.width, borderModifierNodeElement.width) && Intrinsics.areEqual(this.brush, borderModifierNodeElement.brush) && Intrinsics.areEqual(this.shape, borderModifierNodeElement.shape)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.shape.hashCode() + ((this.brush.hashCode() + (Float.hashCode(this.width) * 31)) * 31);
    }

    public final String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) Dp.m580toStringimpl(this.width)) + ", brush=" + this.brush + ", shape=" + this.shape + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BorderModifierNode borderModifierNode) {
        BorderModifierNode node = borderModifierNode;
        Intrinsics.checkNotNullParameter(node, "node");
        float f = node.width;
        float f2 = this.width;
        boolean m579equalsimpl0 = Dp.m579equalsimpl0(f, f2);
        CacheDrawModifierNode cacheDrawModifierNode = node.drawWithCacheModifierNode;
        if (!m579equalsimpl0) {
            node.width = f2;
            cacheDrawModifierNode.invalidateDrawCache();
        }
        Brush value = this.brush;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(node.brush, value)) {
            node.brush = value;
            cacheDrawModifierNode.invalidateDrawCache();
        }
        Shape value2 = this.shape;
        Intrinsics.checkNotNullParameter(value2, "value");
        if (!Intrinsics.areEqual(node.shape, value2)) {
            node.shape = value2;
            cacheDrawModifierNode.invalidateDrawCache();
        }
    }
}
