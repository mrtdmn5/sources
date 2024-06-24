package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* compiled from: KeyMapping.android.kt */
/* loaded from: classes.dex */
public final class KeyMapping_androidKt$platformDefaultKeyMapping$1 implements KeyMapping {
    @Override // androidx.compose.foundation.text.KeyMapping
    /* renamed from: map-ZmokQxo */
    public final KeyCommand mo117mapZmokQxo(KeyEvent keyEvent) {
        KeyCommand keyCommand;
        if (keyEvent.isShiftPressed() && keyEvent.isAltPressed()) {
            long m399getKeyZmokQxo = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
            if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionLeft)) {
                keyCommand = KeyCommand.SELECT_LINE_LEFT;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionRight)) {
                keyCommand = KeyCommand.SELECT_LINE_RIGHT;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionUp)) {
                keyCommand = KeyCommand.SELECT_HOME;
            } else {
                if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionDown)) {
                    keyCommand = KeyCommand.SELECT_END;
                }
                keyCommand = null;
            }
        } else {
            if (keyEvent.isAltPressed()) {
                long m399getKeyZmokQxo2 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
                if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionLeft)) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionRight)) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionUp)) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionDown)) {
                    keyCommand = KeyCommand.END;
                }
            }
            keyCommand = null;
        }
        if (keyCommand == null) {
            return KeyMappingKt.defaultKeyMapping.mo117mapZmokQxo(keyEvent);
        }
        return keyCommand;
    }
}
