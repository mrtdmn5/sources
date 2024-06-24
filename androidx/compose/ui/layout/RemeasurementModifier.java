package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;

/* compiled from: RemeasurementModifier.kt */
/* loaded from: classes.dex */
public interface RemeasurementModifier extends Modifier.Element {
    void onRemeasurementAvailable(LayoutNode layoutNode);
}
