package com.animaconnected.watch.workout;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.NumberFormatter;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DailyGoalsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$observeDailyGoalsData$4", f = "DailyGoalsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DailyGoalsViewModel$observeDailyGoalsData$4 extends SuspendLambda implements Function5<List<? extends StepEntry>, List<? extends StandEntry>, List<? extends ExerciseEntry>, HealthGoals, Continuation<? super List<? extends DailyGoalsProgressItem>>, Object> {
    final /* synthetic */ DateFormatter $dateFormatter;
    final /* synthetic */ EqualIntervals $nbrOfEntries;
    final /* synthetic */ NumberFormatter $numberFormatter;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGoalsViewModel$observeDailyGoalsData$4(EqualIntervals equalIntervals, DateFormatter dateFormatter, NumberFormatter numberFormatter, Continuation<? super DailyGoalsViewModel$observeDailyGoalsData$4> continuation) {
        super(5, continuation);
        this.$nbrOfEntries = equalIntervals;
        this.$dateFormatter = dateFormatter;
        this.$numberFormatter = numberFormatter;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(List<? extends StepEntry> list, List<? extends StandEntry> list2, List<? extends ExerciseEntry> list3, HealthGoals healthGoals, Continuation<? super List<? extends DailyGoalsProgressItem>> continuation) {
        return invoke2((List<StepEntry>) list, (List<StandEntry>) list2, (List<ExerciseEntry>) list3, healthGoals, (Continuation<? super List<DailyGoalsProgressItem>>) continuation);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            List list3 = (List) this.L$2;
            HealthGoals healthGoals = (HealthGoals) this.L$3;
            IntRange until = RangesKt___RangesKt.until(0, this.$nbrOfEntries.getAmountOfEntries());
            DateFormatter dateFormatter = this.$dateFormatter;
            NumberFormatter numberFormatter = this.$numberFormatter;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
            ?? it = until.iterator();
            while (it.hasNext) {
                int nextInt = it.nextInt();
                Instant.Companion companion = Instant.Companion;
                long timestamp = ((StepEntry) list.get(nextInt)).getTimestamp();
                companion.getClass();
                LocalDateTime localDateTime$default = DateTimeUtilsKt.getLocalDateTime$default(Instant.Companion.fromEpochMilliseconds(timestamp), null, 2, null);
                TimeZone.Companion.getClass();
                ArrayList arrayList2 = arrayList;
                String format$default = DateFormatter.format$default(dateFormatter, TimeZoneKt.toInstant(localDateTime$default, TimeZone.UTC).toEpochMilliseconds(), null, false, 6, null);
                int steps = ((StepEntry) list.get(nextInt)).getSteps();
                int successfulStands = ((StandEntry) list2.get(nextInt)).getSuccessfulStands();
                int activeMinutes = ((ExerciseEntry) list3.get(nextInt)).getActiveMinutes();
                BarEntry barEntry = new BarEntry(steps, format$default, 0L, (String) null, numberFormatter.format(steps), false, 44, (DefaultConstructorMarker) null);
                BarEntry barEntry2 = new BarEntry(successfulStands, format$default, 0L, (String) null, numberFormatter.format(successfulStands), false, 44, (DefaultConstructorMarker) null);
                StringBuilder sb = new StringBuilder();
                List list4 = list;
                List list5 = list2;
                sb.append(numberFormatter.format(activeMinutes));
                sb.append(' ');
                sb.append(StringsExtensionsKt.getAppString(Key.timer_minutes));
                BarEntry barEntry3 = new BarEntry(activeMinutes, format$default, 0L, (String) null, sb.toString(), false, 44, (DefaultConstructorMarker) null);
                if (steps >= healthGoals.getSteps()) {
                    z = true;
                } else {
                    z = false;
                }
                if (successfulStands >= healthGoals.getStand()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (activeMinutes >= healthGoals.getExercise()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                arrayList2.add(new DailyGoalsProgressItem(format$default, barEntry, barEntry2, barEntry3, z, z2, z3));
                arrayList = arrayList2;
                list = list4;
                list2 = list5;
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<StepEntry> list, List<StandEntry> list2, List<ExerciseEntry> list3, HealthGoals healthGoals, Continuation<? super List<DailyGoalsProgressItem>> continuation) {
        DailyGoalsViewModel$observeDailyGoalsData$4 dailyGoalsViewModel$observeDailyGoalsData$4 = new DailyGoalsViewModel$observeDailyGoalsData$4(this.$nbrOfEntries, this.$dateFormatter, this.$numberFormatter, continuation);
        dailyGoalsViewModel$observeDailyGoalsData$4.L$0 = list;
        dailyGoalsViewModel$observeDailyGoalsData$4.L$1 = list2;
        dailyGoalsViewModel$observeDailyGoalsData$4.L$2 = list3;
        dailyGoalsViewModel$observeDailyGoalsData$4.L$3 = healthGoals;
        return dailyGoalsViewModel$observeDailyGoalsData$4.invokeSuspend(Unit.INSTANCE);
    }
}
