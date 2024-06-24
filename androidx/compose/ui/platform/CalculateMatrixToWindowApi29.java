package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class CalculateMatrixToWindowApi29 implements CalculateMatrixToWindow {
    public final Matrix tmpMatrix = new Matrix();
    public final int[] tmpPosition = new int[2];

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo493calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Matrix matrix2 = this.tmpMatrix;
        matrix2.reset();
        view.transformMatrixToGlobal(matrix2);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        int[] r1 = this.tmpPosition;
        view.getLocationOnScreen(r1);
        int r3 = r1[0];
        int r5 = r1[1];
        view.getLocationInWindow(r1);
        matrix2.postTranslate(r1[0] - r3, r1[1] - r5);
        AndroidMatrixConversions_androidKt.m291setFromtUYjHk(matrix2, matrix);
    }
}
