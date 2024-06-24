package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateRegistry.kt */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    public boolean attached;
    public final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    public boolean isAllowingSavingState = true;
    public boolean isRestored;
    public Recreator.SavedStateProvider recreatorProvider;
    public Bundle restoredState;

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public final Bundle consumeRestoredStateForKey(String key) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.isRestored) {
            Bundle bundle2 = this.restoredState;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(key);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.restoredState;
            boolean z = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z = true;
            }
            if (!z) {
                this.restoredState = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider getSavedStateProvider() {
        String str;
        SavedStateProvider savedStateProvider;
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        do {
            SafeIterableMap.ListIterator listIterator = (SafeIterableMap.ListIterator) it;
            if (listIterator.hasNext()) {
                Map.Entry components = (Map.Entry) listIterator.next();
                Intrinsics.checkNotNullExpressionValue(components, "components");
                str = (String) components.getKey();
                savedStateProvider = (SavedStateProvider) components.getValue();
            } else {
                return null;
            }
        } while (!Intrinsics.areEqual(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return savedStateProvider;
    }

    public final void registerSavedStateProvider(String key, SavedStateProvider provider) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (this.components.putIfAbsent(key, provider) == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void runOnNextRecreation() {
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                LegacySavedStateHandleController.OnRecreation.class.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    savedStateProvider2.classes.add(LegacySavedStateHandleController.OnRecreation.class.getName());
                    return;
                }
                return;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + LegacySavedStateHandleController.OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
}
