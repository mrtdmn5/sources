package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusProvider.kt */
/* loaded from: classes3.dex */
public final class StatusProvider {
    public static final int $stable = 8;
    private final StatusController[] controllers;
    private boolean isMuted;
    private final Set<StatusChangeListener> listeners;
    private StatusModel status;

    public StatusProvider(StatusController... controllers) {
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        this.controllers = controllers;
        this.listeners = new CopyOnWriteArraySet();
        StatusChangeListener statusChangeListener = new StatusChangeListener() { // from class: com.animaconnected.secondo.provider.status.StatusProvider$changeListener$1
            @Override // com.animaconnected.secondo.provider.status.StatusChangeListener
            public void onStatusChanged() {
                StatusProvider.this.update();
            }
        };
        for (StatusController statusController : controllers) {
            statusController.setStatusChangeListener(statusChangeListener);
        }
        update();
    }

    private final StatusModel calculateHighestPrioStatus() {
        Object obj;
        StatusController[] statusControllerArr = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (StatusController statusController : statusControllerArr) {
            StatusModel currentStatusModel = statusController.getCurrentStatusModel();
            if (currentStatusModel != null) {
                arrayList.add(currentStatusModel);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int priority = ((StatusModel) next).getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((StatusModel) next2).getPriority();
                    if (priority < priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        return (StatusModel) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update() {
        if (this.isMuted) {
            return;
        }
        StatusModel calculateHighestPrioStatus = calculateHighestPrioStatus();
        if (!Intrinsics.areEqual(calculateHighestPrioStatus, this.status)) {
            this.status = calculateHighestPrioStatus;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((StatusChangeListener) it.next()).onStatusChanged();
            }
        }
    }

    public final StatusController[] getControllers() {
        return this.controllers;
    }

    public final StatusModel getCurrent() {
        if (this.isMuted) {
            return null;
        }
        return this.status;
    }

    public final PowerOptimizationStatusController getPowerOptimizationController() {
        PowerOptimizationStatusController powerOptimizationStatusController;
        StatusController[] statusControllerArr = this.controllers;
        int length = statusControllerArr.length;
        int r2 = 0;
        while (true) {
            powerOptimizationStatusController = null;
            if (r2 >= length) {
                break;
            }
            StatusController statusController = statusControllerArr[r2];
            if (statusController instanceof PowerOptimizationStatusController) {
                powerOptimizationStatusController = (PowerOptimizationStatusController) statusController;
            }
            if (powerOptimizationStatusController != null) {
                break;
            }
            r2++;
        }
        return powerOptimizationStatusController;
    }

    public final void muteStatus(boolean z) {
        this.isMuted = z;
        update();
    }

    public final boolean registerListener(StatusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.add(listener);
    }

    public final boolean unregisterListener(StatusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.remove(listener);
    }
}
