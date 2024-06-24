package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.ArrayList;

/* compiled from: InputEventCallback2.android.kt */
/* loaded from: classes.dex */
public interface InputEventCallback2 {
    void onConnectionClosed(RecordingInputConnection recordingInputConnection);

    void onEditCommands(ArrayList arrayList);

    /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void mo543onImeActionKlQnJC8(int r1);

    void onKeyEvent(KeyEvent keyEvent);
}
