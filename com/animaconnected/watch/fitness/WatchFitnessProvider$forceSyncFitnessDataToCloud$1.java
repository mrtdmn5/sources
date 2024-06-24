package com.animaconnected.watch.fitness;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider", f = "WatchFitnessProvider.kt", l = {R.styleable.AppTheme_workoutDetailTintColor, 186, 190}, m = "forceSyncFitnessDataToCloud")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$forceSyncFitnessDataToCloud$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$forceSyncFitnessDataToCloud$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$forceSyncFitnessDataToCloud$1> continuation) {
        super(continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.forceSyncFitnessDataToCloud(this);
    }
}
