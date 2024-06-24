package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.widget.CompoundButtonCompat$Api23Impl;

/* loaded from: classes.dex */
public final class AppCompatCompoundButtonHelper {
    public ColorStateList mButtonTintList = null;
    public PorterDuff.Mode mButtonTintMode = null;
    public boolean mHasButtonTint = false;
    public boolean mHasButtonTintMode = false;
    public boolean mSkipNextApply;
    public final CompoundButton mView;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public final void applyButtonTint() {
        CompoundButton compoundButton = this.mView;
        Drawable buttonDrawable = CompoundButtonCompat$Api23Impl.getButtonDrawable(compoundButton);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable mutate = buttonDrawable.mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat$Api21Impl.setTintList(mutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(mutate, this.mButtonTintMode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:3:0x0019, B:5:0x0020, B:8:0x0026, B:10:0x0035, B:12:0x003b, B:14:0x0041, B:15:0x004c, B:17:0x0053, B:18:0x005a, B:20:0x0061), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:3:0x0019, B:5:0x0020, B:8:0x0026, B:10:0x0035, B:12:0x003b, B:14:0x0041, B:15:0x004c, B:17:0x0053, B:18:0x005a, B:20:0x0061), top: B:2:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void loadFromAttributes(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.CompoundButton r6 = r8.mView
            android.content.Context r0 = r6.getContext()
            int[] r2 = androidx.appcompat.R$styleable.CompoundButton
            androidx.appcompat.widget.TintTypedArray r7 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r9, r2, r10)
            android.content.Context r1 = r6.getContext()
            android.content.res.TypedArray r4 = r7.mWrapped
            r0 = r6
            r3 = r9
            r5 = r10
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r0, r1, r2, r3, r4, r5)
            r9 = 1
            boolean r10 = r7.hasValue(r9)     // Catch: java.lang.Throwable -> L72
            r0 = 0
            if (r10 == 0) goto L32
            int r10 = r7.getResourceId(r9, r0)     // Catch: java.lang.Throwable -> L72
            if (r10 == 0) goto L32
            android.content.Context r1 = r6.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L32 java.lang.Throwable -> L72
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch: android.content.res.Resources.NotFoundException -> L32 java.lang.Throwable -> L72
            r6.setButtonDrawable(r10)     // Catch: android.content.res.Resources.NotFoundException -> L32 java.lang.Throwable -> L72
            goto L33
        L32:
            r9 = r0
        L33:
            if (r9 != 0) goto L4c
            boolean r9 = r7.hasValue(r0)     // Catch: java.lang.Throwable -> L72
            if (r9 == 0) goto L4c
            int r9 = r7.getResourceId(r0, r0)     // Catch: java.lang.Throwable -> L72
            if (r9 == 0) goto L4c
            android.content.Context r10 = r6.getContext()     // Catch: java.lang.Throwable -> L72
            android.graphics.drawable.Drawable r9 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r10, r9)     // Catch: java.lang.Throwable -> L72
            r6.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L72
        L4c:
            r9 = 2
            boolean r10 = r7.hasValue(r9)     // Catch: java.lang.Throwable -> L72
            if (r10 == 0) goto L5a
            android.content.res.ColorStateList r9 = r7.getColorStateList(r9)     // Catch: java.lang.Throwable -> L72
            androidx.core.widget.CompoundButtonCompat$Api21Impl.setButtonTintList(r6, r9)     // Catch: java.lang.Throwable -> L72
        L5a:
            r9 = 3
            boolean r10 = r7.hasValue(r9)     // Catch: java.lang.Throwable -> L72
            if (r10 == 0) goto L6e
            r10 = -1
            int r9 = r7.getInt(r9, r10)     // Catch: java.lang.Throwable -> L72
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r9, r10)     // Catch: java.lang.Throwable -> L72
            androidx.core.widget.CompoundButtonCompat$Api21Impl.setButtonTintMode(r6, r9)     // Catch: java.lang.Throwable -> L72
        L6e:
            r7.recycle()
            return
        L72:
            r9 = move-exception
            r7.recycle()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }
}
