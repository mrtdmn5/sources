package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugGraphFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugGraphFragment$onCreateView$3", f = "DebugGraphFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugGraphFragment$onCreateView$3 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugGraphFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugGraphFragment$onCreateView$3(DebugGraphFragment debugGraphFragment, Continuation<? super DebugGraphFragment$onCreateView$3> continuation) {
        super(2, continuation);
        this.this$0 = debugGraphFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugGraphFragment$onCreateView$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugGraphFragment$onCreateView$3) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().gotoNextFragment(DebugRestingHeartRateChart.Companion.newInstance(true));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
