package com.animaconnected.watch;

import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.InternalFitnessProvider;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$deviceEventListener$1$onSessionData$2", f = "WatchManager.kt", l = {218}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1$onSessionData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<FitnessMetric, Integer> $data;
    int label;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$deviceEventListener$1$onSessionData$2(WatchManager watchManager, Map<FitnessMetric, Integer> map, Continuation<? super WatchManager$deviceEventListener$1$onSessionData$2> continuation) {
        super(2, continuation);
        this.this$0 = watchManager;
        this.$data = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchManager$deviceEventListener$1$onSessionData$2(this.this$0, this.$data, continuation);
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
            WatchManager watchManager = this.this$0;
            InternalFitnessProvider.InternalSessionProvider internalSessionProvider$watch_release = watchManager.internalSessionProvider$watch_release(watchManager.getFitnessProvider());
            Map<FitnessMetric, Integer> map = this.$data;
            this.label = 1;
            if (internalSessionProvider$watch_release.setSessionData(map, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$deviceEventListener$1$onSessionData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
