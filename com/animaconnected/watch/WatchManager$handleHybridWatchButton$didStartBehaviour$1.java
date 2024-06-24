package com.animaconnected.watch;

import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$handleHybridWatchButton$didStartBehaviour$1", f = "WatchManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$handleHybridWatchButton$didStartBehaviour$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ButtonAction $action;
    final /* synthetic */ Behaviour $triggeredBehaviour;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$handleHybridWatchButton$didStartBehaviour$1(Behaviour behaviour, ButtonAction buttonAction, Continuation<? super WatchManager$handleHybridWatchButton$didStartBehaviour$1> continuation) {
        super(2, continuation);
        this.$triggeredBehaviour = behaviour;
        this.$action = buttonAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchManager$handleHybridWatchButton$didStartBehaviour$1(this.$triggeredBehaviour, this.$action, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Pusher pusher;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Behaviour behaviour = this.$triggeredBehaviour;
            if (behaviour instanceof Pusher) {
                pusher = (Pusher) behaviour;
            } else {
                pusher = null;
            }
            boolean z = false;
            if (pusher != null && pusher.execute(this.$action)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((WatchManager$handleHybridWatchButton$didStartBehaviour$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
