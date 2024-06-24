package com.animaconnected.secondo.screens.workout.heartrate;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutHeartRateDetailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$2", f = "WorkoutHeartRateDetailFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutHeartRateDetailFragment$setupDetailView$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutHeartRateDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutHeartRateDetailFragment$setupDetailView$2(WorkoutHeartRateDetailFragment workoutHeartRateDetailFragment, Continuation<? super WorkoutHeartRateDetailFragment$setupDetailView$2> continuation) {
        super(2, continuation);
        this.this$0 = workoutHeartRateDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutHeartRateDetailFragment$setupDetailView$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutHeartRateDetailFragment$setupDetailView$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function0 restingHeartRateFullHistoryClick;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            restingHeartRateFullHistoryClick = this.this$0.getRestingHeartRateFullHistoryClick();
            restingHeartRateFullHistoryClick.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
