package com.amplifyframework.geo;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: classes.dex */
public abstract class GeoCategoryPlugin<E> implements GeoCategoryBehavior, Plugin<E> {
    @Override // com.amplifyframework.core.category.CategoryTypeable
    public final CategoryType getCategoryType() {
        return CategoryType.GEO;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
    }
}
