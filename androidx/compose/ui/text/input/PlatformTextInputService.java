package androidx.compose.ui.text.input;

import androidx.compose.foundation.text.TextFieldDelegate$Companion$restartInput$1;
import androidx.compose.foundation.text.TextFieldState$onImeActionPerformed$1;
import androidx.compose.ui.geometry.Rect;

/* compiled from: TextInputService.kt */
/* loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void showSoftwareKeyboard();

    void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, TextFieldDelegate$Companion$restartInput$1 textFieldDelegate$Companion$restartInput$1, TextFieldState$onImeActionPerformed$1 textFieldState$onImeActionPerformed$1);

    void stopInput();

    void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2);

    default void notifyFocusedRect(Rect rect) {
    }
}
