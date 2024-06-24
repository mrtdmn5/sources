package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
/* loaded from: classes.dex */
public final class FocusRequesterNode extends Modifier.Node implements FocusRequesterModifierNode {
    public FocusRequester focusRequester;

    public FocusRequesterNode(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.focusRequester.focusRequesterNodes.add(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.focusRequester.focusRequesterNodes.remove(this);
    }
}
