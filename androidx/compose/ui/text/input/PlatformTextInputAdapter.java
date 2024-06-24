package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;

/* compiled from: PlatformTextInputAdapter.android.kt */
/* loaded from: classes.dex */
public interface PlatformTextInputAdapter {
    RecordingInputConnection createInputConnection(EditorInfo editorInfo);
}
