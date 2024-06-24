package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CopyPartResult extends SSEResultBase implements Serializable {
    private String etag;
    private Date lastModifiedDate;
    private int partNumber;
    private String versionId;

    public String getETag() {
        return this.etag;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public PartETag getPartETag() {
        return new PartETag(this.partNumber, this.etag);
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setETag(String str) {
        this.etag = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setPartNumber(int r1) {
        this.partNumber = r1;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
