package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1696}, m = "discardSuspend")
/* loaded from: classes3.dex */
public final class ByteBufferChannel$discardSuspend$1 extends ContinuationImpl {
    public long J$0;
    public ByteBufferChannel L$0;
    public Ref$LongRef L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$discardSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$discardSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ByteBufferChannel byteBufferChannel = this.this$0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel._state$FU;
        return byteBufferChannel.discardSuspend(0L, 0L, this);
    }
}
