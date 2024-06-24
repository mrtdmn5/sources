package com.animaconnected.watch;

import com.animaconnected.watch.WatchProvider;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$PeriodicTasksWorker", f = "WatchProvider.kt", l = {233}, m = "doWork")
/* loaded from: classes3.dex */
public final class WatchProvider$PeriodicTasksWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchProvider.PeriodicTasksWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$PeriodicTasksWorker$doWork$1(WatchProvider.PeriodicTasksWorker periodicTasksWorker, Continuation<? super WatchProvider$PeriodicTasksWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = periodicTasksWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
