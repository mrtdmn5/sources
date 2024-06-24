package com.amplifyframework.storage.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.amplifyframework.storage.result.StorageTransferProgress;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class StorageDownloadFileOperation<R> extends StorageTransferOperation<R, StorageDownloadFileResult> {
    public StorageDownloadFileOperation(R r) {
        this(r, UUID.randomUUID().toString(), null, null, null);
    }

    @Override // com.amplifyframework.core.async.AmplifyOperation
    public R getRequest() {
        return (R) super.getRequest();
    }

    @Override // com.amplifyframework.storage.operation.StorageTransferOperation
    public void setOnSuccess(Consumer<StorageDownloadFileResult> consumer) {
        super.setOnSuccess(consumer);
    }

    public StorageDownloadFileOperation(R r, String str, Consumer<StorageTransferProgress> consumer, Consumer<StorageDownloadFileResult> consumer2, Consumer<StorageException> consumer3) {
        super(r, str, consumer, consumer2, consumer3);
    }
}
