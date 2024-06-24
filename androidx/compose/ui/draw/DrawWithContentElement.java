package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class DrawWithContentElement extends ModifierNodeElement<DrawWithContentModifier> {
    public final Function1<ContentDrawScope, Unit> onDraw;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawWithContentElement(Function1<? super ContentDrawScope, Unit> onDraw) {
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        this.onDraw = onDraw;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final DrawWithContentModifier create() {
        return new DrawWithContentModifier(this.onDraw);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DrawWithContentElement) && Intrinsics.areEqual(this.onDraw, ((DrawWithContentElement) obj).onDraw)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onDraw.hashCode();
    }

    public final String toString() {
        return "DrawWithContentElement(onDraw=" + this.onDraw + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(DrawWithContentModifier drawWithContentModifier) {
        DrawWithContentModifier node = drawWithContentModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<ContentDrawScope, Unit> function1 = this.onDraw;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.onDraw = function1;
    }
}
