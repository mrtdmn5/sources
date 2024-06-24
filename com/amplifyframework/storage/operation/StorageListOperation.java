package com.amplifyframework.storage.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public abstract class StorageListOperation<R> extends AmplifyOperation<R> {
    public StorageListOperation(R r) {
        super(CategoryType.STORAGE, r);
    }
}
