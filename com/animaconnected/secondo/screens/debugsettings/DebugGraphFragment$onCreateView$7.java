package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import com.animaconnected.secondo.screens.debugsettings.graphs.DebugElevationChart;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugGraphFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugGraphFragment$onCreateView$7", f = "DebugGraphFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugGraphFragment$onCreateView$7 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugGraphFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugGraphFragment$onCreateView$7(DebugGraphFragment debugGraphFragment, Continuation<? super DebugGraphFragment$onCreateView$7> continuation) {
        super(2, continuation);
        this.this$0 = debugGraphFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugGraphFragment$onCreateView$7(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugGraphFragment$onCreateView$7) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().gotoNextFragment(DebugElevationChart.Companion.newInstance(false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
