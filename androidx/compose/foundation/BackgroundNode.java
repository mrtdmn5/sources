package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Background.kt */
/* loaded from: classes.dex */
public final class BackgroundNode extends Modifier.Node implements DrawModifierNode {
    public float alpha;
    public Brush brush;
    public long color;
    public LayoutDirection lastLayoutDirection;
    public Outline lastOutline;
    public Shape lastShape;
    public Size lastSize;
    public Shape shape;

    public BackgroundNode(long j, Brush brush, float f, Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.color = j;
        this.brush = brush;
        this.alpha = f;
        this.shape = shape;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r25) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BackgroundNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }
}
