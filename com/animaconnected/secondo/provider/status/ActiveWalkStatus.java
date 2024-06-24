package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.screens.status.distress.DistressActiveWalkFragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class ActiveWalkStatus extends StatusModel {
    public static final int $stable = 0;
    private final Observer observer;

    public ActiveWalkStatus(Observer observer) {
        super(2100, DistressActiveWalkFragment.class, null);
        this.observer = observer;
    }

    public static /* synthetic */ ActiveWalkStatus copy$default(ActiveWalkStatus activeWalkStatus, Observer observer, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            observer = activeWalkStatus.observer;
        }
        return activeWalkStatus.copy(observer);
    }

    public final Observer component1() {
        return this.observer;
    }

    public final ActiveWalkStatus copy(Observer observer) {
        return new ActiveWalkStatus(observer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ActiveWalkStatus) && Intrinsics.areEqual(this.observer, ((ActiveWalkStatus) obj).observer)) {
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
        return "ActiveWalkStatus(observer=" + this.observer + ')';
    }
}
