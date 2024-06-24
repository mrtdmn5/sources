package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class NoEndIconDelegate extends EndIconDelegate {
    public NoEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconOnClickListener(null);
        textInputLayout.setEndIconDrawable((Drawable) null);
        textInputLayout.setEndIconContentDescription((CharSequence) null);
    }
}
