package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class EmojiInputFilter implements InputFilter {
    public InitCallbackImpl mInitCallback;
    public final TextView mTextView;

    /* loaded from: classes.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {
        public final WeakReference mEmojiInputFilterReference;
        public final WeakReference mViewRef;

        public InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.mViewRef = new WeakReference(textView);
            this.mEmojiInputFilterReference = new WeakReference(emojiInputFilter);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            Handler handler;
            TextView textView = (TextView) this.mViewRef.get();
            if (textView != null && (handler = textView.getHandler()) != null) {
                handler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            CharSequence text;
            CharSequence process;
            InputFilter[] filters;
            TextView textView = (TextView) this.mViewRef.get();
            InputFilter inputFilter = (InputFilter) this.mEmojiInputFilterReference.get();
            boolean z = false;
            if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
                int r4 = 0;
                while (true) {
                    if (r4 >= filters.length) {
                        break;
                    }
                    if (filters[r4] == inputFilter) {
                        z = true;
                        break;
                    }
                    r4++;
                }
            }
            if (!z || !textView.isAttachedToWindow() || text == (process = EmojiCompat.get().process((text = textView.getText())))) {
                return;
            }
            int selectionStart = Selection.getSelectionStart(process);
            int selectionEnd = Selection.getSelectionEnd(process);
            textView.setText(process);
            if (process instanceof Spannable) {
                Spannable spannable = (Spannable) process;
                if (selectionStart >= 0 && selectionEnd >= 0) {
                    Selection.setSelection(spannable, selectionStart, selectionEnd);
                } else if (selectionStart >= 0) {
                    Selection.setSelection(spannable, selectionStart);
                } else if (selectionEnd >= 0) {
                    Selection.setSelection(spannable, selectionEnd);
                }
            }
        }
    }

    public EmojiInputFilter(TextView textView) {
        this.mTextView = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int r5, int r6, Spanned spanned, int r8, int r9) {
        TextView textView = this.mTextView;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            boolean z = true;
            if (loadState != 1) {
                if (loadState != 3) {
                    return charSequence;
                }
            } else {
                if (r9 == 0 && r8 == 0 && spanned.length() == 0 && charSequence == textView.getText()) {
                    z = false;
                }
                if (z && charSequence != null) {
                    if (r5 != 0 || r6 != charSequence.length()) {
                        charSequence = charSequence.subSequence(r5, r6);
                    }
                    return EmojiCompat.get().process(0, charSequence.length(), charSequence);
                }
                return charSequence;
            }
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(textView, this);
        }
        emojiCompat.registerInitCallback(this.mInitCallback);
        return charSequence;
    }
}
