package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugChartBase.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$onCreateView$1$7", f = "DebugChartBase.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugChartBase$onCreateView$1$7 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugChartBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugChartBase$onCreateView$1$7(DebugChartBase debugChartBase, Continuation<? super DebugChartBase$onCreateView$1$7> continuation) {
        super(2, continuation);
        this.this$0 = debugChartBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugChartBase$onCreateView$1$7(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugChartBase$onCreateView$1$7) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.onRandomizeDataClick();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
