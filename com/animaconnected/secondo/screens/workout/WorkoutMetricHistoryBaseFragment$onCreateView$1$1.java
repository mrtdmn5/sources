package com.animaconnected.secondo.screens.workout;

import android.view.View;
import com.animaconnected.watch.workout.Action;
import com.animaconnected.watch.workout.WorkoutDatePickerViewModel;
import com.animaconnected.watch.workout.WorkoutPeriod;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutMetricHistoryBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$onCreateView$1$1", f = "WorkoutMetricHistoryBaseFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricHistoryBaseFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutMetricHistoryBaseFragment this$0;

    /* compiled from: WorkoutMetricHistoryBaseFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WorkoutPeriod.values().length];
            try {
                r0[WorkoutPeriod.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WorkoutPeriod.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WorkoutPeriod.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricHistoryBaseFragment$onCreateView$1$1(WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment, Continuation<? super WorkoutMetricHistoryBaseFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricHistoryBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutMetricHistoryBaseFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutMetricHistoryBaseFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WorkoutDatePickerViewModel workoutDatePickerViewModel;
        WorkoutDatePickerViewModel workoutDatePickerViewModel2;
        WorkoutDatePickerViewModel workoutDatePickerViewModel3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int r2 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getActiveTab().ordinal()];
            if (r2 == 1) {
                workoutDatePickerViewModel = this.this$0.viewModel;
                workoutDatePickerViewModel.changeWeek(Action.PreviousDate);
            } else if (r2 == 2) {
                workoutDatePickerViewModel2 = this.this$0.viewModel;
                workoutDatePickerViewModel2.changeMonth(Action.PreviousDate);
            } else if (r2 == 3) {
                workoutDatePickerViewModel3 = this.this$0.viewModel;
                workoutDatePickerViewModel3.changeYear(Action.PreviousDate);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
