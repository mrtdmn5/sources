package com.animaconnected.watch.fitness;

import com.animaconnected.watch.Watch;
import com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$2", f = "WatchFitnessProvider.kt", l = {1120, 1122, 1123, 1123, 1124, 1125}, m = "emit")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$setWatch$2$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFitnessProvider$setWatch$2.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WatchFitnessProvider$setWatch$2$2$emit$1(WatchFitnessProvider$setWatch$2.AnonymousClass2<? super T> anonymousClass2, Continuation<? super WatchFitnessProvider$setWatch$2$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Watch.WatchState) null, (Continuation<? super Unit>) this);
    }
}
