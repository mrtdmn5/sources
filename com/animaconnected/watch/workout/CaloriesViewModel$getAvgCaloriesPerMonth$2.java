package com.animaconnected.watch.workout;

import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.BarEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CaloriesViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$2", f = "CaloriesViewModel.kt", l = {98, 98}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CaloriesViewModel$getAvgCaloriesPerMonth$2 extends SuspendLambda implements Function2<TimePeriod, Continuation<? super Flow<? extends List<? extends BarEntry>>>, Object> {
    final /* synthetic */ Function1<Long, String> $markerLabelFormatter;
    final /* synthetic */ TimePeriod $selectedTimePeriod;
    final /* synthetic */ DateFormatter $xAxisLabelFormatter;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaloriesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CaloriesViewModel$getAvgCaloriesPerMonth$2(CaloriesViewModel caloriesViewModel, DateFormatter dateFormatter, Function1<? super Long, String> function1, TimePeriod timePeriod, Continuation<? super CaloriesViewModel$getAvgCaloriesPerMonth$2> continuation) {
        super(2, continuation);
        this.this$0 = caloriesViewModel;
        this.$xAxisLabelFormatter = dateFormatter;
        this.$markerLabelFormatter = function1;
        this.$selectedTimePeriod = timePeriod;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaloriesViewModel$getAvgCaloriesPerMonth$2 caloriesViewModel$getAvgCaloriesPerMonth$2 = new CaloriesViewModel$getAvgCaloriesPerMonth$2(this.this$0, this.$xAxisLabelFormatter, this.$markerLabelFormatter, this.$selectedTimePeriod, continuation);
        caloriesViewModel$getAvgCaloriesPerMonth$2.L$0 = obj;
        return caloriesViewModel$getAvgCaloriesPerMonth$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TimePeriod timePeriod, Continuation<? super Flow<? extends List<BarEntry>>> continuation) {
        return ((CaloriesViewModel$getAvgCaloriesPerMonth$2) create(timePeriod, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x006c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r0 = r8.L$0
            com.animaconnected.watch.fitness.TimePeriod r0 = (com.animaconnected.watch.fitness.TimePeriod) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L68
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            java.lang.Object r1 = r8.L$0
            com.animaconnected.watch.fitness.TimePeriod r1 = (com.animaconnected.watch.fitness.TimePeriod) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L24:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            com.animaconnected.watch.fitness.TimePeriod r9 = (com.animaconnected.watch.fitness.TimePeriod) r9
            r1 = 0
            r4 = 3
            kotlinx.datetime.Instant r5 = com.animaconnected.info.DateTimeUtilsKt.getStartOfDay$default(r1, r1, r4, r1)
            boolean r5 = r9.contains(r5)
            if (r5 == 0) goto L45
            com.animaconnected.watch.fitness.TimePeriod r5 = new com.animaconnected.watch.fitness.TimePeriod
            kotlinx.datetime.Instant r6 = r9.getStart()
            kotlinx.datetime.Instant r1 = com.animaconnected.info.DateTimeUtilsKt.getStartOfDay$default(r1, r1, r4, r1)
            r5.<init>(r6, r1)
            goto L46
        L45:
            r5 = r9
        L46:
            com.animaconnected.watch.workout.CaloriesViewModel r1 = r8.this$0
            com.animaconnected.watch.fitness.FitnessProvider r1 = com.animaconnected.watch.workout.CaloriesViewModel.access$getFitnessProvider$p(r1)
            r8.L$0 = r9
            r8.label = r3
            java.lang.Object r1 = r1.getAvgCaloriesPerMonth(r5, r8)
            if (r1 != r0) goto L57
            return r0
        L57:
            r7 = r1
            r1 = r9
            r9 = r7
        L5a:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r9, r8)
            if (r9 != r0) goto L67
            return r0
        L67:
            r0 = r1
        L68:
            com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry r9 = (com.animaconnected.watch.fitness.WatchFitnessProvider.CalorieEntry) r9
            if (r9 != 0) goto L72
            com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry r9 = new com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry
            r1 = 0
            r9.<init>(r0, r1)
        L72:
            com.animaconnected.watch.workout.CaloriesViewModel r0 = r8.this$0
            com.animaconnected.watch.device.DateFormatter r1 = r8.$xAxisLabelFormatter
            kotlin.jvm.functions.Function1<java.lang.Long, java.lang.String> r2 = r8.$markerLabelFormatter
            com.animaconnected.watch.fitness.TimePeriod r3 = r8.$selectedTimePeriod
            com.animaconnected.watch.graphs.BarEntry r9 = com.animaconnected.watch.workout.CaloriesViewModel.access$toBarEntry(r0, r9, r1, r2, r3)
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r9)
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            r0.<init>(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TimePeriod timePeriod, Continuation<? super Flow<? extends List<? extends BarEntry>>> continuation) {
        return invoke2(timePeriod, (Continuation<? super Flow<? extends List<BarEntry>>>) continuation);
    }
}
