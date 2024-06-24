package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes.dex */
public final class AppCompatCheckedTextView extends CheckedTextView {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final AppCompatCheckedTextViewHelper mCheckedHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081 A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0047, B:5:0x004e, B:8:0x0054, B:10:0x0063, B:12:0x0069, B:14:0x006f, B:15:0x007a, B:17:0x0081, B:18:0x0088, B:20:0x008f), top: B:2:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0047, B:5:0x004e, B:8:0x0054, B:10:0x0063, B:12:0x0069, B:14:0x006f, B:15:0x007a, B:17:0x0081, B:18:0x0088, B:20:0x008f), top: B:2:0x0047 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatCheckedTextView(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            androidx.appcompat.widget.TintContextWrapper.wrap(r8)
            r0 = 2130968747(0x7f0400ab, float:1.7546156E38)
            r7.<init>(r8, r9, r0)
            android.content.Context r8 = r7.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r8, r7)
            androidx.appcompat.widget.AppCompatTextHelper r8 = new androidx.appcompat.widget.AppCompatTextHelper
            r8.<init>(r7)
            r7.mTextHelper = r8
            r8.loadFromAttributes(r9, r0)
            r8.applyCompoundDrawablesTints()
            androidx.appcompat.widget.AppCompatBackgroundHelper r8 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r8.<init>(r7)
            r7.mBackgroundTintHelper = r8
            r8.loadFromAttributes(r9, r0)
            androidx.appcompat.widget.AppCompatCheckedTextViewHelper r8 = new androidx.appcompat.widget.AppCompatCheckedTextViewHelper
            r8.<init>(r7)
            r7.mCheckedHelper = r8
            android.content.Context r8 = r7.getContext()
            int[] r3 = androidx.appcompat.R$styleable.CheckedTextView
            androidx.appcompat.widget.TintTypedArray r8 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r8, r9, r3, r0)
            android.content.Context r2 = r7.getContext()
            android.content.res.TypedArray r5 = r8.mWrapped
            r6 = 2130968747(0x7f0400ab, float:1.7546156E38)
            r1 = r7
            r4 = r9
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6)
            r1 = 1
            boolean r2 = r8.hasValue(r1)     // Catch: java.lang.Throwable -> La7
            r3 = 0
            if (r2 == 0) goto L60
            int r2 = r8.getResourceId(r1, r3)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L60
            android.content.Context r4 = r7.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L60 java.lang.Throwable -> La7
            android.graphics.drawable.Drawable r2 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r4, r2)     // Catch: android.content.res.Resources.NotFoundException -> L60 java.lang.Throwable -> La7
            r7.setCheckMarkDrawable(r2)     // Catch: android.content.res.Resources.NotFoundException -> L60 java.lang.Throwable -> La7
            goto L61
        L60:
            r1 = r3
        L61:
            if (r1 != 0) goto L7a
            boolean r1 = r8.hasValue(r3)     // Catch: java.lang.Throwable -> La7
            if (r1 == 0) goto L7a
            int r1 = r8.getResourceId(r3, r3)     // Catch: java.lang.Throwable -> La7
            if (r1 == 0) goto L7a
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> La7
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r2, r1)     // Catch: java.lang.Throwable -> La7
            r7.setCheckMarkDrawable(r1)     // Catch: java.lang.Throwable -> La7
        L7a:
            r1 = 2
            boolean r2 = r8.hasValue(r1)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L88
            android.content.res.ColorStateList r1 = r8.getColorStateList(r1)     // Catch: java.lang.Throwable -> La7
            r7.setCheckMarkTintList(r1)     // Catch: java.lang.Throwable -> La7
        L88:
            r1 = 3
            boolean r2 = r8.hasValue(r1)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L9c
            r2 = -1
            int r1 = r8.getInt(r1, r2)     // Catch: java.lang.Throwable -> La7
            r2 = 0
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r1, r2)     // Catch: java.lang.Throwable -> La7
            r7.setCheckMarkTintMode(r1)     // Catch: java.lang.Throwable -> La7
        L9c:
            r8.recycle()
            androidx.appcompat.widget.AppCompatEmojiTextHelper r8 = r7.getEmojiTextViewHelper()
            r8.loadFromAttributes(r9, r0)
            return
        La7:
            r9 = move-exception
            r8.recycle()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.applyCheckMarkTint();
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

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.mCheckMarkTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.mCheckMarkTintMode;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AppCompatHintHelper.onCreateInputConnection(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            if (appCompatCheckedTextViewHelper.mSkipNextApply) {
                appCompatCheckedTextViewHelper.mSkipNextApply = false;
            } else {
                appCompatCheckedTextViewHelper.mSkipNextApply = true;
                appCompatCheckedTextViewHelper.applyCheckMarkTint();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.mCheckMarkTintList = colorStateList;
            appCompatCheckedTextViewHelper.mHasCheckMarkTint = true;
            appCompatCheckedTextViewHelper.applyCheckMarkTint();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.mCheckedHelper;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.mCheckMarkTintMode = mode;
            appCompatCheckedTextViewHelper.mHasCheckMarkTintMode = true;
            appCompatCheckedTextViewHelper.applyCheckMarkTint();
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int r2) {
        setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }
}
