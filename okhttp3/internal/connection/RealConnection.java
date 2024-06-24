package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* compiled from: RealConnection.kt */
/* loaded from: classes4.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier {
    public int allocationLimit;
    public final ArrayList calls;
    public final Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNs;
    public boolean noCoalescedConnections;
    public boolean noNewExchanges;
    public final int pingIntervalMillis;
    public final Protocol protocol;
    public final Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public final BufferedSink sink;
    public final Socket socket;
    public final BufferedSource source;
    public int successCount;
    public final TaskRunner taskRunner;

    public RealConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket socket, Socket socket2, Handshake handshake, Protocol protocol, RealBufferedSource realBufferedSource, RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.taskRunner = taskRunner;
        this.route = route;
        this.rawSocket = socket;
        this.socket = socket2;
        this.handshake = handshake;
        this.protocol = protocol;
        this.source = realBufferedSource;
        this.sink = realBufferedSink;
        this.pingIntervalMillis = 0;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public static void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy.type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address;
            address.proxySelector.connectFailed(address.url.uri(), failedRoute.proxy.address(), failure);
        }
        RouteDatabase routeDatabase = client.routeDatabase;
        synchronized (routeDatabase) {
            routeDatabase._failedRoutes.add(failedRoute);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final Route getRoute() {
        return this.route;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c8, code lost:            if (r10 == false) goto L130;     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isEligible$okhttp(okhttp3.Address r9, java.util.List<okhttp3.Route> r10) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.isEligible$okhttp(okhttp3.Address, java.util.List):boolean");
    }

    public final boolean isHealthy(boolean z) {
        long j;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        long nanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.isShutdown) {
                    return false;
                }
                if (http2Connection.degradedPongsReceived < http2Connection.degradedPingsSent) {
                    if (nanoTime >= http2Connection.degradedPongDeadlineNs) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j = nanoTime - this.idleAtNs;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                boolean z2 = !bufferedSource.exhausted();
                socket2.setSoTimeout(soTimeout);
                return z2;
            } catch (Throwable th) {
                socket2.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final synchronized void noNewExchanges() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void onSettings(Http2Connection connection, Settings settings) {
        int r2;
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        if ((settings.set & 16) != 0) {
            r2 = settings.values[4];
        } else {
            r2 = Integer.MAX_VALUE;
        }
        this.allocationLimit = r2;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void onStream(Http2Stream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    public final void start() throws IOException {
        String concat;
        int r1;
        int r6;
        this.idleAtNs = System.nanoTime();
        Protocol protocol = this.protocol;
        if (protocol == Protocol.HTTP_2 || protocol == Protocol.H2_PRIOR_KNOWLEDGE) {
            Socket socket = this.socket;
            Intrinsics.checkNotNull(socket);
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(bufferedSink);
            socket.setSoTimeout(0);
            Http2Connection.Builder builder = new Http2Connection.Builder(this.taskRunner);
            String peerName = this.route.address.url.host;
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            builder.socket = socket;
            if (builder.client) {
                concat = _UtilJvmKt.okHttpName + ' ' + peerName;
            } else {
                concat = "MockWebServer ".concat(peerName);
            }
            Intrinsics.checkNotNullParameter(concat, "<set-?>");
            builder.connectionName = concat;
            builder.source = bufferedSource;
            builder.sink = bufferedSink;
            builder.listener = this;
            builder.pingIntervalMillis = this.pingIntervalMillis;
            Http2Connection http2Connection = new Http2Connection(builder);
            this.http2Connection = http2Connection;
            Settings settings = Http2Connection.DEFAULT_SETTINGS;
            if ((settings.set & 16) != 0) {
                r1 = settings.values[4];
            } else {
                r1 = Integer.MAX_VALUE;
            }
            this.allocationLimit = r1;
            Http2Writer http2Writer = http2Connection.writer;
            synchronized (http2Writer) {
                if (!http2Writer.closed) {
                    if (http2Writer.client) {
                        Logger logger = Http2Writer.logger;
                        if (logger.isLoggable(Level.FINE)) {
                            logger.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                        }
                        http2Writer.sink.write(Http2.CONNECTION_PREFACE);
                        http2Writer.sink.flush();
                    }
                } else {
                    throw new IOException("closed");
                }
            }
            Http2Writer http2Writer2 = http2Connection.writer;
            Settings settings2 = http2Connection.okHttpSettings;
            synchronized (http2Writer2) {
                Intrinsics.checkNotNullParameter(settings2, "settings");
                if (!http2Writer2.closed) {
                    http2Writer2.frameHeader(0, Integer.bitCount(settings2.set) * 6, 4, 0);
                    for (int r5 = 0; r5 < 10; r5++) {
                        boolean z = true;
                        if (((1 << r5) & settings2.set) == 0) {
                            z = false;
                        }
                        if (z) {
                            if (r5 != 4) {
                                if (r5 != 7) {
                                    r6 = r5;
                                } else {
                                    r6 = 4;
                                }
                            } else {
                                r6 = 3;
                            }
                            http2Writer2.sink.writeShort(r6);
                            http2Writer2.sink.writeInt(settings2.values[r5]);
                        }
                    }
                    http2Writer2.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
            if (http2Connection.okHttpSettings.getInitialWindowSize() != 65535) {
                http2Connection.writer.windowUpdate(0, r1 - 65535);
            }
            TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.connectionName, http2Connection.readerRunnable);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        Route route = this.route;
        sb.append(route.address.url.host);
        sb.append(':');
        sb.append(route.address.url.port);
        sb.append(", proxy=");
        sb.append(route.proxy);
        sb.append(" hostAddress=");
        sb.append(route.socketAddress);
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public final synchronized void trackFailure(RealCall call, IOException iOException) {
        boolean z;
        Intrinsics.checkNotNullParameter(call, "call");
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int r4 = this.refusedStreamCount + 1;
                this.refusedStreamCount = r4;
                if (r4 > 1) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.canceled) {
                this.noNewExchanges = true;
                this.routeFailureCount++;
            }
        } else {
            if (this.http2Connection != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        connectFailed$okhttp(call.client, this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        }
    }
}
