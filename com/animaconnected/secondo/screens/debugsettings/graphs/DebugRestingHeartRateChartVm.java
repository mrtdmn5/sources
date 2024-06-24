package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.fitness.mock.HeartRateMock;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;

/* compiled from: DebugRestingHeartRateChart.kt */
/* loaded from: classes3.dex */
public final class DebugRestingHeartRateChartVm {
    public static final int $stable = 8;
    private final MutableStateFlow<List<PointEntry>> entries;

    public DebugRestingHeartRateChartVm() {
        HeartRateMock heartRateMock = new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0).getHeartRateMock();
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        int r2 = Duration.$r8$clinit;
        this.entries = StateFlowKt.MutableStateFlow(heartRateMock.m1523generateRestingHeartRatePointsSxA4cEA(instant, 30, DurationKt.toDuration(1, DurationUnit.DAYS)));
    }

    public final MutableStateFlow<List<PointEntry>> getEntries() {
        return this.entries;
    }

    public final Object randomizeData(int r4, int r5, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugRestingHeartRateChartVm$randomizeData$2(this, r5, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
