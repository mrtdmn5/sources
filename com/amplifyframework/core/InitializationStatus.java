package com.amplifyframework.core;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public enum InitializationStatus {
    SUCCEEDED,
    FAILED;

    public static InitializationStatus fromString(String str) {
        for (InitializationStatus initializationStatus : values()) {
            if (initializationStatus.toString().equals(str)) {
                return initializationStatus;
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("Unknown status = ", str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }
}
