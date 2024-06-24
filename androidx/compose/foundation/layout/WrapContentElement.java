package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {
    public final Object align;
    public final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    public final Direction direction;
    public final boolean unbounded;

    /* compiled from: Size.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static WrapContentElement height(final Alignment.Vertical vertical, boolean z) {
            return new WrapContentElement(Direction.Vertical, z, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$height$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                    long j = intSize.packedValue;
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    return new IntOffset(IntOffsetKt.IntOffset(0, Alignment.Vertical.this.align(0, IntSize.m593getHeightimpl(j))));
                }
            }, vertical, "wrapContentHeight");
        }

        public static WrapContentElement size(final Alignment alignment, boolean z) {
            return new WrapContentElement(Direction.Both, z, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$size$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                    long j = intSize.packedValue;
                    LayoutDirection layoutDirection2 = layoutDirection;
                    Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                    return new IntOffset(Alignment.this.mo229alignKFBX0sM(0L, j, layoutDirection2));
                }
            }, alignment, "wrapContentSize");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentElement(Direction direction, boolean z, Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2, Object obj, String str) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = function2;
        this.align = obj;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(WrapContentElement.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.layout.WrapContentElement");
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        if (this.direction == wrapContentElement.direction && this.unbounded == wrapContentElement.unbounded && Intrinsics.areEqual(this.align, wrapContentElement.align)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.align.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.unbounded, this.direction.hashCode() * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(WrapContentNode wrapContentNode) {
        WrapContentNode node = wrapContentNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Direction direction = this.direction;
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        node.direction = direction;
        node.unbounded = this.unbounded;
        Function2<IntSize, LayoutDirection, IntOffset> function2 = this.alignmentCallback;
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        node.alignmentCallback = function2;
    }
}
