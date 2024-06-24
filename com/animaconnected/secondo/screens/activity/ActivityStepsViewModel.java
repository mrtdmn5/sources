package com.animaconnected.secondo.screens.activity;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.workout.utils.VmChartUtilsKt;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.datetime.Instant;

/* compiled from: ActivityViewModel.kt */
/* loaded from: classes3.dex */
public final class ActivityStepsViewModel {
    public static final int $stable = 8;
    private final FitnessProvider fitnessProvider;
    private final StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());
    private final Flow<StepProgress> stepProgress;
    private final Flow<List<StepsHistoryGraph.GraphData>> stepsHistory;
    private final AndroidDateFormatter xAxisLabelFormatter;

    public ActivityStepsViewModel() {
        FitnessProvider fitness = ProviderFactory.getWatch().fitness();
        this.fitnessProvider = fitness;
        this.xAxisLabelFormatter = new AndroidDateFormatter("MM/dd", ProviderFactory.createConfigProvider().getTranslationCompatibleLocale());
        TimePeriod.Companion companion = TimePeriod.Companion;
        final Flow daysFlow = VmChartUtilsKt.daysFlow(TimePeriod.Companion.lastWeek$default(companion, null, null, 3, null), new Function1<TimePeriod, CommonFlow<List<? extends StepEntry>>>() { // from class: com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$1$flowSteps$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CommonFlow<List<StepEntry>> invoke(TimePeriod it) {
                FitnessProvider fitnessProvider;
                Intrinsics.checkNotNullParameter(it, "it");
                fitnessProvider = ActivityStepsViewModel.this.fitnessProvider;
                return fitnessProvider.getStepsWithResolution(it, 1);
            }
        });
        this.stepsHistory = FlowKt.flowOn(new Flow<List<? extends StepsHistoryGraph.GraphData>>() { // from class: com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ActivityStepsViewModel $this_run$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2", f = "ActivityViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ActivityStepsViewModel activityStepsViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$this_run$inlined = activityStepsViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        r18 = this;
                        r0 = r18
                        r1 = r20
                        boolean r2 = r1 instanceof com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2$1 r2 = (com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2$1 r2 = new com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L33
                        if (r4 != r5) goto L2b
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto L8e
                    L2b:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L33:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r19
                        java.util.List r4 = (java.util.List) r4
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$lambda$2$$inlined$sortedByDescending$1 r6 = new com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$lambda$2$$inlined$sortedByDescending$1
                        r6.<init>()
                        java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r4, r6)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r7 = 10
                        int r7 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r4, r7)
                        r6.<init>(r7)
                        java.util.Iterator r4 = r4.iterator()
                    L58:
                        boolean r7 = r4.hasNext()
                        if (r7 == 0) goto L85
                        java.lang.Object r7 = r4.next()
                        com.animaconnected.watch.fitness.StepEntry r7 = (com.animaconnected.watch.fitness.StepEntry) r7
                        com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph$GraphData r8 = new com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph$GraphData
                        int r9 = r7.getSteps()
                        com.animaconnected.secondo.screens.activity.ActivityStepsViewModel r10 = r0.$this_run$inlined
                        com.animaconnected.watch.AndroidDateFormatter r11 = com.animaconnected.secondo.screens.activity.ActivityStepsViewModel.access$getXAxisLabelFormatter$p(r10)
                        long r12 = r7.getTimestamp()
                        r14 = 0
                        r15 = 0
                        r16 = 6
                        r17 = 0
                        java.lang.String r7 = com.animaconnected.watch.device.DateFormatter.format$default(r11, r12, r14, r15, r16, r17)
                        r8.<init>(r9, r7)
                        r6.add(r8)
                        goto L58
                    L85:
                        r2.label = r5
                        java.lang.Object r1 = r1.emit(r6, r2)
                        if (r1 != r3) goto L8e
                        return r3
                    L8e:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepsHistory$lambda$3$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends StepsHistoryGraph.GraphData>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, Dispatchers.IO);
        CommonFlow<List<StepEntry>> stepsWithResolution = fitness.getStepsWithResolution(TimePeriod.Companion.day$default(companion, null, null, 3, null), 1);
        Instant.Companion.getClass();
        this.stepProgress = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stepsWithResolution, fitness.getGoal(Instant.DISTANT_FUTURE.toEpochMilliseconds()), new ActivityStepsViewModel$stepProgress$1$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatStepPercentage(int r2, int r3) {
        float f = r2 / r3;
        if (f > 1.0f) {
            f = 1.0f;
        }
        String formatPercent = this.stepFormatHelper.formatPercent(((int) (f * 100.0f)) / 100.0f);
        Intrinsics.checkNotNullExpressionValue(formatPercent, "formatPercent(...)");
        return formatPercent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatStepProgress(int r3, int r4) {
        return this.stepFormatHelper.formatNumber(r3) + " / " + this.stepFormatHelper.formatNumber(r4);
    }

    public final Flow<StepProgress> getStepProgress() {
        return this.stepProgress;
    }

    public final Flow<List<StepsHistoryGraph.GraphData>> getStepsHistory() {
        return this.stepsHistory;
    }
}
