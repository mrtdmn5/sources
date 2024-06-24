package androidx.compose.ui.platform;

/* compiled from: AndroidViewConfiguration.android.kt */
/* loaded from: classes.dex */
public final class AndroidViewConfiguration implements ViewConfiguration {
    public final android.view.ViewConfiguration viewConfiguration;

    public AndroidViewConfiguration(android.view.ViewConfiguration viewConfiguration) {
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getDoubleTapTimeoutMillis() {
        return android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getLongPressTimeoutMillis() {
        return android.view.ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final void getDoubleTapMinTimeMillis() {
    }
}
