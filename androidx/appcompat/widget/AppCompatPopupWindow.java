package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.PopupWindowCompat$Api23Impl;

/* loaded from: classes.dex */
public final class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int r4, int r5) {
        super(context, attributeSet, r4, r5);
        Drawable drawable;
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PopupWindow, r4, r5);
        if (obtainStyledAttributes.hasValue(2)) {
            PopupWindowCompat$Api23Impl.setOverlapAnchor(this, obtainStyledAttributes.getBoolean(2, false));
        }
        if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            drawable = AppCompatResources.getDrawable(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(0);
        }
        setBackgroundDrawable(drawable);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int r2, int r3) {
        super.showAsDropDown(view, r2, r3);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int r2, int r3, int r4, int r5) {
        super.update(view, r2, r3, r4, r5);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int r2, int r3, int r4) {
        super.showAsDropDown(view, r2, r3, r4);
    }
}
