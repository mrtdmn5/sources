package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CreateGrantResult implements Serializable {
    private String grantId;
    private String grantToken;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantResult)) {
            return false;
        }
        CreateGrantResult createGrantResult = (CreateGrantResult) obj;
        if (createGrantResult.getGrantToken() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getGrantToken() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (createGrantResult.getGrantToken() != null && !createGrantResult.getGrantToken().equals(getGrantToken())) {
            return false;
        }
        if (createGrantResult.getGrantId() == null) {
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
        if (createGrantResult.getGrantId() == null || createGrantResult.getGrantId().equals(getGrantId())) {
            return true;
        }
        return false;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGrantToken() {
        return this.grantToken;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getGrantToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getGrantToken().hashCode();
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

    public void setGrantToken(String str) {
        this.grantToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGrantToken() != null) {
            sb.append("GrantToken: " + getGrantToken() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateGrantResult withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public CreateGrantResult withGrantToken(String str) {
        this.grantToken = str;
        return this;
    }
}
