package com.amplifyframework.storage.options;

import com.amplifyframework.storage.StorageAccessLevel;

/* loaded from: classes.dex */
abstract class StorageOptions {
    private final StorageAccessLevel accessLevel;
    private final String targetIdentityId;

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder, O extends StorageOptions> {
        private StorageAccessLevel accessLevel;
        private String targetIdentityId;

        public final B accessLevel(StorageAccessLevel storageAccessLevel) {
            this.accessLevel = storageAccessLevel;
            return this;
        }

        public abstract O build();

        public final StorageAccessLevel getAccessLevel() {
            return this.accessLevel;
        }

        public final String getTargetIdentityId() {
            return this.targetIdentityId;
        }

        public final B targetIdentityId(String str) {
            this.targetIdentityId = str;
            return this;
        }
    }

    public StorageOptions(StorageAccessLevel storageAccessLevel, String str) {
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str;
    }

    public final StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
