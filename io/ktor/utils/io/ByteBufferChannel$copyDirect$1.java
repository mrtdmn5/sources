package io.ktor.utils.io;

import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1194, 1265, 1273}, m = "copyDirect$ktor_io")
/* loaded from: classes3.dex */
public final class ByteBufferChannel$copyDirect$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public ByteBufferChannel L$0;
    public ByteBufferChannel L$1;
    public JoiningState L$2;
    public Ref$LongRef L$3;
    public ByteBufferChannel L$4;
    public ByteBufferChannel L$5;
    public RingBufferCapacity L$6;
    public RingBufferCapacity L$7;
    public ByteBuffer L$8;
    public ByteBufferChannel L$9;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$copyDirect$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$copyDirect$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.copyDirect$ktor_io(null, 0L, this);
    }
}
