package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
public class ViewUtilsApi19 extends ViewUtilsBase {
    public static boolean sTryHiddenTransitionAlpha = true;

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(View view) {
        float transitionAlpha;
        if (sTryHiddenTransitionAlpha) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }
}
