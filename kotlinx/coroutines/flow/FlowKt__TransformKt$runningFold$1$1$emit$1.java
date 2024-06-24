package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Transform.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", l = {109, 110}, m = "emit")
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$runningFold$1$1$emit$1 extends ContinuationImpl {
    public FlowKt__TransformKt$runningFold$1$1 L$0;
    public Ref$ObjectRef L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__TransformKt$runningFold$1$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningFold$1$1$emit$1(FlowKt__TransformKt$runningFold$1$1<? super T> flowKt__TransformKt$runningFold$1$1, Continuation<? super FlowKt__TransformKt$runningFold$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__TransformKt$runningFold$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
