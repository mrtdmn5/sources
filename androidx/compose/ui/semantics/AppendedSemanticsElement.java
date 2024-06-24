package androidx.compose.ui.semantics;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class AppendedSemanticsElement extends ModifierNodeElement<CoreSemanticsModifierNode> implements SemanticsModifier {
    public final boolean mergeDescendants;
    public final Function1<SemanticsPropertyReceiver, Unit> properties;

    /* JADX WARN: Multi-variable type inference failed */
    public AppendedSemanticsElement(boolean z, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.mergeDescendants = z;
        this.properties = properties;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final CoreSemanticsModifierNode create() {
        return new CoreSemanticsModifierNode(this.mergeDescendants, this.properties);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        if (this.mergeDescendants == appendedSemanticsElement.mergeDescendants && Intrinsics.areEqual(this.properties, appendedSemanticsElement.properties)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.semantics.SemanticsModifier
    public final SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.mergeDescendants;
        this.properties.invoke(semanticsConfiguration);
        return semanticsConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        boolean z = this.mergeDescendants;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return this.properties.hashCode() + (r0 * 31);
    }

    public final String toString() {
        return "AppendedSemanticsElement(mergeDescendants=" + this.mergeDescendants + ", properties=" + this.properties + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(CoreSemanticsModifierNode coreSemanticsModifierNode) {
        CoreSemanticsModifierNode node = coreSemanticsModifierNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.mergeDescendants = this.mergeDescendants;
        Function1<SemanticsPropertyReceiver, Unit> function1 = this.properties;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.properties = function1;
    }
}
