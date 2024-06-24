package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class DrawBehindElement extends ModifierNodeElement<DrawBackgroundModifier> {
    public final Function1<DrawScope, Unit> onDraw;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawBehindElement(Function1<? super DrawScope, Unit> onDraw) {
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        this.onDraw = onDraw;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final DrawBackgroundModifier create() {
        return new DrawBackgroundModifier(this.onDraw);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DrawBehindElement) && Intrinsics.areEqual(this.onDraw, ((DrawBehindElement) obj).onDraw)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onDraw.hashCode();
    }

    public final String toString() {
        return "DrawBehindElement(onDraw=" + this.onDraw + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(DrawBackgroundModifier drawBackgroundModifier) {
        DrawBackgroundModifier node = drawBackgroundModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<DrawScope, Unit> function1 = this.onDraw;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.onDraw = function1;
    }
}
