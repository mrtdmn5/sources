package androidx.core.view;

import android.view.Window;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl26 extends WindowInsetsControllerCompat$Impl23 {
    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightNavigationBars(boolean z) {
        if (z) {
            Window window = this.mWindow;
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        }
        unsetSystemUiFlag(16);
    }
}
