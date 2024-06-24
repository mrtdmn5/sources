package androidx.core.view;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class WindowCompat$Api16Impl {
    public static void setDecorFitsSystemWindows(Window window, boolean z) {
        int r2;
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            r2 = systemUiVisibility & (-1793);
        } else {
            r2 = systemUiVisibility | 1792;
        }
        decorView.setSystemUiVisibility(r2);
    }
}
