package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.screens.status.distress.PendingWalkFragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class PendingWalkStatus extends StatusModel {
    public static final int $stable = 0;
    private final Observer observer;

    public PendingWalkStatus(Observer observer) {
        super(2100, PendingWalkFragment.class, null);
        this.observer = observer;
    }

    public static /* synthetic */ PendingWalkStatus copy$default(PendingWalkStatus pendingWalkStatus, Observer observer, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            observer = pendingWalkStatus.observer;
        }
        return pendingWalkStatus.copy(observer);
    }

    public final Observer component1() {
        return this.observer;
    }

    public final PendingWalkStatus copy(Observer observer) {
        return new PendingWalkStatus(observer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof PendingWalkStatus) && Intrinsics.areEqual(this.observer, ((PendingWalkStatus) obj).observer)) {
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
        return "PendingWalkStatus(observer=" + this.observer + ')';
    }
}
