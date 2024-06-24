package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: classes.dex */
public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {
    private String eTag;
    private boolean isRequesterCharged;
    private int partNumber;

    public String getETag() {
        return this.eTag;
    }

    public PartETag getPartETag() {
        return new PartETag(this.partNumber, this.eTag);
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int r1) {
        this.partNumber = r1;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
