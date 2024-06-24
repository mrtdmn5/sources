package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Reduce.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "firstOrNull")
/* loaded from: classes4.dex */
public final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {
    public Ref$ObjectRef L$0;
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt.firstOrNull(null, null, this);
    }
}
