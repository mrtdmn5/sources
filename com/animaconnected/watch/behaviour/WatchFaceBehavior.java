package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.Slot;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFaceBehavior.kt */
/* loaded from: classes3.dex */
public abstract class WatchFaceBehavior implements Complication, WatchFaceVisible {
    private final Set<BehaviourChangeListener> changeListeners = new HashSet();

    public float getHoursInDegrees() {
        return 0.0f;
    }

    public float getMinutesInDegrees() {
        return 0.0f;
    }

    public final void notifyDataChanged() {
        Iterator<T> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            ((BehaviourChangeListener) it.next()).onBehaviourChanged();
        }
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceVisible
    public void registerChangeListener(BehaviourChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.changeListeners.add(listener);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceVisible
    public void unregisterChangeListener(BehaviourChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.changeListeners.remove(listener);
    }

    public float getHoursInDegrees(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return getHoursInDegrees();
    }

    public void startRefreshing() {
    }

    public void stopRefreshing() {
    }
}
