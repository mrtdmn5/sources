package okhttp3.internal.http2;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: Http2Connection.kt */
/* loaded from: classes4.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final boolean client;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public long intervalPingsSent;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final PushObserver$Companion$PushObserverCancel pushObserver;
    public final TaskQueue pushQueue;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final Socket socket;
    public final LinkedHashMap streams;
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final boolean client;
        public String connectionName;
        public Listener listener;
        public int pingIntervalMillis;
        public final PushObserver$Companion$PushObserverCancel pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        public final TaskRunner taskRunner;

        public Builder(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = true;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes4.dex */
    public static abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, DfuBaseService.ERROR_CONNECTION_MASK);
        DEFAULT_SETTINGS = settings;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [okhttp3.internal.http2.Http2Connection$1] */
    public Http2Connection(Builder builder) {
        int r3;
        boolean z = builder.client;
        this.client = z;
        this.listener = builder.listener;
        this.streams = new LinkedHashMap();
        String str = builder.connectionName;
        if (str != null) {
            this.connectionName = str;
            if (z) {
                r3 = 3;
            } else {
                r3 = 2;
            }
            this.nextStreamId = r3;
            TaskRunner taskRunner = builder.taskRunner;
            this.taskRunner = taskRunner;
            TaskQueue newQueue = taskRunner.newQueue();
            this.writerQueue = newQueue;
            this.pushQueue = taskRunner.newQueue();
            this.settingsListenerQueue = taskRunner.newQueue();
            this.pushObserver = builder.pushObserver;
            Settings settings = new Settings();
            if (z) {
                settings.set(7, 16777216);
            }
            this.okHttpSettings = settings;
            this.peerSettings = DEFAULT_SETTINGS;
            this.writeBytesMaximum = r3.getInitialWindowSize();
            Socket socket = builder.socket;
            if (socket != null) {
                this.socket = socket;
                BufferedSink bufferedSink = builder.sink;
                if (bufferedSink != null) {
                    this.writer = new Http2Writer(bufferedSink, z);
                    BufferedSource bufferedSource = builder.source;
                    if (bufferedSource != null) {
                        this.readerRunnable = new ReaderRunnable(new Http2Reader(bufferedSource, z));
                        this.currentPushRequests = new LinkedHashSet();
                        int r8 = builder.pingIntervalMillis;
                        if (r8 != 0) {
                            final long nanos = TimeUnit.MILLISECONDS.toNanos(r8);
                            final String name = str.concat(" ping");
                            final ?? r0 = new Function0<Long>() { // from class: okhttp3.internal.http2.Http2Connection.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    boolean z2;
                                    Http2Connection http2Connection = Http2Connection.this;
                                    synchronized (http2Connection) {
                                        long j = http2Connection.intervalPongsReceived;
                                        long j2 = http2Connection.intervalPingsSent;
                                        if (j < j2) {
                                            z2 = true;
                                        } else {
                                            http2Connection.intervalPingsSent = j2 + 1;
                                            z2 = false;
                                        }
                                    }
                                    if (z2) {
                                        Http2Connection.this.failConnection(null);
                                        return -1L;
                                    }
                                    Http2Connection http2Connection2 = Http2Connection.this;
                                    http2Connection2.getClass();
                                    try {
                                        http2Connection2.writer.ping(1, 0, false);
                                    } catch (IOException e) {
                                        http2Connection2.failConnection(e);
                                    }
                                    return Long.valueOf(nanos);
                                }
                            };
                            Intrinsics.checkNotNullParameter(name, "name");
                            newQueue.schedule(new Task(name) { // from class: okhttp3.internal.concurrent.TaskQueue$schedule$2
                                @Override // okhttp3.internal.concurrent.Task
                                public final long runOnce() {
                                    return r0.invoke().longValue();
                                }
                            }, nanos);
                            return;
                        }
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("source");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sink");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int r0;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                objArr = this.streams.values().toArray(new Http2Stream[0]);
                Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.streams.clear();
            } else {
                objArr = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) objArr;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public final void flush() throws IOException {
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            if (!http2Writer.closed) {
                http2Writer.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }
    }

    public final synchronized Http2Stream getStream(int r2) {
        return (Http2Stream) this.streams.get(Integer.valueOf(r2));
    }

    public final synchronized Http2Stream removeStream$okhttp(int r2) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(r2));
        notifyAll();
        return http2Stream;
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int r2 = this.lastGoodStreamId;
                ref$IntRef.element = r2;
                Unit unit = Unit.INSTANCE;
                this.writer.goAway(r2, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:            throw new java.io.IOException("stream closed");     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:            r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.maxFrameSize);        r6 = r2;        r8.writeBytesTotal += r6;        r4 = kotlin.Unit.INSTANCE;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6a
            monitor-enter(r8)
        L12:
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            long r6 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L32
            java.util.LinkedHashMap r2 = r8.streams     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            goto L12
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
            throw r9     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L5b
        L32:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L59
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L59
            okhttp3.internal.http2.Http2Writer r4 = r8.writer     // Catch: java.lang.Throwable -> L59
            int r4 = r4.maxFrameSize     // Catch: java.lang.Throwable -> L59
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L59
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L59
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L59
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L59
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L59
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.data(r5, r9, r11, r2)
            goto Ld
        L59:
            r9 = move-exception
            goto L68
        L5b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L59
            r9.interrupt()     // Catch: java.lang.Throwable -> L59
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L59
            r9.<init>()     // Catch: java.lang.Throwable -> L59
            throw r9     // Catch: java.lang.Throwable -> L59
        L68:
            monitor-exit(r8)
            throw r9
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writeSynResetLater$okhttp(final int r3, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + r3 + "] writeSynReset", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Http2Connection http2Connection = Http2Connection.this;
                try {
                    int r1 = r3;
                    ErrorCode statusCode = errorCode;
                    http2Connection.getClass();
                    Intrinsics.checkNotNullParameter(statusCode, "statusCode");
                    http2Connection.writer.rstStream(r1, statusCode);
                } catch (IOException e) {
                    http2Connection.failConnection(e);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void writeWindowUpdateLater$okhttp(final int r3, final long j) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + r3 + "] windowUpdate", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Http2Connection http2Connection = Http2Connection.this;
                try {
                    http2Connection.writer.windowUpdate(r3, j);
                } catch (IOException e) {
                    http2Connection.failConnection(e);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes4.dex */
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        public final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            this.reader = http2Reader;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00f4, code lost:            if (r20 == false) goto L72;     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00f6, code lost:            r5.receiveHeaders(okhttp3.internal._UtilJvmKt.EMPTY_HEADERS, true);     */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00fb, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:            return;     */
        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void data(final int r17, final int r18, okio.BufferedSource r19, final boolean r20) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.data(int, int, okio.BufferedSource, boolean):void");
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void goAway(int r5, ErrorCode errorCode, ByteString debugData) {
            int r0;
            Object[] array;
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.getSize$okio();
            Http2Connection http2Connection = Http2Connection.this;
            synchronized (http2Connection) {
                array = http2Connection.streams.values().toArray(new Http2Stream[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                http2Connection.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.id > r5 && http2Stream.isLocallyInitiated()) {
                    ErrorCode errorCode2 = ErrorCode.REFUSED_STREAM;
                    synchronized (http2Stream) {
                        Intrinsics.checkNotNullParameter(errorCode2, "errorCode");
                        if (http2Stream.errorCode == null) {
                            http2Stream.errorCode = errorCode2;
                            http2Stream.notifyAll();
                        }
                    }
                    Http2Connection.this.removeStream$okhttp(http2Stream.id);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void headers(final int r11, final List list, final boolean z) {
            boolean z2;
            Http2Connection.this.getClass();
            if (r11 != 0 && (r11 & 1) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                final Http2Connection http2Connection = Http2Connection.this;
                http2Connection.getClass();
                TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + r11 + "] onHeaders", new Function0<Unit>(r11, list, z) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$1
                    public final /* synthetic */ List<Header> $requestHeaders;
                    public final /* synthetic */ int $streamId;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = Http2Connection.this.pushObserver;
                        List<Header> responseHeaders = this.$requestHeaders;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                        Http2Connection http2Connection2 = Http2Connection.this;
                        int r1 = this.$streamId;
                        try {
                            http2Connection2.writer.rstStream(r1, ErrorCode.CANCEL);
                            synchronized (http2Connection2) {
                                http2Connection2.currentPushRequests.remove(Integer.valueOf(r1));
                            }
                        } catch (IOException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            final Http2Connection http2Connection2 = Http2Connection.this;
            synchronized (http2Connection2) {
                Http2Stream stream = http2Connection2.getStream(r11);
                if (stream == null) {
                    if (http2Connection2.isShutdown) {
                        return;
                    }
                    if (r11 <= http2Connection2.lastGoodStreamId) {
                        return;
                    }
                    if (r11 % 2 == http2Connection2.nextStreamId % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(r11, http2Connection2, false, z, _UtilJvmKt.toHeaders(list));
                    http2Connection2.lastGoodStreamId = r11;
                    http2Connection2.streams.put(Integer.valueOf(r11), http2Stream);
                    TaskQueue.execute$default(http2Connection2.taskRunner.newQueue(), http2Connection2.connectionName + '[' + r11 + "] onStream", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            try {
                                Http2Connection.this.listener.onStream(http2Stream);
                            } catch (IOException e) {
                                Platform platform = Platform.platform;
                                Platform platform2 = Platform.platform;
                                String str = "Http2Connection.Listener failure for " + Http2Connection.this.connectionName;
                                platform2.getClass();
                                Platform.log(4, str, e);
                                try {
                                    http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                                } catch (IOException unused) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                Unit unit = Unit.INSTANCE;
                stream.receiveHeaders(_UtilJvmKt.toHeaders(list), z);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Throwable th;
            ErrorCode errorCode;
            Http2Connection http2Connection = Http2Connection.this;
            Http2Reader http2Reader = this.reader;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                http2Reader.readConnectionPreface(this);
                do {
                } while (http2Reader.nextFrame(false, this));
                errorCode = ErrorCode.NO_ERROR;
            } catch (IOException e2) {
                e = e2;
                errorCode = errorCode2;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                http2Connection.close$okhttp(errorCode, errorCode2, e);
                _UtilCommonKt.closeQuietly(http2Reader);
                throw th;
            }
            try {
                try {
                    http2Connection.close$okhttp(errorCode, ErrorCode.CANCEL, null);
                } catch (Throwable th3) {
                    th = th3;
                    http2Connection.close$okhttp(errorCode, errorCode2, e);
                    _UtilCommonKt.closeQuietly(http2Reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                http2Connection.close$okhttp(errorCode3, errorCode3, e);
                _UtilCommonKt.closeQuietly(http2Reader);
                return Unit.INSTANCE;
            }
            _UtilCommonKt.closeQuietly(http2Reader);
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void ping(final int r5, final int r6, boolean z) {
            if (z) {
                Http2Connection http2Connection = Http2Connection.this;
                synchronized (http2Connection) {
                    if (r5 != 1) {
                        if (r5 != 2) {
                            if (r5 == 3) {
                                http2Connection.notifyAll();
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            http2Connection.degradedPongsReceived++;
                        }
                    } else {
                        http2Connection.intervalPongsReceived++;
                    }
                }
                return;
            }
            TaskQueue taskQueue = Http2Connection.this.writerQueue;
            String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), Http2Connection.this.connectionName, " ping");
            final Http2Connection http2Connection2 = Http2Connection.this;
            TaskQueue.execute$default(taskQueue, m, new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    int r0 = r5;
                    int r1 = r6;
                    Http2Connection http2Connection3 = Http2Connection.this;
                    http2Connection3.getClass();
                    try {
                        http2Connection3.writer.ping(r0, r1, true);
                    } catch (IOException e) {
                        http2Connection3.failConnection(e);
                    }
                    return Unit.INSTANCE;
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void pushPromise(final List list, final int r6) {
            final Http2Connection http2Connection = Http2Connection.this;
            http2Connection.getClass();
            synchronized (http2Connection) {
                if (http2Connection.currentPushRequests.contains(Integer.valueOf(r6))) {
                    http2Connection.writeSynResetLater$okhttp(r6, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.currentPushRequests.add(Integer.valueOf(r6));
                TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + r6 + "] onRequest", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = Http2Connection.this.pushObserver;
                        List<Header> requestHeaders = list;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
                        Http2Connection http2Connection2 = Http2Connection.this;
                        int r1 = r6;
                        try {
                            http2Connection2.writer.rstStream(r1, ErrorCode.CANCEL);
                            synchronized (http2Connection2) {
                                http2Connection2.currentPushRequests.remove(Integer.valueOf(r1));
                            }
                        } catch (IOException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void rstStream(final int r5, final ErrorCode errorCode) {
            boolean z;
            final Http2Connection http2Connection = Http2Connection.this;
            http2Connection.getClass();
            if (r5 != 0 && (r5 & 1) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TaskQueue.execute$default(http2Connection.pushQueue, http2Connection.connectionName + '[' + r5 + "] onReset", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = Http2Connection.this.pushObserver;
                        ErrorCode errorCode2 = errorCode;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        Intrinsics.checkNotNullParameter(errorCode2, "errorCode");
                        Http2Connection http2Connection2 = Http2Connection.this;
                        int r1 = r5;
                        synchronized (http2Connection2) {
                            http2Connection2.currentPushRequests.remove(Integer.valueOf(r1));
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            Http2Stream removeStream$okhttp = http2Connection.removeStream$okhttp(r5);
            if (removeStream$okhttp != null) {
                synchronized (removeStream$okhttp) {
                    if (removeStream$okhttp.errorCode == null) {
                        removeStream$okhttp.errorCode = errorCode;
                        removeStream$okhttp.notifyAll();
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void settings(final Settings settings) {
            Http2Connection http2Connection = Http2Connection.this;
            TaskQueue.execute$default(http2Connection.writerQueue, ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), http2Connection.connectionName, " applyAndAckSettings"), new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$1
                public final /* synthetic */ boolean $clearPrevious = false;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1 */
                /* JADX WARN: Type inference failed for: r2v2, types: [T, okhttp3.internal.http2.Settings] */
                /* JADX WARN: Type inference failed for: r2v3 */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    int r6;
                    ?? r2;
                    boolean z;
                    long initialWindowSize;
                    Http2Stream[] http2StreamArr;
                    Http2Connection.ReaderRunnable readerRunnable = Http2Connection.ReaderRunnable.this;
                    boolean z2 = this.$clearPrevious;
                    Settings settings2 = settings;
                    readerRunnable.getClass();
                    Intrinsics.checkNotNullParameter(settings2, "settings");
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    final Http2Connection http2Connection2 = Http2Connection.this;
                    synchronized (http2Connection2.writer) {
                        synchronized (http2Connection2) {
                            try {
                                Settings other = http2Connection2.peerSettings;
                                if (z2) {
                                    r2 = settings2;
                                } else {
                                    Settings settings3 = new Settings();
                                    Intrinsics.checkNotNullParameter(other, "other");
                                    int r7 = 0;
                                    while (true) {
                                        boolean z3 = true;
                                        if (r7 >= 10) {
                                            break;
                                        }
                                        if (((1 << r7) & other.set) == 0) {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            settings3.set(r7, other.values[r7]);
                                        }
                                        r7++;
                                    }
                                    for (int r72 = 0; r72 < 10; r72++) {
                                        if (((1 << r72) & settings2.set) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            settings3.set(r72, settings2.values[r72]);
                                        }
                                    }
                                    r2 = settings3;
                                }
                                ref$ObjectRef.element = r2;
                                initialWindowSize = r2.getInitialWindowSize() - other.getInitialWindowSize();
                                if (initialWindowSize != 0 && !http2Connection2.streams.isEmpty()) {
                                    Object[] array = http2Connection2.streams.values().toArray(new Http2Stream[0]);
                                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    http2StreamArr = (Http2Stream[]) array;
                                    Settings settings4 = (Settings) ref$ObjectRef.element;
                                    Intrinsics.checkNotNullParameter(settings4, "<set-?>");
                                    http2Connection2.peerSettings = settings4;
                                    TaskQueue.execute$default(http2Connection2.settingsListenerQueue, http2Connection2.connectionName + " onSettings", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$1$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            Http2Connection http2Connection3 = Http2Connection.this;
                                            http2Connection3.listener.onSettings(http2Connection3, ref$ObjectRef.element);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Unit unit = Unit.INSTANCE;
                                }
                                http2StreamArr = null;
                                Settings settings42 = (Settings) ref$ObjectRef.element;
                                Intrinsics.checkNotNullParameter(settings42, "<set-?>");
                                http2Connection2.peerSettings = settings42;
                                TaskQueue.execute$default(http2Connection2.settingsListenerQueue, http2Connection2.connectionName + " onSettings", new Function0<Unit>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$1$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Http2Connection http2Connection3 = Http2Connection.this;
                                        http2Connection3.listener.onSettings(http2Connection3, ref$ObjectRef.element);
                                        return Unit.INSTANCE;
                                    }
                                });
                                Unit unit2 = Unit.INSTANCE;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        try {
                            http2Connection2.writer.applyAndAckSettings((Settings) ref$ObjectRef.element);
                        } catch (IOException e) {
                            http2Connection2.failConnection(e);
                        }
                        Unit unit3 = Unit.INSTANCE;
                    }
                    if (http2StreamArr != null) {
                        for (Http2Stream http2Stream : http2StreamArr) {
                            synchronized (http2Stream) {
                                http2Stream.writeBytesMaximum += initialWindowSize;
                                if (initialWindowSize > 0) {
                                    http2Stream.notifyAll();
                                }
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void windowUpdate(int r3, long j) {
            if (r3 == 0) {
                Http2Connection http2Connection = Http2Connection.this;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum += j;
                    http2Connection.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(r3);
            if (stream != null) {
                synchronized (stream) {
                    stream.writeBytesMaximum += j;
                    if (j > 0) {
                        stream.notifyAll();
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public final void priority() {
        }
    }
}
