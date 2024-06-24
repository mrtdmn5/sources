package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: classes.dex */
public class StorageRemoveOptions extends StorageOptions {

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageOptions.Builder<B, StorageRemoveOptions> {
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageRemoveOptions build() {
            return new StorageRemoveOptions(this);
        }
    }

    public StorageRemoveOptions(Builder<?> builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageRemoveOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageRemoveOptions storageRemoveOptions) {
        return (Builder) ((Builder) builder().accessLevel(storageRemoveOptions.getAccessLevel())).targetIdentityId(storageRemoveOptions.getTargetIdentityId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageRemoveOptions)) {
            return false;
        }
        StorageRemoveOptions storageRemoveOptions = (StorageRemoveOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageRemoveOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageRemoveOptions.getTargetIdentityId())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getAccessLevel(), getTargetIdentityId());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StorageRemoveOptions {accessLevel=");
        sb.append(getAccessLevel());
        sb.append(", targetIdentityId=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, getTargetIdentityId(), '}');
    }
}
