package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.fitness.mock.HeartRateMock;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DebugHeartRateChart.kt */
/* loaded from: classes3.dex */
public final class DebugHeartRateChartVm {
    public static final int $stable = 8;
    private final MutableStateFlow<List<PointEntry>> entries;

    public DebugHeartRateChartVm() {
        HeartRateMock heartRateMock = new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0).getHeartRateMock();
        int r1 = Duration.$r8$clinit;
        this.entries = StateFlowKt.MutableStateFlow(heartRateMock.m1521generateHeartRatePointsHG0u8IE(30, DurationKt.toDuration(1, DurationUnit.MINUTES)));
    }

    public final int average(List<PointEntry> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        List<PointEntry> list = entries;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PointEntry) it.next()).getLineChartValue());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof Known) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(((Known) it2.next()).getValue()));
        }
        boolean z = true;
        if (arrayList3.size() <= 1) {
            z = false;
        }
        if (!z) {
            arrayList3 = null;
        }
        if (arrayList3 == null) {
            return 0;
        }
        return (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList3);
    }

    public final MutableStateFlow<List<PointEntry>> getEntries() {
        return this.entries;
    }

    public final Object randomizeData(int r4, int r5, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugHeartRateChartVm$randomizeData$2(this, r5, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
