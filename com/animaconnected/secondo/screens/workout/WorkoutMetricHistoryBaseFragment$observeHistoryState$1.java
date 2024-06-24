package com.animaconnected.secondo.screens.workout;

import android.widget.ImageView;
import android.widget.TextView;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.workout.HistoryState;
import com.animaconnected.watch.workout.WorkoutDatePickerViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: WorkoutMetricHistoryBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$observeHistoryState$1", f = "WorkoutMetricHistoryBaseFragment.kt", l = {125}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricHistoryBaseFragment$observeHistoryState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutMetricHistoryBaseFragment this$0;

    /* compiled from: WorkoutMetricHistoryBaseFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$observeHistoryState$1$1", f = "WorkoutMetricHistoryBaseFragment.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundActivity}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$observeHistoryState$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<HistoryState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WorkoutMetricHistoryBaseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = workoutMetricHistoryBaseFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(HistoryState historyState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(historyState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object updateDataOnTabChange;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                HistoryState historyState = (HistoryState) this.L$0;
                WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment = this.this$0;
                ImageView btnPreviousDate = workoutMetricHistoryBaseFragment.getBinding().btnPreviousDate;
                Intrinsics.checkNotNullExpressionValue(btnPreviousDate, "btnPreviousDate");
                workoutMetricHistoryBaseFragment.invalidatePicker(btnPreviousDate, historyState.isPrevDateClickable());
                WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment2 = this.this$0;
                ImageView btnNextDate = workoutMetricHistoryBaseFragment2.getBinding().btnNextDate;
                Intrinsics.checkNotNullExpressionValue(btnNextDate, "btnNextDate");
                workoutMetricHistoryBaseFragment2.invalidatePicker(btnNextDate, historyState.isNextDateClickable());
                this.this$0.getBinding().tvDateTimeHeader.setText(historyState.getDateTimeHeaderText());
                this.this$0.getBinding().tvDateTime.setText(historyState.getDateTimeText());
                TextView textView = this.this$0.getBinding().tvDateTimeHeader;
                int r4 = 0;
                if (historyState.getDateTimeHeaderText().length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    r4 = 8;
                }
                textView.setVisibility(r4);
                WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment3 = this.this$0;
                this.label = 1;
                updateDataOnTabChange = workoutMetricHistoryBaseFragment3.updateDataOnTabChange(historyState, this);
                if (updateDataOnTabChange == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricHistoryBaseFragment$observeHistoryState$1(WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment, Continuation<? super WorkoutMetricHistoryBaseFragment$observeHistoryState$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricHistoryBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutMetricHistoryBaseFragment$observeHistoryState$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WorkoutDatePickerViewModel workoutDatePickerViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            workoutDatePickerViewModel = this.this$0.viewModel;
            MutableStateFlow<HistoryState> historyState = workoutDatePickerViewModel.getHistoryState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(historyState, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutMetricHistoryBaseFragment$observeHistoryState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
