package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* compiled from: KeyMapping.kt */
/* loaded from: classes.dex */
public final class KeyMappingKt$defaultKeyMapping$2$1 implements KeyMapping {
    public final /* synthetic */ KeyMapping $common;

    public KeyMappingKt$defaultKeyMapping$2$1(KeyMappingKt$commonKeyMapping$1 keyMappingKt$commonKeyMapping$1) {
        this.$common = keyMappingKt$commonKeyMapping$1;
    }

    @Override // androidx.compose.foundation.text.KeyMapping
    /* renamed from: map-ZmokQxo */
    public final KeyCommand mo117mapZmokQxo(KeyEvent keyEvent) {
        KeyCommand keyCommand;
        if (keyEvent.isShiftPressed() && keyEvent.isCtrlPressed()) {
            long m399getKeyZmokQxo = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
            if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionLeft)) {
                keyCommand = KeyCommand.SELECT_LEFT_WORD;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionRight)) {
                keyCommand = KeyCommand.SELECT_RIGHT_WORD;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionUp)) {
                keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
            } else {
                if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.DirectionDown)) {
                    keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                }
                keyCommand = null;
            }
        } else if (keyEvent.isCtrlPressed()) {
            long m399getKeyZmokQxo2 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
            if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionLeft)) {
                keyCommand = KeyCommand.LEFT_WORD;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionRight)) {
                keyCommand = KeyCommand.RIGHT_WORD;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionUp)) {
                keyCommand = KeyCommand.PREV_PARAGRAPH;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionDown)) {
                keyCommand = KeyCommand.NEXT_PARAGRAPH;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.H)) {
                keyCommand = KeyCommand.DELETE_PREV_CHAR;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.Delete)) {
                keyCommand = KeyCommand.DELETE_NEXT_WORD;
            } else if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.Backspace)) {
                keyCommand = KeyCommand.DELETE_PREV_WORD;
            } else {
                if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.Backslash)) {
                    keyCommand = KeyCommand.DESELECT;
                }
                keyCommand = null;
            }
        } else if (keyEvent.isShiftPressed()) {
            long m399getKeyZmokQxo3 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
            if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.MoveHome)) {
                keyCommand = KeyCommand.SELECT_LINE_LEFT;
            } else {
                if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.MoveEnd)) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                }
                keyCommand = null;
            }
        } else {
            if (keyEvent.isAltPressed()) {
                long m399getKeyZmokQxo4 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
                if (Key.m398equalsimpl0(m399getKeyZmokQxo4, MappedKeys.Backspace)) {
                    keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo4, MappedKeys.Delete)) {
                    keyCommand = KeyCommand.DELETE_TO_LINE_END;
                }
            }
            keyCommand = null;
        }
        if (keyCommand == null) {
            return this.$common.mo117mapZmokQxo(keyEvent);
        }
        return keyCommand;
    }
}
