package com.amazonaws.services.s3.model;

@Deprecated
/* loaded from: classes.dex */
public class ProgressEvent extends com.amazonaws.event.ProgressEvent {
    public ProgressEvent(int r3) {
        super(r3);
    }

    @Deprecated
    public int getBytesTransfered() {
        return (int) getBytesTransferred();
    }

    @Deprecated
    public void setBytesTransfered(int r3) {
        setBytesTransferred(r3);
    }

    public ProgressEvent(int r1, long j) {
        super(r1, j);
    }
}
