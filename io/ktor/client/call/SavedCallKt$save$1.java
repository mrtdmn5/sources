package io.ktor.client.call;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SavedCall.kt */
@DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", l = {73}, m = "save")
/* loaded from: classes3.dex */
public final class SavedCallKt$save$1 extends ContinuationImpl {
    public HttpClientCall L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SavedCallKt.save(null, this);
    }
}
