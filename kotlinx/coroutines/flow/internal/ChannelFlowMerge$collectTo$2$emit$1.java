package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", l = {66}, m = "emit")
/* loaded from: classes4.dex */
public final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {
    public ChannelFlowMerge$collectTo$2 L$0;
    public Flow L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ChannelFlowMerge$collectTo$2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2$emit$1(ChannelFlowMerge$collectTo$2<? super T> channelFlowMerge$collectTo$2, Continuation<? super ChannelFlowMerge$collectTo$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = channelFlowMerge$collectTo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Flow) null, (Continuation<? super Unit>) this);
    }
}
