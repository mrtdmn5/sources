package kotlinx.coroutines.flow;

import com.animaconnected.watch.display.PascalDisplay;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

/* compiled from: SharedFlow.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, PascalDisplay.bottom}, m = "collect$suspendImpl")
/* loaded from: classes4.dex */
public final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {
    public SharedFlowImpl L$0;
    public FlowCollector L$1;
    public SharedFlowSlot L$2;
    public Job L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SharedFlowImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super SharedFlowImpl$collect$1> continuation) {
        super(continuation);
        this.this$0 = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
    }
}
