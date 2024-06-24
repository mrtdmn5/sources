package androidx.compose.ui.platform;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewVerificationHelperMethodsO {
    public static final AndroidComposeViewVerificationHelperMethodsO INSTANCE = new AndroidComposeViewVerificationHelperMethodsO();

    public final void focusable(View view, int r3, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(r3);
        view.setDefaultFocusHighlightEnabled(z);
    }
}
