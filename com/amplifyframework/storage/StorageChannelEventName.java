package com.amplifyframework.storage;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.util.Objects;

/* loaded from: classes.dex */
public enum StorageChannelEventName {
    UPLOAD_ERROR("upload_error"),
    UPLOAD_STATE("upload_state"),
    DOWNLOAD_ERROR("download_error"),
    DOWNLOAD_STATE("download_state");

    private final String hubEventName;

    StorageChannelEventName(String str) {
        Objects.requireNonNull(str);
        this.hubEventName = str;
    }

    public static StorageChannelEventName fromString(String str) {
        for (StorageChannelEventName storageChannelEventName : values()) {
            if (storageChannelEventName.toString().equals(str)) {
                return storageChannelEventName;
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("Storage category does not publish any Hub event with name = ", str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.hubEventName;
    }
}
