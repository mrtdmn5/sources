package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiInputConnection extends InputConnectionWrapper {
    public final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    public final TextView mTextView;

    /* loaded from: classes.dex */
    public static class EmojiCompatDeleteHelper {
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0050, code lost:            if (java.lang.Character.isHighSurrogate(r5) != false) goto L38;     */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x008d, code lost:            if (java.lang.Character.isLowSurrogate(r5) != false) goto L64;     */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0080, code lost:            if (r11 != false) goto L72;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean handleDeleteSurroundingText(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.viewsintegration.EmojiInputConnection.EmojiCompatDeleteHelper.handleDeleteSurroundingText(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiInputConnection(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        EmojiCompatDeleteHelper emojiCompatDeleteHelper = new EmojiCompatDeleteHelper();
        this.mTextView = editText;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r3, int r4) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        if (!EmojiCompatDeleteHelper.handleDeleteSurroundingText(this, editableText, r3, r4, false) && !super.deleteSurroundingText(r3, r4)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int r3, int r4) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        if (EmojiCompatDeleteHelper.handleDeleteSurroundingText(this, editableText, r3, r4, true) || super.deleteSurroundingTextInCodePoints(r3, r4)) {
            return true;
        }
        return false;
    }
}
