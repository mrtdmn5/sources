package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.internal.zzgp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {242}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ FlowCollector<Object> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public /* synthetic */ Object L$0;
    public Ref$ObjectRef L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Continuation continuation, Ref$ObjectRef ref$ObjectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(continuation, this.$lastValue, this.$downstream);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(new ChannelResult(channelResult.holder), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef<Object> ref$ObjectRef;
        ChannelResult.Closed closed;
        Throwable th;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ref$ObjectRef2 = this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ?? r7 = ((ChannelResult) this.L$0).holder;
            boolean z = r7 instanceof ChannelResult.Failed;
            ref$ObjectRef = this.$lastValue;
            if (!z) {
                ref$ObjectRef.element = r7;
            }
            if (z) {
                Object obj2 = null;
                if (r7 instanceof ChannelResult.Closed) {
                    closed = (ChannelResult.Closed) r7;
                } else {
                    closed = null;
                }
                if (closed != null) {
                    th = closed.cause;
                } else {
                    th = null;
                }
                if (th == null) {
                    Object obj3 = ref$ObjectRef.element;
                    if (obj3 != null) {
                        if (obj3 != zzgp.NULL) {
                            obj2 = obj3;
                        }
                        this.L$0 = r7;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (this.$downstream.emit(obj2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = zzgp.DONE;
                } else {
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = zzgp.DONE;
        return Unit.INSTANCE;
    }
}
