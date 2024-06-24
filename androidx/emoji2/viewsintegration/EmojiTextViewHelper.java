package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {
    public final HelperInternal mHelper;

    /* loaded from: classes.dex */
    public static class HelperInternal {
        public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean isEnabled() {
            throw null;
        }

        public void setAllCaps(boolean z) {
            throw null;
        }

        public void setEnabled(boolean z) {
            throw null;
        }

        public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class HelperInternal19 extends HelperInternal {
        public final EmojiInputFilter mEmojiInputFilter;
        public boolean mEnabled = true;
        public final TextView mTextView;

        public HelperInternal19(TextView textView) {
            this.mTextView = textView;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            if (!this.mEnabled) {
                SparseArray sparseArray = new SparseArray(1);
                for (int r2 = 0; r2 < inputFilterArr.length; r2++) {
                    InputFilter inputFilter = inputFilterArr[r2];
                    if (inputFilter instanceof EmojiInputFilter) {
                        sparseArray.put(r2, inputFilter);
                    }
                }
                if (sparseArray.size() != 0) {
                    int length = inputFilterArr.length;
                    InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                    int r4 = 0;
                    for (int r1 = 0; r1 < length; r1++) {
                        if (sparseArray.indexOfKey(r1) < 0) {
                            inputFilterArr2[r4] = inputFilterArr[r1];
                            r4++;
                        }
                    }
                    return inputFilterArr2;
                }
                return inputFilterArr;
            }
            int length2 = inputFilterArr.length;
            int r3 = 0;
            while (true) {
                EmojiInputFilter emojiInputFilter = this.mEmojiInputFilter;
                if (r3 < length2) {
                    if (inputFilterArr[r3] != emojiInputFilter) {
                        r3++;
                    } else {
                        return inputFilterArr;
                    }
                } else {
                    InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = emojiInputFilter;
                    return inputFilterArr3;
                }
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final boolean isEnabled() {
            return this.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void setAllCaps(boolean z) {
            if (z) {
                TextView textView = this.mTextView;
                textView.setTransformationMethod(wrapTransformationMethod(textView.getTransformationMethod()));
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void setEnabled(boolean z) {
            this.mEnabled = z;
            TextView textView = this.mTextView;
            textView.setTransformationMethod(wrapTransformationMethod(textView.getTransformationMethod()));
            textView.setFilters(getFilters(textView.getFilters()));
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            if (this.mEnabled) {
                if (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                    return new EmojiTransformationMethod(transformationMethod);
                }
                return transformationMethod;
            }
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return ((EmojiTransformationMethod) transformationMethod).mTransformationMethod;
            }
            return transformationMethod;
        }
    }

    /* loaded from: classes.dex */
    public static class SkippingHelper19 extends HelperInternal {
        public final HelperInternal19 mHelperDelegate;

        public SkippingHelper19(TextView textView) {
            this.mHelperDelegate = new HelperInternal19(textView);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            if (!EmojiCompat.isConfigured()) {
                return inputFilterArr;
            }
            return this.mHelperDelegate.getFilters(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final boolean isEnabled() {
            return this.mHelperDelegate.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void setAllCaps(boolean z) {
            if (!EmojiCompat.isConfigured()) {
                return;
            }
            this.mHelperDelegate.setAllCaps(z);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void setEnabled(boolean z) {
            boolean z2 = !EmojiCompat.isConfigured();
            HelperInternal19 helperInternal19 = this.mHelperDelegate;
            if (z2) {
                helperInternal19.mEnabled = z;
            } else {
                helperInternal19.setEnabled(z);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            if (!EmojiCompat.isConfigured()) {
                return transformationMethod;
            }
            return this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
        }
    }

    public EmojiTextViewHelper(TextView textView) {
        if (textView != null) {
            this.mHelper = new SkippingHelper19(textView);
            return;
        }
        throw new NullPointerException("textView cannot be null");
    }
}
