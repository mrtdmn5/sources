package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {723, 727}, m = "readAvailableSuspend")
/* loaded from: classes3.dex */
public final class ByteBufferChannel$readAvailableSuspend$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public ByteBufferChannel L$0;
    public byte[] L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readAvailableSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readAvailableSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel._state$FU;
        return this.this$0.readAvailableSuspend(null, 0, 0, this);
    }
}
