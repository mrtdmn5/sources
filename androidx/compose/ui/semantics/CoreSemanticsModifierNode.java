package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class CoreSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    public final boolean isClearingSemantics;
    public boolean mergeDescendants;
    public Function1<? super SemanticsPropertyReceiver, Unit> properties;

    public CoreSemanticsModifierNode(boolean z, Function1 properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.mergeDescendants = z;
        this.isClearingSemantics = false;
        this.properties = properties;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        this.properties.invoke(semanticsConfiguration);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldClearDescendantSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return this.mergeDescendants;
    }
}
