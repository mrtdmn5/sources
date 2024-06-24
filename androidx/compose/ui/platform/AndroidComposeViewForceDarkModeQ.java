package androidx.compose.ui.platform;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewForceDarkModeQ {
    public static final AndroidComposeViewForceDarkModeQ INSTANCE = new AndroidComposeViewForceDarkModeQ();

    public final void disallowForceDark(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setForceDarkAllowed(false);
    }
}
