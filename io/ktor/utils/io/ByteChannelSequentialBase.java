package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: ByteChannelSequential.kt */
/* loaded from: classes3.dex */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, HasWriteSession {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU;
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private volatile /* synthetic */ int channelSize;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;

    static {
        AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");
        AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");
        AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");
        AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");
        _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r2, byte[] r3, int r4, int r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r3 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            if (r3 == 0) goto L13
            r3 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r3 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.label = r4
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r3 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r3.<init>(r2, r6)
        L18:
            java.lang.Object r4 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 == r1) goto L2b
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r2 = r3.L$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L66
        L31:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.Throwable r4 = r2.getClosedCause()
            if (r4 != 0) goto L6b
            boolean r4 = r2.getClosed()
            if (r4 == 0) goto L4b
            int r4 = r2._availableForRead
            if (r4 != 0) goto L4b
            java.lang.Integer r2 = new java.lang.Integer
            r3 = -1
            r2.<init>(r3)
            return r2
        L4b:
            if (r5 != 0) goto L54
            java.lang.Integer r2 = new java.lang.Integer
            r3 = 0
            r2.<init>(r3)
            return r2
        L54:
            int r4 = r2._availableForRead
            if (r4 != 0) goto L66
            r3.L$0 = r2
            r3.getClass()
            r3.label = r1
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = r2.awaitSuspend(r1, r3)
            if (r3 != r6) goto L66
            return r6
        L66:
            r2.getClass()
            r2 = 0
            throw r2
        L6b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            int r5 = r0.I$1
            int r6 = r0.I$0
            byte[] r7 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r5
            r5 = r0
            goto L55
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            int r7 = r7 + r8
            if (r7 <= 0) goto L63
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            kotlin.Unit r0 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r0 != r1) goto L52
            return r1
        L52:
            r4 = r8
            r8 = r6
            r6 = r4
        L55:
            int r5 = r5.getAvailableForWrite()
            int r7 = r7 - r6
            int r5 = java.lang.Math.min(r5, r7)
            r7 = 0
            io.ktor.utils.io.core.OutputKt.writeFully(r7, r8, r6, r5)
            throw r7
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static kotlin.coroutines.intrinsics.CoroutineSingletons writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            io.ktor.utils.io.core.ByteReadPacket r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.Unit r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            r5.getClass()
            r4.getClass()
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit awaitAtLeastNBytesAvailableForRead$ktor_io(final int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            int r5 = r0.I$0
            io.ktor.utils.io.ByteChannelSequentialBase r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L37
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r4
        L37:
            int r6 = r1._availableForRead
            if (r6 >= r5) goto L4f
            boolean r6 = r1.isClosedForRead()
            if (r6 == 0) goto L42
            goto L4f
        L42:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2 r6 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
            r6.<init>()
            r0.L$0 = r1
            r0.I$0 = r5
            r0.label = r2
            r5 = 0
            throw r5
        L4f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForRead$ktor_io(int, kotlin.coroutines.Continuation):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit awaitAtLeastNBytesAvailableForWrite$ktor_io(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r0.label
            r1 = 0
            if (r0 == 0) goto L32
            r5 = 1
            if (r0 != r5) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            r5 = 0
            r6 = r1
            goto L36
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r4
        L36:
            int r0 = r6.getAvailableForWrite()
            if (r0 >= r5) goto L44
            boolean r5 = r6.getClosed()
            if (r5 == 0) goto L43
            goto L44
        L43:
            throw r1
        L44:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(int, kotlin.coroutines.Continuation):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.coroutines.intrinsics.CoroutineSingletons awaitSuspend(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 < 0) goto L38
            r6 = r3
            goto L39
        L38:
            r6 = 0
        L39:
            if (r6 == 0) goto L4c
            r0.L$0 = r4
            r0.label = r3
            kotlin.Unit r5 = r4.awaitAtLeastNBytesAvailableForRead$ktor_io(r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            r5 = r4
        L47:
            r5.getClass()
            r5 = 0
            throw r5
        L4c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitSuspend(int, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final WriterSuspendSession beginWriteSession() {
        return new WriterSuspendSession() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$beginWriteSession$1
            @Override // io.ktor.utils.io.WriterSuspendSession
            public final ChunkBuffer request(int r3) {
                ByteChannelSequentialBase byteChannelSequentialBase = ByteChannelSequentialBase.this;
                if (byteChannelSequentialBase.getAvailableForWrite() == 0) {
                    return null;
                }
                byteChannelSequentialBase.getClass();
                throw null;
            }

            @Override // io.ktor.utils.io.WriterSuspendSession
            public final Object tryAwait(int r3, WriterSessionKt$writeBufferSuspend$1 writerSessionKt$writeBufferSuspend$1) {
                ByteChannelSequentialBase byteChannelSequentialBase = ByteChannelSequentialBase.this;
                if (byteChannelSequentialBase.getAvailableForWrite() < r3) {
                    Unit awaitAtLeastNBytesAvailableForWrite$ktor_io = byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, writerSessionKt$writeBufferSuspend$1);
                    if (awaitAtLeastNBytesAvailableForWrite$ktor_io == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return awaitAtLeastNBytesAvailableForWrite$ktor_io;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean cancel(Throwable th) {
        if (getClosedCause() == null && !getClosed()) {
            if (th == null) {
                th = new CancellationException("Channel cancelled");
            }
            close(th);
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean close(Throwable th) {
        CloseElement closeElement;
        boolean z;
        if (th == null) {
            closeElement = CloseElementKt.CLOSED_SUCCESS;
        } else {
            closeElement = new CloseElement(th);
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closed$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, closeElement)) {
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
        if (th != null) {
            throw null;
        }
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object discard(Continuation continuation) {
        throw null;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final void endWriteSession(int r1) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final void flush() {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean getAutoFlush() {
        return false;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int getAvailableForRead() {
        return this._availableForRead;
    }

    public final int getAvailableForWrite() {
        return Math.max(0, 4088 - this.channelSize);
    }

    public final boolean getClosed() {
        if (this._closed != null) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Throwable getClosedCause() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.cause;
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean isClosedForRead() {
        Throwable th;
        boolean z;
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            th = closeElement.cause;
        } else {
            th = null;
        }
        if (th != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        if (getClosed() && this.channelSize == 0) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean isClosedForWrite() {
        return getClosed();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(byte[] bArr, int r2, int r3, ContinuationImpl continuationImpl) {
        return readAvailable$suspendImpl(this, bArr, r2, r3, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readAvailable$ktor_io(io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6c
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Throwable r6 = r4.getClosedCause()
            if (r6 != 0) goto L71
            boolean r6 = r4.getClosed()
            if (r6 == 0) goto L4b
            int r6 = r4._availableForRead
            if (r6 != 0) goto L4b
            java.lang.Integer r5 = new java.lang.Integer
            r6 = -1
            r5.<init>(r6)
            return r5
        L4b:
            int r6 = r5.limit
            int r5 = r5.writePosition
            int r6 = r6 - r5
            if (r6 != 0) goto L59
            java.lang.Integer r5 = new java.lang.Integer
            r6 = 0
            r5.<init>(r6)
            return r5
        L59:
            int r5 = r4._availableForRead
            if (r5 != 0) goto L6b
            r0.L$0 = r4
            r0.getClass()
            r0.label = r3
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = r4.awaitSuspend(r3, r0)
            if (r5 != r1) goto L6b
            return r1
        L6b:
            r5 = r4
        L6c:
            r5.getClass()
            r5 = 0
            throw r5
        L71:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$ktor_io(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.nextRef$FU;
            ByteBuffer byteBuffer = Memory.Empty;
            throw null;
        }
        throw closedCause;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(Buffer buffer, ContinuationImpl continuationImpl) {
        return writeFully$suspendImpl(this, buffer, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl) {
        return readAvailable$ktor_io(chunkBuffer, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(byte[] bArr, int r2, ContinuationImpl continuationImpl) {
        return writeFully$suspendImpl(this, bArr, r2, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static kotlin.coroutines.intrinsics.CoroutineSingletons writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.core.Buffer r5 = r0.L$1
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.Unit r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            int r6 = r5.writePosition
            r4.getClass()
            int r4 = r5.writePosition
            int r6 = r5.readPosition
            int r4 = r4 - r6
            io.ktor.utils.io.core.OutputKt.writeFully(r5, r4)
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }
}
