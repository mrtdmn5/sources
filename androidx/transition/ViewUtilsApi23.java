package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class ViewUtilsApi23 extends ViewUtilsApi22 {
    public static boolean sTryHiddenSetTransitionVisibility = true;

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(int r3, View view) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(r3, view);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                view.setTransitionVisibility(r3);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
