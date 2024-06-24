package com.animaconnected.secondo.behaviour.ifttt;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.kronaby.watch.app.R;
import java.util.Map;

/* loaded from: classes3.dex */
public class IftttActionReceiver implements RemoteMessageReceiver {
    private static final String REMOTE_SERVICE_NAME = "ifttt";
    private static final String TAG = "IftttActionReceiver";
    private static int sIftttNotificationId = 99889988;
    private static IftttActionReceiver sInstance;

    private IftttActionReceiver() {
    }

    public static IftttActionReceiver getInstance() {
        if (sInstance == null) {
            sInstance = new IftttActionReceiver();
        }
        return sInstance;
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    private void handleAction(final String str) {
        ProviderFactory.getNotificationProvider().getNotificationItemASync(10).success(new SuccessCallback() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttActionReceiver$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                IftttActionReceiver.lambda$handleAction$0(str, (ConfigurationItem) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleAction$0(String str, ConfigurationItem configurationItem) {
        if (configurationItem != null) {
            int group = configurationItem.getGroup();
            Log.d(TAG, "Current group is: " + group);
            Context context = KronabyApplication.getContext();
            if (group != -1 && RemoteConfigController.getInstance(context).isIftttNotificationsEnabled(Ifttt.TYPE)) {
                ProviderFactory.getWatch().alert(group + 1);
                showNotification(context, str);
            }
        }
    }

    private static void showNotification(Context context, String str) {
        NotificationManager notificationManager = getNotificationManager(context);
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.behaviour_name_ifttt));
        createNotificationBuilder.setContentText(str);
        createNotificationBuilder.setFlag(16, true);
        int r3 = sIftttNotificationId;
        sIftttNotificationId = r3 + 1;
        notificationManager.notify(r3, createNotificationBuilder.build());
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public String getServiceName() {
        return REMOTE_SERVICE_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public void onMessageReceived(Map<String, String> map) {
        if (REMOTE_SERVICE_NAME.equals(map.get(AnalyticsConstants.KEY_SERVICE))) {
            handleAction(map.get("message"));
        }
    }
}
