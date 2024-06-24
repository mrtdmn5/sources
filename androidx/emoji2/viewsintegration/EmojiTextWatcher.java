package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class EmojiTextWatcher implements TextWatcher {
    public final EditText mEditText;
    public InitCallbackImpl mInitCallback;
    public final boolean mExpectInitializedEmojiCompat = false;
    public boolean mEnabled = true;

    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {
        public final WeakReference mViewRef;

        public InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            Handler handler;
            EditText editText = (EditText) this.mViewRef.get();
            if (editText == null || (handler = editText.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            EmojiTextWatcher.processTextOnEnablingEvent((EditText) this.mViewRef.get(), 1);
        }
    }

    public EmojiTextWatcher(EditText editText) {
        this.mEditText = editText;
    }

    public static void processTextOnEnablingEvent(EditText editText, int r3) {
        if (r3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int r5, int r6, int r7) {
        boolean z;
        EditText editText = this.mEditText;
        if (!editText.isInEditMode()) {
            if (this.mEnabled && (this.mExpectInitializedEmojiCompat || EmojiCompat.isConfigured())) {
                z = false;
            } else {
                z = true;
            }
            if (!z && r6 <= r7 && (charSequence instanceof Spannable)) {
                int loadState = EmojiCompat.get().getLoadState();
                if (loadState != 0) {
                    if (loadState != 1) {
                        if (loadState != 3) {
                            return;
                        }
                    } else {
                        EmojiCompat.get().process(r5, r7 + r5, (Spannable) charSequence);
                        return;
                    }
                }
                EmojiCompat emojiCompat = EmojiCompat.get();
                if (this.mInitCallback == null) {
                    this.mInitCallback = new InitCallbackImpl(editText);
                }
                emojiCompat.registerInitCallback(this.mInitCallback);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
    }
}
