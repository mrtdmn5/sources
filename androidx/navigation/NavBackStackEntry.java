package androidx.navigation;

import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public Bundle mArgs;
    public final NavDestination mDestination;
    public Lifecycle.State mHostLifecycle;
    public final UUID mId;
    public final LifecycleRegistry mLifecycle;
    public Lifecycle.State mMaxLifecycle;
    public final NavControllerViewModel mNavControllerViewModel;
    public final SavedStateRegistryController mSavedStateRegistryController;

    /* renamed from: androidx.navigation.NavBackStackEntry$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0;
            try {
                r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public NavBackStackEntry(NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel) {
        this(navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), null);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.mNavControllerViewModel;
        if (navControllerViewModel != null) {
            HashMap<UUID, ViewModelStore> hashMap = navControllerViewModel.mViewModelStores;
            UUID r1 = this.mId;
            ViewModelStore viewModelStore = hashMap.get(r1);
            if (viewModelStore == null) {
                ViewModelStore viewModelStore2 = new ViewModelStore();
                hashMap.put(r1, viewModelStore2);
                return viewModelStore2;
            }
            return viewModelStore;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public final void updateState() {
        int ordinal = this.mHostLifecycle.ordinal();
        int ordinal2 = this.mMaxLifecycle.ordinal();
        LifecycleRegistry lifecycleRegistry = this.mLifecycle;
        if (ordinal < ordinal2) {
            lifecycleRegistry.setCurrentState(this.mHostLifecycle);
        } else {
            lifecycleRegistry.setCurrentState(this.mMaxLifecycle);
        }
    }

    public NavBackStackEntry(NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel, UUID r7, Bundle bundle2) {
        this.mLifecycle = new LifecycleRegistry(this);
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(this);
        this.mSavedStateRegistryController = savedStateRegistryController;
        this.mHostLifecycle = Lifecycle.State.CREATED;
        this.mMaxLifecycle = Lifecycle.State.RESUMED;
        this.mId = r7;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        savedStateRegistryController.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.mHostLifecycle = lifecycleOwner.getLifecycle().getCurrentState();
        }
    }
}
