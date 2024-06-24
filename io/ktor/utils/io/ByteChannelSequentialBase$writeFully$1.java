package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteChannelSequential.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {193}, m = "writeFully$suspendImpl")
/* loaded from: classes3.dex */
public final class ByteChannelSequentialBase$writeFully$1 extends ContinuationImpl {
    public ByteChannelSequentialBase L$0;
    public Buffer L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeFully$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$writeFully$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.writeFully$suspendImpl(this.this$0, null, this);
    }
}
