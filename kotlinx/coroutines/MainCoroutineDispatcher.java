package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes4.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher getImmediate();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        MainCoroutineDispatcher mainCoroutineDispatcher2 = MainDispatcherLoader.dispatcher;
        if (this == mainCoroutineDispatcher2) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcher = mainCoroutineDispatcher2.getImmediate();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcher = null;
            }
            if (this == mainCoroutineDispatcher) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str == null) {
            return getClass().getSimpleName() + '@' + DebugStringsKt.getHexAddress(this);
        }
        return str;
    }
}
