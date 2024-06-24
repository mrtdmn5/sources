package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DebugHeartRateChart.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugHeartRateChartVm$randomizeData$2", f = "DebugHeartRateChart.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugHeartRateChartVm$randomizeData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $baseLine;
    final /* synthetic */ int $range;
    int label;
    final /* synthetic */ DebugHeartRateChartVm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugHeartRateChartVm$randomizeData$2(DebugHeartRateChartVm debugHeartRateChartVm, int r2, int r3, Continuation<? super DebugHeartRateChartVm$randomizeData$2> continuation) {
        super(2, continuation);
        this.this$0 = debugHeartRateChartVm;
        this.$range = r2;
        this.$baseLine = r3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugHeartRateChartVm$randomizeData$2(this.this$0, this.$range, this.$baseLine, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<PointEntry> value;
        ArrayList arrayList;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<List<PointEntry>> entries = this.this$0.getEntries();
            int r0 = this.$range;
            int r1 = this.$baseLine;
            do {
                value = entries.getValue();
                List<PointEntry> list = value;
                arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(PointEntry.copy$default((PointEntry) it.next(), new Known(Random.Default.nextInt(r0) + r1, false, 2, (DefaultConstructorMarker) null), null, null, false, 14, null));
                }
            } while (!entries.compareAndSet(value, arrayList));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugHeartRateChartVm$randomizeData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
