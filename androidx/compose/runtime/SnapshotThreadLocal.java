package androidx.compose.runtime;

import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.ThreadMapKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;

/* compiled from: ActualJvm.jvm.kt */
/* loaded from: classes.dex */
public final class SnapshotThreadLocal<T> {
    public final AtomicReference<ThreadMap> map = new AtomicReference<>(ThreadMapKt.emptyThreadMap);
    public final Object writeMutex = new Object();

    public final T get() {
        ThreadMap threadMap = this.map.get();
        int find = threadMap.find(Thread.currentThread().getId());
        if (find >= 0) {
            return (T) threadMap.values[find];
        }
        return null;
    }

    public final void set(T t) {
        boolean z;
        long id = Thread.currentThread().getId();
        synchronized (this.writeMutex) {
            ThreadMap threadMap = this.map.get();
            int find = threadMap.find(id);
            if (find < 0) {
                z = false;
            } else {
                threadMap.values[find] = t;
                z = true;
            }
            if (z) {
                return;
            }
            this.map.set(threadMap.newWith(id, t));
            Unit unit = Unit.INSTANCE;
        }
    }
}
