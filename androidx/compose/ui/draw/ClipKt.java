package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clip.kt */
/* loaded from: classes.dex */
public final class ClipKt {
    public static final Modifier clip(Modifier modifier, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return GraphicsLayerModifierKt.m331graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, shape, true, 0, 124927);
    }

    public static final Modifier clipToBounds(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return GraphicsLayerModifierKt.m331graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, null, true, 0, 126975);
    }
}
