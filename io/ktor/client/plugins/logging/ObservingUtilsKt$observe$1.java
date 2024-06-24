package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ObservingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt", f = "ObservingUtils.kt", l = {14}, m = "observe")
/* loaded from: classes3.dex */
public final class ObservingUtilsKt$observe$1 extends ContinuationImpl {
    public OutgoingContent L$0;
    public ByteWriteChannel L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ObservingUtilsKt.observe(null, null, this);
    }
}
