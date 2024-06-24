package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class ViewUtilsApi29 extends ViewUtilsApi23 {
    @Override // androidx.transition.ViewUtilsApi19
    public final float getTransitionAlpha(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // androidx.transition.ViewUtilsApi22
    public final void setLeftTopRightBottom(View view, int r2, int r3, int r4, int r5) {
        view.setLeftTopRightBottom(r2, r3, r4, r5);
    }

    @Override // androidx.transition.ViewUtilsApi19
    public final void setTransitionAlpha(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsBase
    public final void setTransitionVisibility(int r1, View view) {
        view.setTransitionVisibility(r1);
    }

    @Override // androidx.transition.ViewUtilsApi21
    public final void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi21
    public final void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
