package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayer$Companion$OutlineProvider$1 extends ViewOutlineProvider {
    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Outline outline2 = ((ViewLayer) view).outlineResolver.getOutline();
        Intrinsics.checkNotNull(outline2);
        outline.set(outline2);
    }
}
