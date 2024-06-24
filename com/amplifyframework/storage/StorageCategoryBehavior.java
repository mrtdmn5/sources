package com.amplifyframework.storage;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.operation.StorageDownloadFileOperation;
import com.amplifyframework.storage.operation.StorageGetUrlOperation;
import com.amplifyframework.storage.operation.StorageListOperation;
import com.amplifyframework.storage.operation.StorageRemoveOperation;
import com.amplifyframework.storage.operation.StorageTransferOperation;
import com.amplifyframework.storage.operation.StorageUploadFileOperation;
import com.amplifyframework.storage.operation.StorageUploadInputStreamOperation;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.options.StorageGetUrlOptions;
import com.amplifyframework.storage.options.StorageListOptions;
import com.amplifyframework.storage.options.StorageRemoveOptions;
import com.amplifyframework.storage.options.StorageUploadFileOptions;
import com.amplifyframework.storage.options.StorageUploadInputStreamOptions;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.amplifyframework.storage.result.StorageGetUrlResult;
import com.amplifyframework.storage.result.StorageListResult;
import com.amplifyframework.storage.result.StorageRemoveResult;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageTransferResult;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import com.amplifyframework.storage.result.StorageUploadInputStreamResult;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface StorageCategoryBehavior {
    StorageDownloadFileOperation<?> downloadFile(String str, File file, Consumer<StorageDownloadFileResult> consumer, Consumer<StorageException> consumer2);

    StorageDownloadFileOperation<?> downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer<StorageDownloadFileResult> consumer, Consumer<StorageException> consumer2);

    StorageDownloadFileOperation<?> downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer<StorageTransferProgress> consumer, Consumer<StorageDownloadFileResult> consumer2, Consumer<StorageException> consumer3);

    void getTransfer(String str, Consumer<StorageTransferOperation<?, ? extends StorageTransferResult>> consumer, Consumer<StorageException> consumer2);

    StorageGetUrlOperation<?> getUrl(String str, Consumer<StorageGetUrlResult> consumer, Consumer<StorageException> consumer2);

    StorageGetUrlOperation<?> getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Consumer<StorageGetUrlResult> consumer, Consumer<StorageException> consumer2);

    StorageListOperation<?> list(String str, Consumer<StorageListResult> consumer, Consumer<StorageException> consumer2);

    StorageListOperation<?> list(String str, StorageListOptions storageListOptions, Consumer<StorageListResult> consumer, Consumer<StorageException> consumer2);

    StorageRemoveOperation<?> remove(String str, Consumer<StorageRemoveResult> consumer, Consumer<StorageException> consumer2);

    StorageRemoveOperation<?> remove(String str, StorageRemoveOptions storageRemoveOptions, Consumer<StorageRemoveResult> consumer, Consumer<StorageException> consumer2);

    StorageUploadFileOperation<?> uploadFile(String str, File file, Consumer<StorageUploadFileResult> consumer, Consumer<StorageException> consumer2);

    StorageUploadFileOperation<?> uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer<StorageUploadFileResult> consumer, Consumer<StorageException> consumer2);

    StorageUploadFileOperation<?> uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer<StorageTransferProgress> consumer, Consumer<StorageUploadFileResult> consumer2, Consumer<StorageException> consumer3);

    StorageUploadInputStreamOperation<?> uploadInputStream(String str, InputStream inputStream, Consumer<StorageUploadInputStreamResult> consumer, Consumer<StorageException> consumer2);

    StorageUploadInputStreamOperation<?> uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer<StorageUploadInputStreamResult> consumer, Consumer<StorageException> consumer2);

    StorageUploadInputStreamOperation<?> uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer<StorageTransferProgress> consumer, Consumer<StorageUploadInputStreamResult> consumer2, Consumer<StorageException> consumer3);
}
