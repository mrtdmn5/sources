package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;

/* loaded from: classes.dex */
public final class AppCompatCheckedTextViewHelper {
    public ColorStateList mCheckMarkTintList = null;
    public PorterDuff.Mode mCheckMarkTintMode = null;
    public boolean mHasCheckMarkTint = false;
    public boolean mHasCheckMarkTintMode = false;
    public boolean mSkipNextApply;
    public final CheckedTextView mView;

    public AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.mView = checkedTextView;
    }

    public final void applyCheckMarkTint() {
        CheckedTextView checkedTextView = this.mView;
        Drawable checkMarkDrawable = checkedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.mHasCheckMarkTint || this.mHasCheckMarkTintMode) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.mHasCheckMarkTint) {
                    DrawableCompat$Api21Impl.setTintList(mutate, this.mCheckMarkTintList);
                }
                if (this.mHasCheckMarkTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(mutate, this.mCheckMarkTintMode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(checkedTextView.getDrawableState());
                }
                checkedTextView.setCheckMarkDrawable(mutate);
            }
        }
    }
}
