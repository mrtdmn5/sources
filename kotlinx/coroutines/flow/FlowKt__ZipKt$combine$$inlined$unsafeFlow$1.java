package kotlinx.coroutines.flow;

import com.animaconnected.watch.CommonFlow;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow<Object> {
    public final /* synthetic */ Flow $flow$inlined;
    public final /* synthetic */ Flow $this_combine$inlined;
    public final /* synthetic */ Function3 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(Flow flow, CommonFlow commonFlow, Function3 function3) {
        this.$this_combine$inlined = flow;
        this.$flow$inlined = commonFlow;
        this.$transform$inlined = function3;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
        Object combineInternal = CombineKt.combineInternal(continuation, FlowKt__ZipKt$nullArrayFactory$1.INSTANCE, new FlowKt__ZipKt$combine$1$1(this.$transform$inlined, null), flowCollector, new Flow[]{this.$this_combine$inlined, this.$flow$inlined});
        if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }
}
