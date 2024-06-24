package com.animaconnected.watch.device;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;

/* compiled from: WatchEventListener.kt */
/* loaded from: classes3.dex */
public interface BehaviourListener {
    void onBehaviourSet(Slot slot, Behaviour behaviour);

    void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction buttonAction, boolean z);
}
