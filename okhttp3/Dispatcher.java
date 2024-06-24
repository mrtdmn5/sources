package okhttp3;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public final class Dispatcher {
    public ThreadPoolExecutor executorServiceOrNull;
    public int maxRequests = 64;
    public int maxRequestsPerHost = 5;
    public final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque<>();
    public final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque<>();
    public final ArrayDeque<RealCall> runningSyncCalls = new ArrayDeque<>();

    public final synchronized ExecutorService executorService() {
        ThreadPoolExecutor threadPoolExecutor;
        if (this.executorServiceOrNull == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            String name = _UtilJvmKt.okHttpName + " Dispatcher";
            Intrinsics.checkNotNullParameter(name, "name");
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new _UtilJvmKt$$ExternalSyntheticLambda0(name, false));
        }
        threadPoolExecutor = this.executorServiceOrNull;
        Intrinsics.checkNotNull(threadPoolExecutor);
        return threadPoolExecutor;
    }

    public final void finished$okhttp(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.callsPerHost.decrementAndGet();
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.runningAsyncCalls;
        synchronized (this) {
            if (arrayDeque.remove(call)) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        promoteAndExecute();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void promoteAndExecute() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Dispatcher.promoteAndExecute():void");
    }
}
