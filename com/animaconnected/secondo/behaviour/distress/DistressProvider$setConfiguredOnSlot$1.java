package com.animaconnected.secondo.behaviour.distress;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.distress.Distress;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressProvider$setConfiguredOnSlot$1", f = "DistressProvider.kt", l = {20}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressProvider$setConfiguredOnSlot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Slot $watchSlot;
    int label;
    final /* synthetic */ DistressProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressProvider$setConfiguredOnSlot$1(DistressProvider distressProvider, Slot slot, Continuation<? super DistressProvider$setConfiguredOnSlot$1> continuation) {
        super(2, continuation);
        this.this$0 = distressProvider;
        this.$watchSlot = slot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DistressProvider$setConfiguredOnSlot$1(this.this$0, this.$watchSlot, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Behaviours behaviours;
        Behaviours behaviours2;
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
            behaviours = this.this$0.behaviours;
            Behaviour behaviour = behaviours.getBehaviour(Distress.TYPE);
            Intrinsics.checkNotNull(behaviour);
            behaviours2 = this.this$0.behaviours;
            Slot slot = this.$watchSlot;
            this.label = 1;
            if (behaviours2.moveBehaviourToSlot(slot, behaviour, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressProvider$setConfiguredOnSlot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
