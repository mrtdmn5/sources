package com.animaconnected.secondo.screens.debugsettings;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: DebugCSEMLogsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugCSEMLogsFragment$onResume$1", f = "DebugCSEMLogsFragment.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugCSEMLogsFragment$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugCSEMLogsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCSEMLogsFragment$onResume$1(DebugCSEMLogsFragment debugCSEMLogsFragment, Continuation<? super DebugCSEMLogsFragment$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = debugCSEMLogsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugCSEMLogsFragment$onResume$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0 && r1 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        while (this.this$0.isResumed()) {
            this.this$0.updateText();
            int r12 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(3, DurationUnit.SECONDS);
            this.label = 1;
            if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugCSEMLogsFragment$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
