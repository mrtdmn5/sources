package com.amplifyframework.logging;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: classes.dex */
public abstract class LoggingPlugin<E> implements LoggingCategoryBehavior, Plugin<E> {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoggingPlugin)) {
            return false;
        }
        return getPluginKey().equals(((LoggingPlugin) obj).getPluginKey());
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public final CategoryType getCategoryType() {
        return CategoryType.LOGGING;
    }

    public final int hashCode() {
        return getPluginKey().hashCode();
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
    }
}
