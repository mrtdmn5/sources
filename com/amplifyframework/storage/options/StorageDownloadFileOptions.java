package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: classes.dex */
public class StorageDownloadFileOptions extends StorageOptions {

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageOptions.Builder<B, StorageDownloadFileOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageDownloadFileOptions build() {
            return new StorageDownloadFileOptions(this);
        }
    }

    public StorageDownloadFileOptions(Builder<?> builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageDownloadFileOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageDownloadFileOptions storageDownloadFileOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageDownloadFileOptions.getAccessLevel())).targetIdentityId(storageDownloadFileOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageDownloadFileOptions)) {
            return false;
        }
        StorageDownloadFileOptions storageDownloadFileOptions = (StorageDownloadFileOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageDownloadFileOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageDownloadFileOptions.getTargetIdentityId())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StorageDownloadFileOptions {accessLevel=");
        sb.append(getAccessLevel());
        sb.append(", targetIdentityId=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, getTargetIdentityId(), '}');
    }
}
