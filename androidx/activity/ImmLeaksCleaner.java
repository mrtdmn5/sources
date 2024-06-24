package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static int sReflectedFieldsInitialized;

    public ImmLeaksCleaner() {
        throw null;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (sReflectedFieldsInitialized == 0) {
            try {
                sReflectedFieldsInitialized = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                sReflectedFieldsInitialized = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (sReflectedFieldsInitialized != 1) {
        } else {
            throw null;
        }
    }
}
