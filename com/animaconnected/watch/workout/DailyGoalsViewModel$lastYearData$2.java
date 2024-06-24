package com.animaconnected.watch.workout;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DailyGoalsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.DailyGoalsViewModel$lastYearData$2", f = "DailyGoalsViewModel.kt", l = {107, 112, 117}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DailyGoalsViewModel$lastYearData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DailyGoalsProgressSection>>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DailyGoalsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGoalsViewModel$lastYearData$2(DailyGoalsViewModel dailyGoalsViewModel, Continuation<? super DailyGoalsViewModel$lastYearData$2> continuation) {
        super(2, continuation);
        this.this$0 = dailyGoalsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DailyGoalsViewModel$lastYearData$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends DailyGoalsProgressSection>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<DailyGoalsProgressSection>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0110 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0149  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x013e -> B:7:0x0145). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DailyGoalsViewModel$lastYearData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<DailyGoalsProgressSection>> continuation) {
        return ((DailyGoalsViewModel$lastYearData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
