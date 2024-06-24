package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Scroll.kt */
/* loaded from: classes.dex */
final class ScrollingLayoutElement extends ModifierNodeElement<ScrollingLayoutNode> {
    public final boolean isReversed;
    public final boolean isVertical;
    public final ScrollState scrollState;

    public ScrollingLayoutElement(ScrollState scrollState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        this.scrollState = scrollState;
        this.isReversed = z;
        this.isVertical = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ScrollingLayoutNode create() {
        return new ScrollingLayoutNode(this.scrollState, this.isReversed, this.isVertical);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        if (!Intrinsics.areEqual(this.scrollState, scrollingLayoutElement.scrollState) || this.isReversed != scrollingLayoutElement.isReversed || this.isVertical != scrollingLayoutElement.isVertical) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.isVertical) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isReversed, this.scrollState.hashCode() * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(ScrollingLayoutNode scrollingLayoutNode) {
        ScrollingLayoutNode node = scrollingLayoutNode;
        Intrinsics.checkNotNullParameter(node, "node");
        ScrollState scrollState = this.scrollState;
        Intrinsics.checkNotNullParameter(scrollState, "<set-?>");
        node.scrollerState = scrollState;
        node.isReversed = this.isReversed;
        node.isVertical = this.isVertical;
    }
}
