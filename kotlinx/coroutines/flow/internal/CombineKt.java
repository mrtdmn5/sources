package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: Combine.kt */
/* loaded from: classes4.dex */
public final class CombineKt {
    public static final Object combineInternal(Continuation continuation, Function0 function0, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(null, function0, function3, flowCollector, flowArr);
        FlowCoroutine flowCoroutine = new FlowCoroutine(continuation, continuation.getContext());
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(flowCoroutine, flowCoroutine, combineKt$combineInternal$2);
        if (startUndispatchedOrReturn == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return startUndispatchedOrReturn;
        }
        return Unit.INSTANCE;
    }
}
