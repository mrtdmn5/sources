package com.animaconnected.watch.workout;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DashboardViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel", f = "DashboardViewModel.kt", l = {R.styleable.AppTheme_subComplicationDropZoneNotSelected}, m = "getWorkoutDetailed")
/* loaded from: classes3.dex */
public final class DashboardViewModel$getWorkoutDetailed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DashboardViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardViewModel$getWorkoutDetailed$1(DashboardViewModel dashboardViewModel, Continuation<? super DashboardViewModel$getWorkoutDetailed$1> continuation) {
        super(continuation);
        this.this$0 = dashboardViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getWorkoutDetailed(0L, this);
    }
}
