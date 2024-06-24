package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WriterSession.kt */
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", l = {80}, m = "completeWritingFallback")
/* loaded from: classes3.dex */
public final class WriterSessionKt$completeWritingFallback$1 extends ContinuationImpl {
    public Buffer L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.completeWritingFallback(null, null, this);
    }
}
