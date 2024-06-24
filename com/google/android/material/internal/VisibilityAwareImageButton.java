package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class VisibilityAwareImageButton extends ImageButton {
    public int userSetVisibility;

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int r1, boolean z) {
        super.setVisibility(r1);
        if (z) {
            this.userSetVisibility = r1;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r2) {
        internalSetVisibility(r2, true);
    }
}
