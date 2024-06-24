package com.animaconnected.watch.behaviour.distress;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Distress.kt */
/* loaded from: classes3.dex */
public interface DistressInterface {
    default void doOnStateChange(Function1<? super WalkMeHomeState, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    WalkMeHomeState getCurrentState();

    void startEmergency();

    void startSharingLocation();

    void stopEmergency();

    void stopSharingLocation();
}
