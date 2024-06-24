package androidx.core.view;

import android.view.Window;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl23 extends WindowInsetsControllerCompat$Impl20 {
    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightStatusBars(boolean z) {
        if (z) {
            Window window = this.mWindow;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            setSystemUiFlag(DfuBaseService.ERROR_REMOTE_MASK);
            return;
        }
        unsetSystemUiFlag(DfuBaseService.ERROR_REMOTE_MASK);
    }
}
