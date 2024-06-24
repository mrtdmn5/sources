package com.amplifyframework.storage.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public class StorageUploadResult extends StorageTransferResult {
    private final String key;

    public StorageUploadResult(String str) {
        this.key = str;
    }

    public static StorageUploadResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.key, ((StorageUploadResult) obj).key);
        }
        return false;
    }

    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.key;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
