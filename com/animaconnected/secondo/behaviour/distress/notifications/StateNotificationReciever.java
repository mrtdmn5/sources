package com.animaconnected.secondo.behaviour.distress.notifications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.service.DistressService;
import com.animaconnected.secondo.behaviour.distress.utils.VibratorHelper;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class StateNotificationReciever implements DistressModel.OnChangeListener {
    private static final String TAG = "StateNotificationReciever";

    @SuppressLint({"StaticFieldLeak"})
    private static StateNotificationReciever sInstance;
    private final Context mContext;
    private boolean mMissingObserver;
    private WalkMeHomeState mPreviousState = WalkMeHomeState.NotStarted;

    private StateNotificationReciever(Context context) {
        this.mContext = context;
        DistressModel.getInstance(context).addOnChangeListener(this);
        update();
    }

    public static StateNotificationReciever getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new StateNotificationReciever(context.getApplicationContext());
        }
        return sInstance;
    }

    private void handleCurrentState(WalkMeHomeState walkMeHomeState) {
        if (this.mMissingObserver) {
            this.mMissingObserver = false;
            pushNotification(this.mContext.getString(R.string.distress_ntf_no_safety_contact_title), this.mContext.getString(R.string.distress_ntf_no_safety_contact_message), false);
        } else if (walkMeHomeState == WalkMeHomeState.Pending) {
            VibratorHelper.getInstance().acknowledgeReceived();
            DistressModel.getInstance(this.mContext).setState(WalkMeHomeState.Active);
            sharingLocationNotification();
        } else if (walkMeHomeState == WalkMeHomeState.Active) {
            sharingLocationNotification();
        } else if (walkMeHomeState == WalkMeHomeState.Distress) {
            pushNotification(this.mContext.getString(R.string.distress_ntf_distress_title), this.mContext.getString(R.string.distress_ntf_distress_message));
        } else {
            Log.d(TAG, "This state change requires no android notification: " + walkMeHomeState);
            StateNotificationHandler.cancel(this.mContext);
        }
        if (walkMeHomeState == WalkMeHomeState.Pending) {
            PendingTimeout.startPendingTimeout(this.mContext);
        } else {
            PendingTimeout.cancelPending();
        }
    }

    private void pushNotification(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 26) {
            DistressService.updateNotification(str, str2);
        } else {
            StateNotificationHandler.pushNotification(this.mContext, str, str2);
        }
    }

    private void sharingLocationNotification() {
        String str;
        DistressModel distressModel = DistressModel.getInstance(this.mContext);
        if (distressModel.getObserver() != null && distressModel.getObserver().getFirstName() != null) {
            str = distressModel.getObserver().getFirstName();
        } else {
            str = "";
        }
        pushNotification(this.mContext.getString(R.string.distress_ntf_fmh_active_title), this.mContext.getString(R.string.distress_ntf_fmh_active_message, str));
    }

    private void update() {
        WalkMeHomeState state = DistressModel.getInstance(this.mContext).getState();
        if (!state.equals(this.mPreviousState) || this.mMissingObserver) {
            this.mPreviousState = state;
            Log.d(TAG, "state changed: " + state);
            handleCurrentState(state);
        }
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onChanged() {
        update();
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onMissingObserver() {
        this.mMissingObserver = true;
        update();
    }

    private void pushNotification(String str, String str2, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            DistressService.updateNotification(str, str2);
        } else {
            StateNotificationHandler.pushNotification(this.mContext, str, str2, z);
        }
    }
}
