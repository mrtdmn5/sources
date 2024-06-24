package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.watch.fitness.mock.ElevationMock;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DebugElevationChart.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugElevationViewModel$randomizeData$2", f = "DebugElevationChart.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugElevationViewModel$randomizeData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $baseLine;
    final /* synthetic */ int $range;
    int label;
    final /* synthetic */ DebugElevationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugElevationViewModel$randomizeData$2(DebugElevationViewModel debugElevationViewModel, int r2, int r3, Continuation<? super DebugElevationViewModel$randomizeData$2> continuation) {
        super(2, continuation);
        this.this$0 = debugElevationViewModel;
        this.$baseLine = r2;
        this.$range = r3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugElevationViewModel$randomizeData$2(this.this$0, this.$baseLine, this.$range, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ElevationMock elevationMock;
        ElevationMock elevationMock2;
        List<PointEntry> value;
        ArrayList arrayList;
        ElevationMock elevationMock3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            elevationMock = this.this$0.elevationMock;
            elevationMock.setBaseElevation(this.$baseLine);
            elevationMock2 = this.this$0.elevationMock;
            elevationMock2.setElevationRange(this.$range);
            MutableStateFlow<List<PointEntry>> entries = this.this$0.getEntries();
            DebugElevationViewModel debugElevationViewModel = this.this$0;
            do {
                value = entries.getValue();
                List<PointEntry> list = value;
                arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                for (PointEntry pointEntry : list) {
                    elevationMock3 = debugElevationViewModel.elevationMock;
                    arrayList.add(PointEntry.copy$default(pointEntry, new Known(elevationMock3.getNextElevationValue().invoke().intValue(), false, 2, (DefaultConstructorMarker) null), null, null, false, 14, null));
                }
            } while (!entries.compareAndSet(value, arrayList));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugElevationViewModel$randomizeData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
