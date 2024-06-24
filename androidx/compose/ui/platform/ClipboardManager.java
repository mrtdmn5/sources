package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;

/* compiled from: ClipboardManager.kt */
/* loaded from: classes.dex */
public interface ClipboardManager {
    AnnotatedString getText();

    default boolean hasText() {
        boolean z;
        AnnotatedString text = getText();
        if (text == null) {
            return false;
        }
        if (text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    void setText(AnnotatedString annotatedString);
}
