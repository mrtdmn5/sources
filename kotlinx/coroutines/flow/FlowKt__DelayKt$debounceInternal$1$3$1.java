package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.internal.zzgp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {232}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public final /* synthetic */ FlowCollector<Object> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$1(Continuation continuation, Ref$ObjectRef ref$ObjectRef, FlowCollector flowCollector) {
        super(1, continuation);
        this.$downstream = flowCollector;
        this.$lastValue = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(continuation, this.$lastValue, this.$downstream);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Symbol symbol = zzgp.NULL;
            Object obj2 = ref$ObjectRef.element;
            if (obj2 == symbol) {
                obj2 = null;
            }
            this.label = 1;
            if (this.$downstream.emit(obj2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        ref$ObjectRef.element = null;
        return Unit.INSTANCE;
    }
}
