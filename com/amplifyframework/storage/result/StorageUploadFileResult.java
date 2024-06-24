package com.amplifyframework.storage.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StorageUploadFileResult extends StorageUploadResult {
    private StorageUploadFileResult(String str) {
        super(str);
    }

    public static StorageUploadFileResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadFileResult(str);
    }

    @Override // com.amplifyframework.storage.result.StorageUploadResult
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StorageUploadFileResult.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(super.getKey(), ((StorageUploadFileResult) obj).getKey());
        }
        return false;
    }

    @Override // com.amplifyframework.storage.result.StorageUploadResult
    public int hashCode() {
        return super.hashCode();
    }
}
