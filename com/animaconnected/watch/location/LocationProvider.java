package com.animaconnected.watch.location;

import com.animaconnected.watch.ServiceLocator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StartedWhileSubscribed;

/* compiled from: LocationProvider.kt */
/* loaded from: classes3.dex */
public final class LocationProvider {
    private final LocationBackend locationBackend;
    private final Flow<LocationResult> locations;
    private final String tag;

    public LocationProvider(LocationBackend locationBackend) {
        Intrinsics.checkNotNullParameter(locationBackend, "locationBackend");
        this.locationBackend = locationBackend;
        this.tag = "LocationProvider";
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(FlowKt.callbackFlow(new LocationProvider$locations$1(this, null)), new LocationProvider$locations$2(this, null));
        CoroutineScope scope = ServiceLocator.INSTANCE.getScope();
        int r1 = Duration.$r8$clinit;
        this.locations = new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(new SafeFlow(new FlowKt__LimitKt$transformWhile$1(FlowKt.shareIn(flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1, scope, new StartedWhileSubscribed(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.SECONDS)), Duration.m1677getInWholeMillisecondsimpl(0L)), 1), new LocationProvider$locations$3(null), null)), new LocationProvider$locations$4(this, null));
    }

    public final Object getGeoCodedAddress(Spot spot, Continuation<? super String> continuation) {
        return this.locationBackend.getGeoCodedAddress(spot, continuation);
    }

    public final boolean getHasLocationPermission() {
        return this.locationBackend.getHasLocationPermission();
    }

    public final Object getLocationSuspending(Continuation<? super LocationResult> continuation) {
        return FlowKt.single(new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(this.locations), continuation);
    }

    public final Flow<LocationResult> getLocations() {
        return this.locations;
    }

    public final String getTag() {
        return this.tag;
    }
}
