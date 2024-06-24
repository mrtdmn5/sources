package com.animaconnected.cloud.util;

/* loaded from: classes.dex */
public class CloudIftttStatus {
    private final boolean mConnection;

    public CloudIftttStatus(boolean z) {
        this.mConnection = z;
    }

    public boolean isConnected() {
        return this.mConnection;
    }
}
