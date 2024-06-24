package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;

/* compiled from: InputMethodManager.kt */
/* loaded from: classes.dex */
public interface InputMethodManager {
    void hideSoftInput();

    void restartInput();

    void showSoftInput();

    void updateExtractedText(int r1, ExtractedText extractedText);

    void updateSelection(int r1, int r2, int r3, int r4);
}
