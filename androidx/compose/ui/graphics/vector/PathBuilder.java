package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;

/* compiled from: PathBuilder.kt */
/* loaded from: classes.dex */
public final class PathBuilder {
    public final ArrayList nodes = new ArrayList();

    public final void addNode(PathNode pathNode) {
        this.nodes.add(pathNode);
    }

    public final void lineTo(float f, float f2) {
        addNode(new PathNode.LineTo(f, f2));
    }
}
