package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes3.dex */
public abstract class EndIconDelegate {
    public final Context context;
    public final int customEndIcon;
    public final CheckableImageButton endIconView;
    public final TextInputLayout textInputLayout;

    public EndIconDelegate(TextInputLayout textInputLayout, int r3) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
        this.customEndIcon = r3;
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int r1) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean z) {
    }
}
