package okhttp3.internal.connection;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

/* compiled from: RealConnectionPool.kt */
/* loaded from: classes4.dex */
public final class RealConnectionPool {
    public final TaskQueue cleanupQueue;
    public final RealConnectionPool$cleanupTask$1 cleanupTask;
    public final ConcurrentLinkedQueue<RealConnection> connections;
    public final long keepAliveDurationNs;
    public final int maxIdleConnections;

    /* JADX WARN: Type inference failed for: r6v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, long j, TimeUnit timeUnit) {
        boolean z;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.maxIdleConnections = 5;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.newQueue();
        final String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(m) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                RealConnectionPool realConnectionPool = RealConnectionPool.this;
                long nanoTime = System.nanoTime();
                Iterator<RealConnection> it = realConnectionPool.connections.iterator();
                int r4 = 0;
                long j2 = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int r5 = 0;
                while (it.hasNext()) {
                    RealConnection connection = it.next();
                    Intrinsics.checkNotNullExpressionValue(connection, "connection");
                    synchronized (connection) {
                        if (realConnectionPool.pruneAndGetAllocationCount(connection, nanoTime) > 0) {
                            r5++;
                        } else {
                            r4++;
                            long j3 = nanoTime - connection.idleAtNs;
                            if (j3 > j2) {
                                realConnection = connection;
                                j2 = j3;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
                long j4 = realConnectionPool.keepAliveDurationNs;
                if (j2 < j4 && r4 <= realConnectionPool.maxIdleConnections) {
                    if (r4 > 0) {
                        return j4 - j2;
                    }
                    if (r5 <= 0) {
                        return -1L;
                    }
                    return j4;
                }
                Intrinsics.checkNotNull(realConnection);
                synchronized (realConnection) {
                    if (!(!realConnection.calls.isEmpty())) {
                        if (realConnection.idleAtNs + j2 == nanoTime) {
                            realConnection.noNewExchanges = true;
                            realConnectionPool.connections.remove(realConnection);
                            Socket socket = realConnection.socket;
                            Intrinsics.checkNotNull(socket);
                            _UtilJvmKt.closeQuietly(socket);
                            if (realConnectionPool.connections.isEmpty()) {
                                realConnectionPool.cleanupQueue.cancelAll();
                            }
                        }
                    }
                }
                return 0L;
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("keepAliveDuration <= 0: ", j).toString());
        }
    }

    public final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        ArrayList arrayList = realConnection.calls;
        int r2 = 0;
        while (r2 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(r2);
            if (reference.get() != null) {
                r2++;
            } else {
                String str = "A connection to " + realConnection.route.address.url + " was leaked. Did you forget to close a response body?";
                Platform platform = Platform.platform;
                Platform.platform.logCloseableLeak(((RealCall.CallReference) reference).callStackTrace, str);
                arrayList.remove(r2);
                realConnection.noNewExchanges = true;
                if (arrayList.isEmpty()) {
                    realConnection.idleAtNs = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
