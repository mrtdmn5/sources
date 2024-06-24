package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class RevokeGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private String grantId;
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RevokeGrantRequest)) {
            return false;
        }
        RevokeGrantRequest revokeGrantRequest = (RevokeGrantRequest) obj;
        if (revokeGrantRequest.getKeyId() == null) {
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
        if (revokeGrantRequest.getKeyId() != null && !revokeGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (revokeGrantRequest.getGrantId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getGrantId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (revokeGrantRequest.getGrantId() == null || revokeGrantRequest.getGrantId().equals(getGrantId())) {
            return true;
        }
        return false;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getGrantId() != null) {
            r1 = getGrantId().hashCode();
        }
        return r0 + r1;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId());
        }
        sb.append("}");
        return sb.toString();
    }

    public RevokeGrantRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public RevokeGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
