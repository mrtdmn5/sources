package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.device.ButtonAction;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pusher.kt */
/* loaded from: classes3.dex */
public interface Pusher extends Behaviour {
    default boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        throw new UnsupportedOperationException("Only implemented by triggers");
    }

    default boolean isExecuting() {
        return false;
    }
}
