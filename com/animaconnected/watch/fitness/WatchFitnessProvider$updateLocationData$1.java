package com.animaconnected.watch.fitness;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.location.LocationResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1", f = "WatchFitnessProvider.kt", l = {1170, 1178}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$updateLocationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $locationNeeded;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* compiled from: WatchFitnessProvider.kt */
    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1$2", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $locationNeeded;
        int label;
        final /* synthetic */ WatchFitnessProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WatchFitnessProvider watchFitnessProvider, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = watchFitnessProvider;
            this.$locationNeeded = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$locationNeeded, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.updateLocationData(this.$locationNeeded);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$updateLocationData$1(WatchFitnessProvider watchFitnessProvider, boolean z, Continuation<? super WatchFitnessProvider$updateLocationData$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$locationNeeded = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$updateLocationData$1(this.this$0, this.$locationNeeded, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocationProvider locationProvider;
        Watch watch;
        DisplayWatch displayWatch;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    BuildersKt.launch$default(this.this$0.getScope(), null, null, new AnonymousClass2(this.this$0, this.$locationNeeded, null), 3);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            locationProvider = this.this$0.locationProvider;
            Flow<LocationResult> locations = locationProvider.getLocations();
            final WatchFitnessProvider watchFitnessProvider = this.this$0;
            FlowCollector<? super LocationResult> flowCollector = new FlowCollector() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((LocationResult) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(LocationResult locationResult, Continuation<? super Unit> continuation) {
                    Object handleLocationResult;
                    handleLocationResult = WatchFitnessProvider.this.handleLocationResult(locationResult, continuation);
                    return handleLocationResult == CoroutineSingletons.COROUTINE_SUSPENDED ? handleLocationResult : Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (locations.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        watch = this.this$0.watch;
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        if (displayWatch != null) {
            displayWatch.reSync$watch_release();
        }
        int r7 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(10, DurationUnit.SECONDS);
        this.label = 2;
        if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        BuildersKt.launch$default(this.this$0.getScope(), null, null, new AnonymousClass2(this.this$0, this.$locationNeeded, null), 3);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$updateLocationData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
