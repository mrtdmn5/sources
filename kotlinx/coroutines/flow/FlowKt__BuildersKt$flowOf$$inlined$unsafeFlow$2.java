package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes4.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2 implements Flow<Object> {
    public final /* synthetic */ Object $value$inlined;

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(Object obj) {
        this.$value$inlined = obj;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
        Object emit = flowCollector.emit(this.$value$inlined, continuation);
        if (emit == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return emit;
        }
        return Unit.INSTANCE;
    }
}
