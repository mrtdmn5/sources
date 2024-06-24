package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    public final Impl20 mImpl;

    /* loaded from: classes.dex */
    public static class Impl {
    }

    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        public final View mView;

        public Impl20(View view) {
            this.mView = view;
        }

        public void hide() {
            View view = this.mView;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Impl30 extends Impl20 {
        public final View mView;

        public Impl30(View view) {
            super(view);
            this.mView = view;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.core.view.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda2] */
        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20
        public final void hide() {
            WindowInsetsController windowInsetsController;
            int ime;
            View view = this.mView;
            if (view != null) {
                windowInsetsController = view.getWindowInsetsController();
            } else {
                windowInsetsController = null;
            }
            if (windowInsetsController != null) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ?? r4 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda2
                    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int r2) {
                        boolean z;
                        AtomicBoolean atomicBoolean2 = atomicBoolean;
                        if ((r2 & 8) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        atomicBoolean2.set(z);
                    }
                };
                windowInsetsController.addOnControllableInsetsChangedListener(r4);
                if (!atomicBoolean.get() && view != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(r4);
                ime = WindowInsets.Type.ime();
                windowInsetsController.hide(ime);
                return;
            }
            super.hide();
        }
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(view);
        } else {
            this.mImpl = new Impl20(view);
        }
    }
}
