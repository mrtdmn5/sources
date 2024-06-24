package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: classes.dex */
public class StorageListOptions extends StorageOptions {

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageOptions.Builder<B, StorageListOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageListOptions build() {
            return new StorageListOptions(this);
        }
    }

    public StorageListOptions(Builder<?> builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageListOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageListOptions storageListOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageListOptions.getAccessLevel())).targetIdentityId(storageListOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageListOptions)) {
            return false;
        }
        StorageListOptions storageListOptions = (StorageListOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageListOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageListOptions.getTargetIdentityId())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StorageListOptions {accessLevel=");
        sb.append(getAccessLevel());
        sb.append(", targetIdentityId=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, getTargetIdentityId(), '}');
    }
}
