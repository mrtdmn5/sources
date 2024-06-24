package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements OnReceiveContentViewBehavior {
    public final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    public final AppCompatTextClassifierHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            return appCompatTextClassifierHelper.getTextClassifier();
        }
        return super.getTextClassifier();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:            if (r1 != null) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:            r6 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:            if (r1 != null) goto L26;     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            androidx.appcompat.widget.AppCompatTextHelper r1 = r7.mTextHelper
            r1.getClass()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 >= r2) goto L18
            if (r0 == 0) goto L18
            java.lang.CharSequence r3 = r7.getText()
            androidx.core.view.inputmethod.EditorInfoCompat.setInitialSurroundingText(r8, r3)
        L18:
            androidx.appcompat.widget.AppCompatHintHelper.onCreateInputConnection(r7, r8, r0)
            if (r0 == 0) goto L7e
            if (r1 > r2) goto L7e
            java.lang.String[] r2 = androidx.core.view.ViewCompat.getOnReceiveContentMimeTypes(r7)
            if (r2 == 0) goto L7e
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r1 < r5) goto L31
            androidx.core.view.inputmethod.EditorInfoCompat$$ExternalSyntheticApiModelOutline0.m(r8, r2)
            goto L46
        L31:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L3c
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L3c:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r2)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r2)
        L46:
            androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0 r2 = new androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0
            r2.<init>(r7)
            if (r1 < r5) goto L54
            androidx.core.view.inputmethod.InputConnectionCompat$1 r1 = new androidx.core.view.inputmethod.InputConnectionCompat$1
            r1.<init>(r0)
        L52:
            r0 = r1
            goto L7e
        L54:
            java.lang.String[] r6 = androidx.core.view.inputmethod.EditorInfoCompat.EMPTY_STRING_ARRAY
            if (r1 < r5) goto L60
            java.lang.String[] r1 = androidx.core.view.inputmethod.EditorInfoCompat$$ExternalSyntheticApiModelOutline1.m(r8)
            if (r1 == 0) goto L74
        L5e:
            r6 = r1
            goto L74
        L60:
            android.os.Bundle r1 = r8.extras
            if (r1 != 0) goto L65
            goto L74
        L65:
            java.lang.String[] r1 = r1.getStringArray(r4)
            if (r1 != 0) goto L71
            android.os.Bundle r1 = r8.extras
            java.lang.String[] r1 = r1.getStringArray(r3)
        L71:
            if (r1 == 0) goto L74
            goto L5e
        L74:
            int r1 = r6.length
            if (r1 != 0) goto L78
            goto L7e
        L78:
            androidx.core.view.inputmethod.InputConnectionCompat$2 r1 = new androidx.core.view.inputmethod.InputConnectionCompat$2
            r1.<init>(r0)
            goto L52
        L7e:
            androidx.appcompat.widget.AppCompatEmojiEditTextHelper r1 = r7.mAppCompatEmojiEditTextHelper
            android.view.inputmethod.InputConnection r8 = r1.onCreateInputConnection(r0, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AppCompatReceiveContentHelper$OnDropApi24Impl.onDropForTextView(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, contentInfoCompat);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r8) {
        ClipData primaryClip;
        ContentInfoCompat.BuilderCompat builderCompatImpl;
        int r0 = Build.VERSION.SDK_INT;
        int r2 = 0;
        if (r0 < 31 && ViewCompat.getOnReceiveContentMimeTypes(this) != null && (r8 == 16908322 || r8 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                if (r0 >= 31) {
                    builderCompatImpl = new ContentInfoCompat.BuilderCompat31Impl(primaryClip, 1);
                } else {
                    builderCompatImpl = new ContentInfoCompat.BuilderCompatImpl(primaryClip, 1);
                }
                if (r8 != 16908322) {
                    r2 = 1;
                }
                builderCompatImpl.setFlags(r2);
                ViewCompat.performReceiveContent(this, builderCompatImpl.build());
            }
            r2 = 1;
        }
        if (r2 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        super.setBackgroundResource(r2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(r2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int r3) {
        super.setTextAppearance(context, r3);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, r3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            appCompatTextClassifierHelper.mTextClassifier = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, R.attr.editTextStyle);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            int inputType = super.getInputType();
            KeyListener keyListener2 = appCompatEmojiEditTextHelper.getKeyListener(keyListener);
            if (keyListener2 == keyListener) {
                return;
            }
            super.setKeyListener(keyListener2);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}
