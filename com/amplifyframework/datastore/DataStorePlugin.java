package com.amplifyframework.datastore;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: classes.dex */
public abstract class DataStorePlugin<E> implements DataStoreCategoryBehavior, Plugin<E> {
    @Override // com.amplifyframework.core.category.CategoryTypeable
    public final CategoryType getCategoryType() {
        return CategoryType.DATASTORE;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
    }
}
