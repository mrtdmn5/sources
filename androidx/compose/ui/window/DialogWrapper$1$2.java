package androidx.compose.ui.window;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class DialogWrapper$1$2 extends ViewOutlineProvider {
    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(result, "result");
        result.setRect(0, 0, view.getWidth(), view.getHeight());
        result.setAlpha(0.0f);
    }
}
