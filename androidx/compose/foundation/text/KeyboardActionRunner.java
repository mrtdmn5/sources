package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardActionRunner.kt */
/* loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    public TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        throw null;
    }
}
