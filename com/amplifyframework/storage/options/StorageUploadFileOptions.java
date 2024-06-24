package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageUploadOptions;

/* loaded from: classes.dex */
public class StorageUploadFileOptions extends StorageUploadOptions {

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageUploadOptions.Builder<B, StorageUploadFileOptions> {
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageUploadFileOptions build() {
            return new StorageUploadFileOptions(this);
        }
    }

    public StorageUploadFileOptions(Builder<?> builder) {
        super(builder);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageUploadFileOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageUploadFileOptions storageUploadFileOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(storageUploadFileOptions.getAccessLevel())).targetIdentityId(storageUploadFileOptions.getTargetIdentityId())).contentType(storageUploadFileOptions.getContentType())).metadata(storageUploadFileOptions.getMetadata());
    }

    @Override // com.amplifyframework.storage.options.StorageUploadOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageUploadFileOptions)) {
            return false;
        }
        StorageUploadFileOptions storageUploadFileOptions = (StorageUploadFileOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageUploadFileOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageUploadFileOptions.getTargetIdentityId()) && ObjectsCompat$Api19Impl.equals(getContentType(), storageUploadFileOptions.getContentType()) && ObjectsCompat$Api19Impl.equals(getMetadata(), storageUploadFileOptions.getMetadata())) {
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
        return "StorageUploadFileOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", metadata=" + getMetadata() + '}';
    }
}
