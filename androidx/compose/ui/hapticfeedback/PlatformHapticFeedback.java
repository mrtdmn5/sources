package androidx.compose.ui.hapticfeedback;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformHapticFeedback.android.kt */
/* loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public final View view;

    public PlatformHapticFeedback(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public final void mo396performHapticFeedbackCdsT49E() {
        this.view.performHapticFeedback(9);
    }
}
