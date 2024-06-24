package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class MissingMainCoroutineDispatcherFactory implements MainDispatcherFactory {
    public static final MissingMainCoroutineDispatcherFactory INSTANCE = new MissingMainCoroutineDispatcherFactory();

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new MissingMainCoroutineDispatcher(null);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final int getLoadPriority() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final String hintOnError() {
        return null;
    }
}
