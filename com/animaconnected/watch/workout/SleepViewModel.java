package com.animaconnected.watch.workout;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.StackedBarEntry;
import com.animaconnected.watch.graphs.StateEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.SleepViewModel;
import com.animaconnected.watch.workout.utils.VmChartUtilsKt;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: SleepViewModel.kt */
/* loaded from: classes3.dex */
public final class SleepViewModel extends ChartViewModel {
    private final FitnessProvider fitnessProvider;

    /* compiled from: SleepViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class SleepSummary {
        private final List<StateEntry> data;
        private final String deepSleepPercentage;
        private final boolean isEmpty;
        private final String lightSleepPercentage;
        private final String totalSleep;

        public SleepSummary(String totalSleep, String lightSleepPercentage, String deepSleepPercentage, boolean z, List<StateEntry> data) {
            Intrinsics.checkNotNullParameter(totalSleep, "totalSleep");
            Intrinsics.checkNotNullParameter(lightSleepPercentage, "lightSleepPercentage");
            Intrinsics.checkNotNullParameter(deepSleepPercentage, "deepSleepPercentage");
            Intrinsics.checkNotNullParameter(data, "data");
            this.totalSleep = totalSleep;
            this.lightSleepPercentage = lightSleepPercentage;
            this.deepSleepPercentage = deepSleepPercentage;
            this.isEmpty = z;
            this.data = data;
        }

        public static /* synthetic */ SleepSummary copy$default(SleepSummary sleepSummary, String str, String str2, String str3, boolean z, List list, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                str = sleepSummary.totalSleep;
            }
            if ((r9 & 2) != 0) {
                str2 = sleepSummary.lightSleepPercentage;
            }
            String str4 = str2;
            if ((r9 & 4) != 0) {
                str3 = sleepSummary.deepSleepPercentage;
            }
            String str5 = str3;
            if ((r9 & 8) != 0) {
                z = sleepSummary.isEmpty;
            }
            boolean z2 = z;
            if ((r9 & 16) != 0) {
                list = sleepSummary.data;
            }
            return sleepSummary.copy(str, str4, str5, z2, list);
        }

        public final String component1() {
            return this.totalSleep;
        }

        public final String component2() {
            return this.lightSleepPercentage;
        }

        public final String component3() {
            return this.deepSleepPercentage;
        }

        public final boolean component4() {
            return this.isEmpty;
        }

        public final List<StateEntry> component5() {
            return this.data;
        }

        public final SleepSummary copy(String totalSleep, String lightSleepPercentage, String deepSleepPercentage, boolean z, List<StateEntry> data) {
            Intrinsics.checkNotNullParameter(totalSleep, "totalSleep");
            Intrinsics.checkNotNullParameter(lightSleepPercentage, "lightSleepPercentage");
            Intrinsics.checkNotNullParameter(deepSleepPercentage, "deepSleepPercentage");
            Intrinsics.checkNotNullParameter(data, "data");
            return new SleepSummary(totalSleep, lightSleepPercentage, deepSleepPercentage, z, data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SleepSummary)) {
                return false;
            }
            SleepSummary sleepSummary = (SleepSummary) obj;
            if (Intrinsics.areEqual(this.totalSleep, sleepSummary.totalSleep) && Intrinsics.areEqual(this.lightSleepPercentage, sleepSummary.lightSleepPercentage) && Intrinsics.areEqual(this.deepSleepPercentage, sleepSummary.deepSleepPercentage) && this.isEmpty == sleepSummary.isEmpty && Intrinsics.areEqual(this.data, sleepSummary.data)) {
                return true;
            }
            return false;
        }

        public final List<StateEntry> getData() {
            return this.data;
        }

        public final String getDeepSleepPercentage() {
            return this.deepSleepPercentage;
        }

        public final String getLightSleepPercentage() {
            return this.lightSleepPercentage;
        }

        public final String getTotalSleep() {
            return this.totalSleep;
        }

        public int hashCode() {
            return this.data.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isEmpty, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.deepSleepPercentage, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.lightSleepPercentage, this.totalSleep.hashCode() * 31, 31), 31), 31);
        }

        public final boolean isEmpty() {
            return this.isEmpty;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SleepSummary(totalSleep=");
            sb.append(this.totalSleep);
            sb.append(", lightSleepPercentage=");
            sb.append(this.lightSleepPercentage);
            sb.append(", deepSleepPercentage=");
            sb.append(this.deepSleepPercentage);
            sb.append(", isEmpty=");
            sb.append(this.isEmpty);
            sb.append(", data=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.data, ')');
        }
    }

    /* compiled from: SleepViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[SleepType.values().length];
            try {
                r0[SleepType.AWAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SleepType.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SleepType.DEEP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[HistoryPeriodTab.values().length];
            try {
                r02[HistoryPeriodTab.Week.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[HistoryPeriodTab.Month.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[HistoryPeriodTab.Year.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public SleepViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
    }

    private final StackedBarEntry createStackedBarEntry(SleepHistoryEntry sleepHistoryEntry, DateFormatter dateFormatter, Function1<? super Long, String> function1, TimePeriod timePeriod) {
        String format$default = DateFormatter.format$default(dateFormatter, sleepHistoryEntry.getEnd(), null, false, 6, null);
        String invoke = function1.invoke(Long.valueOf(sleepHistoryEntry.getEnd()));
        BarEntry barEntry = new BarEntry(0, format$default, 0L, (String) null, invoke, false, 44, (DefaultConstructorMarker) null);
        int r2 = Duration.$r8$clinit;
        int lightSleepMs = (int) sleepHistoryEntry.getLightSleepMs();
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        return new StackedBarEntry(CollectionsKt__CollectionsKt.listOf((Object[]) new BarEntry[]{BarEntry.copy$default(barEntry, (int) Duration.m1679getInWholeSecondsimpl(DurationKt.toDuration(lightSleepMs, durationUnit)), null, 0L, null, null, false, 62, null), BarEntry.copy$default(barEntry, (int) Duration.m1679getInWholeSecondsimpl(DurationKt.toDuration((int) sleepHistoryEntry.getDeepSleepMs(), durationUnit)), null, 0L, null, null, false, 62, null)}), format$default, invoke, VmChartUtilsKt.isSelected(sleepHistoryEntry.getEnd(), timePeriod));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final StateEntry createStateEntry(SleepType sleepType, long j) {
        Pair pair;
        int r0 = WhenMappings.$EnumSwitchMapping$0[sleepType.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    pair = new Pair(StringsExtensionsKt.getAppString(Key.sleep_type_deep), 1);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                pair = new Pair(StringsExtensionsKt.getAppString(Key.sleep_type_light), 2);
            }
        } else {
            pair = new Pair(StringsExtensionsKt.getAppString(Key.sleep_type_awake), 3);
        }
        return new StateEntry(((Number) pair.second).intValue(), j, DateFormatter.format$default(getDayMarkerFormatter$watch_release(), j, null, false, 6, null), (String) pair.first, DateFormatter.format$default(getDayMarkerFormatter$watch_release(), j, null, false, 6, null), false, 32, (DefaultConstructorMarker) null);
    }

    private final Function1<Long, String> markerSleepLastNightFormatter() {
        return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.SleepViewModel$markerSleepLastNightFormatter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Long l) {
                return invoke(l.longValue());
            }

            public final String invoke(long j) {
                StringBuilder sb = new StringBuilder();
                DateFormatter weekMarkerFormatter$watch_release = SleepViewModel.this.getWeekMarkerFormatter$watch_release();
                int r1 = Duration.$r8$clinit;
                sb.append(DateFormatter.format$default(weekMarkerFormatter$watch_release, j - Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.DAYS)), null, false, 6, null));
                sb.append('-');
                sb.append(DateFormatter.format$default(SleepViewModel.this.getWeekMarkerFormatter$watch_release(), j, null, false, 6, null));
                return sb.toString();
            }
        };
    }

    private final boolean sameMonth(Instant instant, Instant instant2, TimeZone timeZone) {
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, timeZone);
        LocalDateTime localDateTime2 = TimeZoneKt.toLocalDateTime(instant2, timeZone);
        if (localDateTime.getYear() == localDateTime2.getYear() && localDateTime.getMonth() == localDateTime2.getMonth()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean sameMonth$default(SleepViewModel sleepViewModel, Instant instant, Instant instant2, TimeZone timeZone, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return sleepViewModel.sameMonth(instant, instant2, timeZone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toPercentageString(double d) {
        if (d > 0.0d) {
            return MathKt__MathJVMKt.roundToInt(d * 100) + " %";
        }
        return "-";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSleepHistoryData(com.animaconnected.watch.fitness.TimePeriod r22, com.animaconnected.watch.fitness.TimePeriod r23, com.animaconnected.watch.fitness.EntriesAmount r24, com.animaconnected.watch.device.DateFormatter r25, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String> r26, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.animaconnected.watch.graphs.StackedBarEntry>>> r27) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.SleepViewModel.getSleepHistoryData(com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.EntriesAmount, com.animaconnected.watch.device.DateFormatter, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean hasSleepData() {
        if (this.fitnessProvider.getSleepHistoryLatestEntry() != null) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.workout.ChartViewModel
    public Function1<Long, String> markerHistoryFormatter(HistoryPeriodTab historyPeriod) {
        Intrinsics.checkNotNullParameter(historyPeriod, "historyPeriod");
        int r0 = WhenMappings.$EnumSwitchMapping$1[historyPeriod.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    return super.markerHistoryFormatter(historyPeriod);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.SleepViewModel$markerHistoryFormatter$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Long l) {
                    return invoke(l.longValue());
                }

                public final String invoke(long j) {
                    DateFormatter dateMarkerFormatter$watch_release = SleepViewModel.this.getDateMarkerFormatter$watch_release();
                    int r02 = Duration.$r8$clinit;
                    return DateFormatter.format$default(dateMarkerFormatter$watch_release, j - Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.DAYS)), null, false, 6, null) + '-' + DateFormatter.format$default(SleepViewModel.this.getDateMarkerFormatter$watch_release(), j, null, false, 6, null) + ' ' + DateFormatter.format$default(DateTimeFormattersKt.getShortMonthInYearFormatter(ServiceLocator.INSTANCE.getStringsBackend()), j, null, false, 6, null);
                }
            };
        }
        return markerSleepLastNightFormatter();
    }

    public final CommonFlow<SleepSummary> observeLastNightSleepData() {
        FitnessProvider fitnessProvider = this.fitnessProvider;
        final CommonFlow<SleepSession> lastNightSleepData = fitnessProvider.getLastNightSleepData(fitnessProvider.getProfile().getBedtime());
        return FlowExtensionsKt.asCommonFlow(new Flow<SleepSummary>() { // from class: com.animaconnected.watch.workout.SleepViewModel$observeLastNightSleepData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.SleepViewModel$observeLastNightSleepData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ SleepViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.SleepViewModel$observeLastNightSleepData$$inlined$map$1$2", f = "SleepViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.SleepViewModel$observeLastNightSleepData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, SleepViewModel sleepViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = sleepViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        Method dump skipped, instructions count: 316
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.SleepViewModel$observeLastNightSleepData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SleepViewModel.SleepSummary> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final Object observeLastWeekSleepData(Continuation<? super CommonFlow<ChartData<StackedBarEntry>>> continuation) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeSleepData(TimePeriod.Companion.lastWeek$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), markerSleepLastNightFormatter(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object observeSleepData(final com.animaconnected.watch.fitness.TimePeriod r9, com.animaconnected.watch.fitness.TimePeriod r10, com.animaconnected.watch.fitness.EntriesAmount r11, com.animaconnected.watch.device.DateFormatter r12, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String> r13, kotlin.coroutines.Continuation<? super com.animaconnected.watch.CommonFlow<com.animaconnected.watch.graphs.ChartData<com.animaconnected.watch.graphs.StackedBarEntry>>> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.workout.SleepViewModel$observeSleepData$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.workout.SleepViewModel$observeSleepData$1 r0 = (com.animaconnected.watch.workout.SleepViewModel$observeSleepData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.SleepViewModel$observeSleepData$1 r0 = new com.animaconnected.watch.workout.SleepViewModel$observeSleepData$1
            r0.<init>(r8, r14)
        L18:
            r7 = r0
            java.lang.Object r14 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r7.L$1
            com.animaconnected.watch.fitness.TimePeriod r9 = (com.animaconnected.watch.fitness.TimePeriod) r9
            java.lang.Object r10 = r7.L$0
            com.animaconnected.watch.workout.SleepViewModel r10 = (com.animaconnected.watch.workout.SleepViewModel) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4f
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            kotlin.ResultKt.throwOnFailure(r14)
            r7.L$0 = r8
            r7.L$1 = r9
            r7.label = r2
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.getSleepHistoryData(r2, r3, r4, r5, r6, r7)
            if (r14 != r0) goto L4e
            return r0
        L4e:
            r10 = r8
        L4f:
            kotlinx.coroutines.flow.Flow r14 = (kotlinx.coroutines.flow.Flow) r14
            com.animaconnected.watch.workout.SleepViewModel$observeSleepData$$inlined$map$1 r11 = new com.animaconnected.watch.workout.SleepViewModel$observeSleepData$$inlined$map$1
            r11.<init>()
            com.animaconnected.watch.CommonFlow r9 = com.animaconnected.watch.FlowExtensionsKt.asCommonFlow(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.SleepViewModel.observeSleepData(com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.EntriesAmount, com.animaconnected.watch.device.DateFormatter, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
