package com.amplifyframework.predictions.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public abstract class InterpretOperation<R> extends AmplifyOperation<R> {
    public InterpretOperation(R r) {
        super(CategoryType.PREDICTIONS, r);
    }
}
