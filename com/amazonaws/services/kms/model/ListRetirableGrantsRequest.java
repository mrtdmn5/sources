package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListRetirableGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;
    private String retiringPrincipal;

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
        if (obj == null || !(obj instanceof ListRetirableGrantsRequest)) {
            return false;
        }
        ListRetirableGrantsRequest listRetirableGrantsRequest = (ListRetirableGrantsRequest) obj;
        if (listRetirableGrantsRequest.getLimit() == null) {
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
        if (listRetirableGrantsRequest.getLimit() != null && !listRetirableGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listRetirableGrantsRequest.getMarker() == null) {
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
        if (listRetirableGrantsRequest.getMarker() != null && !listRetirableGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if (listRetirableGrantsRequest.getRetiringPrincipal() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getRetiringPrincipal() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listRetirableGrantsRequest.getRetiringPrincipal() == null || listRetirableGrantsRequest.getRetiringPrincipal().equals(getRetiringPrincipal())) {
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

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getLimit() == null) {
            hashCode = 0;
        } else {
            hashCode = getLimit().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMarker().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getRetiringPrincipal() != null) {
            r1 = getRetiringPrincipal().hashCode();
        }
        return r02 + r1;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListRetirableGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListRetirableGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListRetirableGrantsRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }
}
