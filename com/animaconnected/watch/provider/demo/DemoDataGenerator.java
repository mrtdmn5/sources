package com.animaconnected.watch.provider.demo;

import com.animaconnected.watch.fitness.ActivityClass;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.Entry;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.mock.SessionMock$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: DemoDataGenerator.kt */
/* loaded from: classes3.dex */
public final class DemoDataGenerator {
    private final Bedtime bedtime;
    private final List<Integer> firstStandEntries;
    private final boolean generateFitnessConfig;
    private final String historyDeviceId;
    private final Random r;
    private final TimePeriod timePeriod;

    public /* synthetic */ DemoDataGenerator(String str, TimePeriod timePeriod, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, timePeriod, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int daysBeforePeriodEnd(TimePeriod timePeriod) {
        return (int) Duration.m1689toLongimpl(this.timePeriod.getEnd().m1704minus5sfh64U(timePeriod.getStart()), DurationUnit.DAYS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FitnessConfig getFitnessConfig() {
        Long valueOf = Long.valueOf(this.timePeriod.getStartTs());
        Instant end = this.timePeriod.getEnd();
        int r4 = Duration.$r8$clinit;
        Long valueOf2 = Long.valueOf(end.m1705minusLRDsOJo(DurationKt.toDuration(13240, DurationUnit.DAYS)).toEpochMilliseconds());
        Integer valueOf3 = Integer.valueOf(FitnessProvider.Profile.Gender.Male.getId$watch_release());
        FitnessProvider.Profile.Temperature temperature = FitnessProvider.Profile.Temperature.Celsius;
        return new FitnessConfig(valueOf, 1780, 72000, valueOf2, valueOf3, Integer.valueOf(temperature.getId$watch_release()), Integer.valueOf(temperature.getId$watch_release()), this.bedtime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sequence<Entry> runSession(Instant instant) {
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(new DemoDataGenerator$runSession$1(instant, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sequence<Entry> sleepEntriesForDay(TimePeriod timePeriod) {
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(new DemoDataGenerator$sleepEntriesForDay$1(this, timePeriod, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StandEntry standEntryForDay(TimePeriod timePeriod) {
        int normalClampedInt;
        Integer valueOf;
        String str = this.historyDeviceId;
        Instant start = timePeriod.getStart();
        int r2 = Duration.$r8$clinit;
        long m = SessionMock$$ExternalSyntheticOutline0.m(8, DurationUnit.HOURS, start);
        List<Integer> list = this.firstStandEntries;
        int daysBeforePeriodEnd = daysBeforePeriodEnd(timePeriod);
        if (daysBeforePeriodEnd < 0 || daysBeforePeriodEnd > CollectionsKt__CollectionsKt.getLastIndex(list)) {
            normalClampedInt = DemoDataGeneratorKt.normalClampedInt(this.r, new IntRange(1, 16));
            valueOf = Integer.valueOf(normalClampedInt);
        } else {
            valueOf = list.get(daysBeforePeriodEnd);
        }
        return new StandEntry(str, m, valueOf.intValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityEntry walkActivity(Instant instant, int r17) {
        return new ActivityEntry(this.historyDeviceId, instant.toEpochMilliseconds(), Integer.valueOf(ActivityClass.Walk.getId()), Integer.valueOf(r17), 0, 0, 0, Float.valueOf(0.0f), 0, Integer.valueOf((int) (r17 * 0.5d * 0.0625d)), null);
    }

    public final Sequence<Object> generate() {
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(new DemoDataGenerator$generate$1(this, null));
    }

    public final HealthGoals getHealthGoals() {
        return new HealthGoals(8000, 7, 110);
    }

    private DemoDataGenerator(String historyDeviceId, TimePeriod timePeriod, boolean z) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        this.historyDeviceId = historyDeviceId;
        this.timePeriod = timePeriod;
        this.generateFitnessConfig = z;
        this.r = new XorWowRandom(42, 0);
        this.bedtime = new Bedtime(22, 30);
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(0.3d), Double.valueOf(1.1d), Double.valueOf(1.2d), Double.valueOf(0.8d), Double.valueOf(0.2d), Double.valueOf(0.9d), Double.valueOf(1.3d)});
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((int) (getHealthGoals().getStand() * ((Number) it.next()).doubleValue())));
        }
        this.firstStandEntries = arrayList;
    }
}
