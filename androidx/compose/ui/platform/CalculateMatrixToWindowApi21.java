package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    public final int[] tmpLocation = new int[2];
    public final float[] tmpMatrix = Matrix.m337constructorimpl$default();

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public final void mo493calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Matrix.m340resetimpl(matrix);
        m495transformMatrixToWindowEL8BTi8(view, matrix);
    }

    /* renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    public final void m494preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        float[] fArr2 = this.tmpMatrix;
        Matrix.m340resetimpl(fArr2);
        Matrix.m341translateimpl$default(fArr2, f, f2);
        AndroidComposeView_androidKt.m491access$preTransformJiSxe2E(fArr, fArr2);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    public final void m495transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m495transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m494preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m494preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m494preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m494preTranslate3XD1CNM(fArr, r0[0], r0[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr2 = this.tmpMatrix;
            AndroidMatrixConversions_androidKt.m291setFromtUYjHk(matrix, fArr2);
            AndroidComposeView_androidKt.m491access$preTransformJiSxe2E(fArr, fArr2);
        }
    }
}
