package com.animaconnected.secondo.screens.workout.detail;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WorkoutUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutUtils", f = "WorkoutUtils.kt", l = {19}, m = "shareTcxFile")
/* loaded from: classes3.dex */
public final class WorkoutUtils$shareTcxFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkoutUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutUtils$shareTcxFile$1(WorkoutUtils workoutUtils, Continuation<? super WorkoutUtils$shareTcxFile$1> continuation) {
        super(continuation);
        this.this$0 = workoutUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.shareTcxFile(null, null, this);
    }
}
