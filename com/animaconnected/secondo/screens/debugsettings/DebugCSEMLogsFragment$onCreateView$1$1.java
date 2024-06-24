package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import com.animaconnected.watch.device.WatchIODebug;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugCSEMLogsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugCSEMLogsFragment$onCreateView$1$1", f = "DebugCSEMLogsFragment.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugCSEMLogsFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DebugCSEMLogsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCSEMLogsFragment$onCreateView$1$1(DebugCSEMLogsFragment debugCSEMLogsFragment, Continuation<? super DebugCSEMLogsFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugCSEMLogsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugCSEMLogsFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugCSEMLogsFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchIODebug watchIODebug;
        DebugCSEMLogsFragment debugCSEMLogsFragment;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                debugCSEMLogsFragment = (DebugCSEMLogsFragment) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            watchIODebug = this.this$0.watchDebugIo;
            if (watchIODebug != null) {
                DebugCSEMLogsFragment debugCSEMLogsFragment2 = this.this$0;
                CSEMLogsFileSaver cSEMLogsFileSaver = CSEMLogsFileSaver.INSTANCE;
                this.L$0 = debugCSEMLogsFragment2;
                this.label = 1;
                if (cSEMLogsFileSaver.enable(watchIODebug, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                debugCSEMLogsFragment = debugCSEMLogsFragment2;
            }
            return Unit.INSTANCE;
        }
        debugCSEMLogsFragment.updateText();
        return Unit.INSTANCE;
    }
}
