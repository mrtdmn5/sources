package com.polidea.rxandroidble2;

/* loaded from: classes3.dex */
public final class ConnectionSetup {
    public final boolean autoConnect;
    public final Timeout operationTimeout;
    public final boolean suppressOperationCheck;

    public ConnectionSetup(boolean z, boolean z2, Timeout timeout) {
        this.autoConnect = z;
        this.suppressOperationCheck = z2;
        this.operationTimeout = timeout;
    }
}
