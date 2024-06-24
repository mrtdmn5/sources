package com.amplifyframework.kotlin.notifications;

import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Notifications.kt */
/* loaded from: classes.dex */
public interface Notifications {
    Object identifyUser(String str, UserProfile userProfile, Continuation<? super Unit> continuation) throws PushNotificationsException;

    Object identifyUser(String str, Continuation<? super Unit> continuation) throws PushNotificationsException;
}
