package com.animaconnected.secondo.provider.status;

/* compiled from: StatusController.kt */
/* loaded from: classes3.dex */
public abstract class StatusController {
    public static final int $stable = 8;
    private StatusModel currentStatusModel;
    private StatusChangeListener statusChangeListener;

    public final StatusModel getCurrentStatusModel() {
        return this.currentStatusModel;
    }

    public final StatusChangeListener getStatusChangeListener() {
        return this.statusChangeListener;
    }

    public final void setCurrentStatusModel(StatusModel statusModel) {
        this.currentStatusModel = statusModel;
    }

    public final void setStatusChangeListener(StatusChangeListener statusChangeListener) {
        this.statusChangeListener = statusChangeListener;
    }

    public void update() {
    }
}
