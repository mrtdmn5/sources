package androidx.core.view;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl20 extends WindowInsetsControllerCompat$Impl {
    public final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
        this.mWindow = window;
        this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void hide() {
        for (int r1 = 1; r1 <= 256; r1 <<= 1) {
            if ((1 & r1) != 0) {
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 == 8) {
                            this.mSoftwareKeyboardControllerCompat.mImpl.hide();
                        }
                    } else {
                        setSystemUiFlag(2);
                    }
                } else {
                    setSystemUiFlag(4);
                }
            }
        }
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setSystemBarsBehavior() {
        unsetSystemUiFlag(2048);
        setSystemUiFlag(4096);
    }

    public final void setSystemUiFlag(int r3) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility(r3 | decorView.getSystemUiVisibility());
    }

    public final void unsetSystemUiFlag(int r3) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~r3) & decorView.getSystemUiVisibility());
    }
}
