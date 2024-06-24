package com.amplifyframework.storage.result;

import java.io.File;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StorageDownloadFileResult extends StorageTransferResult {
    private final File file;

    private StorageDownloadFileResult(File file) {
        this.file = file;
    }

    public static StorageDownloadFileResult fromFile(File file) {
        Objects.requireNonNull(file);
        return new StorageDownloadFileResult(file);
    }

    public File getFile() {
        return this.file;
    }
}
