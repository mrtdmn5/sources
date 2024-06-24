package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyInputModifier.kt */
/* loaded from: classes.dex */
public final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {
    public Function1<? super KeyEvent, Boolean> onEvent;
    public Function1<? super KeyEvent, Boolean> onPreEvent;

    public KeyInputNode(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public final boolean mo12onKeyEventZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1<? super KeyEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return function1.invoke(new KeyEvent(event)).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public final boolean mo14onPreKeyEventZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1<? super KeyEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(new KeyEvent(event)).booleanValue();
        }
        return false;
    }
}
