package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.internal.zzgp;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Distinct.kt */
/* loaded from: classes4.dex */
public final class DistinctFlowImpl<T> implements Flow<T> {
    public final Function2<Object, Object, Boolean> areEquivalent;
    public final Function1<T, Object> keySelector;
    public final Flow<T> upstream;

    public DistinctFlowImpl(Flow flow) {
        FlowKt__DistinctKt$defaultKeySelector$1 flowKt__DistinctKt$defaultKeySelector$1 = FlowKt__DistinctKt.defaultKeySelector;
        FlowKt__DistinctKt$defaultAreEquivalent$1 flowKt__DistinctKt$defaultAreEquivalent$1 = FlowKt__DistinctKt.defaultAreEquivalent;
        this.upstream = flow;
        this.keySelector = flowKt__DistinctKt$defaultKeySelector$1;
        this.areEquivalent = flowKt__DistinctKt$defaultAreEquivalent$1;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) zzgp.NULL;
        Object collect = this.upstream.collect(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, flowCollector), continuation);
        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
