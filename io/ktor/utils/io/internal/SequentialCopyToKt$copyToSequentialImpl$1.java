package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SequentialCopyTo.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {27, 32, 40}, m = "copyToSequentialImpl")
/* loaded from: classes3.dex */
public final class SequentialCopyToKt$copyToSequentialImpl$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public ByteChannelSequentialBase L$0;
    public ByteChannelSequentialBase L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SequentialCopyToKt.copyToSequentialImpl(null, null, 0L, this);
    }
}
