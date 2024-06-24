package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* compiled from: RotaryInputModifier.kt */
/* loaded from: classes.dex */
public final class RotaryInputNode extends Modifier.Node implements RotaryInputModifierNode {
    public Function1<? super RotaryScrollEvent, Boolean> onEvent;
    public Function1<? super RotaryScrollEvent, Boolean> onPreEvent;

    public RotaryInputNode(Function1<? super RotaryScrollEvent, Boolean> function1, Function1<? super RotaryScrollEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public final boolean onPreRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(rotaryScrollEvent).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public final boolean onRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return function1.invoke(rotaryScrollEvent).booleanValue();
        }
        return false;
    }
}
