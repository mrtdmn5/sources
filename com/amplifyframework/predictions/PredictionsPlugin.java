package com.amplifyframework.predictions;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: classes.dex */
public abstract class PredictionsPlugin<E> implements PredictionsCategoryBehavior, Plugin<E> {
    @Override // com.amplifyframework.core.category.CategoryTypeable
    public final CategoryType getCategoryType() {
        return CategoryType.PREDICTIONS;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) throws AmplifyException {
    }
}
