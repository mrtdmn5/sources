package androidx.compose.ui.platform;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    public final void setOutlineAmbientShadowColor(View view, int r3) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOutlineAmbientShadowColor(r3);
    }

    public final void setOutlineSpotShadowColor(View view, int r3) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOutlineSpotShadowColor(r3);
    }
}
