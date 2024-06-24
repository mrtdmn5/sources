package com.amplifyframework.notifications;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.category.SubCategoryType;
import com.amplifyframework.core.plugin.Plugin;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsPlugin.kt */
/* loaded from: classes.dex */
public abstract class NotificationsPlugin<E> implements NotificationsCategoryBehavior, Plugin<E> {
    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.NOTIFICATIONS;
    }

    public abstract SubCategoryType getSubCategoryType();

    @Override // com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
