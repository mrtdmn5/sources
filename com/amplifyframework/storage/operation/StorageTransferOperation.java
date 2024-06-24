package com.amplifyframework.storage.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.async.Resumable;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.TransferState;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageTransferResult;

/* loaded from: classes.dex */
public abstract class StorageTransferOperation<R, T extends StorageTransferResult> extends AmplifyOperation<R> implements Resumable, Cancelable {
    private StorageException error;
    private Consumer<StorageException> internalOnError;
    private Consumer<StorageTransferProgress> onProgress;
    private Consumer<T> onSuccess;
    private final String transferId;
    private TransferState transferState;

    /* loaded from: classes.dex */
    public class InternalOnError implements Consumer<StorageException> {
        private Consumer<StorageException> onError;

        public InternalOnError(Consumer<StorageException> consumer) {
            this.onError = consumer;
        }

        @Override // com.amplifyframework.core.Consumer
        public void accept(StorageException storageException) {
            StorageTransferOperation.this.setError(storageException);
            Consumer<StorageException> consumer = this.onError;
            if (consumer != null) {
                consumer.accept(storageException);
            }
        }
    }

    public StorageTransferOperation(R r, String str, Consumer<StorageTransferProgress> consumer, Consumer<T> consumer2, Consumer<StorageException> consumer3) {
        super(CategoryType.STORAGE, r);
        this.transferId = str;
        this.onProgress = consumer;
        this.onSuccess = consumer2;
        this.internalOnError = new InternalOnError(consumer3);
    }

    public void clearAllListeners() {
        this.onProgress = null;
        this.onSuccess = null;
        this.internalOnError = null;
    }

    public StorageException getError() {
        return this.error;
    }

    public Consumer<StorageException> getOnError() {
        return this.internalOnError;
    }

    public Consumer<StorageTransferProgress> getOnProgress() {
        return this.onProgress;
    }

    public Consumer<T> getOnSuccess() {
        return this.onSuccess;
    }

    public String getTransferId() {
        return this.transferId;
    }

    public abstract TransferState getTransferState();

    public void setError(StorageException storageException) {
        this.error = storageException;
    }

    public void setOnError(Consumer<StorageException> consumer) {
        if (consumer == null) {
            this.internalOnError = null;
            return;
        }
        this.internalOnError = new InternalOnError(consumer);
        if (getTransferState() == TransferState.FAILED) {
            if (this.error == null) {
                this.error = new StorageException("Something went wrong with your AWS S3 Storage transfer operation", new UnknownError("Reason unknown"), "Please re-queue the operation");
            }
            this.internalOnError.accept(this.error);
        }
    }

    public void setOnProgress(Consumer<StorageTransferProgress> consumer) {
        this.onProgress = consumer;
    }

    public void setOnSuccess(Consumer<T> consumer) {
        this.onSuccess = consumer;
    }

    public void setTransferState(TransferState transferState) {
        this.transferState = transferState;
    }
}
