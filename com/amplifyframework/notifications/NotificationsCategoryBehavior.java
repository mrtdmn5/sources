package com.amplifyframework.notifications;

import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;

/* compiled from: NotificationsCategoryBehavior.kt */
/* loaded from: classes.dex */
public interface NotificationsCategoryBehavior {
    void identifyUser(String str, UserProfile userProfile, Action action, Consumer<PushNotificationsException> consumer);

    void identifyUser(String str, Action action, Consumer<PushNotificationsException> consumer);
}
