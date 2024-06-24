package com.amazonaws.mobileconnectors.s3.transferutility;

/* loaded from: classes.dex */
public interface TransferListener {
    void onError(int r1, Exception exc);

    void onProgressChanged(int r1, long j, long j2);

    void onStateChanged(int r1, TransferState transferState);
}
