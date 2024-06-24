package com.amplifyframework.notifications.pushnotifications;

import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushNotificationsCategory.kt */
/* loaded from: classes.dex */
public final class PushNotificationsCategory extends Category<PushNotificationsPlugin<?>> implements PushNotificationsCategoryBehavior {
    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return getSelectedPlugin().getCategoryType();
    }

    @Override // com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior
    public void handleNotificationReceived(NotificationPayload payload, Consumer<PushNotificationResult> onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().handleNotificationReceived(payload, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.NotificationsCategoryBehavior
    public void identifyUser(String userId, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().identifyUser(userId, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior
    public void recordNotificationOpened(NotificationPayload payload, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().recordNotificationOpened(payload, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior
    public void recordNotificationReceived(NotificationPayload payload, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().recordNotificationReceived(payload, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior
    public void registerDevice(String token, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().registerDevice(token, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior
    public boolean shouldHandleNotification(NotificationPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return getSelectedPlugin().shouldHandleNotification(payload);
    }

    @Override // com.amplifyframework.notifications.NotificationsCategoryBehavior
    public void identifyUser(String userId, UserProfile profile, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        getSelectedPlugin().identifyUser(userId, profile, onSuccess, onError);
    }
}
