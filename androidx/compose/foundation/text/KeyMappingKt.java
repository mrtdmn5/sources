package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyMapping.kt */
/* loaded from: classes.dex */
public final class KeyMappingKt {
    public static final KeyMappingKt$defaultKeyMapping$2$1 defaultKeyMapping;

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1] */
    static {
        final KeyMappingKt$defaultKeyMapping$1 shortcutModifier = KeyMappingKt$defaultKeyMapping$1.INSTANCE;
        Intrinsics.checkNotNullParameter(shortcutModifier, "shortcutModifier");
        defaultKeyMapping = new KeyMappingKt$defaultKeyMapping$2$1(new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public final KeyCommand mo117mapZmokQxo(KeyEvent keyEvent) {
                boolean m398equalsimpl0;
                androidx.compose.ui.input.key.KeyEvent keyEvent2 = new androidx.compose.ui.input.key.KeyEvent(keyEvent);
                Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> function1 = shortcutModifier;
                if (function1.invoke(keyEvent2).booleanValue() && keyEvent.isShiftPressed()) {
                    if (Key.m398equalsimpl0(KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent), MappedKeys.Z)) {
                        return KeyCommand.REDO;
                    }
                } else if (function1.invoke(new androidx.compose.ui.input.key.KeyEvent(keyEvent)).booleanValue()) {
                    long m399getKeyZmokQxo = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.C)) {
                        m398equalsimpl0 = true;
                    } else {
                        m398equalsimpl0 = Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.Insert);
                    }
                    if (m398equalsimpl0) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.V)) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.X)) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.A)) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.Y)) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, MappedKeys.Z)) {
                        return KeyCommand.UNDO;
                    }
                } else if (!keyEvent.isCtrlPressed()) {
                    if (keyEvent.isShiftPressed()) {
                        long m399getKeyZmokQxo2 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionLeft)) {
                            return KeyCommand.SELECT_LEFT_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionRight)) {
                            return KeyCommand.SELECT_RIGHT_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionUp)) {
                            return KeyCommand.SELECT_UP;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.DirectionDown)) {
                            return KeyCommand.SELECT_DOWN;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.PageUp)) {
                            return KeyCommand.SELECT_PAGE_UP;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.PageDown)) {
                            return KeyCommand.SELECT_PAGE_DOWN;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.MoveHome)) {
                            return KeyCommand.SELECT_LINE_START;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.MoveEnd)) {
                            return KeyCommand.SELECT_LINE_END;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo2, MappedKeys.Insert)) {
                            return KeyCommand.PASTE;
                        }
                    } else {
                        long m399getKeyZmokQxo3 = KeyEvent_androidKt.m399getKeyZmokQxo(keyEvent);
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.DirectionLeft)) {
                            return KeyCommand.LEFT_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.DirectionRight)) {
                            return KeyCommand.RIGHT_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.DirectionUp)) {
                            return KeyCommand.UP;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.DirectionDown)) {
                            return KeyCommand.DOWN;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.PageUp)) {
                            return KeyCommand.PAGE_UP;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.PageDown)) {
                            return KeyCommand.PAGE_DOWN;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.MoveHome)) {
                            return KeyCommand.LINE_START;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.MoveEnd)) {
                            return KeyCommand.LINE_END;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Enter)) {
                            return KeyCommand.NEW_LINE;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Backspace)) {
                            return KeyCommand.DELETE_PREV_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Delete)) {
                            return KeyCommand.DELETE_NEXT_CHAR;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Paste)) {
                            return KeyCommand.PASTE;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Cut)) {
                            return KeyCommand.CUT;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Copy)) {
                            return KeyCommand.COPY;
                        }
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo3, MappedKeys.Tab)) {
                            return KeyCommand.TAB;
                        }
                    }
                }
                return null;
            }
        });
    }
}
