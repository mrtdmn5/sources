package com.animaconnected.secondo.screens.workout;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutMetricDetailBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$onCreateView$1$1", f = "WorkoutMetricDetailBaseFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricDetailBaseFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutMetricDetailBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricDetailBaseFragment$onCreateView$1$1(WorkoutMetricDetailBaseFragment workoutMetricDetailBaseFragment, Continuation<? super WorkoutMetricDetailBaseFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricDetailBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutMetricDetailBaseFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutMetricDetailBaseFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getFullHistoryClick().invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
