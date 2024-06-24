package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class FillElement extends ModifierNodeElement<FillNode> {
    public final Direction direction;
    public final float fraction;

    public FillElement(Direction direction, float f, String str) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FillNode create() {
        return new FillNode(this.direction, this.fraction);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        if (this.direction != fillElement.direction) {
            return false;
        }
        if (this.fraction == fillElement.fraction) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Float.hashCode(this.fraction) + (this.direction.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FillNode fillNode) {
        FillNode node = fillNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Direction direction = this.direction;
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        node.direction = direction;
        node.fraction = this.fraction;
    }
}
