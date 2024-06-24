package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* compiled from: TextFieldFocusModifier.android.kt */
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    /* renamed from: access$isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m121access$isKeyCodeYhN2O0w(int r2, KeyEvent keyEvent) {
        if (((int) (KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent) >> 32)) == r2) {
            return true;
        }
        return false;
    }
}
