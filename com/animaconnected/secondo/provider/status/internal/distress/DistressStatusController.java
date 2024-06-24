package com.animaconnected.secondo.provider.status.internal.distress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.provider.status.ActiveEmergencyStatus;
import com.animaconnected.secondo.provider.status.ActiveWalkStatus;
import com.animaconnected.secondo.provider.status.NoInviteStatus;
import com.animaconnected.secondo.provider.status.PendingWalkStatus;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.provider.status.WaitingForResponseStatus;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DistressStatusController.kt */
/* loaded from: classes3.dex */
public final class DistressStatusController extends StatusController implements DistressModel.OnChangeListener {
    public static final int $stable = 8;
    private final Context context;
    private final Handler handler;
    private boolean missingObserver;

    public DistressStatusController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        DistressModel.Companion.getInstance(context).addOnChangeListener(this);
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$0(DistressStatusController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCurrentStatusModel() instanceof NoInviteStatus) {
            this$0.setCurrentStatusModel(null);
            StatusChangeListener statusChangeListener = this$0.getStatusChangeListener();
            if (statusChangeListener != null) {
                statusChangeListener.onStatusChanged();
            }
        }
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onChanged() {
        update();
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onMissingObserver() {
        this.missingObserver = true;
        update();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusController
    public void update() {
        StatusModel statusModel;
        DistressModel companion = DistressModel.Companion.getInstance(this.context);
        WalkMeHomeState state = companion.getState();
        if (this.missingObserver) {
            this.missingObserver = false;
            setCurrentStatusModel(NoInviteStatus.INSTANCE);
            this.handler.postDelayed(new DistressStatusController$$ExternalSyntheticLambda0(0, this), 3500L);
        } else {
            if (WalkMeHomeState.Active == state) {
                statusModel = new ActiveWalkStatus(companion.getObserver());
            } else if (WalkMeHomeState.Distress == state) {
                statusModel = new ActiveEmergencyStatus(companion.getObserver());
            } else if (WalkMeHomeState.Pending == state) {
                statusModel = new PendingWalkStatus(companion.getObserver());
            } else if (companion.isWaitingForInviteResponse()) {
                statusModel = WaitingForResponseStatus.INSTANCE;
            } else {
                statusModel = null;
            }
            setCurrentStatusModel(statusModel);
        }
        StatusChangeListener statusChangeListener = getStatusChangeListener();
        if (statusChangeListener != null) {
            statusChangeListener.onStatusChanged();
        }
    }
}
