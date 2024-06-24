package com.animaconnected.watch.location;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: LocationProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.location.LocationProvider$locations$1", f = "LocationProvider.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LocationProvider$locations$1 extends SuspendLambda implements Function2<ProducerScope<? super LocationResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocationProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationProvider$locations$1(LocationProvider locationProvider, Continuation<? super LocationProvider$locations$1> continuation) {
        super(2, continuation);
        this.this$0 = locationProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocationProvider$locations$1 locationProvider$locations$1 = new LocationProvider$locations$1(this.this$0, continuation);
        locationProvider$locations$1.L$0 = obj;
        return locationProvider$locations$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocationBackend locationBackend;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            locationBackend = this.this$0.locationBackend;
            locationBackend.startLocationUpdates(new Function1<LocationResult, Unit>() { // from class: com.animaconnected.watch.location.LocationProvider$locations$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LocationResult locationResult) {
                    invoke2(locationResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LocationResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo1701trySendJP2dKIU(it);
                    if (it instanceof Spot) {
                        return;
                    }
                    producerScope.close(null);
                }
            });
            final LocationProvider locationProvider = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.watch.location.LocationProvider$locations$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LocationBackend locationBackend2;
                    locationBackend2 = LocationProvider.this.locationBackend;
                    locationBackend2.stopUpdates();
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super LocationResult> producerScope, Continuation<? super Unit> continuation) {
        return ((LocationProvider$locations$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
