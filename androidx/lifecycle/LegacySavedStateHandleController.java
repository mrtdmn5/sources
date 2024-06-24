package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LegacySavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* compiled from: LegacySavedStateHandleController.kt */
    /* loaded from: classes.dex */
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public final void onRecreated(SavedStateRegistryOwner owner) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (owner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
                viewModelStore.getClass();
                Iterator it = new HashSet(viewModelStore.map.keySet()).iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    linkedHashMap = viewModelStore.map;
                    if (!hasNext) {
                        break;
                    }
                    String key = (String) it.next();
                    Intrinsics.checkNotNullParameter(key, "key");
                    ViewModel viewModel = (ViewModel) linkedHashMap.get(key);
                    Intrinsics.checkNotNull(viewModel);
                    LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, owner.getLifecycle());
                }
                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                    savedStateRegistry.runOnNextRecreation();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.isAttached) {
            savedStateHandleController.attachToLifecycle(lifecycle, registry);
            Lifecycle.State currentState = lifecycle.getCurrentState();
            if (currentState != Lifecycle.State.INITIALIZED && !currentState.isAtLeast(Lifecycle.State.STARTED)) {
                lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, registry));
            } else {
                registry.runOnNextRecreation();
            }
        }
    }
}
