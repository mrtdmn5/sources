package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ViewLayer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayer$Companion$getMatrix$1 extends Lambda implements Function2<View, Matrix, Unit> {
    public static final ViewLayer$Companion$getMatrix$1 INSTANCE = new ViewLayer$Companion$getMatrix$1();

    public ViewLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(View view, Matrix matrix) {
        View view2 = view;
        Matrix matrix2 = matrix;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(matrix2, "matrix");
        matrix2.set(view2.getMatrix());
        return Unit.INSTANCE;
    }
}
