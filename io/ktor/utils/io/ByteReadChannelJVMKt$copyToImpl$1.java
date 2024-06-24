package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteReadChannelJVM.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", l = {302, 305}, m = "copyToImpl")
/* loaded from: classes3.dex */
public final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public long J$0;
    public long J$1;
    public ByteReadChannel L$0;
    public ByteWriteChannel L$1;
    public ChunkBuffer L$2;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelJVMKt.copyToImpl(null, null, 0L, this);
    }
}
