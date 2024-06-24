package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.emoji2.viewsintegration.EmojiKeyListener;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class AppCompatEmojiEditTextHelper {
    public final EmojiEditTextHelper mEmojiEditTextHelper;
    public final EditText mView;

    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText);
    }

    public final KeyListener getKeyListener(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            this.mEmojiEditTextHelper.mHelper.getClass();
            if (!(keyListener instanceof EmojiKeyListener)) {
                if (keyListener == null) {
                    return null;
                }
                if (!(keyListener instanceof NumberKeyListener)) {
                    return new EmojiKeyListener(keyListener);
                }
                return keyListener;
            }
            return keyListener;
        }
        return keyListener;
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int r5) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, r5, 0);
        try {
            boolean z = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        EmojiEditTextHelper emojiEditTextHelper = this.mEmojiEditTextHelper;
        if (inputConnection == null) {
            emojiEditTextHelper.getClass();
            return null;
        }
        EmojiEditTextHelper.HelperInternal19 helperInternal19 = emojiEditTextHelper.mHelper;
        helperInternal19.getClass();
        if (!(inputConnection instanceof EmojiInputConnection)) {
            return new EmojiInputConnection(helperInternal19.mEditText, inputConnection, editorInfo);
        }
        return inputConnection;
    }

    public final void setEnabled(boolean z) {
        EmojiTextWatcher emojiTextWatcher = this.mEmojiEditTextHelper.mHelper.mTextWatcher;
        if (emojiTextWatcher.mEnabled != z) {
            if (emojiTextWatcher.mInitCallback != null) {
                EmojiCompat emojiCompat = EmojiCompat.get();
                EmojiTextWatcher.InitCallbackImpl initCallbackImpl = emojiTextWatcher.mInitCallback;
                emojiCompat.getClass();
                Preconditions.checkNotNull(initCallbackImpl, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = emojiCompat.mInitLock;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    emojiCompat.mInitCallbacks.remove(initCallbackImpl);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            emojiTextWatcher.mEnabled = z;
            if (z) {
                EmojiTextWatcher.processTextOnEnablingEvent(emojiTextWatcher.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }
}
