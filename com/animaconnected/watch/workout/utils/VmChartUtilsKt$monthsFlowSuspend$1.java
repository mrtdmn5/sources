package com.animaconnected.watch.workout.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VmChartUtils.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.utils.VmChartUtilsKt", f = "VmChartUtils.kt", l = {29}, m = "monthsFlowSuspend")
/* loaded from: classes3.dex */
public final class VmChartUtilsKt$monthsFlowSuspend$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public VmChartUtilsKt$monthsFlowSuspend$1(Continuation<? super VmChartUtilsKt$monthsFlowSuspend$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VmChartUtilsKt.monthsFlowSuspend(null, null, this);
    }
}
