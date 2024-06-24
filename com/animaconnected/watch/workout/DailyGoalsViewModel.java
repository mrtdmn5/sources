package com.animaconnected.watch.workout;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.NumberFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: DailyGoalsViewModel.kt */
/* loaded from: classes3.dex */
public final class DailyGoalsViewModel {
    private final FitnessProvider fitnessProvider;
    private final StringsBackend stringsBackend;

    /* compiled from: DailyGoalsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class DayData {
        private final boolean allGoalsCompleted;
        private final boolean exerciseGoalCompleted;
        private final int exercises;
        private final HealthGoals goals;
        private final boolean standGoalCompleted;
        private final int stands;
        private final boolean stepGoalCompleted;
        private final int steps;
        private final long timestamp;

        public DayData(long j, int r4, int r5, int r6, HealthGoals goals) {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(goals, "goals");
            this.timestamp = j;
            this.stands = r4;
            this.steps = r5;
            this.exercises = r6;
            this.goals = goals;
            if (r5 >= goals.getSteps()) {
                z = true;
            } else {
                z = false;
            }
            this.stepGoalCompleted = z;
            if (r4 >= goals.getStand()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.standGoalCompleted = z2;
            if (r6 >= goals.getExercise()) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.exerciseGoalCompleted = z3;
            this.allGoalsCompleted = z && z2 && z3;
        }

        public static /* synthetic */ DayData copy$default(DayData dayData, long j, int r10, int r11, int r12, HealthGoals healthGoals, int r14, Object obj) {
            if ((r14 & 1) != 0) {
                j = dayData.timestamp;
            }
            long j2 = j;
            if ((r14 & 2) != 0) {
                r10 = dayData.stands;
            }
            int r3 = r10;
            if ((r14 & 4) != 0) {
                r11 = dayData.steps;
            }
            int r4 = r11;
            if ((r14 & 8) != 0) {
                r12 = dayData.exercises;
            }
            int r5 = r12;
            if ((r14 & 16) != 0) {
                healthGoals = dayData.goals;
            }
            return dayData.copy(j2, r3, r4, r5, healthGoals);
        }

        public final long component1() {
            return this.timestamp;
        }

        public final int component2() {
            return this.stands;
        }

        public final int component3() {
            return this.steps;
        }

        public final int component4() {
            return this.exercises;
        }

        public final HealthGoals component5() {
            return this.goals;
        }

        public final DayData copy(long j, int r11, int r12, int r13, HealthGoals goals) {
            Intrinsics.checkNotNullParameter(goals, "goals");
            return new DayData(j, r11, r12, r13, goals);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayData)) {
                return false;
            }
            DayData dayData = (DayData) obj;
            if (this.timestamp == dayData.timestamp && this.stands == dayData.stands && this.steps == dayData.steps && this.exercises == dayData.exercises && Intrinsics.areEqual(this.goals, dayData.goals)) {
                return true;
            }
            return false;
        }

        public final boolean getAllGoalsCompleted() {
            return this.allGoalsCompleted;
        }

        public final boolean getExerciseGoalCompleted() {
            return this.exerciseGoalCompleted;
        }

        public final int getExercises() {
            return this.exercises;
        }

        public final HealthGoals getGoals() {
            return this.goals;
        }

        public final boolean getStandGoalCompleted() {
            return this.standGoalCompleted;
        }

        public final int getStands() {
            return this.stands;
        }

        public final boolean getStepGoalCompleted() {
            return this.stepGoalCompleted;
        }

        public final int getSteps() {
            return this.steps;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return this.goals.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.exercises, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.stands, Long.hashCode(this.timestamp) * 31, 31), 31), 31);
        }

        public String toString() {
            return "DayData(timestamp=" + this.timestamp + ", stands=" + this.stands + ", steps=" + this.steps + ", exercises=" + this.exercises + ", goals=" + this.goals + ')';
        }
    }

    /* compiled from: DailyGoalsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class MonthData {
        private final List<DayData> days;
        private final TimePeriod timePeriod;

        public MonthData(TimePeriod timePeriod, List<DayData> days) {
            Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
            Intrinsics.checkNotNullParameter(days, "days");
            this.timePeriod = timePeriod;
            this.days = days;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MonthData copy$default(MonthData monthData, TimePeriod timePeriod, List list, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                timePeriod = monthData.timePeriod;
            }
            if ((r3 & 2) != 0) {
                list = monthData.days;
            }
            return monthData.copy(timePeriod, list);
        }

        public final TimePeriod component1() {
            return this.timePeriod;
        }

        public final List<DayData> component2() {
            return this.days;
        }

        public final MonthData copy(TimePeriod timePeriod, List<DayData> days) {
            Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
            Intrinsics.checkNotNullParameter(days, "days");
            return new MonthData(timePeriod, days);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MonthData)) {
                return false;
            }
            MonthData monthData = (MonthData) obj;
            if (Intrinsics.areEqual(this.timePeriod, monthData.timePeriod) && Intrinsics.areEqual(this.days, monthData.days)) {
                return true;
            }
            return false;
        }

        public final List<DayData> getDays() {
            return this.days;
        }

        public final TimePeriod getTimePeriod() {
            return this.timePeriod;
        }

        public int hashCode() {
            return this.days.hashCode() + (this.timePeriod.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MonthData(timePeriod=");
            sb.append(this.timePeriod);
            sb.append(", days=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.days, ')');
        }
    }

    public DailyGoalsViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        this.stringsBackend = ServiceLocator.INSTANCE.getStringsBackend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailyGoalsProgressSection createMonthSection(MonthData monthData, DateFormatter dateFormatter) {
        Instant start = monthData.getTimePeriod().getStart();
        int r4 = 0;
        DateFormatter createDateFormatter$default = StringsBackend.createDateFormatter$default(this.stringsBackend, DateTimeFormattersKt.longMonthInYearFormat, false, 2, null);
        List<DayData> days = monthData.getDays();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(days, 10));
        int r5 = 0;
        int r14 = 0;
        for (DayData dayData : days) {
            long timestamp = dayData.getTimestamp();
            int steps = dayData.getSteps();
            int stands = dayData.getStands();
            int exercises = dayData.getExercises();
            HealthGoals goals = dayData.getGoals();
            if (steps >= goals.getSteps()) {
                r4++;
            }
            if (stands >= goals.getStand()) {
                r5++;
            }
            if (exercises >= goals.getExercise()) {
                r14++;
            }
            String format$default = DateFormatter.format$default(dateFormatter, timestamp, null, false, 6, null);
            arrayList.add(new DailyGoalsProgressItem(format$default, new BarEntry(steps, format$default, 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null), new BarEntry(stands, format$default, 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null), new BarEntry(exercises, format$default, 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null), dayData.getStepGoalCompleted(), dayData.getStandGoalCompleted(), dayData.getExerciseGoalCompleted()));
        }
        return new DailyGoalsProgressSection(new DailyGoalSummary(DateFormatter.format$default(createDateFormatter$default, start.toEpochMilliseconds(), null, false, 6, null), String.valueOf(r4), String.valueOf(r5), String.valueOf(r14), String.valueOf(TimePeriodKt.inDays$default(monthData.getTimePeriod(), null, 1, null))), arrayList);
    }

    private final CommonFlow<List<DailyGoalsProgressItem>> observeDailyGoalsData(TimePeriod timePeriod, EqualIntervals equalIntervals, DateFormatter dateFormatter, NumberFormatter numberFormatter) {
        final CommonFlow<List<StepEntry>> stepsWithResolution = this.fitnessProvider.getStepsWithResolution(timePeriod, equalIntervals.getAmountOfEntries());
        Flow<List<? extends StepEntry>> flow = new Flow<List<? extends StepEntry>>() { // from class: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2", f = "DailyGoalsViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$2$$inlined$sortedByDescending$1 r2 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$2$$inlined$sortedByDescending$1
                        r2.<init>()
                        java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends StepEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        final CommonFlow<List<StandEntry>> standWithResolution = this.fitnessProvider.getStandWithResolution(timePeriod, equalIntervals.getAmountOfEntries());
        Flow<List<? extends StandEntry>> flow2 = new Flow<List<? extends StandEntry>>() { // from class: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2", f = "DailyGoalsViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2$1 r0 = (com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2$1 r0 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$4$$inlined$sortedByDescending$1 r2 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$4$$inlined$sortedByDescending$1
                        r2.<init>()
                        java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends StandEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        final CommonFlow<List<ExerciseEntry>> exerciseWithResolution = this.fitnessProvider.getExerciseWithResolution(timePeriod, equalIntervals.getAmountOfEntries());
        Flow<List<? extends ExerciseEntry>> flow3 = new Flow<List<? extends ExerciseEntry>>() { // from class: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2", f = "DailyGoalsViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2$1 r0 = (com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2$1 r0 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$6$$inlined$sortedByDescending$1 r2 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$lambda$6$$inlined$sortedByDescending$1
                        r2.<init>()
                        java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends ExerciseEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        CommonFlow<HealthGoals> goal = this.fitnessProvider.getGoal(timePeriod.getEndTs());
        final DailyGoalsViewModel$observeDailyGoalsData$4 dailyGoalsViewModel$observeDailyGoalsData$4 = new DailyGoalsViewModel$observeDailyGoalsData$4(equalIntervals, dateFormatter, numberFormatter, null);
        final Flow[] flowArr = {flow, flow2, flow3, goal};
        return FlowExtensionsKt.asCommonFlow(new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
                public final /* synthetic */ Function5 $transform$inlined;
                public /* synthetic */ FlowCollector L$0;
                public /* synthetic */ Object[] L$1;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Continuation continuation, Function5 function5) {
                    super(3, continuation);
                    this.$transform$inlined = function5;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<Object> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.$transform$inlined);
                    anonymousClass2.L$0 = flowCollector;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FlowCollector flowCollector;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 != 1) {
                            if (r1 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowCollector = this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.L$0;
                        Object[] objArr = this.L$1;
                        Function5 function5 = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        this.L$0 = flowCollector;
                        this.label = 1;
                        obj = function5.invoke(obj2, obj3, obj4, obj5, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object combineInternal = CombineKt.combineInternal(continuation, FlowKt__ZipKt$nullArrayFactory$1.INSTANCE, new AnonymousClass2(null, dailyGoalsViewModel$observeDailyGoalsData$4), flowCollector, flowArr);
                if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final Object lastYearData(Continuation<? super List<DailyGoalsProgressSection>> continuation) {
        return BuildersKt.withContext(Dispatchers.Default, new DailyGoalsViewModel$lastYearData$2(this, null), continuation);
    }

    public final CommonFlow<List<DailyGoalsProgressItem>> observeDailyGoalsLastWeek() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimeZone.Companion.getClass();
        return observeDailyGoalsData(TimePeriod.Companion.lastWeek$default(companion, null, TimeZone.UTC, 1, null), new EqualIntervals(7), StringsBackend.createDateFormatter$default(this.stringsBackend, DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), this.stringsBackend.createNumberFormatter(0, 7, 0, 0));
    }

    public final CommonFlow<DailyGoalsProgressItem> observeDailyGoalsToday() {
        final CommonFlow<List<DailyGoalsProgressItem>> observeDailyGoalsData = observeDailyGoalsData(TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null), new EqualIntervals(1), StringsBackend.createDateFormatter$default(this.stringsBackend, DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), this.stringsBackend.createNumberFormatter(0, 7, 0, 0));
        return FlowExtensionsKt.asCommonFlow(new Flow<DailyGoalsProgressItem>() { // from class: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2", f = "DailyGoalsViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L43
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.first(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsToday$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DailyGoalsProgressItem> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }
}
