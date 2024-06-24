package androidx.compose.ui.node;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;

/* compiled from: DrawModifierNode.kt */
/* loaded from: classes.dex */
public interface DrawModifierNode extends DelegatableNode {
    void draw(ContentDrawScope contentDrawScope);

    default void onMeasureResultChanged() {
    }
}
