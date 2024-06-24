package com.animaconnected.watch.fitness;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getLocationForSession$2", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$getLocationForSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LocationEntry>>, Object> {
    final /* synthetic */ long $start;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$getLocationForSession$2(WatchFitnessProvider watchFitnessProvider, long j, Continuation<? super WatchFitnessProvider$getLocationForSession$2> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$start = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$getLocationForSession$2(this.this$0, this.$start, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends LocationEntry>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<LocationEntry>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DBSession executeAsOneOrNull = this.this$0.getDb().getSession(this.$start).executeAsOneOrNull();
            if (executeAsOneOrNull == null) {
                return EmptyList.INSTANCE;
            }
            return FitnessDatabaseExtensionsKt.m1226getDetailedLocationsForSessionOPDSpw(this.this$0.getDb(), executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp(), executeAsOneOrNull.m1182getHdidV9ZILtA());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<LocationEntry>> continuation) {
        return ((WatchFitnessProvider$getLocationForSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
