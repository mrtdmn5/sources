package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;

/* compiled from: Search.kt */
/* loaded from: classes.dex */
public final class SearchKt {
    public static ImageVector _search;

    public static final ImageVector getSearch() {
        ImageVector imageVector = _search;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Search", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 224);
        int r1 = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.addNode(new PathNode.MoveTo(15.5f, 14.0f));
        pathBuilder.addNode(new PathNode.RelativeHorizontalTo(-0.79f));
        pathBuilder.addNode(new PathNode.RelativeLineTo(-0.28f, -0.27f));
        pathBuilder.addNode(new PathNode.CurveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f));
        pathBuilder.addNode(new PathNode.CurveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f));
        pathBuilder.addNode(new PathNode.ReflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f));
        pathBuilder.addNode(new PathNode.ReflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f));
        pathBuilder.addNode(new PathNode.RelativeCurveTo(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f));
        pathBuilder.addNode(new PathNode.RelativeLineTo(0.27f, 0.28f));
        pathBuilder.addNode(new PathNode.RelativeVerticalTo(0.79f));
        pathBuilder.addNode(new PathNode.RelativeLineTo(5.0f, 4.99f));
        pathBuilder.lineTo(20.49f, 19.0f);
        pathBuilder.addNode(new PathNode.RelativeLineTo(-4.99f, -5.0f));
        PathNode.Close close = PathNode.Close.INSTANCE;
        pathBuilder.addNode(close);
        pathBuilder.addNode(new PathNode.MoveTo(9.5f, 14.0f));
        pathBuilder.addNode(new PathNode.CurveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f));
        pathBuilder.addNode(new PathNode.ReflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f));
        pathBuilder.addNode(new PathNode.ReflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f));
        pathBuilder.addNode(new PathNode.ReflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f));
        pathBuilder.addNode(close);
        builder.m394addPathoIyEayM(1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0, 0, 2, solidColor, null, "", pathBuilder.nodes);
        ImageVector build = builder.build();
        _search = build;
        return build;
    }
}
