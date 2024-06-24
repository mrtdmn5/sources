package com.amplifyframework.storage.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StorageUploadInputStreamResult extends StorageUploadResult {
    private StorageUploadInputStreamResult(String str) {
        super(str);
    }

    public static StorageUploadInputStreamResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadInputStreamResult(str);
    }

    @Override // com.amplifyframework.storage.result.StorageUploadResult
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StorageUploadInputStreamResult.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(super.getKey(), ((StorageUploadInputStreamResult) obj).getKey());
        }
        return false;
    }

    @Override // com.amplifyframework.storage.result.StorageUploadResult
    public int hashCode() {
        return super.hashCode();
    }
}
