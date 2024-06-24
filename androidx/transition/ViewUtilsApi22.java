package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
public class ViewUtilsApi22 extends ViewUtilsApi21 {
    public static boolean sTryHiddenSetLeftTopRightBottom = true;

    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(View view, int r3, int r4, int r5, int r6) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                view.setLeftTopRightBottom(r3, r4, r5, r6);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
