package com.animaconnected.secondo.screens.workout.detail;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$2", f = "WorkoutDetailsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$onCreateView$1$5$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutDetailsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$onCreateView$1$5$2(WorkoutDetailsFragment workoutDetailsFragment, Continuation<? super WorkoutDetailsFragment$onCreateView$1$5$2> continuation) {
        super(2, continuation);
        this.this$0 = workoutDetailsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$onCreateView$1$5$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$onCreateView$1$5$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WorkoutDetailsViewModel workoutDetailsViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            workoutDetailsViewModel = this.this$0.viewModel;
            if (workoutDetailsViewModel != null) {
                workoutDetailsViewModel.onPlayAnimation();
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
