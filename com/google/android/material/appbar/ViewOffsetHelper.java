package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class ViewOffsetHelper {
    public int layoutLeft;
    public int layoutTop;
    public int offsetTop;
    public final View view;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    public final void applyOffsets() {
        int r0 = this.offsetTop;
        View view = this.view;
        int top = r0 - (view.getTop() - this.layoutTop);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.layoutLeft));
    }
}
