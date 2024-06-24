package com.animaconnected.watch.behaviour;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Behaviours.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours", f = "Behaviours.kt", l = {218}, m = "setBehaviourForSlot")
/* loaded from: classes3.dex */
public final class Behaviours$setBehaviourForSlot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Behaviours this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Behaviours$setBehaviourForSlot$1(Behaviours behaviours, Continuation<? super Behaviours$setBehaviourForSlot$1> continuation) {
        super(continuation);
        this.this$0 = behaviours;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setBehaviourForSlot(null, null, this);
    }
}
