package com.animaconnected.widget.theme;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Shapes;

/* compiled from: Shapes.kt */
/* loaded from: classes3.dex */
public final class ShapesKt {
    private static final Shapes BasicRoundShapes;
    private static final Shapes BasicSharpShapes;
    private static final Shapes LotusRoundShapes;

    static {
        float f = 16;
        float f2 = 24;
        BasicRoundShapes = new Shapes(RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(12), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f2));
        LotusRoundShapes = new Shapes(RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f2), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f2));
        float f3 = 0;
        BasicSharpShapes = new Shapes(RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f3), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f3), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f3));
    }

    public static final Shapes getBasicRoundShapes() {
        return BasicRoundShapes;
    }

    public static final Shapes getBasicSharpShapes() {
        return BasicSharpShapes;
    }

    public static final Shapes getLotusRoundShapes() {
        return LotusRoundShapes;
    }
}
