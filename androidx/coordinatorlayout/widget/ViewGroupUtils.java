package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class ViewGroupUtils {
    public static final ThreadLocal<Matrix> sMatrix = new ThreadLocal<>();
    public static final ThreadLocal<RectF> sRectF = new ThreadLocal<>();

    public static void offsetDescendantMatrix(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            offsetDescendantMatrix(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
