package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl30 extends WindowInsetsControllerCompat$Impl {
    public final WindowInsetsController mInsetsController;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl30(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        new SimpleArrayMap();
        this.mInsetsController = insetsController;
        this.mWindow = window;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void hide() {
        this.mInsetsController.hide(1);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightNavigationBars(boolean z) {
        WindowInsetsController windowInsetsController = this.mInsetsController;
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightStatusBars(boolean z) {
        WindowInsetsController windowInsetsController = this.mInsetsController;
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | DfuBaseService.ERROR_REMOTE_MASK);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setSystemBarsBehavior() {
        this.mInsetsController.setSystemBarsBehavior(2);
    }
}
