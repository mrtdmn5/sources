package com.amplifyframework.notifications.pushnotifications;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.category.SubCategoryType;
import com.amplifyframework.notifications.NotificationsPlugin;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushNotificationsPlugin.kt */
/* loaded from: classes.dex */
public abstract class PushNotificationsPlugin<E> extends NotificationsPlugin<E> implements PushNotificationsCategoryBehavior {
    @Override // com.amplifyframework.notifications.NotificationsPlugin, com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.NOTIFICATIONS;
    }

    @Override // com.amplifyframework.notifications.NotificationsPlugin
    public SubCategoryType getSubCategoryType() {
        return SubCategoryType.PUSH_NOTIFICATIONS;
    }

    @Override // com.amplifyframework.notifications.NotificationsPlugin, com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
