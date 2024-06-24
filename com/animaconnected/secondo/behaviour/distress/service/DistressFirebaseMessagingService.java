package com.animaconnected.secondo.behaviour.distress.service;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.behaviour.distress.utils.VibratorHelper;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import com.google.gson.Gson;
import com.kronaby.watch.app.R;
import java.util.Map;

/* loaded from: classes3.dex */
public class DistressFirebaseMessagingService implements RemoteMessageReceiver {
    private static final String SERVICE_NAME = "distress";
    private static final String TAG = "DistressFirebaseMessagingService";
    private static final String WALK_ME_HOME_ACCEPT = "walk-me-home";
    private static final String WATCHUP_INVITATION_ACCEPT = "invitation-accept";

    @SuppressLint({"StaticFieldLeak"})
    private static DistressFirebaseMessagingService sInstance;
    private final Context mContext;

    private DistressFirebaseMessagingService(Context context) {
        this.mContext = context;
    }

    public static DistressFirebaseMessagingService getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DistressFirebaseMessagingService(context.getApplicationContext());
        }
        return sInstance;
    }

    private void handleAcknowledge(Map<String, String> map) {
        String str;
        String str2;
        Log.d(TAG, "handleAcknowledge() called with data = [" + map + "]");
        if (map == null) {
            str = "unknown";
        } else {
            str = map.get("state");
        }
        str.getClass();
        if (!str.equals("in-distress-acknowledged")) {
            if (str.equals("not-started") && DistressModel.getInstance(this.mContext).getState().equals(WalkMeHomeState.Idle)) {
                DistressModel distressModel = DistressModel.getInstance(this.mContext);
                if (distressModel.getObserver() != null) {
                    str2 = distressModel.getObserver().getFirstName();
                } else {
                    str2 = " ";
                }
                sendNotification(this.mContext.getString(R.string.behaviour_name_distress), this.mContext.getString(R.string.distress_ntf_safety_contact_removed, str2), KronabyApplication.createStartApplicationIntent());
                ProviderFactory.getDistressProvider().setNotConfigured();
                distressModel.setObserver(null);
                distressModel.setState(WalkMeHomeState.Registered);
                return;
            }
            return;
        }
        VibratorHelper.getInstance().acknowledgeReceived();
    }

    private void handleInvitationAccept(Map<String, String> map) {
        Observer observer = (Observer) new Gson().fromJson(map.get("user"), Observer.class);
        VibratorHelper.getInstance().acknowledgeInvite();
        sendNotification(this.mContext.getString(R.string.behaviour_name_distress), this.mContext.getString(R.string.distress_invite_accepted_notification_message, observer.getFirstName()), KronabyApplication.createStartApplicationIntent());
        DistressModel.getInstance(this.mContext).setObserver(observer);
        DistressModel.getInstance(this.mContext).setState(WalkMeHomeState.Idle);
    }

    private void sendNotification(String str, String str2, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, intent, 1073741824 | AppUtils.getPendingIntentFlag());
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(this.mContext, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(str);
        createNotificationBuilder.setContentText(str2);
        createNotificationBuilder.setFlag(16, true);
        createNotificationBuilder.setSound(defaultUri);
        createNotificationBuilder.mContentIntent = activity;
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.notify(0, createNotificationBuilder.build());
        }
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public void onMessageReceived(Map<String, String> map) {
        String str = map.get("type");
        if (WATCHUP_INVITATION_ACCEPT.equals(str)) {
            handleInvitationAccept(map);
            return;
        }
        if (WALK_ME_HOME_ACCEPT.equals(str)) {
            handleAcknowledge(map);
            return;
        }
        Log.i(TAG, "Unhandled Firebase Cloud Message : " + str);
    }
}
