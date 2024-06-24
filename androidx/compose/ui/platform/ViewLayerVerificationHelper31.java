package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayerVerificationHelper31 {
    public static final ViewLayerVerificationHelper31 INSTANCE = new ViewLayerVerificationHelper31();

    public final void setRenderEffect(View view, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRenderEffect(null);
    }
}
