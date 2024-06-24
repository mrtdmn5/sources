package androidx.compose.ui.platform;

import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderNodeLayer.android.kt */
/* loaded from: classes.dex */
public final class WrapperRenderNodeLayerHelperMethods {
    public static final WrapperRenderNodeLayerHelperMethods INSTANCE = new WrapperRenderNodeLayerHelperMethods();

    public final void onDescendantInvalidated(AndroidComposeView ownerView) {
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        ViewParent parent = ownerView.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(ownerView, ownerView);
        }
    }
}
