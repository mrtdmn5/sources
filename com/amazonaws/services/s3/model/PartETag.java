package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class PartETag {
    private String eTag;
    private int partNumber;

    public PartETag(int r1, String str) {
        this.partNumber = r1;
        this.eTag = str;
    }

    public String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int r1) {
        this.partNumber = r1;
    }

    public PartETag withETag(String str) {
        this.eTag = str;
        return this;
    }

    public PartETag withPartNumber(int r1) {
        this.partNumber = r1;
        return this;
    }
}
