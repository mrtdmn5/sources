package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    public Function1<? super FocusProperties, Unit> focusPropertiesScope;

    public FocusPropertiesNode(Function1<? super FocusProperties, Unit> focusPropertiesScope) {
        Intrinsics.checkNotNullParameter(focusPropertiesScope, "focusPropertiesScope");
        this.focusPropertiesScope = focusPropertiesScope;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        this.focusPropertiesScope.invoke(focusProperties);
    }
}
