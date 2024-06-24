package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DescribeCustomKeyStoresRequest extends AmazonWebServiceRequest implements Serializable {
    private String customKeyStoreId;
    private String customKeyStoreName;
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresRequest)) {
            return false;
        }
        DescribeCustomKeyStoresRequest describeCustomKeyStoresRequest = (DescribeCustomKeyStoresRequest) obj;
        if (describeCustomKeyStoresRequest.getCustomKeyStoreId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCustomKeyStoreId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getCustomKeyStoreId() != null && !describeCustomKeyStoresRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getCustomKeyStoreName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCustomKeyStoreName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getCustomKeyStoreName() != null && !describeCustomKeyStoresRequest.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getLimit() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getLimit() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getLimit() != null && !describeCustomKeyStoresRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getMarker() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getMarker() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getMarker() == null || describeCustomKeyStoresRequest.getMarker().equals(getMarker())) {
            return true;
        }
        return false;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
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
        int hashCode3;
        int r1 = 0;
        if (getCustomKeyStoreId() == null) {
            hashCode = 0;
        } else {
            hashCode = getCustomKeyStoreId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getCustomKeyStoreName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCustomKeyStoreName().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getLimit() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLimit().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getMarker() != null) {
            r1 = getMarker().hashCode();
        }
        return r03 + r1;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getCustomKeyStoreName() != null) {
            sb.append("CustomKeyStoreName: " + getCustomKeyStoreName() + ",");
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

    public DescribeCustomKeyStoresRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public DescribeCustomKeyStoresRequest withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public DescribeCustomKeyStoresRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public DescribeCustomKeyStoresRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
