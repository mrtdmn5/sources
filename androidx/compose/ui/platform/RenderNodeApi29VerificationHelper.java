package androidx.compose.ui.platform;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderNodeApi29.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeApi29VerificationHelper {
    public static final RenderNodeApi29VerificationHelper INSTANCE = new RenderNodeApi29VerificationHelper();

    public final void setRenderEffect(RenderNode renderNode, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.setRenderEffect(null);
    }
}
