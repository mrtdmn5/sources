package okhttp3;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;

/* compiled from: ConnectionPool.kt */
/* loaded from: classes4.dex */
public final class ConnectionPool {
    public final RealConnectionPool delegate;

    public ConnectionPool(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.delegate = new RealConnectionPool(TaskRunner.INSTANCE, j, timeUnit);
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.delegate.connections;
        int r2 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            Iterator<RealConnection> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                RealConnection it2 = it.next();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                synchronized (it2) {
                    isEmpty = it2.calls.isEmpty();
                }
                if (isEmpty && (r2 = r2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                    throw null;
                }
            }
        }
        return r2;
    }
}
