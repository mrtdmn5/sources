package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListResourceTagsRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceTagsRequest)) {
            return false;
        }
        ListResourceTagsRequest listResourceTagsRequest = (ListResourceTagsRequest) obj;
        if (listResourceTagsRequest.getKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listResourceTagsRequest.getKeyId() != null && !listResourceTagsRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (listResourceTagsRequest.getLimit() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getLimit() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listResourceTagsRequest.getLimit() != null && !listResourceTagsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listResourceTagsRequest.getMarker() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getMarker() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listResourceTagsRequest.getMarker() == null || listResourceTagsRequest.getMarker().equals(getMarker())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getLimit() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLimit().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getMarker() != null) {
            r1 = getMarker().hashCode();
        }
        return r02 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListResourceTagsRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ListResourceTagsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListResourceTagsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
