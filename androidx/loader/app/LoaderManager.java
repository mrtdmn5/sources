package androidx.loader.app;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* loaded from: classes.dex */
    public interface LoaderCallbacks<D> {
    }

    public static LoaderManagerImpl getInstance(LifecycleOwner lifecycleOwner) {
        return new LoaderManagerImpl(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }
}
