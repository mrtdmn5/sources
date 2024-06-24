package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.fitness.mock.ElevationMock;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DebugElevationChart.kt */
/* loaded from: classes3.dex */
public final class DebugElevationViewModel {
    public static final int $stable = 8;
    private final ElevationMock elevationMock;
    private final MutableStateFlow<List<PointEntry>> entries;

    public DebugElevationViewModel() {
        ElevationMock elevationMock = new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0).getElevationMock();
        this.elevationMock = elevationMock;
        this.entries = StateFlowKt.MutableStateFlow(elevationMock.generateElevationData(50));
    }

    public final MutableStateFlow<List<PointEntry>> getEntries() {
        return this.entries;
    }

    public final Object randomizeData(int r4, int r5, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugElevationViewModel$randomizeData$2(this, r4, r5, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
