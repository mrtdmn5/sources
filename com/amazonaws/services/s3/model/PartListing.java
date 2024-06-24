package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class PartListing implements S3RequesterChargedResult {
    private Date abortDate;
    private String abortRuleId;
    private String bucketName;
    private String encodingType;
    private Owner initiator;
    private boolean isRequesterCharged;
    private boolean isTruncated;
    private String key;
    private Integer maxParts;
    private Integer nextPartNumberMarker;
    private Owner owner;
    private Integer partNumberMarker;
    private List<PartSummary> parts;
    private String storageClass;
    private String uploadId;

    public Date getAbortDate() {
        return this.abortDate;
    }

    public String getAbortRuleId() {
        return this.abortRuleId;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public Owner getInitiator() {
        return this.initiator;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public Integer getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public List<PartSummary> getParts() {
        if (this.parts == null) {
            this.parts = new ArrayList();
        }
        return this.parts;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setAbortDate(Date date) {
        this.abortDate = date;
    }

    public void setAbortRuleId(String str) {
        this.abortRuleId = str;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setInitiator(Owner owner) {
        this.initiator = owner;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxParts(int r1) {
        this.maxParts = Integer.valueOf(r1);
    }

    public void setNextPartNumberMarker(int r1) {
        this.nextPartNumberMarker = Integer.valueOf(r1);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPartNumberMarker(int r1) {
        this.partNumberMarker = Integer.valueOf(r1);
    }

    public void setParts(List<PartSummary> list) {
        this.parts = list;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
