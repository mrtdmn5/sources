package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.workout.StepsViewModel;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: DebugStepsChartFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$2", f = "DebugStepsChartFragment.kt", l = {R.styleable.AppTheme_stepsHistoryLegendColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugStepsChartFragment$observeHistorySteps$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Long, String> $markerLabelFormatter;
    final /* synthetic */ EntriesAmount $nbrOfEntries;
    final /* synthetic */ TimePeriod $selectedTimePeriod;
    final /* synthetic */ TimePeriod $timePeriod;
    final /* synthetic */ DateFormatter $xAxisLabelFormatter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugStepsChartFragment this$0;

    /* compiled from: DebugStepsChartFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$2$1", f = "DebugStepsChartFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ChartData<? extends BarEntry>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DebugStepsChartFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DebugStepsChartFragment debugStepsChartFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = debugStepsChartFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ChartData<BarEntry> chartData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(chartData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChartData chartData = (ChartData) this.L$0;
                this.this$0.stepsData = CollectionsKt___CollectionsKt.toMutableList((Collection) chartData.getEntries());
                this.this$0.invalidateCurrentScreen();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ChartData<? extends BarEntry> chartData, Continuation<? super Unit> continuation) {
            return invoke2((ChartData<BarEntry>) chartData, continuation);
        }
    }

    /* compiled from: DebugStepsChartFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$2$2", f = "DebugStepsChartFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$2$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super ChartData<? extends BarEntry>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ DebugStepsChartFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DebugStepsChartFragment debugStepsChartFragment, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = debugStepsChartFragment;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super ChartData<? extends BarEntry>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super ChartData<BarEntry>>) flowCollector, th, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogKt.debug$default(this.L$0, "Exception from monthSteps, maybe watch was just closed?", this.this$0.getName(), (Throwable) this.L$1, false, 8, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super ChartData<BarEntry>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugStepsChartFragment$observeHistorySteps$2(DebugStepsChartFragment debugStepsChartFragment, TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, Function1<? super Long, String> function1, Continuation<? super DebugStepsChartFragment$observeHistorySteps$2> continuation) {
        super(2, continuation);
        this.this$0 = debugStepsChartFragment;
        this.$timePeriod = timePeriod;
        this.$selectedTimePeriod = timePeriod2;
        this.$nbrOfEntries = entriesAmount;
        this.$xAxisLabelFormatter = dateFormatter;
        this.$markerLabelFormatter = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugStepsChartFragment$observeHistorySteps$2 debugStepsChartFragment$observeHistorySteps$2 = new DebugStepsChartFragment$observeHistorySteps$2(this.this$0, this.$timePeriod, this.$selectedTimePeriod, this.$nbrOfEntries, this.$xAxisLabelFormatter, this.$markerLabelFormatter, continuation);
        debugStepsChartFragment$observeHistorySteps$2.L$0 = obj;
        return debugStepsChartFragment$observeHistorySteps$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StepsViewModel stepsViewModel;
        CoroutineScope coroutineScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            stepsViewModel = this.this$0.viewModel;
            TimePeriod timePeriod = this.$timePeriod;
            TimePeriod timePeriod2 = this.$selectedTimePeriod;
            EntriesAmount entriesAmount = this.$nbrOfEntries;
            DateFormatter dateFormatter = this.$xAxisLabelFormatter;
            Function1<Long, String> function1 = this.$markerLabelFormatter;
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object observeStepsData = stepsViewModel.observeStepsData(timePeriod, timePeriod2, entriesAmount, dateFormatter, function1, this);
            if (observeStepsData == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope2;
            obj = observeStepsData;
        }
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(this.this$0, null), (Flow) obj), new AnonymousClass2(this.this$0, null)), coroutineScope);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugStepsChartFragment$observeHistorySteps$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
