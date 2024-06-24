package com.amplifyframework.notifications;

import android.content.Context;
import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryConfiguration;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.category.EmptyCategoryConfiguration;
import com.amplifyframework.core.category.SubCategoryType;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsCategory;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsPlugin;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsCategory.kt */
/* loaded from: classes.dex */
public class NotificationsCategory extends Category<NotificationsPlugin<?>> implements NotificationsCategoryBehavior {
    public PushNotificationsCategory Push = new PushNotificationsCategory();

    /* compiled from: NotificationsCategory.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SubCategoryType.values().length];
            r0[SubCategoryType.PUSH_NOTIFICATIONS.ordinal()] = 1;
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // com.amplifyframework.core.category.Category
    public void configure(CategoryConfiguration configuration, Context context) {
        CategoryConfiguration categoryConfiguration;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(context, "context");
        Set<NotificationsPlugin<?>> plugins = getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "plugins");
        Iterator<T> it = plugins.iterator();
        while (it.hasNext()) {
            NotificationsPlugin notificationsPlugin = (NotificationsPlugin) it.next();
            if (WhenMappings.$EnumSwitchMapping$0[notificationsPlugin.getSubCategoryType().ordinal()] == 1) {
                this.Push.addPlugin((PushNotificationsPlugin) notificationsPlugin);
                if (configuration instanceof NotificationsCategoryConfiguration) {
                    categoryConfiguration = (NotificationsCategoryConfiguration) configuration;
                } else {
                    categoryConfiguration = null;
                }
                PushNotificationsCategory pushNotificationsCategory = this.Push;
                if (categoryConfiguration == null) {
                    categoryConfiguration = EmptyCategoryConfiguration.forCategoryType(getCategoryType());
                }
                pushNotificationsCategory.configure(categoryConfiguration, context);
            }
        }
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.NOTIFICATIONS;
    }

    @Override // com.amplifyframework.notifications.NotificationsCategoryBehavior
    public void identifyUser(String userId, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.Push.identifyUser(userId, onSuccess, onError);
    }

    @Override // com.amplifyframework.notifications.NotificationsCategoryBehavior
    public void identifyUser(String userId, UserProfile profile, Action onSuccess, Consumer<PushNotificationsException> onError) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.Push.identifyUser(userId, profile, onSuccess, onError);
    }

    public static /* synthetic */ void getPush$annotations() {
    }
}
