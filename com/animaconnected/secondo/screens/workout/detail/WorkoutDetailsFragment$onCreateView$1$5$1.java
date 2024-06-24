package com.animaconnected.secondo.screens.workout.detail;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$1", f = "WorkoutDetailsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$onCreateView$1$5$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutDetailsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$onCreateView$1$5$1(WorkoutDetailsFragment workoutDetailsFragment, Continuation<? super WorkoutDetailsFragment$onCreateView$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutDetailsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$onCreateView$1$5$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$onCreateView$1$5$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
