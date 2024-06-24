package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.view.View;
import com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugStepsChartFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$setupCharts$1$1", f = "DebugStepsChartFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugStepsChartFragment$setupCharts$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugStepsChartFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugStepsChartFragment$setupCharts$1$1(DebugStepsChartFragment debugStepsChartFragment, Continuation<? super DebugStepsChartFragment$setupCharts$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugStepsChartFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugStepsChartFragment$setupCharts$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugStepsChartFragment$setupCharts$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int r0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ActivityStepGoalDialogFragment.Companion companion = ActivityStepGoalDialogFragment.Companion;
            r0 = this.this$0.goalValue;
            companion.newInstance(r0).show(this.this$0.getChildFragmentManager(), (String) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
