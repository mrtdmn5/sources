package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: CoreTextField.kt */
/* loaded from: classes.dex */
public final class TextFieldState$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {
    public final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ImeAction imeAction) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Function1<KeyboardActionScope, Unit> function1;
        Unit unit;
        boolean z9;
        boolean z10;
        TextInputSession textInputSession;
        int r10 = imeAction.value;
        KeyboardActionRunner keyboardActionRunner = this.this$0.keyboardActionRunner;
        keyboardActionRunner.getClass();
        boolean z11 = false;
        if (r10 == 7) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            function1 = keyboardActionRunner.getKeyboardActions().onDone;
        } else {
            if (r10 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                function1 = keyboardActionRunner.getKeyboardActions().onGo;
            } else {
                if (r10 == 6) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    function1 = keyboardActionRunner.getKeyboardActions().onNext;
                } else {
                    if (r10 == 5) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        function1 = keyboardActionRunner.getKeyboardActions().onPrevious;
                    } else {
                        if (r10 == 3) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            function1 = keyboardActionRunner.getKeyboardActions().onSearch;
                        } else {
                            if (r10 == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                function1 = keyboardActionRunner.getKeyboardActions().onSend;
                            } else {
                                if (r10 == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7 || r10 == 0) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                if (z8) {
                                    function1 = null;
                                } else {
                                    throw new IllegalStateException("invalid ImeAction".toString());
                                }
                            }
                        }
                    }
                }
            }
        }
        if (function1 != null) {
            function1.invoke(keyboardActionRunner);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (r10 == 6) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                FocusManager focusManager = keyboardActionRunner.focusManager;
                if (focusManager != null) {
                    focusManager.mo238moveFocus3ESFkO8(1);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("focusManager");
                    throw null;
                }
            } else {
                if (r10 == 5) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    FocusManager focusManager2 = keyboardActionRunner.focusManager;
                    if (focusManager2 != null) {
                        focusManager2.mo238moveFocus3ESFkO8(2);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
                        throw null;
                    }
                } else {
                    if (r10 == 7) {
                        z11 = true;
                    }
                    if (z11 && (textInputSession = keyboardActionRunner.inputSession) != null && textInputSession.isOpen()) {
                        textInputSession.platformTextInputService.hideSoftwareKeyboard();
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
