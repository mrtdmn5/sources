package com.amplifyframework.kotlin.notifications.pushnotifications;

import com.amplifyframework.kotlin.notifications.Notifications;
import com.amplifyframework.notifications.pushnotifications.NotificationPayload;
import com.amplifyframework.notifications.pushnotifications.PushNotificationResult;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Push.kt */
/* loaded from: classes.dex */
public interface Push extends Notifications {
    Object handleNotificationReceived(NotificationPayload notificationPayload, Continuation<? super PushNotificationResult> continuation) throws PushNotificationsException;

    Object recordNotificationOpened(NotificationPayload notificationPayload, Continuation<? super Unit> continuation) throws PushNotificationsException;

    Object recordNotificationReceived(NotificationPayload notificationPayload, Continuation<? super Unit> continuation) throws PushNotificationsException;

    Object registerDevice(String str, Continuation<? super Unit> continuation) throws PushNotificationsException;

    boolean shouldHandleNotification(NotificationPayload notificationPayload);
}
