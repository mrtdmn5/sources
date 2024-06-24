package com.animaconnected.watch.account.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessCloudProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudProvider", f = "FitnessCloudProvider.kt", l = {76, 81, 92, 93}, m = "sync")
/* loaded from: classes3.dex */
public final class FitnessCloudProvider$sync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessCloudProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudProvider$sync$1(FitnessCloudProvider fitnessCloudProvider, Continuation<? super FitnessCloudProvider$sync$1> continuation) {
        super(continuation);
        this.this$0 = fitnessCloudProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sync(null, false, this);
    }
}
