package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusChangedModifier.kt */
/* loaded from: classes.dex */
public final class FocusChangedNode extends Modifier.Node implements FocusEventModifierNode {
    public FocusState focusState;
    public Function1<? super FocusState, Unit> onFocusChanged;

    public FocusChangedNode(Function1<? super FocusState, Unit> onFocusChanged) {
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        this.onFocusChanged = onFocusChanged;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (!Intrinsics.areEqual(this.focusState, focusState)) {
            this.focusState = focusState;
            this.onFocusChanged.invoke(focusState);
        }
    }
}
