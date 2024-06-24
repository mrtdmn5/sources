package com.google.android.material.textfield;

/* loaded from: classes3.dex */
public final class CustomEndIconDelegate extends EndIconDelegate {
    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int r0 = this.customEndIcon;
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(r0);
        textInputLayout.setEndIconOnClickListener(null);
        textInputLayout.setEndIconOnLongClickListener(null);
    }
}
