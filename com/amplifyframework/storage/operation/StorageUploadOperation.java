package com.amplifyframework.storage.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageUploadResult;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class StorageUploadOperation<R, T extends StorageUploadResult> extends StorageTransferOperation<R, T> {
    public StorageUploadOperation(R r) {
        this(r, UUID.randomUUID().toString(), null, null, null);
    }

    @Override // com.amplifyframework.core.async.AmplifyOperation
    public R getRequest() {
        return (R) super.getRequest();
    }

    @Override // com.amplifyframework.storage.operation.StorageTransferOperation
    public void setOnSuccess(Consumer<T> consumer) {
        super.setOnSuccess(consumer);
    }

    public StorageUploadOperation(R r, String str, Consumer<StorageTransferProgress> consumer, Consumer<T> consumer2, Consumer<StorageException> consumer3) {
        super(r, str, consumer, consumer2, consumer3);
    }
}
