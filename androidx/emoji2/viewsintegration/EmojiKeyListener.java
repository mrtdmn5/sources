package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;

/* loaded from: classes.dex */
public final class EmojiKeyListener implements KeyListener {
    public final EmojiCompatHandleKeyDownHelper mEmojiCompatHandleKeyDownHelper;
    public final KeyListener mKeyListener;

    /* loaded from: classes.dex */
    public static class EmojiCompatHandleKeyDownHelper {
    }

    public EmojiKeyListener(KeyListener keyListener) {
        EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper = new EmojiCompatHandleKeyDownHelper();
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = emojiCompatHandleKeyDownHelper;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int r4) {
        this.mKeyListener.clearMetaKeyState(view, editable, r4);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int r6, KeyEvent keyEvent) {
        boolean delete;
        boolean z;
        this.mEmojiCompatHandleKeyDownHelper.getClass();
        Object obj = EmojiCompat.INSTANCE_LOCK;
        if (r6 != 67) {
            if (r6 != 112) {
                delete = false;
            } else {
                delete = EmojiProcessor.delete(editable, keyEvent, true);
            }
        } else {
            delete = EmojiProcessor.delete(editable, keyEvent, false);
        }
        if (delete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        if (!z && !this.mKeyListener.onKeyDown(view, editable, r6, keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int r4, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, r4, keyEvent);
    }
}
