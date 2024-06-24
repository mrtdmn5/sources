package androidx.compose.ui.platform;

import android.view.RenderNode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderNodeApi23.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeVerificationHelper28 {
    public static final RenderNodeVerificationHelper28 INSTANCE = new RenderNodeVerificationHelper28();

    public final int getAmbientShadowColor(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        return renderNode.getAmbientShadowColor();
    }

    public final int getSpotShadowColor(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        return renderNode.getSpotShadowColor();
    }

    public final void setAmbientShadowColor(RenderNode renderNode, int r3) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.setAmbientShadowColor(r3);
    }

    public final void setSpotShadowColor(RenderNode renderNode, int r3) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        renderNode.setSpotShadowColor(r3);
    }
}
