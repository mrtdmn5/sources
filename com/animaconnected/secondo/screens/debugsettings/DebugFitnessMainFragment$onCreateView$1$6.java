package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$6", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$6 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$6(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super DebugFitnessMainFragment$onCreateView$1$6> continuation) {
        super(2, continuation);
        this.this$0 = debugFitnessMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$6(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$6) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().gotoNextFragment(new DebugFitnessDatabaseFragment());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
