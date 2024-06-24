package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageUploadOptions;

/* loaded from: classes.dex */
public class StorageUploadInputStreamOptions extends StorageUploadOptions {

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageUploadOptions.Builder<B, StorageUploadInputStreamOptions> {
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageUploadInputStreamOptions build() {
            return new StorageUploadInputStreamOptions(this);
        }
    }

    public StorageUploadInputStreamOptions(Builder<?> builder) {
        super(builder);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageUploadInputStreamOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageUploadInputStreamOptions storageUploadInputStreamOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(storageUploadInputStreamOptions.getAccessLevel())).targetIdentityId(storageUploadInputStreamOptions.getTargetIdentityId())).contentType(storageUploadInputStreamOptions.getContentType())).metadata(storageUploadInputStreamOptions.getMetadata());
    }

    @Override // com.amplifyframework.storage.options.StorageUploadOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageUploadInputStreamOptions)) {
            return false;
        }
        StorageUploadInputStreamOptions storageUploadInputStreamOptions = (StorageUploadInputStreamOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageUploadInputStreamOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageUploadInputStreamOptions.getTargetIdentityId()) && ObjectsCompat$Api19Impl.equals(getContentType(), storageUploadInputStreamOptions.getContentType()) && ObjectsCompat$Api19Impl.equals(getMetadata(), storageUploadInputStreamOptions.getMetadata())) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.storage.options.StorageUploadOptions
    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getAccessLevel(), getTargetIdentityId(), getContentType(), getMetadata());
    }

    @Override // com.amplifyframework.storage.options.StorageUploadOptions
    public String toString() {
        return "StorageUploadInputStreamOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", metadata=" + getMetadata() + '}';
    }
}
