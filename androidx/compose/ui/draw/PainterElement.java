package androidx.compose.ui.draw;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PainterModifier.kt */
/* loaded from: classes.dex */
public final class PainterElement extends ModifierNodeElement<PainterNode> {
    public final Alignment alignment;
    public final float alpha;
    public final ColorFilter colorFilter;
    public final ContentScale contentScale;
    public final Painter painter;
    public final boolean sizeToIntrinsics;

    public PainterElement(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final PainterNode create() {
        return new PainterNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        if (Intrinsics.areEqual(this.painter, painterElement.painter) && this.sizeToIntrinsics == painterElement.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterElement.alignment) && Intrinsics.areEqual(this.contentScale, painterElement.contentScale) && Float.compare(this.alpha, painterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, painterElement.colorFilter)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.painter.hashCode() * 31;
        boolean z = this.sizeToIntrinsics;
        int r1 = z;
        if (z != 0) {
            r1 = 1;
        }
        int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.alpha, (this.contentScale.hashCode() + ((this.alignment.hashCode() + ((hashCode2 + r1) * 31)) * 31)) * 31, 31);
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter == null) {
            hashCode = 0;
        } else {
            hashCode = colorFilter.hashCode();
        }
        return m + hashCode;
    }

    public final String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(PainterNode painterNode) {
        boolean z;
        PainterNode node = painterNode;
        Intrinsics.checkNotNullParameter(node, "node");
        boolean z2 = node.sizeToIntrinsics;
        Painter painter = this.painter;
        boolean z3 = this.sizeToIntrinsics;
        if (z2 == z3 && (!z3 || Size.m273equalsimpl0(node.painter.mo392getIntrinsicSizeNHjbRc(), painter.mo392getIntrinsicSizeNHjbRc()))) {
            z = false;
        } else {
            z = true;
        }
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        node.painter = painter;
        node.sizeToIntrinsics = z3;
        Alignment alignment = this.alignment;
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        node.alignment = alignment;
        ContentScale contentScale = this.contentScale;
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        node.contentScale = contentScale;
        node.alpha = this.alpha;
        node.colorFilter = this.colorFilter;
        if (z) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
    }
}
