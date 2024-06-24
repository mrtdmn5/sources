package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WriteSessionImpl.kt */
/* loaded from: classes3.dex */
public final class WriteSessionImpl implements WriterSuspendSession {
    public ByteBuffer byteBuffer;
    public ByteBufferChannel current;
    public int locked;
    public RingBufferCapacity ringBufferCapacity;
    public ChunkBuffer view;

    public WriteSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        channel.resolveChannelInstance$ktor_io();
        this.current = channel;
        ChunkBuffer chunkBuffer = ChunkBuffer.Empty;
        this.byteBuffer = chunkBuffer.memory;
        this.view = chunkBuffer;
        this.ringBufferCapacity = channel.currentState$ktor_io().capacity;
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public final ChunkBuffer request(int r6) {
        int r2;
        int r0 = this.locked;
        RingBufferCapacity ringBufferCapacity = this.ringBufferCapacity;
        while (true) {
            r2 = ringBufferCapacity._availableForWrite$internal;
            if (r2 < 0) {
                r2 = 0;
                break;
            }
            if (RingBufferCapacity._availableForWrite$FU$internal.compareAndSet(ringBufferCapacity, r2, 0)) {
                break;
            }
        }
        int r02 = r0 + r2;
        this.locked = r02;
        if (r02 < r6) {
            return null;
        }
        ByteBufferChannel byteBufferChannel = this.current;
        ByteBuffer buffer = this.byteBuffer;
        byteBufferChannel.getClass();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        byteBufferChannel.prepareBuffer(buffer, byteBufferChannel.writePosition, r02);
        if (this.byteBuffer.remaining() < r6) {
            return null;
        }
        BufferUtilsJvmKt.resetFromContentToWrite(this.view, this.byteBuffer);
        return this.view;
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public final Object tryAwait(int r3, WriterSessionKt$writeBufferSuspend$1 writerSessionKt$writeBufferSuspend$1) {
        if (this.current.getJoining$ktor_io() != null) {
            Object tryAwaitJoinSwitch = tryAwaitJoinSwitch(r3, writerSessionKt$writeBufferSuspend$1);
            if (tryAwaitJoinSwitch == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return tryAwaitJoinSwitch;
            }
            return Unit.INSTANCE;
        }
        int r0 = this.locked;
        if (r0 >= r3) {
            return Unit.INSTANCE;
        }
        if (r0 > 0) {
            this.ringBufferCapacity.completeRead(r0);
            this.locked = 0;
        }
        Object tryWriteSuspend$ktor_io = this.current.tryWriteSuspend$ktor_io(r3, writerSessionKt$writeBufferSuspend$1);
        if (tryWriteSuspend$ktor_io == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return tryWriteSuspend$ktor_io;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object tryAwaitJoinSwitch(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.internal.WriteSessionImpl r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.locked
            if (r6 <= 0) goto L40
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.ringBufferCapacity
            r2.completeRead(r6)
            r6 = 0
            r4.locked = r6
        L40:
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.flushImpl(r3)
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.tryTerminate$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.tryWriteSuspend$ktor_io(r5, r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            r5 = r4
        L5d:
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            r6.resolveChannelInstance$ktor_io()
            r5.current = r6
            java.nio.ByteBuffer r6 = r6.setupStateForWrite$ktor_io()
            if (r6 != 0) goto L6b
            goto L8b
        L6b:
            r5.byteBuffer = r6
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            java.nio.ByteBuffer r6 = r6.backingBuffer
            r0 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.BufferUtilsJvmKt.ChunkBuffer(r6, r0)
            r5.view = r6
            java.nio.ByteBuffer r0 = r5.byteBuffer
            io.ktor.utils.io.core.BufferUtilsJvmKt.resetFromContentToWrite(r6, r0)
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.capacity
            r5.ringBufferCapacity = r6
        L8b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.WriteSessionImpl.tryAwaitJoinSwitch(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
