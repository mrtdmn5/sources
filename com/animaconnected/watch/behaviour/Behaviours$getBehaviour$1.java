package com.animaconnected.watch.behaviour;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Behaviours.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours", f = "Behaviours.kt", l = {115, 117}, m = "getBehaviour")
/* loaded from: classes3.dex */
public final class Behaviours$getBehaviour$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Behaviours this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Behaviours$getBehaviour$1(Behaviours behaviours, Continuation<? super Behaviours$getBehaviour$1> continuation) {
        super(continuation);
        this.this$0 = behaviours;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getBehaviour(null, this);
    }
}
