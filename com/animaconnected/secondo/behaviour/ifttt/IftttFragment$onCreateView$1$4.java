package com.animaconnected.secondo.behaviour.ifttt;

import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: IftttFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.ifttt.IftttFragment$onCreateView$1$4", f = "IftttFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class IftttFragment$onCreateView$1$4 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public IftttFragment$onCreateView$1$4(Continuation<? super IftttFragment$onCreateView$1$4> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, "Something went wrong with collecting ifttt state", (String) null, (Throwable) this.L$1, false, 10, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        IftttFragment$onCreateView$1$4 iftttFragment$onCreateView$1$4 = new IftttFragment$onCreateView$1$4(continuation);
        iftttFragment$onCreateView$1$4.L$0 = flowCollector;
        iftttFragment$onCreateView$1$4.L$1 = th;
        return iftttFragment$onCreateView$1$4.invokeSuspend(Unit.INSTANCE);
    }
}
