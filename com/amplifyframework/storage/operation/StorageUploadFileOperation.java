package com.amplifyframework.storage.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class StorageUploadFileOperation<R> extends StorageUploadOperation<R, StorageUploadFileResult> {
    public StorageUploadFileOperation(R r) {
        this(r, UUID.randomUUID().toString(), null, null, null);
    }

    @Override // com.amplifyframework.storage.operation.StorageUploadOperation, com.amplifyframework.storage.operation.StorageTransferOperation
    public void setOnSuccess(Consumer<StorageUploadFileResult> consumer) {
        super.setOnSuccess(consumer);
    }

    public StorageUploadFileOperation(R r, String str, Consumer<StorageTransferProgress> consumer, Consumer<StorageUploadFileResult> consumer2, Consumer<StorageException> consumer3) {
        super(r, str, consumer, consumer2, consumer3);
    }
}
