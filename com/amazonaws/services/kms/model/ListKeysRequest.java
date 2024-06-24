package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListKeysRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeysRequest)) {
            return false;
        }
        ListKeysRequest listKeysRequest = (ListKeysRequest) obj;
        if (listKeysRequest.getLimit() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getLimit() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listKeysRequest.getLimit() != null && !listKeysRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listKeysRequest.getMarker() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMarker() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listKeysRequest.getMarker() == null || listKeysRequest.getMarker().equals(getMarker())) {
            return true;
        }
        return false;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getLimit() == null) {
            hashCode = 0;
        } else {
            hashCode = getLimit().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMarker() != null) {
            r1 = getMarker().hashCode();
        }
        return r0 + r1;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListKeysRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListKeysRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
