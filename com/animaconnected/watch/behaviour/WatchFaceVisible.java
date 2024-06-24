package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.Slot;

/* compiled from: WatchFaceVisible.kt */
/* loaded from: classes3.dex */
public interface WatchFaceVisible {
    float getHoursInDegrees();

    float getHoursInDegrees(Slot slot);

    float getMinutesInDegrees();

    void registerChangeListener(BehaviourChangeListener behaviourChangeListener);

    void startRefreshing();

    void stopRefreshing();

    void unregisterChangeListener(BehaviourChangeListener behaviourChangeListener);
}
