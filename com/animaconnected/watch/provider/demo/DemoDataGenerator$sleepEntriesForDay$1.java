package com.animaconnected.watch.provider.demo;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.Entry;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.mock.SessionMock$$ExternalSyntheticOutline0;
import com.animaconnected.watch.workout.SleepType;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.ranges.ClosedDoubleRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequenceScope;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: DemoDataGenerator.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoDataGenerator$sleepEntriesForDay$1", f = "DemoDataGenerator.kt", l = {120, R.styleable.AppTheme_stepsHistoryGoalLineColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoDataGenerator$sleepEntriesForDay$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Entry>, Continuation<? super Unit>, Object> {
    final /* synthetic */ TimePeriod $day;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DemoDataGenerator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoDataGenerator$sleepEntriesForDay$1(DemoDataGenerator demoDataGenerator, TimePeriod timePeriod, Continuation<? super DemoDataGenerator$sleepEntriesForDay$1> continuation) {
        super(2, continuation);
        this.this$0 = demoDataGenerator;
        this.$day = timePeriod;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DemoDataGenerator$sleepEntriesForDay$1 demoDataGenerator$sleepEntriesForDay$1 = new DemoDataGenerator$sleepEntriesForDay$1(this.this$0, this.$day, continuation);
        demoDataGenerator$sleepEntriesForDay$1.L$0 = obj;
        return demoDataGenerator$sleepEntriesForDay$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int daysBeforePeriodEnd;
        Random random;
        int normalClampedInt;
        Random random2;
        int normalClampedInt2;
        Random random3;
        double normal;
        String str;
        Bedtime bedtime;
        Bedtime bedtime2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Object yieldAll;
        CoroutineSingletons coroutineSingletons;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 != 1 && r2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            daysBeforePeriodEnd = this.this$0.daysBeforePeriodEnd(this.$day);
            if (daysBeforePeriodEnd == 0) {
                Instant start = this.$day.getStart();
                int r6 = Duration.$r8$clinit;
                Instant m1705minusLRDsOJo = start.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
                bedtime = this.this$0.bedtime;
                int hour = bedtime.getHour();
                DurationUnit durationUnit = DurationUnit.HOURS;
                Instant m1706plusLRDsOJo = m1705minusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(hour, durationUnit));
                bedtime2 = this.this$0.bedtime;
                int minute = bedtime2.getMinute();
                DurationUnit durationUnit2 = DurationUnit.MINUTES;
                Instant m1706plusLRDsOJo2 = m1706plusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(minute, durationUnit2));
                str2 = this.this$0.historyDeviceId;
                long epochMilliseconds = m1706plusLRDsOJo2.toEpochMilliseconds();
                SleepType sleepType = SleepType.AWAKE;
                SleepEntry sleepEntry = new SleepEntry(str2, epochMilliseconds, sleepType, null);
                str3 = this.this$0.historyDeviceId;
                long m = SessionMock$$ExternalSyntheticOutline0.m(15, durationUnit2, m1706plusLRDsOJo2);
                SleepType sleepType2 = SleepType.DEEP;
                SleepEntry sleepEntry2 = new SleepEntry(str3, m, sleepType2, null);
                str4 = this.this$0.historyDeviceId;
                long m2 = SessionMock$$ExternalSyntheticOutline0.m(1, durationUnit, m1706plusLRDsOJo2);
                SleepType sleepType3 = SleepType.LIGHT;
                SleepEntry sleepEntry3 = new SleepEntry(str4, m2, sleepType3, null);
                str5 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry4 = new SleepEntry(str5, SessionMock$$ExternalSyntheticOutline0.m(2, durationUnit, m1706plusLRDsOJo2), sleepType2, null);
                str6 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry5 = new SleepEntry(str6, SessionMock$$ExternalSyntheticOutline0.m(3, durationUnit, m1706plusLRDsOJo2), sleepType2, null);
                str7 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry6 = new SleepEntry(str7, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(3, durationUnit))), sleepType2, null);
                str8 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry7 = new SleepEntry(str8, SessionMock$$ExternalSyntheticOutline0.m(4, durationUnit, m1706plusLRDsOJo2), sleepType3, null);
                str9 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry8 = new SleepEntry(str9, SessionMock$$ExternalSyntheticOutline0.m(5, durationUnit, m1706plusLRDsOJo2), sleepType2, null);
                str10 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry9 = new SleepEntry(str10, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(7, durationUnit))), sleepType2, null);
                str11 = this.this$0.historyDeviceId;
                SleepEntry sleepEntry10 = new SleepEntry(str11, SessionMock$$ExternalSyntheticOutline0.m(45, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(7, durationUnit))), sleepType3, null);
                str12 = this.this$0.historyDeviceId;
                List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new SleepEntry[]{sleepEntry, sleepEntry2, sleepEntry3, sleepEntry4, sleepEntry5, sleepEntry6, sleepEntry7, sleepEntry8, sleepEntry9, sleepEntry10, new SleepEntry(str12, SessionMock$$ExternalSyntheticOutline0.m(18, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(8, durationUnit))), sleepType, null)});
                this.label = 1;
                sequenceScope.getClass();
                if ((listOf instanceof Collection) && listOf.isEmpty()) {
                    yieldAll = Unit.INSTANCE;
                    coroutineSingletons = coroutineSingletons2;
                } else {
                    yieldAll = sequenceScope.yieldAll(listOf.iterator(), this);
                    coroutineSingletons = coroutineSingletons2;
                    if (yieldAll != coroutineSingletons) {
                        yieldAll = Unit.INSTANCE;
                    }
                }
                if (yieldAll == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Instant start2 = this.$day.getStart();
                int r5 = Duration.$r8$clinit;
                random = this.this$0.r;
                normalClampedInt = DemoDataGeneratorKt.normalClampedInt(random, new IntRange(0, 120));
                DurationUnit durationUnit3 = DurationUnit.MINUTES;
                Instant m1705minusLRDsOJo2 = start2.m1705minusLRDsOJo(DurationKt.toDuration(normalClampedInt, durationUnit3));
                Instant m1706plusLRDsOJo3 = this.$day.getStart().m1706plusLRDsOJo(DurationKt.toDuration(6, DurationUnit.HOURS));
                random2 = this.this$0.r;
                normalClampedInt2 = DemoDataGeneratorKt.normalClampedInt(random2, new IntRange(0, 120));
                Instant m1706plusLRDsOJo4 = m1706plusLRDsOJo3.m1706plusLRDsOJo(DurationKt.toDuration(normalClampedInt2, durationUnit3));
                long m1677getInWholeMillisecondsimpl = Duration.m1677getInWholeMillisecondsimpl(m1706plusLRDsOJo4.m1704minus5sfh64U(m1705minusLRDsOJo2));
                random3 = this.this$0.r;
                normal = DemoDataGeneratorKt.normal(random3, 0.7d, 0.2d);
                double doubleValue = ((Number) RangesKt___RangesKt.coerceIn(new Double(normal), new ClosedDoubleRange())).doubleValue();
                double d = m1677getInWholeMillisecondsimpl;
                str = this.this$0.historyDeviceId;
                SleepHistoryEntry sleepHistoryEntry = new SleepHistoryEntry(str, m1705minusLRDsOJo2.toEpochMilliseconds(), m1706plusLRDsOJo4.toEpochMilliseconds(), (long) ((1 - doubleValue) * d), (long) (d * doubleValue), null);
                this.label = 2;
                if (sequenceScope.yield(sleepHistoryEntry, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Entry> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DemoDataGenerator$sleepEntriesForDay$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
