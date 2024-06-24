package io.ktor.utils.io;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteReadChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", l = {255}, m = "copyAndClose")
/* loaded from: classes3.dex */
public final class ByteReadChannelKt$copyAndClose$1 extends ContinuationImpl {
    public ByteWriteChannel L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelKt.copyAndClose(null, null, 0L, this);
    }
}
