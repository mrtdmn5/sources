package androidx.compose.ui.platform.coreshims;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.ui.platform.AndroidComposeView;
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

        public Impl20(AndroidComposeView androidComposeView) {
            this.mView = androidComposeView;
        }

        public void hide() {
            View view = this.mView;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        public void show() {
            final View view;
            View view2 = this.mView;
            if (view2 == null) {
                return;
            }
            if (!view2.isInEditMode() && !view2.onCheckIsTextEditor()) {
                view = view2.getRootView().findFocus();
            } else {
                view2.requestFocus();
                view = view2;
            }
            if (view == null) {
                view = view2.getRootView().findViewById(R.id.content);
            }
            if (view != null && view.hasWindowFocus()) {
                view.post(new Runnable() { // from class: androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        View view3 = view;
                        ((InputMethodManager) view3.getContext().getSystemService("input_method")).showSoftInput(view3, 0);
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Impl30 extends Impl20 {
        public final View mView;

        public Impl30(AndroidComposeView androidComposeView) {
            super(androidComposeView);
            this.mView = androidComposeView;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda6] */
        @Override // androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat.Impl20
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
                ?? r4 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda6
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

        @Override // androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat.Impl20
        public final void show() {
            WindowInsetsController windowInsetsController;
            int ime;
            View view = this.mView;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            if (view != null) {
                windowInsetsController = view.getWindowInsetsController();
            } else {
                windowInsetsController = null;
            }
            if (windowInsetsController != null) {
                ime = WindowInsets.Type.ime();
                windowInsetsController.show(ime);
            } else {
                super.show();
            }
        }
    }

    public SoftwareKeyboardControllerCompat(AndroidComposeView androidComposeView) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(androidComposeView);
        } else {
            this.mImpl = new Impl20(androidComposeView);
        }
    }
}
