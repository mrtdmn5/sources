package com.animaconnected.watch.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WorkoutViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.WorkoutViewModel", f = "WorkoutViewModel.kt", l = {79}, m = "getWorkoutDetailed")
/* loaded from: classes3.dex */
public final class WorkoutViewModel$getWorkoutDetailed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkoutViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutViewModel$getWorkoutDetailed$1(WorkoutViewModel workoutViewModel, Continuation<? super WorkoutViewModel$getWorkoutDetailed$1> continuation) {
        super(continuation);
        this.this$0 = workoutViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getWorkoutDetailed(0L, this);
    }
}
