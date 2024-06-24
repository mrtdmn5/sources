package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Behaviour.kt */
/* loaded from: classes3.dex */
public interface Behaviour {
    default void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    Slot[] compatibleSlots();

    default void connected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
    }

    default void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    default void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
    }

    String getAnalyticsName();

    default Function0<Boolean> getCheckPermissions() {
        return new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.Behaviour$checkPermissions$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        };
    }

    default Function0<Boolean> getCheckSetupNeeded() {
        return new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.Behaviour$checkSetupNeeded$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        };
    }

    String getType();

    default boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return true;
    }
}
