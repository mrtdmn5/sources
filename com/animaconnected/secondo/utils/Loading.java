package com.animaconnected.secondo.utils;

import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountUtils.kt */
/* loaded from: classes3.dex */
public final class Loading {
    public static final int $stable = 8;
    private final View button;
    private boolean isInitialState;
    private final View progress;

    public Loading(View button, View progress, boolean z) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.button = button;
        this.progress = progress;
        this.isInitialState = z;
    }

    private final void startLoading() {
        ViewKt.visible(this.progress);
        this.button.setEnabled(false);
    }

    private final void stopLoading() {
        ViewKt.gone(this.progress);
        this.button.setEnabled(true);
    }

    public final void invalidate(boolean z) {
        if (this.isInitialState) {
            this.isInitialState = false;
        } else if (z) {
            startLoading();
        } else {
            stopLoading();
        }
    }

    public /* synthetic */ Loading(View view, View view2, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, (r4 & 4) != 0 ? true : z);
    }
}
