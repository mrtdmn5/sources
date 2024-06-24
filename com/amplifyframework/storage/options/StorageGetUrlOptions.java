package com.amplifyframework.storage.options;

import android.annotation.SuppressLint;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.storage.options.StorageOptions;

/* loaded from: classes.dex */
public class StorageGetUrlOptions extends StorageOptions {
    private final int expires;

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<B>> extends StorageOptions.Builder<B, StorageGetUrlOptions> {
        private int expires;

        public final B expires(int r1) {
            this.expires = r1;
            return this;
        }

        public final int getExpires() {
            return this.expires;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.storage.options.StorageOptions.Builder
        @SuppressLint({"SyntheticAccessor"})
        public StorageGetUrlOptions build() {
            return new StorageGetUrlOptions(this);
        }
    }

    public StorageGetUrlOptions(Builder<?> builder) {
        super(builder.getAccessLevel(), builder.getTargetIdentityId());
        this.expires = builder.getExpires();
    }

    @SuppressLint({"SyntheticAccessor"})
    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static StorageGetUrlOptions defaultInstance() {
        return builder().build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder<?> from(StorageGetUrlOptions storageGetUrlOptions) {
        return ((Builder) ((Builder) builder().accessLevel(storageGetUrlOptions.getAccessLevel())).targetIdentityId(storageGetUrlOptions.getTargetIdentityId())).expires(storageGetUrlOptions.getExpires());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageGetUrlOptions)) {
            return false;
        }
        StorageGetUrlOptions storageGetUrlOptions = (StorageGetUrlOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getAccessLevel(), storageGetUrlOptions.getAccessLevel()) && ObjectsCompat$Api19Impl.equals(getTargetIdentityId(), storageGetUrlOptions.getTargetIdentityId()) && ObjectsCompat$Api19Impl.equals(Integer.valueOf(getExpires()), Integer.valueOf(storageGetUrlOptions.getExpires()))) {
            return true;
        }
        return false;
    }

    public int getExpires() {
        return this.expires;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getAccessLevel(), getTargetIdentityId(), Integer.valueOf(getExpires()));
    }

    public String toString() {
        return "StorageGetUrlOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", expires=" + getExpires() + '}';
    }
}
