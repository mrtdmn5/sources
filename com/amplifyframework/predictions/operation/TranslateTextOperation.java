package com.amplifyframework.predictions.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public abstract class TranslateTextOperation<R> extends AmplifyOperation<R> {
    public TranslateTextOperation(R r) {
        super(CategoryType.PREDICTIONS, r);
    }
}
