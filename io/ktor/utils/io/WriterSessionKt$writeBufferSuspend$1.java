package io.ktor.utils.io;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WriterSession.kt */
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", l = {90}, m = "writeBufferSuspend")
/* loaded from: classes3.dex */
public final class WriterSessionKt$writeBufferSuspend$1 extends ContinuationImpl {
    public int I$0;
    public WriterSuspendSession L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.writeBufferSuspend(null, 0, this);
    }
}
