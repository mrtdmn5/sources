package com.animaconnected.secondo.widget.chart;

import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartEntry;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChartView.kt */
@DebugMetadata(c = "com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$2", f = "ChartView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ChartViewKt$ChartView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Chart $chart;
    final /* synthetic */ List<ChartEntry> $data;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChartViewKt$ChartView$2(Chart chart, List<? extends ChartEntry> list, Continuation<? super ChartViewKt$ChartView$2> continuation) {
        super(2, continuation);
        this.$chart = chart;
        this.$data = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewKt$ChartView$2(this.$chart, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$chart.setData(this.$data);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewKt$ChartView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
