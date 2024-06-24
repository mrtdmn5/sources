package kotlinx.coroutines.test.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: ExceptionCollector.kt */
/* loaded from: classes4.dex */
public final class ExceptionCollector extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public static final ExceptionCollector INSTANCE = new ExceptionCollector();
    public static final Object lock = new Object();

    static {
        new ArrayList();
        new LinkedHashMap();
    }

    public ExceptionCollector() {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExceptionCollector) && !(obj instanceof ExceptionCollectorAsService)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        synchronized (lock) {
        }
    }
}
