package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;

/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public interface DrawModifier extends Modifier.Element {
    void draw(ContentDrawScope contentDrawScope);
}
