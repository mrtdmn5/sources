package com.animaconnected.watch.location;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: LocationProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.location.LocationProvider$locations$3", f = "LocationProvider.kt", l = {56}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LocationProvider$locations$3 extends SuspendLambda implements Function3<FlowCollector<? super LocationResult>, LocationResult, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public LocationProvider$locations$3(Continuation<? super LocationProvider$locations$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocationResult locationResult;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                locationResult = (LocationResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            LocationResult locationResult2 = (LocationResult) this.L$1;
            this.L$0 = locationResult2;
            this.label = 1;
            if (flowCollector.emit(locationResult2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            locationResult = locationResult2;
        }
        return Boolean.valueOf(locationResult instanceof Spot);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super LocationResult> flowCollector, LocationResult locationResult, Continuation<? super Boolean> continuation) {
        LocationProvider$locations$3 locationProvider$locations$3 = new LocationProvider$locations$3(continuation);
        locationProvider$locations$3.L$0 = flowCollector;
        locationProvider$locations$3.L$1 = locationResult;
        return locationProvider$locations$3.invokeSuspend(Unit.INSTANCE);
    }
}
