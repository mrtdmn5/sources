package com.animaconnected.secondo.screens.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WorkoutMetricHistoryBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment", f = "WorkoutMetricHistoryBaseFragment.kt", l = {119, 119}, m = "updateDataOnTabChange")
/* loaded from: classes3.dex */
public final class WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkoutMetricHistoryBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1(WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment, Continuation<? super WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1> continuation) {
        super(continuation);
        this.this$0 = workoutMetricHistoryBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateDataOnTabChange;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateDataOnTabChange = this.this$0.updateDataOnTabChange(null, this);
        return updateDataOnTabChange;
    }
}
