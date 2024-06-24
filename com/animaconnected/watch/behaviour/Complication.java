package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.device.Scale;
import java.util.List;

/* compiled from: Pusher.kt */
/* loaded from: classes3.dex */
public interface Complication extends Behaviour {
    List<Scale> compatibleScales();

    int getDeviceComplicationMode();
}
