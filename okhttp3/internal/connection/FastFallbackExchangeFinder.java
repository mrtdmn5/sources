package okhttp3.internal.connection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;

/* compiled from: FastFallbackExchangeFinder.kt */
/* loaded from: classes4.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    public final long connectDelayNanos;
    public final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    public long nextTcpConnectAtNanos;
    public final RoutePlanner routePlanner;
    public final TaskRunner taskRunner;
    public final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RealRoutePlanner realRoutePlanner, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = realRoutePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.backend.decorate(new LinkedBlockingDeque());
    }

    public final void cancelInFlightConnects() {
        CopyOnWriteArrayList<RoutePlanner.Plan> copyOnWriteArrayList = this.tcpConnectsInFlight;
        Iterator<RoutePlanner.Plan> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.cancel();
            RoutePlanner.Plan retry = next.retry();
            if (retry != null) {
                this.routePlanner.getDeferredPlans().addLast(retry);
            }
        }
        copyOnWriteArrayList.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[Catch: all -> 0x00bf, TryCatch #0 {all -> 0x00bf, blocks: (B:4:0x0004, B:7:0x000e, B:13:0x001c, B:15:0x0022, B:22:0x0047, B:69:0x0050, B:71:0x005c, B:28:0x0064, B:30:0x0069, B:35:0x0074, B:37:0x007d, B:38:0x0081, B:40:0x0085, B:45:0x008d, B:49:0x0097, B:51:0x009b, B:54:0x00a1, B:55:0x00a5, B:57:0x00a9, B:58:0x00aa, B:61:0x00ae, B:73:0x003c, B:75:0x00b7, B:76:0x00be), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #0 {all -> 0x00bf, blocks: (B:4:0x0004, B:7:0x000e, B:13:0x001c, B:15:0x0022, B:22:0x0047, B:69:0x0050, B:71:0x005c, B:28:0x0064, B:30:0x0069, B:35:0x0074, B:37:0x007d, B:38:0x0081, B:40:0x0085, B:45:0x008d, B:49:0x0097, B:51:0x009b, B:54:0x00a1, B:55:0x00a5, B:57:0x00a9, B:58:0x00aa, B:61:0x00ae, B:73:0x003c, B:75:0x00b7, B:76:0x00be), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b A[Catch: all -> 0x00bf, TryCatch #0 {all -> 0x00bf, blocks: (B:4:0x0004, B:7:0x000e, B:13:0x001c, B:15:0x0022, B:22:0x0047, B:69:0x0050, B:71:0x005c, B:28:0x0064, B:30:0x0069, B:35:0x0074, B:37:0x007d, B:38:0x0081, B:40:0x0085, B:45:0x008d, B:49:0x0097, B:51:0x009b, B:54:0x00a1, B:55:0x00a5, B:57:0x00a9, B:58:0x00aa, B:61:0x00ae, B:73:0x003c, B:75:0x00b7, B:76:0x00be), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0002 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0064 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.RealConnection find() {
        /*
            r12 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r12.tcpConnectsInFlight
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lbf
            r4 = 1
            r3 = r3 ^ r4
            okhttp3.internal.connection.RoutePlanner r5 = r12.routePlanner
            if (r3 != 0) goto L1c
            boolean r3 = r5.hasNext(r0)     // Catch: java.lang.Throwable -> Lbf
            if (r3 == 0) goto L15
            goto L1c
        L15:
            r12.cancelInFlightConnects()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            throw r1
        L1c:
            boolean r3 = r5.isCanceled()     // Catch: java.lang.Throwable -> Lbf
            if (r3 != 0) goto Lb7
            okhttp3.internal.concurrent.TaskRunner r3 = r12.taskRunner     // Catch: java.lang.Throwable -> Lbf
            okhttp3.internal.concurrent.TaskRunner$Backend r3 = r3.backend     // Catch: java.lang.Throwable -> Lbf
            long r6 = r3.nanoTime()     // Catch: java.lang.Throwable -> Lbf
            long r8 = r12.nextTcpConnectAtNanos     // Catch: java.lang.Throwable -> Lbf
            long r8 = r8 - r6
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lbf
            if (r3 != 0) goto L3c
            r10 = 0
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 > 0) goto L3a
            goto L3c
        L3a:
            r3 = r0
            goto L45
        L3c:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r3 = r12.launchTcpConnect()     // Catch: java.lang.Throwable -> Lbf
            long r8 = r12.connectDelayNanos     // Catch: java.lang.Throwable -> Lbf
            long r6 = r6 + r8
            r12.nextTcpConnectAtNanos = r6     // Catch: java.lang.Throwable -> Lbf
        L45:
            if (r3 != 0) goto L64
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> Lbf
            boolean r6 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lbf
            if (r6 == 0) goto L50
            goto L5a
        L50:
            java.util.concurrent.BlockingQueue<okhttp3.internal.connection.RoutePlanner$ConnectResult> r6 = r12.connectResults     // Catch: java.lang.Throwable -> Lbf
            java.lang.Object r3 = r6.poll(r8, r3)     // Catch: java.lang.Throwable -> Lbf
            okhttp3.internal.connection.RoutePlanner$ConnectResult r3 = (okhttp3.internal.connection.RoutePlanner.ConnectResult) r3     // Catch: java.lang.Throwable -> Lbf
            if (r3 != 0) goto L5c
        L5a:
            r3 = r0
            goto L61
        L5c:
            okhttp3.internal.connection.RoutePlanner$Plan r6 = r3.plan     // Catch: java.lang.Throwable -> Lbf
            r2.remove(r6)     // Catch: java.lang.Throwable -> Lbf
        L61:
            if (r3 != 0) goto L64
            goto L2
        L64:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r3.nextPlan     // Catch: java.lang.Throwable -> Lbf
            r6 = 0
            if (r2 != 0) goto L6f
            java.lang.Throwable r2 = r3.throwable     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto L6f
            r2 = r4
            goto L70
        L6f:
            r2 = r6
        L70:
            okhttp3.internal.connection.RoutePlanner$Plan r7 = r3.plan
            if (r2 == 0) goto L97
            r12.cancelInFlightConnects()     // Catch: java.lang.Throwable -> Lbf
            boolean r2 = r7.isReady()     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto L81
            okhttp3.internal.connection.RoutePlanner$ConnectResult r3 = r7.connectTlsEtc()     // Catch: java.lang.Throwable -> Lbf
        L81:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r3.nextPlan     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto L8a
            java.lang.Throwable r2 = r3.throwable     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto L8a
            goto L8b
        L8a:
            r4 = r6
        L8b:
            if (r4 == 0) goto L97
            okhttp3.internal.connection.RoutePlanner$Plan r0 = r3.plan     // Catch: java.lang.Throwable -> Lbf
            okhttp3.internal.connection.RealConnection r0 = r0.handleSuccess()     // Catch: java.lang.Throwable -> Lbf
            r12.cancelInFlightConnects()
            return r0
        L97:
            java.lang.Throwable r2 = r3.throwable     // Catch: java.lang.Throwable -> Lbf
            if (r2 == 0) goto Laa
            boolean r4 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> Lbf
            if (r4 == 0) goto La9
            if (r1 != 0) goto La5
            java.io.IOException r2 = (java.io.IOException) r2     // Catch: java.lang.Throwable -> Lbf
            r1 = r2
            goto Laa
        La5:
            kotlin.ExceptionsKt.addSuppressed(r1, r2)     // Catch: java.lang.Throwable -> Lbf
            goto Laa
        La9:
            throw r2     // Catch: java.lang.Throwable -> Lbf
        Laa:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r3.nextPlan     // Catch: java.lang.Throwable -> Lbf
            if (r2 == 0) goto L2
            kotlin.collections.ArrayDeque r3 = r5.getDeferredPlans()     // Catch: java.lang.Throwable -> Lbf
            r3.addFirst(r2)     // Catch: java.lang.Throwable -> Lbf
            goto L2
        Lb7:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lbf
            throw r0     // Catch: java.lang.Throwable -> Lbf
        Lbf:
            r0 = move-exception
            r12.cancelInFlightConnects()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.FastFallbackExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public final RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    public final RoutePlanner.ConnectResult launchTcpConnect() {
        final RoutePlanner.Plan failedPlan;
        RoutePlanner routePlanner = this.routePlanner;
        if (routePlanner.hasNext(null)) {
            try {
                failedPlan = routePlanner.plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner.ConnectResult(failedPlan, null, null, 6);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).result;
            }
            this.tcpConnectsInFlight.add(failedPlan);
            final String str = _UtilJvmKt.okHttpName + " connect " + routePlanner.getAddress().url.redact();
            this.taskRunner.newQueue().schedule(new Task(str) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() {
                    RoutePlanner.ConnectResult connectResult;
                    RoutePlanner.Plan plan = failedPlan;
                    try {
                        connectResult = plan.connectTcp();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(plan, null, th2, 2);
                    }
                    FastFallbackExchangeFinder fastFallbackExchangeFinder = this;
                    if (fastFallbackExchangeFinder.tcpConnectsInFlight.contains(plan)) {
                        fastFallbackExchangeFinder.connectResults.put(connectResult);
                        return -1L;
                    }
                    return -1L;
                }
            }, 0L);
        }
        return null;
    }
}
