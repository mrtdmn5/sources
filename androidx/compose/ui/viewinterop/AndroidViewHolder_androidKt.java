package androidx.compose.ui.viewinterop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AndroidViewHolder.android.kt */
/* loaded from: classes.dex */
public final class AndroidViewHolder_androidKt {
    public static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new AndroidViewHolder_androidKt$NoOpScrollConnection$1();

    public static final void access$layoutAccordingTo(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.nodes.innerCoordinator);
        int roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(positionInRoot));
        int roundToInt2 = MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(positionInRoot));
        androidViewHolder.layout(roundToInt, roundToInt2, androidViewHolder.getMeasuredWidth() + roundToInt, androidViewHolder.getMeasuredHeight() + roundToInt2);
    }
}
