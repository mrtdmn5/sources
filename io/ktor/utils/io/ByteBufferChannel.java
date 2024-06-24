package io.ktor.utils.io;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.common.collect.Lists;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes3.dex */
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, HasWriteSession {
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    private volatile Job attachedJob;
    public final boolean autoFlush;
    private volatile JoiningState joining;
    public final ObjectPool<ReadWriteBufferState.Initial> pool;
    public int readPosition;
    public final CancellableReusableContinuation<Boolean> readSuspendContinuationCache;
    public final int reservedSize;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    public int writePosition;
    public final WriteSessionImpl writeSession;
    public final CancellableReusableContinuation<Unit> writeSuspendContinuationCache;
    public final ByteBufferChannel$writeSuspension$1 writeSuspension;
    private volatile int writeSuspensionSize;
    public static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _readOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _writeOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");

    public ByteBufferChannel(boolean z) {
        this(z, ObjectPoolKt.BufferObjectPool, 8);
    }

    public static final ClosedElement access$getClosed(ByteBufferChannel byteBufferChannel) {
        return (ClosedElement) byteBufferChannel._closed;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[EDGE_INSN: B:26:0x006e->B:22:0x006e BREAK  A[LOOP:0: B:2:0x0007->B:24:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int readAsMuchAsPossible$default(io.ktor.utils.io.ByteBufferChannel r9, io.ktor.utils.io.core.Buffer r10) {
        /*
            int r0 = r10.limit
            int r1 = r10.writePosition
            int r0 = r0 - r1
            r1 = 0
            r2 = r1
        L7:
            java.nio.ByteBuffer r3 = r9.setupStateForRead()
            r4 = 1
            if (r3 != 0) goto Lf
            goto L1f
        Lf:
            java.lang.Object r5 = r9._state
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = (io.ktor.utils.io.internal.ReadWriteBufferState) r5
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r5.capacity
            int r6 = r5._availableForRead$internal     // Catch: java.lang.Throwable -> L6f
            if (r6 != 0) goto L22
            r9.restoreStateAfterRead()
            r9.tryTerminate$ktor_io()
        L1f:
            r3 = r1
            r7 = r3
            goto L56
        L22:
            int r6 = r10.limit     // Catch: java.lang.Throwable -> L6f
            int r7 = r10.writePosition     // Catch: java.lang.Throwable -> L6f
            int r6 = r6 - r7
            int r7 = r3.remaining()     // Catch: java.lang.Throwable -> L6f
            int r8 = java.lang.Math.min(r6, r0)     // Catch: java.lang.Throwable -> L6f
            int r7 = java.lang.Math.min(r7, r8)     // Catch: java.lang.Throwable -> L6f
            int r7 = r5.tryReadAtMost(r7)     // Catch: java.lang.Throwable -> L6f
            if (r7 > 0) goto L3b
            r3 = r1
            goto L50
        L3b:
            int r8 = r3.remaining()     // Catch: java.lang.Throwable -> L6f
            if (r6 >= r8) goto L49
            int r8 = r3.position()     // Catch: java.lang.Throwable -> L6f
            int r8 = r8 + r6
            r3.limit(r8)     // Catch: java.lang.Throwable -> L6f
        L49:
            io.ktor.utils.io.core.BufferPrimitivesJvmKt.writeFully(r10, r3)     // Catch: java.lang.Throwable -> L6f
            r9.bytesRead(r3, r5, r7)     // Catch: java.lang.Throwable -> L6f
            r3 = r4
        L50:
            r9.restoreStateAfterRead()
            r9.tryTerminate$ktor_io()
        L56:
            int r2 = r2 + r7
            int r0 = r0 - r7
            if (r3 == 0) goto L6e
            int r3 = r10.limit
            int r5 = r10.writePosition
            if (r3 <= r5) goto L61
            goto L62
        L61:
            r4 = r1
        L62:
            if (r4 == 0) goto L6e
            java.lang.Object r3 = r9._state
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = (io.ktor.utils.io.internal.ReadWriteBufferState) r3
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            int r3 = r3._availableForRead$internal
            if (r3 > 0) goto L7
        L6e:
            return r2
        L6f:
            r10 = move-exception
            r9.restoreStateAfterRead()
            r9.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAsMuchAsPossible$default(io.ktor.utils.io.ByteBufferChannel, io.ktor.utils.io.core.Buffer):int");
    }

    public static void resolveDelegation(ByteBufferChannel byteBufferChannel, JoiningState joiningState) {
        if (((ReadWriteBufferState) byteBufferChannel._state) != ReadWriteBufferState.Terminated.INSTANCE) {
        } else {
            throw null;
        }
    }

    @Override // io.ktor.utils.io.ByteChannel
    public final void attachJob(Job job) {
        Job job2 = this.attachedJob;
        if (job2 != null) {
            job2.cancel(null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$attachJob$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                Throwable th2 = th;
                ByteBufferChannel byteBufferChannel = ByteBufferChannel.this;
                byteBufferChannel.attachedJob = null;
                if (th2 != null) {
                    Throwable th3 = th2;
                    while (th3 instanceof CancellationException) {
                        if (Intrinsics.areEqual(th3, th3.getCause())) {
                            break;
                        }
                        Throwable cause = th3.getCause();
                        if (cause == null) {
                            break;
                        }
                        th3 = cause;
                    }
                    th2 = th3;
                    byteBufferChannel.cancel(th2);
                }
                return Unit.INSTANCE;
            }
        }, 2);
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final WriterSuspendSession beginWriteSession() {
        WriteSessionImpl writeSessionImpl = this.writeSession;
        ByteBufferChannel byteBufferChannel = writeSessionImpl.current;
        byteBufferChannel.resolveChannelInstance$ktor_io();
        writeSessionImpl.current = byteBufferChannel;
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer != null) {
            writeSessionImpl.byteBuffer = byteBuffer;
            ChunkBuffer ChunkBuffer = BufferUtilsJvmKt.ChunkBuffer(((ReadWriteBufferState) writeSessionImpl.current._state).backingBuffer, null);
            writeSessionImpl.view = ChunkBuffer;
            BufferUtilsJvmKt.resetFromContentToWrite(ChunkBuffer, writeSessionImpl.byteBuffer);
            writeSessionImpl.ringBufferCapacity = ((ReadWriteBufferState) writeSessionImpl.current._state).capacity;
        }
        return writeSessionImpl;
    }

    public final void bytesRead(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int r5) {
        boolean z;
        if (r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.readPosition = carryIndex(this.readPosition + r5, byteBuffer);
            ringBufferCapacity.completeRead(r5);
            this.totalBytesRead += r5;
            resumeWriteOp();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void bytesWritten(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int r5) {
        boolean z;
        if (r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.writePosition = carryIndex(this.writePosition + r5, byteBuffer);
            ringBufferCapacity.completeWrite(r5);
            this.totalBytesWritten += r5;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean cancel(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return close(th);
    }

    public final int carryIndex(int r3, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        int r1 = this.reservedSize;
        if (r3 >= capacity - r1) {
            return r3 - (byteBuffer.capacity() - r1);
        }
        return r3;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable th) {
        ClosedElement closedElement;
        boolean z;
        boolean z2;
        JoiningState joiningState;
        Throwable th2;
        boolean z3 = false;
        if (((ClosedElement) this._closed) != null) {
            return false;
        }
        if (th == null) {
            closedElement = ClosedElement.EmptyCause;
        } else {
            closedElement = new ClosedElement(th);
        }
        ((ReadWriteBufferState) this._state).capacity.flush();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closed$FU;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, closedElement)) {
                z = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != null) {
                z = false;
                break;
            }
        }
        if (!z) {
            return false;
        }
        ((ReadWriteBufferState) this._state).capacity.flush();
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
        if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.totalCapacity) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || th != null) {
            tryTerminate$ktor_io();
        }
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            if (th != null) {
                continuation.resumeWith(ResultKt.createFailure(th));
            } else {
                if (((ReadWriteBufferState) this._state).capacity._availableForRead$internal > 0) {
                    z3 = true;
                }
                continuation.resumeWith(Boolean.valueOf(z3));
            }
        }
        Continuation continuation2 = (Continuation) _writeOp$FU.getAndSet(this, null);
        if (continuation2 != null) {
            if (th == null) {
                th2 = new ClosedWriteChannelException("Byte channel was closed");
            } else {
                th2 = th;
            }
            continuation2.resumeWith(ResultKt.createFailure(th2));
        }
        if (((ReadWriteBufferState) this._state) == ReadWriteBufferState.Terminated.INSTANCE && (joiningState = this.joining) != null) {
            ensureClosedJoined(joiningState);
        }
        if (th != null) {
            Job job = this.attachedJob;
            if (job != null) {
                job.cancel(null);
            }
            this.readSuspendContinuationCache.close(th);
            this.writeSuspendContinuationCache.close(th);
            return true;
        }
        this.writeSuspendContinuationCache.close(new ClosedWriteChannelException("Byte channel was closed"));
        CancellableReusableContinuation<Boolean> cancellableReusableContinuation = this.readSuspendContinuationCache;
        Boolean value = Boolean.valueOf(((ReadWriteBufferState) this._state).capacity.flush());
        cancellableReusableContinuation.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        cancellableReusableContinuation.resumeWith(value);
        CancellableReusableContinuation.JobRelation jobRelation = (CancellableReusableContinuation.JobRelation) CancellableReusableContinuation.jobCancellationHandler$FU.getAndSet(cancellableReusableContinuation, null);
        if (jobRelation != null) {
            jobRelation.dispose();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0330, code lost:            if (r13.tryCompleteJoining(r12) == false) goto L165;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0100, code lost:            r2 = r27;        r3 = r28;        r6 = r29;        r0 = r1;        r1 = r15;        r27 = r16;        r9 = r19;        r16 = r20;        r15 = r8;        r8 = r18;     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0390 A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0147 A[Catch: all -> 0x0164, TRY_LEAVE, TryCatch #2 {all -> 0x0164, blocks: (B:170:0x0143, B:172:0x0147), top: B:169:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cc A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03a1 A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02c5 A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02eb A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x033a A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0106 A[Catch: all -> 0x036a, TRY_LEAVE, TryCatch #5 {all -> 0x036a, blocks: (B:64:0x0100, B:66:0x0106), top: B:63:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0294 A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029e A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0386 A[Catch: all -> 0x00d4, TryCatch #10 {all -> 0x00d4, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00cc, B:20:0x00d0, B:21:0x00d7, B:25:0x02c5, B:29:0x02cc, B:31:0x02d8, B:32:0x02e5, B:34:0x02eb, B:36:0x02f5, B:40:0x0319, B:43:0x0323, B:46:0x0336, B:48:0x033a, B:55:0x032c, B:58:0x00e6, B:77:0x028e, B:79:0x0294, B:82:0x029e, B:83:0x02b3, B:85:0x0298, B:95:0x0380, B:97:0x0386, B:100:0x0390, B:101:0x0398, B:102:0x039e, B:103:0x038a, B:194:0x03a1, B:195:0x03a5, B:200:0x005a), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x02d8 -> B:15:0x0365). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object copyDirect$ktor_io(io.ktor.utils.io.ByteBufferChannel r27, long r28, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.copyDirect$ktor_io(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ReadWriteBufferState currentState$ktor_io() {
        return (ReadWriteBufferState) this._state;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object discard(Continuation continuation) {
        ByteBuffer byteBuffer = setupStateForRead();
        long j = 0;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int tryReadAtMost = ringBufferCapacity.tryReadAtMost((int) Math.min(2147483647L, Long.MAX_VALUE));
                    bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                    j = tryReadAtMost + 0;
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        long j2 = j;
        if (j2 != Long.MAX_VALUE && !isClosedForRead()) {
            return discardSuspend(j2, Long.MAX_VALUE, continuation);
        }
        return new Long(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x009f, code lost:            if (((java.lang.Boolean) r14).booleanValue() == false) goto L39;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:            if (r13.isClosedForRead() != false) goto L39;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:            r0.L$0 = r13;        r0.L$1 = r12;        r0.J$0 = r10;        r0.label = 1;        r14 = r13.readSuspend(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:            if (r14 != r1) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:            return r1;     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[EDGE_INSN: B:29:0x0084->B:30:0x0084 BREAK  A[LOOP:0: B:16:0x0043->B:35:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:16:0x0043->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0096 -> B:10:0x0099). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object discardSuspend(long r10, long r12, kotlin.coroutines.Continuation<? super java.lang.Long> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$discardSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            long r10 = r0.J$0
            kotlin.jvm.internal.Ref$LongRef r12 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r13 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L99
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L43:
            long r4 = r12.element
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto Laa
            java.nio.ByteBuffer r14 = r13.setupStateForRead()
            if (r14 != 0) goto L50
            goto L60
        L50:
            java.lang.Object r2 = r13._state
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = (io.ktor.utils.io.internal.ReadWriteBufferState) r2
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            int r4 = r2._availableForRead$internal     // Catch: java.lang.Throwable -> La2
            if (r4 != 0) goto L62
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
        L60:
            r14 = 0
            goto L82
        L62:
            long r4 = r12.element     // Catch: java.lang.Throwable -> La2
            long r4 = r10 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.lang.Throwable -> La2
            int r4 = (int) r4     // Catch: java.lang.Throwable -> La2
            int r4 = r2.tryReadAtMost(r4)     // Catch: java.lang.Throwable -> La2
            r13.bytesRead(r14, r2, r4)     // Catch: java.lang.Throwable -> La2
            long r5 = r12.element     // Catch: java.lang.Throwable -> La2
            long r7 = (long) r4     // Catch: java.lang.Throwable -> La2
            long r5 = r5 + r7
            r12.element = r5     // Catch: java.lang.Throwable -> La2
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
            r14 = r3
        L82:
            if (r14 != 0) goto L43
            boolean r14 = r13.isClosedForRead()
            if (r14 != 0) goto Laa
            r0.L$0 = r13
            r0.L$1 = r12
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r14 = r13.readSuspend(r0)
            if (r14 != r1) goto L99
            return r1
        L99:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L43
            goto Laa
        La2:
            r10 = move-exception
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
            throw r10
        Laa:
            long r10 = r12.element
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final void endWriteSession(int r6) {
        WriteSessionImpl writeSessionImpl = this.writeSession;
        if (r6 >= 0) {
            int r1 = writeSessionImpl.locked;
            if (r6 <= r1) {
                writeSessionImpl.locked = r1 - r6;
                ByteBufferChannel byteBufferChannel = writeSessionImpl.current;
                ByteBuffer buffer = writeSessionImpl.byteBuffer;
                RingBufferCapacity capacity = writeSessionImpl.ringBufferCapacity;
                byteBufferChannel.getClass();
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                Intrinsics.checkNotNullParameter(capacity, "capacity");
                byteBufferChannel.bytesWritten(buffer, capacity, r6);
                int r62 = writeSessionImpl.locked;
                if (r62 > 0) {
                    writeSessionImpl.ringBufferCapacity.completeRead(r62);
                    writeSessionImpl.locked = 0;
                }
                writeSessionImpl.current.restoreStateAfterWrite$ktor_io();
                writeSessionImpl.current.tryTerminate$ktor_io();
                return;
            }
        } else {
            writeSessionImpl.getClass();
        }
        if (r6 < 0) {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Written bytes count shouldn't be negative: ", r6));
        }
        throw new IllegalStateException(ConstraintWidget$$ExternalSyntheticOutline0.m(SuggestionsAdapter$$ExternalSyntheticOutline0.m("Unable to mark ", r6, " bytes as written: only "), writeSessionImpl.locked, " were pre-locked."));
    }

    public final void ensureClosedJoined(JoiningState joiningState) {
        if (((ClosedElement) this._closed) == null) {
            return;
        }
        this.joining = null;
        joiningState.getClass();
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final void flush() {
        flushImpl(1);
    }

    public final void flushImpl(int r5) {
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.Terminated terminated;
        do {
            readWriteBufferState = (ReadWriteBufferState) this._state;
            terminated = ReadWriteBufferState.Terminated.INSTANCE;
            if (readWriteBufferState == terminated) {
                return;
            } else {
                readWriteBufferState.capacity.flush();
            }
        } while (readWriteBufferState != ((ReadWriteBufferState) this._state));
        int r2 = readWriteBufferState.capacity._availableForWrite$internal;
        if (readWriteBufferState.capacity._availableForRead$internal >= 1) {
            resumeReadOp();
        }
        JoiningState joiningState = this.joining;
        if (r2 >= r5) {
            if (joiningState == null || ((ReadWriteBufferState) this._state) == terminated) {
                resumeWriteOp();
            }
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean getAutoFlush() {
        return this.autoFlush;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int getAvailableForRead() {
        return ((ReadWriteBufferState) this._state).capacity._availableForRead$internal;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Throwable getClosedCause() {
        ClosedElement closedElement = (ClosedElement) this._closed;
        if (closedElement != null) {
            return closedElement.cause;
        }
        return null;
    }

    public final JoiningState getJoining$ktor_io() {
        return this.joining;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean isClosedForRead() {
        if (((ReadWriteBufferState) this._state) == ReadWriteBufferState.Terminated.INSTANCE && ((ClosedElement) this._closed) != null) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean isClosedForWrite() {
        if (((ClosedElement) this._closed) != null) {
            return true;
        }
        return false;
    }

    public final void prepareBuffer(ByteBuffer byteBuffer, int r6, int r7) {
        boolean z;
        boolean z2 = true;
        if (r6 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r7 < 0) {
                z2 = false;
            }
            if (z2) {
                int capacity = byteBuffer.capacity() - this.reservedSize;
                int r72 = r7 + r6;
                if (r72 <= capacity) {
                    capacity = r72;
                }
                byteBuffer.limit(capacity);
                byteBuffer.position(r6);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final int readAsMuchAsPossible(byte[] bArr, int r9, int r10) {
        ByteBuffer byteBuffer = setupStateForRead();
        int r1 = 0;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = byteBuffer.capacity() - this.reservedSize;
                    while (true) {
                        int r4 = r10 - r1;
                        if (r4 == 0) {
                            break;
                        }
                        int r5 = this.readPosition;
                        int tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(capacity - r5, r4));
                        if (tryReadAtMost == 0) {
                            break;
                        }
                        byteBuffer.limit(r5 + tryReadAtMost);
                        byteBuffer.position(r5);
                        byteBuffer.get(bArr, r9 + r1, tryReadAtMost);
                        bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                        r1 += tryReadAtMost;
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        return r1;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(byte[] bArr, int r4, int r5, ContinuationImpl continuationImpl) {
        int readAsMuchAsPossible = readAsMuchAsPossible(bArr, r4, r5);
        if (readAsMuchAsPossible == 0 && ((ClosedElement) this._closed) != null) {
            readAsMuchAsPossible = ((ReadWriteBufferState) this._state).capacity.flush() ? readAsMuchAsPossible(bArr, r4, r5) : -1;
        } else if (readAsMuchAsPossible <= 0 && r5 != 0) {
            return readAvailableSuspend(bArr, r4, r5, continuationImpl);
        }
        return new Integer(readAsMuchAsPossible);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L68
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.readSuspend(r0)
            if (r7 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5a
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L5a:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable(r6, r0)
            if (r7 != r1) goto L68
            return r1
        L68:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        boolean z;
        if (isClosedForWrite()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null);
                try {
                    ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder, 1, null);
                    while (true) {
                        try {
                            if (prepareWriteHead.limit - prepareWriteHead.writePosition > j) {
                                prepareWriteHead.resetForWrite((int) j);
                            }
                            j -= readAsMuchAsPossible$default(this, prepareWriteHead);
                            if (j > 0 && !isClosedForRead()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                prepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder, 1, prepareWriteHead);
                            } else {
                                bytePacketBuilder.afterHeadWrite();
                                return bytePacketBuilder.build();
                            }
                        } catch (Throwable th) {
                            bytePacketBuilder.afterHeadWrite();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    bytePacketBuilder.close();
                    throw th2;
                }
            } else {
                Lists.access$rethrowClosed(closedCause);
                throw null;
            }
        } else {
            return readRemainingSuspend(j, continuation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009a A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x008d, B:16:0x009a, B:17:0x0054, B:19:0x0060, B:20:0x0064, B:22:0x0074, B:24:0x007a), top: B:10:0x002d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x008d, B:16:0x009a, B:17:0x0054, B:19:0x0060, B:20:0x0064, B:22:0x0074, B:24:0x007a), top: B:10:0x002d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x008d, B:16:0x009a, B:17:0x0054, B:19:0x0060, B:20:0x0064, B:22:0x0074, B:24:0x007a), top: B:10:0x002d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f A[Catch: all -> 0x00b2, TRY_ENTER, TryCatch #1 {all -> 0x00b2, blocks: (B:28:0x009f, B:30:0x00a8, B:32:0x00ad, B:36:0x00ae, B:37:0x00b1, B:11:0x002d, B:12:0x008d, B:16:0x009a, B:17:0x0054, B:19:0x0060, B:20:0x0064, B:22:0x0074, B:24:0x007a), top: B:10:0x002d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008a -> B:12:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:15:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readRemainingSuspend(long r11, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = r0.L$4
            io.ktor.utils.io.core.Output r12 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = r0.L$2
            io.ktor.utils.io.core.BytePacketBuilder r4 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L31
            goto L8d
        L31:
            r11 = move-exception
            goto Lae
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3c:
            kotlin.ResultKt.throwOnFailure(r13)
            io.ktor.utils.io.core.BytePacketBuilder r13 = new io.ktor.utils.io.core.BytePacketBuilder
            r2 = 0
            r13.<init>(r2)
            kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef     // Catch: java.lang.Throwable -> Lb5
            r4.<init>()     // Catch: java.lang.Throwable -> Lb5
            r4.element = r11     // Catch: java.lang.Throwable -> Lb5
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r13, r3, r2)     // Catch: java.lang.Throwable -> Lb5
            r5 = r10
            r12 = r13
            r2 = r4
            r4 = r12
        L54:
            int r13 = r11.limit     // Catch: java.lang.Throwable -> L31
            int r6 = r11.writePosition     // Catch: java.lang.Throwable -> L31
            int r13 = r13 - r6
            long r6 = (long) r13     // Catch: java.lang.Throwable -> L31
            long r8 = r2.element     // Catch: java.lang.Throwable -> L31
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 <= 0) goto L64
            int r13 = (int) r8     // Catch: java.lang.Throwable -> L31
            r11.resetForWrite(r13)     // Catch: java.lang.Throwable -> L31
        L64:
            int r13 = readAsMuchAsPossible$default(r5, r11)     // Catch: java.lang.Throwable -> L31
            long r6 = r2.element     // Catch: java.lang.Throwable -> L31
            long r8 = (long) r13     // Catch: java.lang.Throwable -> L31
            long r6 = r6 - r8
            r2.element = r6     // Catch: java.lang.Throwable -> L31
            r8 = 0
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 <= 0) goto L97
            boolean r13 = r5.isClosedForRead()     // Catch: java.lang.Throwable -> L31
            if (r13 != 0) goto L97
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L31
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L31
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L31
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L31
            r0.L$4 = r11     // Catch: java.lang.Throwable -> L31
            r0.label = r3     // Catch: java.lang.Throwable -> L31
            java.lang.Object r13 = r5.readSuspend(r0)     // Catch: java.lang.Throwable -> L31
            if (r13 != r1) goto L8d
            return r1
        L8d:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Throwable -> L31
            boolean r13 = r13.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r13 == 0) goto L97
            r13 = r3
            goto L98
        L97:
            r13 = 0
        L98:
            if (r13 == 0) goto L9f
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r12, r3, r11)     // Catch: java.lang.Throwable -> L31
            goto L54
        L9f:
            r12.afterHeadWrite()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Throwable r11 = r5.getClosedCause()     // Catch: java.lang.Throwable -> Lb2
            if (r11 != 0) goto Lad
            io.ktor.utils.io.core.ByteReadPacket r11 = r4.build()     // Catch: java.lang.Throwable -> Lb2
            return r11
        Lad:
            throw r11     // Catch: java.lang.Throwable -> Lb2
        Lae:
            r12.afterHeadWrite()     // Catch: java.lang.Throwable -> Lb2
            throw r11     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r11 = move-exception
            r13 = r4
            goto Lb6
        Lb5:
            r11 = move-exception
        Lb6:
            r13.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readRemainingSuspend(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object readSuspend(ContinuationImpl continuationImpl) {
        boolean z = true;
        if (((ReadWriteBufferState) this._state).capacity._availableForRead$internal >= 1) {
            return Boolean.TRUE;
        }
        ClosedElement closedElement = (ClosedElement) this._closed;
        if (closedElement != null) {
            Throwable th = closedElement.cause;
            if (th == null) {
                RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
                if (!ringBufferCapacity.flush() || ringBufferCapacity._availableForRead$internal < 1) {
                    z = false;
                }
                if (((Continuation) this._readOp) == null) {
                    return Boolean.valueOf(z);
                }
                throw new IllegalStateException("Read operation is already in progress");
            }
            Lists.access$rethrowClosed(th);
            throw null;
        }
        return readSuspendImpl(1, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readSuspendImpl(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.ByteBufferChannel r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L29
            goto L6e
        L29:
            r6 = move-exception
            goto L72
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = (io.ktor.utils.io.internal.ReadWriteBufferState) r6
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r6.capacity
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L54
            io.ktor.utils.io.internal.JoiningState r2 = r4.joining
            if (r2 == 0) goto L52
            java.lang.Object r2 = r4._writeOp
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            if (r2 == 0) goto L52
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r6 == r2) goto L54
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r6 != 0) goto L54
        L52:
            r6 = r3
            goto L55
        L54:
            r6 = 0
        L55:
            if (r6 != 0) goto L5a
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L5a:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L6f
            r0.label = r3     // Catch: java.lang.Throwable -> L6f
            io.ktor.utils.io.internal.CancellableReusableContinuation<java.lang.Boolean> r6 = r4.readSuspendContinuationCache     // Catch: java.lang.Throwable -> L6f
            r4.suspensionForSize(r5, r6)     // Catch: java.lang.Throwable -> L6f
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r6 = r6.completeSuspendBlock(r5)     // Catch: java.lang.Throwable -> L6f
            if (r6 != r1) goto L6e
            return r1
        L6e:
            return r6
        L6f:
            r5 = move-exception
            r6 = r5
            r5 = r4
        L72:
            r0 = 0
            r5._readOp = r0
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readSuspendImpl(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void releaseBuffer(ReadWriteBufferState.Initial initial) {
        this.pool.recycle(initial);
    }

    public final void resolveChannelInstance$ktor_io() {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
    }

    public final void restoreStateAfterRead() {
        ReadWriteBufferState stopReading$ktor_io;
        boolean z;
        boolean z2;
        boolean z3;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            Object obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty != null) {
                idleNonEmpty.capacity.resetForWrite();
                resumeWriteOp();
                readWriteBufferState = null;
            }
            stopReading$ktor_io = readWriteBufferState2.stopReading$ktor_io();
            if ((stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && ((ReadWriteBufferState) this._state) == readWriteBufferState2 && stopReading$ktor_io.capacity.tryLockForRelease()) {
                stopReading$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                readWriteBufferState = stopReading$ktor_io;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            while (true) {
                z = true;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, stopReading$ktor_io)) {
                    z2 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z2 = false;
                    break;
                }
            }
        } while (!z2);
        ReadWriteBufferState.IdleEmpty idleEmpty = ReadWriteBufferState.IdleEmpty.INSTANCE;
        if (stopReading$ktor_io == idleEmpty) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty2 != null) {
                releaseBuffer(idleNonEmpty2.initial);
            }
            resumeWriteOp();
            return;
        }
        if (stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) {
            RingBufferCapacity ringBufferCapacity = stopReading$ktor_io.capacity;
            if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.totalCapacity) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && stopReading$ktor_io.capacity.tryLockForRelease()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, stopReading$ktor_io, idleEmpty)) {
                        break;
                    } else if (atomicReferenceFieldUpdater2.get(this) != stopReading$ktor_io) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    stopReading$ktor_io.capacity.resetForWrite();
                    releaseBuffer(((ReadWriteBufferState.IdleNonEmpty) stopReading$ktor_io).initial);
                    resumeWriteOp();
                }
            }
        }
    }

    public final void restoreStateAfterWrite$ktor_io() {
        ReadWriteBufferState stopWriting$ktor_io;
        boolean z;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty;
        boolean z2;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            Object obj = this._state;
            stopWriting$ktor_io = ((ReadWriteBufferState) obj).stopWriting$ktor_io();
            z = true;
            if (stopWriting$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) {
                RingBufferCapacity ringBufferCapacity = stopWriting$ktor_io.capacity;
                if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.totalCapacity) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    stopWriting$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                    readWriteBufferState = stopWriting$ktor_io;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, stopWriting$ktor_io)) {
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (stopWriting$ktor_io == ReadWriteBufferState.IdleEmpty.INSTANCE && (idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState) != null) {
            releaseBuffer(idleNonEmpty.initial);
        }
    }

    public final void resumeReadOp() {
        Throwable th = null;
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement != null) {
                th = closedElement.cause;
            }
            if (th != null) {
                continuation.resumeWith(ResultKt.createFailure(th));
            } else {
                continuation.resumeWith(Boolean.TRUE);
            }
        }
    }

    public final void resumeWriteOp() {
        Continuation continuation;
        ClosedElement closedElement;
        boolean z;
        Object createFailure;
        do {
            continuation = (Continuation) this._writeOp;
            if (continuation == null) {
                return;
            }
            closedElement = (ClosedElement) this._closed;
            if (closedElement == null && this.joining != null) {
                ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
                if (!(readWriteBufferState instanceof ReadWriteBufferState.Writing) && !(readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting) && readWriteBufferState != ReadWriteBufferState.Terminated.INSTANCE) {
                    return;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _writeOp$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, continuation, null)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != continuation) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (closedElement == null) {
            createFailure = Unit.INSTANCE;
        } else {
            createFailure = ResultKt.createFailure(closedElement.getSendException());
        }
        continuation.resumeWith(createFailure);
    }

    public final ByteBuffer setupStateForRead() {
        boolean z;
        boolean areEqual;
        Throwable th;
        ReadWriteBufferState startReading$ktor_io;
        Throwable th2;
        do {
            Object obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            z = true;
            if (Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.Terminated.INSTANCE)) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.IdleEmpty.INSTANCE);
            }
            if (areEqual) {
                ClosedElement closedElement = (ClosedElement) this._closed;
                if (closedElement == null || (th = closedElement.cause) == null) {
                    return null;
                }
                Lists.access$rethrowClosed(th);
                throw null;
            }
            ClosedElement closedElement2 = (ClosedElement) this._closed;
            if (closedElement2 != null && (th2 = closedElement2.cause) != null) {
                Lists.access$rethrowClosed(th2);
                throw null;
            }
            if (readWriteBufferState.capacity._availableForRead$internal == 0) {
                return null;
            }
            startReading$ktor_io = readWriteBufferState.startReading$ktor_io();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, startReading$ktor_io)) {
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        ByteBuffer readBuffer = startReading$ktor_io.getReadBuffer();
        prepareBuffer(readBuffer, this.readPosition, startReading$ktor_io.capacity._availableForRead$internal);
        return readBuffer;
    }

    public final ByteBuffer setupStateForWrite$ktor_io() {
        ReadWriteBufferState startWriting$ktor_io;
        boolean z;
        Continuation continuation = (Continuation) this._writeOp;
        if (continuation == null) {
            ReadWriteBufferState.Initial initial = null;
            while (true) {
                Object obj = this._state;
                ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
                if (this.joining != null) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    return null;
                }
                if (((ClosedElement) this._closed) != null) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    ClosedElement closedElement = (ClosedElement) this._closed;
                    Intrinsics.checkNotNull(closedElement);
                    Lists.access$rethrowClosed(closedElement.getSendException());
                    throw null;
                }
                if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                    if (initial == null) {
                        initial = this.pool.borrow();
                        initial.capacity.resetForWrite();
                    }
                    startWriting$ktor_io = initial.writingState;
                } else {
                    if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                        if (initial != null) {
                            releaseBuffer(initial);
                        }
                        if (this.joining != null) {
                            return null;
                        }
                        ClosedElement closedElement2 = (ClosedElement) this._closed;
                        Intrinsics.checkNotNull(closedElement2);
                        Lists.access$rethrowClosed(closedElement2.getSendException());
                        throw null;
                    }
                    startWriting$ktor_io = readWriteBufferState.startWriting$ktor_io();
                }
                ReadWriteBufferState readWriteBufferState2 = startWriting$ktor_io;
                ReadWriteBufferState.Initial initial2 = initial;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, readWriteBufferState2)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    if (((ClosedElement) this._closed) == null) {
                        ByteBuffer writeBuffer = readWriteBufferState2.getWriteBuffer();
                        if (initial2 != null) {
                            if (readWriteBufferState != null) {
                                if (readWriteBufferState != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                                    releaseBuffer(initial2);
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("old");
                                throw null;
                            }
                        }
                        prepareBuffer(writeBuffer, this.writePosition, readWriteBufferState2.capacity._availableForWrite$internal);
                        return writeBuffer;
                    }
                    restoreStateAfterWrite$ktor_io();
                    tryTerminate$ktor_io();
                    ClosedElement closedElement3 = (ClosedElement) this._closed;
                    Intrinsics.checkNotNull(closedElement3);
                    Lists.access$rethrowClosed(closedElement3.getSendException());
                    throw null;
                }
                initial = initial2;
            }
        } else {
            throw new IllegalStateException("Write operation is already in progress: " + continuation);
        }
    }

    public final boolean shouldResumeReadOp() {
        if (this.joining != null && (((ReadWriteBufferState) this._state) == ReadWriteBufferState.IdleEmpty.INSTANCE || (((ReadWriteBufferState) this._state) instanceof ReadWriteBufferState.IdleNonEmpty))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f1, code lost:            r2 = false;     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1 A[EDGE_INSN: B:89:0x00f1->B:69:0x00f1 BREAK  A[LOOP:1: B:15:0x0065->B:84:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void suspensionForSize(int r6, io.ktor.utils.io.internal.CancellableReusableContinuation r7) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.suspensionForSize(int, io.ktor.utils.io.internal.CancellableReusableContinuation):void");
    }

    public final String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + ((ReadWriteBufferState) this._state) + ')';
    }

    public final boolean tryCompleteJoining(JoiningState joiningState) {
        if (!tryReleaseBuffer(true)) {
            return false;
        }
        ensureClosedJoined(joiningState);
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            continuation.resumeWith(ResultKt.createFailure(new IllegalStateException("Joining is in progress")));
        }
        resumeWriteOp();
        return true;
    }

    public final boolean tryReleaseBuffer(boolean z) {
        boolean z2;
        Throwable th;
        ReadWriteBufferState.Initial initial = null;
        do {
            Object obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (initial != null) {
                if (closedElement != null) {
                    th = closedElement.cause;
                } else {
                    th = null;
                }
                if (th == null) {
                    initial.capacity.resetForWrite();
                }
                resumeWriteOp();
                initial = null;
            }
            ReadWriteBufferState.Terminated terminated = ReadWriteBufferState.Terminated.INSTANCE;
            if (readWriteBufferState == terminated) {
                return true;
            }
            z2 = false;
            if (readWriteBufferState != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                if (closedElement != null && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState.capacity.tryLockForRelease() || closedElement.cause != null)) {
                    if (closedElement.cause != null) {
                        RingBufferCapacity ringBufferCapacity = readWriteBufferState.capacity;
                        ringBufferCapacity.getClass();
                        RingBufferCapacity._availableForWrite$FU$internal.getAndSet(ringBufferCapacity, 0);
                    }
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).initial;
                } else {
                    if (!z || !(readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) || !readWriteBufferState.capacity.tryLockForRelease()) {
                        return false;
                    }
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).initial;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, terminated)) {
                    z2 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        } while (!z2);
        if (initial != null && ((ReadWriteBufferState) this._state) == ReadWriteBufferState.Terminated.INSTANCE) {
            releaseBuffer(initial);
        }
        return true;
    }

    public final void tryTerminate$ktor_io() {
        if (((ClosedElement) this._closed) != null && tryReleaseBuffer(false)) {
            JoiningState joiningState = this.joining;
            if (joiningState != null) {
                ensureClosedJoined(joiningState);
            }
            resumeReadOp();
            resumeWriteOp();
        }
    }

    public final int tryWritePacketPart(ByteReadPacket byteReadPacket) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement == null) {
                int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost((int) Math.min(byteReadPacket.getRemaining(), byteBuffer.remaining()));
                if (tryWriteAtMost > 0) {
                    byteBuffer.limit(byteBuffer.position() + tryWriteAtMost);
                    ByteBuffersKt.readFully(byteReadPacket, byteBuffer);
                    bytesWritten(byteBuffer, ringBufferCapacity, tryWriteAtMost);
                }
                return tryWriteAtMost;
            }
            Lists.access$rethrowClosed(closedElement.getSendException());
            throw null;
        } finally {
            if (ringBufferCapacity.isFull() || this.autoFlush) {
                flushImpl(1);
            }
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
        }
    }

    public final Object tryWriteSuspend$ktor_io(int r2, ContinuationImpl continuationImpl) {
        if (!writeSuspendPredicate(r2)) {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement == null) {
                return Unit.INSTANCE;
            }
            Lists.access$rethrowClosed(closedElement.getSendException());
            throw null;
        }
        this.writeSuspensionSize = r2;
        if (this.attachedJob != null) {
            Object invoke = this.writeSuspension.invoke(continuationImpl);
            if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return invoke;
            }
            return Unit.INSTANCE;
        }
        CancellableReusableContinuation<Unit> cancellableReusableContinuation = this.writeSuspendContinuationCache;
        this.writeSuspension.invoke(cancellableReusableContinuation);
        Object completeSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuationImpl));
        if (completeSuspendBlock == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return completeSuspendBlock;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:            r9.limit(r3);        bytesWritten(r0, r1, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeAsMuchAsPossible(java.nio.ByteBuffer r9) {
        /*
            r8 = this;
            io.ktor.utils.io.internal.JoiningState r0 = r8.joining
            if (r0 == 0) goto L7
            resolveDelegation(r8, r0)
        L7:
            java.nio.ByteBuffer r0 = r8.setupStateForWrite$ktor_io()
            if (r0 != 0) goto Le
            return
        Le:
            java.lang.Object r1 = r8._state
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = (io.ktor.utils.io.internal.ReadWriteBufferState) r1
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.capacity
            r2 = 1
            java.lang.Object r3 = r8._closed     // Catch: java.lang.Throwable -> L86
            io.ktor.utils.io.internal.ClosedElement r3 = (io.ktor.utils.io.internal.ClosedElement) r3     // Catch: java.lang.Throwable -> L86
            if (r3 != 0) goto L7d
            int r3 = r9.limit()     // Catch: java.lang.Throwable -> L86
            r4 = 0
            r5 = r4
        L21:
            int r6 = r9.position()     // Catch: java.lang.Throwable -> L86
            int r6 = r3 - r6
            if (r6 == 0) goto L63
            int r7 = r0.remaining()     // Catch: java.lang.Throwable -> L86
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L86
            int r6 = r1.tryWriteAtMost(r6)     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L63
            if (r6 <= 0) goto L3b
            r7 = r2
            goto L3c
        L3b:
            r7 = r4
        L3c:
            if (r7 == 0) goto L57
            int r7 = r9.position()     // Catch: java.lang.Throwable -> L86
            int r7 = r7 + r6
            r9.limit(r7)     // Catch: java.lang.Throwable -> L86
            r0.put(r9)     // Catch: java.lang.Throwable -> L86
            int r5 = r5 + r6
            int r6 = r8.writePosition     // Catch: java.lang.Throwable -> L86
            int r6 = r6 + r5
            int r6 = r8.carryIndex(r6, r0)     // Catch: java.lang.Throwable -> L86
            int r7 = r1._availableForWrite$internal     // Catch: java.lang.Throwable -> L86
            r8.prepareBuffer(r0, r6, r7)     // Catch: java.lang.Throwable -> L86
            goto L21
        L57:
            java.lang.String r9 = "Failed requirement."
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L86
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L86
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L86
            throw r0     // Catch: java.lang.Throwable -> L86
        L63:
            r9.limit(r3)     // Catch: java.lang.Throwable -> L86
            r8.bytesWritten(r0, r1, r5)     // Catch: java.lang.Throwable -> L86
            boolean r9 = r1.isFull()
            if (r9 != 0) goto L73
            boolean r9 = r8.autoFlush
            if (r9 == 0) goto L76
        L73:
            r8.flushImpl(r2)
        L76:
            r8.restoreStateAfterWrite$ktor_io()
            r8.tryTerminate$ktor_io()
            return
        L7d:
            java.lang.Throwable r9 = r3.getSendException()     // Catch: java.lang.Throwable -> L86
            com.google.common.collect.Lists.access$rethrowClosed(r9)     // Catch: java.lang.Throwable -> L86
            r9 = 0
            throw r9     // Catch: java.lang.Throwable -> L86
        L86:
            r9 = move-exception
            boolean r0 = r1.isFull()
            if (r0 != 0) goto L91
            boolean r0 = r8.autoFlush
            if (r0 == 0) goto L94
        L91:
            r8.flushImpl(r2)
        L94:
            r8.restoreStateAfterWrite$ktor_io()
            r8.tryTerminate$ktor_io()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeAsMuchAsPossible(java.nio.ByteBuffer):void");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(ByteBuffer byteBuffer, ReadingKt$toByteReadChannel$1 readingKt$toByteReadChannel$1) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        writeAsMuchAsPossible(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = writeFullySuspend(byteBuffer, readingKt$toByteReadChannel$1);
        return writeFullySuspend == CoroutineSingletons.COROUTINE_SUSPENDED ? writeFullySuspend : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0055 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeFullySuspend(io.ktor.utils.io.core.Buffer r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 == r3) goto L34
            r6 = 2
            if (r2 != r6) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            io.ktor.utils.io.core.Buffer r6 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L40:
            int r7 = r6.writePosition
            int r4 = r6.readPosition
            if (r7 <= r4) goto L48
            r7 = r3
            goto L49
        L48:
            r7 = 0
        L49:
            if (r7 == 0) goto L63
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.tryWriteSuspend$ktor_io(r3, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            io.ktor.utils.io.internal.JoiningState r7 = r2.joining
            if (r7 == 0) goto L5f
            resolveDelegation(r2, r7)
        L5f:
            r2.writeAsMuchAsPossible(r6)
            goto L40
        L63:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        do {
            try {
                if (!(!byteReadPacket.getEndOfInput())) {
                    break;
                }
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        } while (tryWritePacketPart(byteReadPacket) != 0);
        if (byteReadPacket.getRemaining() > 0) {
            JoiningState joiningState2 = this.joining;
            if (joiningState2 != null) {
                resolveDelegation(this, joiningState2);
            }
            Object writePacketSuspend = writePacketSuspend(byteReadPacket, continuation);
            if (writePacketSuspend != CoroutineSingletons.COROUTINE_SUSPENDED) {
                return Unit.INSTANCE;
            }
            return writePacketSuspend;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x002a, B:20:0x003f, B:21:0x005b, B:23:0x005f, B:24:0x0065, B:25:0x0047, B:27:0x004e), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x002a, B:20:0x003f, B:21:0x005b, B:23:0x005f, B:24:0x0065, B:25:0x0047, B:27:0x004e), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0058 -> B:21:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writePacketSuspend(io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 == r3) goto L3b
            r5 = 2
            if (r2 != r5) goto L33
            io.ktor.utils.io.ByteBufferChannel r5 = r0.L$0
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L63
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L63
            r5.release()
            return r6
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            io.ktor.utils.io.core.ByteReadPacket r5 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L63
            goto L5b
        L43:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L47:
            boolean r6 = r5.getEndOfInput()     // Catch: java.lang.Throwable -> L63
            r6 = r6 ^ r3
            if (r6 == 0) goto L69
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L63
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L63
            r0.label = r3     // Catch: java.lang.Throwable -> L63
            java.lang.Object r6 = r2.writeSuspend(r3, r0)     // Catch: java.lang.Throwable -> L63
            if (r6 != r1) goto L5b
            return r1
        L5b:
            io.ktor.utils.io.internal.JoiningState r6 = r2.joining     // Catch: java.lang.Throwable -> L63
            if (r6 == 0) goto L65
            resolveDelegation(r2, r6)     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r6 = move-exception
            goto L6f
        L65:
            r2.tryWritePacketPart(r5)     // Catch: java.lang.Throwable -> L63
            goto L47
        L69:
            r5.release()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L6f:
            r5.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writePacketSuspend(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:            r2.flushImpl(r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:            if (r2.shouldResumeReadOp() == false) goto L54;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:            r2.resumeReadOp();     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:            r10 = r10.getResult();        r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:            if (r10 != r1) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b8, code lost:            return r1;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeSuspend(int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean writeSuspendPredicate(int r5) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
        if (((ClosedElement) this._closed) != null) {
            return false;
        }
        if (joiningState == null) {
            if (readWriteBufferState.capacity._availableForWrite$internal >= r5 || readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                return false;
            }
        } else if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE || (readWriteBufferState instanceof ReadWriteBufferState.Writing) || (readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting)) {
            return false;
        }
        return true;
    }

    public ByteBufferChannel(ByteBuffer byteBuffer) {
        this(false, ObjectPoolKt.BufferObjectNoPool, 0);
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(0, slice);
        initial.capacity.resetForRead();
        this._state = initial.writingState;
        restoreStateAfterWrite$ktor_io();
        ByteWriteChannelKt.close(this);
        tryTerminate$ktor_io();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L70
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r8 = r0.I$1
            int r7 = r0.I$0
            byte[] r6 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readSuspend(r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            r2 = r5
        L53:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L62
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L62:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L70
            return r1
        L70:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(Buffer buffer, ContinuationImpl continuationImpl) {
        writeAsMuchAsPossible(buffer);
        if (!(buffer.writePosition > buffer.readPosition)) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = writeFullySuspend(buffer, continuationImpl);
        return writeFullySuspend == CoroutineSingletons.COROUTINE_SUSPENDED ? writeFullySuspend : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl) {
        int readAsMuchAsPossible$default = readAsMuchAsPossible$default(this, chunkBuffer);
        if (readAsMuchAsPossible$default == 0 && ((ClosedElement) this._closed) != null) {
            readAsMuchAsPossible$default = ((ReadWriteBufferState) this._state).capacity.flush() ? readAsMuchAsPossible$default(this, chunkBuffer) : -1;
        } else if (readAsMuchAsPossible$default <= 0) {
            if (chunkBuffer.limit > chunkBuffer.writePosition) {
                return readAvailableSuspend(chunkBuffer, continuationImpl);
            }
        }
        return new Integer(readAsMuchAsPossible$default);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0050 -> B:17:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 == r3) goto L34
            r5 = 2
            if (r2 != r5) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.nio.ByteBuffer r5 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L53
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L40:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L5e
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.tryWriteSuspend$ktor_io(r3, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            io.ktor.utils.io.internal.JoiningState r6 = r2.joining
            if (r6 == 0) goto L5a
            resolveDelegation(r2, r6)
        L5a:
            r2.writeAsMuchAsPossible(r5)
            goto L40
        L5e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public ByteBufferChannel(boolean z, ObjectPool<ReadWriteBufferState.Initial> pool, int r4) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this.pool = pool;
        this.reservedSize = r4;
        this._state = ReadWriteBufferState.IdleEmpty.INSTANCE;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.nextRef$FU;
        this.writeSession = new WriteSessionImpl(this);
        this.readSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspension = new ByteBufferChannel$writeSuspension$1(this);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(byte[] bArr, int r4, ContinuationImpl continuationImpl) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        int r0 = 0;
        while (r4 > 0) {
            int writeAsMuchAsPossible = writeAsMuchAsPossible(bArr, r0, r4);
            if (writeAsMuchAsPossible == 0) {
                break;
            }
            r0 += writeAsMuchAsPossible;
            r4 -= writeAsMuchAsPossible;
        }
        if (r4 == 0) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = writeFullySuspend(bArr, r0, r4, continuationImpl);
        return writeFullySuspend == CoroutineSingletons.COROUTINE_SUSPENDED ? writeFullySuspend : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0062 -> B:10:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeFullySuspend(byte[] r7, int r8, int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r7 = r0.I$1
            int r8 = r0.I$0
            byte[] r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L65
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r6
        L3b:
            if (r9 <= 0) goto L71
            r0.L$0 = r2
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            io.ktor.utils.io.internal.JoiningState r10 = r2.joining
            if (r10 == 0) goto L4e
            resolveDelegation(r2, r10)
        L4e:
            int r10 = r2.writeAsMuchAsPossible(r7, r8, r9)
            if (r10 <= 0) goto L5b
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r10)
            r10 = r4
            goto L5f
        L5b:
            java.lang.Object r10 = r2.writeSuspend(r7, r8, r9, r0)
        L5f:
            if (r10 != r1) goto L62
            return r1
        L62:
            r5 = r9
            r9 = r7
            r7 = r5
        L65:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            int r8 = r8 + r10
            int r7 = r7 - r10
            r5 = r9
            r9 = r7
            r7 = r5
            goto L3b
        L71:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:17:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L32
            r6 = 2
            if (r2 != r6) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r6 = r0.I$1
            int r7 = r0.I$0
            byte[] r8 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L56
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r5
        L45:
            r0.L$0 = r2
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r9 = r2.tryWriteSuspend$ktor_io(r3, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            io.ktor.utils.io.internal.JoiningState r9 = r2.joining
            if (r9 == 0) goto L5d
            resolveDelegation(r2, r9)
        L5d:
            int r9 = r2.writeAsMuchAsPossible(r6, r7, r8)
            if (r9 <= 0) goto L45
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void writeAsMuchAsPossible(Buffer buffer) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement == null) {
                int r3 = 0;
                while (true) {
                    int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(buffer.writePosition - buffer.readPosition, byteBuffer.remaining()));
                    if (tryWriteAtMost == 0) {
                        break;
                    }
                    BufferUtilsJvmKt.readFully(buffer, byteBuffer, tryWriteAtMost);
                    r3 += tryWriteAtMost;
                    prepareBuffer(byteBuffer, carryIndex(this.writePosition + r3, byteBuffer), ringBufferCapacity._availableForWrite$internal);
                }
                bytesWritten(byteBuffer, ringBufferCapacity, r3);
                return;
            }
            Lists.access$rethrowClosed(closedElement.getSendException());
            throw null;
        } finally {
            if (ringBufferCapacity.isFull() || this.autoFlush) {
                flushImpl(1);
            }
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
        }
    }

    public final int writeAsMuchAsPossible(byte[] bArr, int r9, int r10) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            resolveDelegation(this, joiningState);
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).capacity;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement != null) {
                Lists.access$rethrowClosed(closedElement.getSendException());
                throw null;
            }
            int r4 = 0;
            while (true) {
                int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(r10 - r4, byteBuffer.remaining()));
                if (tryWriteAtMost == 0) {
                    bytesWritten(byteBuffer, ringBufferCapacity, r4);
                    return r4;
                }
                if (tryWriteAtMost > 0) {
                    byteBuffer.put(bArr, r9 + r4, tryWriteAtMost);
                    r4 += tryWriteAtMost;
                    prepareBuffer(byteBuffer, carryIndex(this.writePosition + r4, byteBuffer), ringBufferCapacity._availableForWrite$internal);
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } finally {
            if (ringBufferCapacity.isFull() || this.autoFlush) {
                flushImpl(1);
            }
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
        }
    }
}
