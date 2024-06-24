package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private String grantId;
    private String granteePrincipal;
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
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGrantsRequest)) {
            return false;
        }
        ListGrantsRequest listGrantsRequest = (ListGrantsRequest) obj;
        if (listGrantsRequest.getLimit() == null) {
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
        if (listGrantsRequest.getLimit() != null && !listGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listGrantsRequest.getMarker() == null) {
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
        if (listGrantsRequest.getMarker() != null && !listGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if (listGrantsRequest.getKeyId() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyId() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listGrantsRequest.getKeyId() != null && !listGrantsRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (listGrantsRequest.getGrantId() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getGrantId() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (listGrantsRequest.getGrantId() != null && !listGrantsRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if (listGrantsRequest.getGranteePrincipal() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getGranteePrincipal() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (listGrantsRequest.getGranteePrincipal() == null || listGrantsRequest.getGranteePrincipal().equals(getGranteePrincipal())) {
            return true;
        }
        return false;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
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
        int hashCode3;
        int hashCode4;
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
        if (getKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getGrantId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getGrantId().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getGranteePrincipal() != null) {
            r1 = getGranteePrincipal().hashCode();
        }
        return r04 + r1;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
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
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId() + ",");
        }
        if (getGranteePrincipal() != null) {
            sb.append("GranteePrincipal: " + getGranteePrincipal());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListGrantsRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public ListGrantsRequest withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public ListGrantsRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ListGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
