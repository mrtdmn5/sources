package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class EmptySemanticsModifier extends Modifier.Node implements SemanticsModifierNode {
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
    }
}
