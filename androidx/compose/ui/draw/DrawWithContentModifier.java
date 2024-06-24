package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class DrawWithContentModifier extends Modifier.Node implements DrawModifierNode {
    public Function1<? super ContentDrawScope, Unit> onDraw;

    public DrawWithContentModifier(Function1<? super ContentDrawScope, Unit> onDraw) {
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        this.onDraw = onDraw;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.onDraw.invoke(contentDrawScope);
    }
}
