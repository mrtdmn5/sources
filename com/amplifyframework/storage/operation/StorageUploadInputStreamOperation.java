package com.amplifyframework.storage.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageUploadInputStreamResult;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class StorageUploadInputStreamOperation<R> extends StorageUploadOperation<R, StorageUploadInputStreamResult> {
    public StorageUploadInputStreamOperation(R r) {
        this(r, UUID.randomUUID().toString(), null, null, null);
    }

    @Override // com.amplifyframework.storage.operation.StorageUploadOperation, com.amplifyframework.storage.operation.StorageTransferOperation
    public void setOnSuccess(Consumer<StorageUploadInputStreamResult> consumer) {
        super.setOnSuccess(consumer);
    }

    public StorageUploadInputStreamOperation(R r, String str, Consumer<StorageTransferProgress> consumer, Consumer<StorageUploadInputStreamResult> consumer2, Consumer<StorageException> consumer3) {
        super(r, str, consumer, consumer2, consumer3);
    }
}
