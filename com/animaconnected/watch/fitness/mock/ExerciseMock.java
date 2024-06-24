package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: ExerciseMock.kt */
/* loaded from: classes3.dex */
public final class ExerciseMock {
    private final String id = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
    private Integer staticExerciseValue;

    public final CommonFlow<List<ExerciseEntry>> getData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Integer num = this.staticExerciseValue;
        if (num != null) {
            return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new ExerciseEntry(this.id, timePeriod.getStartTs(), num.intValue(), null))));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new ExerciseEntry(this.id, timePeriod.getStartTs(), Random.Default.nextInt(0, 60), null))));
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public final CommonFlow<List<ExerciseEntry>> getDataWithResolution(TimePeriod timePeriod, int r20) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Integer num = this.staticExerciseValue;
        if (num != null) {
            return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new ExerciseEntry(this.id, timePeriod.getStartTs(), num.intValue(), null))));
        }
        long durationMs = timePeriod.getDurationMs() / r20;
        IntRange until = RangesKt___RangesKt.until(0, r20);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        ?? it = until.iterator();
        while (it.hasNext) {
            long nextInt = (it.nextInt() * durationMs) + timePeriod.getStartTs();
            arrayList.add(new ExerciseEntry(this.id, nextInt, new XorWowRandom((int) nextInt, (int) (nextInt >> 32)).nextInt(0, 120), null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    /* renamed from: getId-V9ZILtA, reason: not valid java name */
    public final String m1518getIdV9ZILtA() {
        return this.id;
    }

    public final Integer getStaticExerciseValue() {
        return this.staticExerciseValue;
    }

    public final void setStaticExerciseValue(Integer num) {
        this.staticExerciseValue = num;
    }
}
