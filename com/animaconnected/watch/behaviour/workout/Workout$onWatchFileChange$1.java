package com.animaconnected.watch.behaviour.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Workout.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.workout.Workout", f = "Workout.kt", l = {47}, m = "onWatchFileChange")
/* loaded from: classes3.dex */
public final class Workout$onWatchFileChange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Workout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Workout$onWatchFileChange$1(Workout workout, Continuation<? super Workout$onWatchFileChange$1> continuation) {
        super(continuation);
        this.this$0 = workout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onWatchFileChange(null, null, this);
    }
}
