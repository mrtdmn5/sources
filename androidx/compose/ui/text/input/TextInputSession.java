package androidx.compose.ui.text.input;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputService.kt */
/* loaded from: classes.dex */
public final class TextInputSession {
    public final PlatformTextInputService platformTextInputService;
    public final TextInputService textInputService;

    public TextInputSession(TextInputService textInputService, PlatformTextInputService platformTextInputService) {
        Intrinsics.checkNotNullParameter(textInputService, "textInputService");
        Intrinsics.checkNotNullParameter(platformTextInputService, "platformTextInputService");
        this.textInputService = textInputService;
        this.platformTextInputService = platformTextInputService;
    }

    public final boolean isOpen() {
        return Intrinsics.areEqual(this.textInputService._currentInputSession.get(), this);
    }

    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        if (isOpen()) {
            this.platformTextInputService.updateState(textFieldValue, textFieldValue2);
        }
    }
}
