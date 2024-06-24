package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    public final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        this.provider = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        boolean z;
        if (event == Lifecycle.Event.ON_CREATE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            SavedStateHandlesProvider savedStateHandlesProvider = this.provider;
            if (!savedStateHandlesProvider.restored) {
                savedStateHandlesProvider.restoredState = savedStateHandlesProvider.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
                savedStateHandlesProvider.restored = true;
                return;
            }
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
