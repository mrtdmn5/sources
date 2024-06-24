package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.WatchManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Behaviours.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours$setBehaviourForSlot$3", f = "Behaviours.kt", l = {257}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Behaviours$setBehaviourForSlot$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Behaviours this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Behaviours$setBehaviourForSlot$3(Behaviours behaviours, Continuation<? super Behaviours$setBehaviourForSlot$3> continuation) {
        super(2, continuation);
        this.this$0 = behaviours;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Behaviours$setBehaviourForSlot$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchManager watchManager;
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
            watchManager = this.this$0.wm;
            this.label = 1;
            if (watchManager.sync(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Behaviours$setBehaviourForSlot$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
