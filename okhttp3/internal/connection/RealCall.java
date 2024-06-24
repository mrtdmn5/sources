package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

/* compiled from: RealCall.kt */
/* loaded from: classes4.dex */
public final class RealCall implements Call, Cloneable {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public final EventListener eventListener;
    public volatile Exchange exchange;
    public ExchangeFinder exchangeFinder;
    public final AtomicBoolean executed;
    public boolean expectMoreExchanges;
    public final boolean forWebSocket;
    public Exchange interceptorScopedExchange;
    public final Request originalRequest;
    public final CopyOnWriteArrayList<RoutePlanner.Plan> plansToCancel;
    public boolean requestBodyOpen;
    public boolean responseBodyOpen;
    public final RealCall$timeout$1 timeout;
    public boolean timeoutEarlyExit;

    /* compiled from: RealCall.kt */
    /* loaded from: classes4.dex */
    public final class AsyncCall implements Runnable {
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final Callback responseCallback;

        public AsyncCall(Callback callback) {
            this.responseCallback = callback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OkHttpClient okHttpClient;
            String str = "OkHttp " + RealCall.this.originalRequest.url.redact();
            RealCall realCall = RealCall.this;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                realCall.timeout.enter();
                boolean z = false;
                try {
                    try {
                        try {
                            this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                            okHttpClient = realCall.client;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                Platform platform = Platform.platform;
                                Platform platform2 = Platform.platform;
                                String str2 = "Callback failure for " + RealCall.access$toLoggableString(realCall);
                                platform2.getClass();
                                Platform.log(4, str2, e);
                            } else {
                                this.responseCallback.onFailure(realCall, e);
                            }
                            okHttpClient = realCall.client;
                            okHttpClient.dispatcher.finished$okhttp(this);
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            realCall.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                ExceptionsKt.addSuppressed(iOException, th);
                                this.responseCallback.onFailure(realCall, iOException);
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    okHttpClient.dispatcher.finished$okhttp(this);
                } catch (Throwable th3) {
                    realCall.client.dispatcher.finished$okhttp(this);
                    throw th3;
                }
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    /* loaded from: classes4.dex */
    public static final class CallReference extends WeakReference<RealCall> {
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [okio.Timeout, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient client, Request originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.connectionPool.delegate;
        this.eventListener = client.eventListenerFactory.create(this);
        ?? r2 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public final void timedOut() {
                RealCall.this.cancel();
            }
        };
        r2.timeout(0, TimeUnit.MILLISECONDS);
        this.timeout = r2;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
    }

    public static final String access$toLoggableString(RealCall realCall) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (realCall.canceled) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (realCall.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(realCall.originalRequest.url.redact());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        boolean z;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        if (this.connection == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.connection = realConnection;
            realConnection.calls.add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final <E extends IOException> E callDone(E e) {
        E e2;
        Socket releaseConnectionNoEvents$okhttp;
        boolean z;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else {
                if (releaseConnectionNoEvents$okhttp == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (this.timeoutEarlyExit || !exit()) {
            e2 = e;
        } else {
            e2 = new InterruptedIOException("timeout");
            if (e != null) {
                e2.initCause(e);
            }
        }
        if (e != null) {
            EventListener eventListener = this.eventListener;
            Intrinsics.checkNotNull(e2);
            eventListener.callFailed(this, e2);
        } else {
            this.eventListener.callEnd(this);
        }
        return e2;
    }

    @Override // okhttp3.Call
    public final void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.codec.cancel();
        }
        Iterator<RoutePlanner.Plan> it = this.plansToCancel.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.eventListener.canceled(this);
    }

    public final Object clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public final void enqueue(Callback callback) {
        AsyncCall asyncCall;
        if (this.executed.compareAndSet(false, true)) {
            Platform platform = Platform.platform;
            this.callStackTrace = Platform.platform.getStackTraceForCloseable();
            this.eventListener.callStart(this);
            Dispatcher dispatcher = this.client.dispatcher;
            AsyncCall asyncCall2 = new AsyncCall(callback);
            dispatcher.getClass();
            synchronized (dispatcher) {
                dispatcher.readyAsyncCalls.add(asyncCall2);
                if (!this.forWebSocket) {
                    String str = this.originalRequest.url.host;
                    Iterator<AsyncCall> it = dispatcher.runningAsyncCalls.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            asyncCall = it.next();
                            if (Intrinsics.areEqual(RealCall.this.originalRequest.url.host, str)) {
                                break;
                            }
                        } else {
                            Iterator<AsyncCall> it2 = dispatcher.readyAsyncCalls.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    asyncCall = it2.next();
                                    if (Intrinsics.areEqual(RealCall.this.originalRequest.url.host, str)) {
                                        break;
                                    }
                                } else {
                                    asyncCall = null;
                                    break;
                                }
                            }
                        }
                    }
                    if (asyncCall != null) {
                        asyncCall2.callsPerHost = asyncCall.callsPerHost;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            dispatcher.promoteAndExecute();
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z && (exchange = this.exchange) != null) {
            exchange.codec.cancel();
            exchange.call.messageDone$okhttp(exchange, true, true, null);
        }
        this.interceptorScopedExchange = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List<okhttp3.Interceptor> r0 = r0.interceptors
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt__ReversedViewsKt.addAll(r0, r2)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.CookieJar r1 = r1.cookieJar
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            r1.getClass()
            r0.<init>()
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r10.forWebSocket
            if (r0 != 0) goto L43
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List<okhttp3.Interceptor> r0 = r0.networkInterceptors
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt__ReversedViewsKt.addAll(r0, r2)
        L43:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r10.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r10.originalRequest
            okhttp3.OkHttpClient r0 = r10.client
            int r6 = r0.connectTimeoutMillis
            int r7 = r0.readTimeoutMillis
            int r8 = r0.writeTimeoutMillis
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            okhttp3.Request r1 = r10.originalRequest     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            okhttp3.Response r1 = r9.proceed(r1)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            boolean r2 = r10.canceled     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            if (r2 != 0) goto L6f
            r10.noMoreExchanges$okhttp(r0)
            return r1
        L6f:
            okhttp3.internal._UtilCommonKt.closeQuietly(r1)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
            throw r1     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7d
        L7a:
            r1 = move-exception
            r2 = 0
            goto L8a
        L7d:
            r1 = move-exception
            java.io.IOException r1 = r10.noMoreExchanges$okhttp(r1)     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L88
            throw r1     // Catch: java.lang.Throwable -> L88
        L88:
            r1 = move-exception
            r2 = 1
        L8a:
            if (r2 != 0) goto L8f
            r10.noMoreExchanges$okhttp(r0)
        L8f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    @Override // okhttp3.Call
    public final boolean isCanceled() {
        return this.canceled;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:50:0x0013, B:12:0x0022, B:14:0x0026, B:15:0x0028, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001c), top: B:49:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:50:0x0013, B:12:0x0022, B:14:0x0026, B:15:0x0028, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001c), top: B:49:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okhttp3.internal.connection.Exchange r0 = r2.exchange
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r3 != 0) goto Le
            return r6
        Le:
            monitor-enter(r2)
            r3 = 1
            r0 = 0
            if (r4 == 0) goto L1a
            boolean r1 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L20
            goto L1a
        L18:
            r3 = move-exception
            goto L61
        L1a:
            if (r5 == 0) goto L41
            boolean r1 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L41
        L20:
            if (r4 == 0) goto L24
            r2.requestBodyOpen = r0     // Catch: java.lang.Throwable -> L18
        L24:
            if (r5 == 0) goto L28
            r2.responseBodyOpen = r0     // Catch: java.lang.Throwable -> L18
        L28:
            boolean r4 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L32
            boolean r5 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r5 != 0) goto L32
            r5 = r3
            goto L33
        L32:
            r5 = r0
        L33:
            if (r4 != 0) goto L3e
            boolean r4 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L3e
            boolean r4 = r2.expectMoreExchanges     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L3e
            r0 = r3
        L3e:
            r4 = r0
            r0 = r5
            goto L42
        L41:
            r4 = r0
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r0 == 0) goto L59
            r5 = 0
            r2.exchange = r5
            okhttp3.internal.connection.RealConnection r5 = r2.connection
            if (r5 == 0) goto L59
            monitor-enter(r5)
            int r0 = r5.successCount     // Catch: java.lang.Throwable -> L56
            int r0 = r0 + r3
            r5.successCount = r0     // Catch: java.lang.Throwable -> L56
            monitor-exit(r5)
            goto L59
        L56:
            r3 = move-exception
            monitor-exit(r5)
            throw r3
        L59:
            if (r4 == 0) goto L60
            java.io.IOException r3 = r2.callDone(r6)
            return r3
        L60:
            return r6
        L61:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            return callDone(iOException);
        }
        return iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        boolean z;
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        ArrayList arrayList = realConnection.calls;
        Iterator it = arrayList.iterator();
        boolean z2 = false;
        int r4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(((Reference) it.next()).get(), this)) {
                    break;
                }
                r4++;
            } else {
                r4 = -1;
                break;
            }
        }
        if (r4 != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            arrayList.remove(r4);
            this.connection = null;
            if (arrayList.isEmpty()) {
                realConnection.idleAtNs = System.nanoTime();
                RealConnectionPool realConnectionPool = this.connectionPool;
                realConnectionPool.getClass();
                Headers headers2 = _UtilJvmKt.EMPTY_HEADERS;
                boolean z3 = realConnection.noNewExchanges;
                TaskQueue taskQueue = realConnectionPool.cleanupQueue;
                if (!z3 && realConnectionPool.maxIdleConnections != 0) {
                    taskQueue.schedule(realConnectionPool.cleanupTask, 0L);
                } else {
                    realConnection.noNewExchanges = true;
                    ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = realConnectionPool.connections;
                    concurrentLinkedQueue.remove(realConnection);
                    if (concurrentLinkedQueue.isEmpty()) {
                        taskQueue.cancelAll();
                    }
                    z2 = true;
                }
                if (z2) {
                    Socket socket = realConnection.socket;
                    Intrinsics.checkNotNull(socket);
                    return socket;
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public final Request request() {
        return this.originalRequest;
    }
}
