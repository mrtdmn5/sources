package com.amplifyframework.storage.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public abstract class StorageRemoveOperation<R> extends AmplifyOperation<R> {
    public StorageRemoveOperation(R r) {
        super(CategoryType.STORAGE, r);
    }
}
