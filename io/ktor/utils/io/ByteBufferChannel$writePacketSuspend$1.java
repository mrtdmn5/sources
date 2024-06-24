package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacket;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1736, 1738}, m = "writePacketSuspend")
/* loaded from: classes3.dex */
public final class ByteBufferChannel$writePacketSuspend$1 extends ContinuationImpl {
    public ByteBufferChannel L$0;
    public ByteReadPacket L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writePacketSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writePacketSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel._state$FU;
        return this.this$0.writePacketSuspend(null, this);
    }
}
