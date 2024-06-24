package androidx.compose.ui.text.input;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TextInputService.kt */
/* loaded from: classes.dex */
public final class TextInputService {
    public final AtomicReference<TextInputSession> _currentInputSession = new AtomicReference<>(null);
    public final PlatformTextInputService platformTextInputService;

    public TextInputService(TextInputServiceAndroid textInputServiceAndroid) {
        this.platformTextInputService = textInputServiceAndroid;
    }
}
