package com.animaconnected.watch.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CaloriesViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.CaloriesViewModel", f = "CaloriesViewModel.kt", l = {90}, m = "getAvgCaloriesPerMonth")
/* loaded from: classes3.dex */
public final class CaloriesViewModel$getAvgCaloriesPerMonth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaloriesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaloriesViewModel$getAvgCaloriesPerMonth$1(CaloriesViewModel caloriesViewModel, Continuation<? super CaloriesViewModel$getAvgCaloriesPerMonth$1> continuation) {
        super(continuation);
        this.this$0 = caloriesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object avgCaloriesPerMonth;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        avgCaloriesPerMonth = this.this$0.getAvgCaloriesPerMonth(null, null, null, null, this);
        return avgCaloriesPerMonth;
    }
}
