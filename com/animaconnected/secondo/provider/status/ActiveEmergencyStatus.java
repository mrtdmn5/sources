package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.screens.status.distress.DistressActiveEmergencyFragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class ActiveEmergencyStatus extends StatusModel {
    public static final int $stable = 0;
    private final Observer observer;

    public ActiveEmergencyStatus(Observer observer) {
        super(2100, DistressActiveEmergencyFragment.class, null);
        this.observer = observer;
    }

    public static /* synthetic */ ActiveEmergencyStatus copy$default(ActiveEmergencyStatus activeEmergencyStatus, Observer observer, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            observer = activeEmergencyStatus.observer;
        }
        return activeEmergencyStatus.copy(observer);
    }

    public final Observer component1() {
        return this.observer;
    }

    public final ActiveEmergencyStatus copy(Observer observer) {
        return new ActiveEmergencyStatus(observer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ActiveEmergencyStatus) && Intrinsics.areEqual(this.observer, ((ActiveEmergencyStatus) obj).observer)) {
            return true;
        }
        return false;
    }

    public final Observer getObserver() {
        return this.observer;
    }

    public int hashCode() {
        Observer observer = this.observer;
        if (observer == null) {
            return 0;
        }
        return observer.hashCode();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusModel
    public String toString() {
        return "ActiveEmergencyStatus(observer=" + this.observer + ')';
    }
}
