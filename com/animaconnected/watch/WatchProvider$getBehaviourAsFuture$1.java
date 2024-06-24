package com.animaconnected.watch;

import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$getBehaviourAsFuture$1", f = "WatchProvider.kt", l = {281}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$getBehaviourAsFuture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Behaviour>, Object> {
    final /* synthetic */ Slot $slot;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$getBehaviourAsFuture$1(WatchProvider watchProvider, Slot slot, Continuation<? super WatchProvider$getBehaviourAsFuture$1> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
        this.$slot = slot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchProvider$getBehaviourAsFuture$1(this.this$0, this.$slot, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Behaviours behaviours = this.this$0.getBehaviours();
            Slot slot = this.$slot;
            this.label = 1;
            obj = behaviours.getBehaviour(slot, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Behaviour> continuation) {
        return ((WatchProvider$getBehaviourAsFuture$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
