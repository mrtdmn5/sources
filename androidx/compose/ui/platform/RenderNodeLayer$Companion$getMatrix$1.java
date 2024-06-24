package androidx.compose.ui.platform;

import android.graphics.Matrix;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RenderNodeLayer.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeLayer$Companion$getMatrix$1 extends Lambda implements Function2<DeviceRenderNode, Matrix, Unit> {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    public RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        DeviceRenderNode rn = deviceRenderNode;
        Matrix matrix2 = matrix;
        Intrinsics.checkNotNullParameter(rn, "rn");
        Intrinsics.checkNotNullParameter(matrix2, "matrix");
        rn.getMatrix(matrix2);
        return Unit.INSTANCE;
    }
}
