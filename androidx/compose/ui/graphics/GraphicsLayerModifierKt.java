package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: GraphicsLayerModifier.kt */
/* loaded from: classes.dex */
public final class GraphicsLayerModifierKt {
    public static final Modifier graphicsLayer(Modifier modifier, Function1<? super GraphicsLayerScope, Unit> block) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return modifier.then(new BlockGraphicsLayerElement(block));
    }

    /* renamed from: graphicsLayer-Ap8cVGQ$default, reason: not valid java name */
    public static Modifier m331graphicsLayerAp8cVGQ$default(Modifier graphicsLayer, float f, float f2, float f3, Shape shape, boolean z, int r30, int r31) {
        float f4;
        float f5;
        float f6;
        float f7;
        long j;
        Shape shape2;
        boolean z2;
        long j2;
        long j3;
        int r23;
        if ((r31 & 1) != 0) {
            f4 = 1.0f;
        } else {
            f4 = f;
        }
        if ((r31 & 2) != 0) {
            f5 = 1.0f;
        } else {
            f5 = f2;
        }
        if ((r31 & 4) != 0) {
            f6 = 1.0f;
        } else {
            f6 = f3;
        }
        if ((r31 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            f7 = 8.0f;
        } else {
            f7 = 0.0f;
        }
        float f8 = f7;
        if ((r31 & 1024) != 0) {
            j = TransformOrigin.Center;
        } else {
            j = 0;
        }
        if ((r31 & 2048) != 0) {
            shape2 = RectangleShapeKt.RectangleShape;
        } else {
            shape2 = shape;
        }
        if ((r31 & 4096) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((r31 & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
            j2 = GraphicsLayerScopeKt.DefaultShadowColor;
        } else {
            j2 = 0;
        }
        if ((32768 & r31) != 0) {
            j3 = GraphicsLayerScopeKt.DefaultShadowColor;
        } else {
            j3 = 0;
        }
        if ((r31 & 65536) != 0) {
            r23 = 0;
        } else {
            r23 = r30;
        }
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape2, "shape");
        return graphicsLayer.then(new GraphicsLayerElement(f4, f5, f6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f8, j, shape2, z2, j2, j3, r23));
    }
}
