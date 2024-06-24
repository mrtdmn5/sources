package com.animaconnected.secondo.screens.workout.dailygoal;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.animaconnected.watch.workout.DailyGoalsProgressSection;
import com.animaconnected.watch.workout.DailyGoalsViewModel;
import com.kronaby.watch.app.R;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: WorkoutDailyGoalHistoryFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragment$ComposeContent$1", f = "WorkoutDailyGoalHistoryFragment.kt", l = {44, 45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDailyGoalHistoryFragment$ComposeContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateList<DailyGoalsProgressSection> $history;
    final /* synthetic */ DailyGoalsViewModel $viewModel;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutDailyGoalHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDailyGoalHistoryFragment$ComposeContent$1(WorkoutDailyGoalHistoryFragment workoutDailyGoalHistoryFragment, SnapshotStateList<DailyGoalsProgressSection> snapshotStateList, DailyGoalsViewModel dailyGoalsViewModel, Continuation<? super WorkoutDailyGoalHistoryFragment$ComposeContent$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutDailyGoalHistoryFragment;
        this.$history = snapshotStateList;
        this.$viewModel = dailyGoalsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDailyGoalHistoryFragment$ComposeContent$1(this.this$0, this.$history, this.$viewModel, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SnapshotStateList<DailyGoalsProgressSection> snapshotStateList;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    snapshotStateList = (SnapshotStateList) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    snapshotStateList.addAll((Collection) obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            long integer = this.this$0.getResources().getInteger(R.integer.screen_transition_duration_horizontal);
            this.label = 1;
            if (DelayKt.delay(integer, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        SnapshotStateList<DailyGoalsProgressSection> snapshotStateList2 = this.$history;
        DailyGoalsViewModel dailyGoalsViewModel = this.$viewModel;
        this.L$0 = snapshotStateList2;
        this.label = 2;
        Object lastYearData = dailyGoalsViewModel.lastYearData(this);
        if (lastYearData == coroutineSingletons) {
            return coroutineSingletons;
        }
        snapshotStateList = snapshotStateList2;
        obj = lastYearData;
        snapshotStateList.addAll((Collection) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutDailyGoalHistoryFragment$ComposeContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
