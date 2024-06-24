package com.amplifyframework.storage.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StorageRemoveResult {
    private final String key;

    private StorageRemoveResult(String str) {
        this.key = str;
    }

    public static StorageRemoveResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageRemoveResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StorageRemoveResult.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.key, ((StorageRemoveResult) obj).key);
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
