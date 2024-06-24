package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;

/* compiled from: Clear.kt */
/* loaded from: classes.dex */
public final class ClearKt {
    public static ImageVector _clear;

    public static final ImageVector getClear() {
        ImageVector imageVector = _clear;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Clear", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 224);
        int r1 = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.addNode(new PathNode.MoveTo(19.0f, 6.41f));
        pathBuilder.lineTo(17.59f, 5.0f);
        pathBuilder.lineTo(12.0f, 10.59f);
        pathBuilder.lineTo(6.41f, 5.0f);
        pathBuilder.lineTo(5.0f, 6.41f);
        pathBuilder.lineTo(10.59f, 12.0f);
        pathBuilder.lineTo(5.0f, 17.59f);
        pathBuilder.lineTo(6.41f, 19.0f);
        pathBuilder.lineTo(12.0f, 13.41f);
        pathBuilder.lineTo(17.59f, 19.0f);
        pathBuilder.lineTo(19.0f, 17.59f);
        pathBuilder.lineTo(13.41f, 12.0f);
        pathBuilder.addNode(PathNode.Close.INSTANCE);
        builder.m394addPathoIyEayM(1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0, 0, 2, solidColor, null, "", pathBuilder.nodes);
        ImageVector build = builder.build();
        _clear = build;
        return build;
    }
}
