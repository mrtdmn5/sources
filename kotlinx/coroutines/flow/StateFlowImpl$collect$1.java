package kotlinx.coroutines.flow;

import com.animaconnected.watch.account.HttpUtilsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

/* compiled from: StateFlow.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE}, m = "collect")
/* loaded from: classes4.dex */
public final class StateFlowImpl$collect$1 extends ContinuationImpl {
    public StateFlowImpl L$0;
    public FlowCollector L$1;
    public StateFlowSlot L$2;
    public Job L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StateFlowImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, Continuation<? super StateFlowImpl$collect$1> continuation) {
        super(continuation);
        this.this$0 = stateFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
