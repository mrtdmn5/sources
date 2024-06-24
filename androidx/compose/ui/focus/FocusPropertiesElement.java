package androidx.compose.ui.focus;

import androidx.compose.foundation.FocusableKt$focusGroup$1;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
final class FocusPropertiesElement extends ModifierNodeElement<FocusPropertiesNode> {
    public final Function1<FocusProperties, Unit> scope;

    public FocusPropertiesElement(FocusableKt$focusGroup$1 scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FocusPropertiesNode create() {
        return new FocusPropertiesNode(this.scope);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FocusPropertiesElement) && Intrinsics.areEqual(this.scope, ((FocusPropertiesElement) obj).scope)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.scope.hashCode();
    }

    public final String toString() {
        return "FocusPropertiesElement(scope=" + this.scope + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FocusPropertiesNode focusPropertiesNode) {
        FocusPropertiesNode node = focusPropertiesNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<FocusProperties, Unit> function1 = this.scope;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.focusPropertiesScope = function1;
    }
}
