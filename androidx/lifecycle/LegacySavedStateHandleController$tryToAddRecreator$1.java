package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: LegacySavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle $lifecycle;
    public final /* synthetic */ SavedStateRegistry $registry;

    public LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.$lifecycle = lifecycle;
        this.$registry = savedStateRegistry;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.$lifecycle.removeObserver(this);
            this.$registry.runOnNextRecreation();
        }
    }
}
