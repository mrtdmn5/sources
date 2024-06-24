package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class UnprocessedIdentityId implements Serializable {
    private String errorCode;
    private String identityId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnprocessedIdentityId)) {
            return false;
        }
        UnprocessedIdentityId unprocessedIdentityId = (UnprocessedIdentityId) obj;
        if (unprocessedIdentityId.getIdentityId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (unprocessedIdentityId.getIdentityId() != null && !unprocessedIdentityId.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (unprocessedIdentityId.getErrorCode() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getErrorCode() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (unprocessedIdentityId.getErrorCode() == null || unprocessedIdentityId.getErrorCode().equals(getErrorCode())) {
            return true;
        }
        return false;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getErrorCode() != null) {
            r1 = getErrorCode().hashCode();
        }
        return r0 + r1;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getErrorCode() != null) {
            sb.append("ErrorCode: " + getErrorCode());
        }
        sb.append("}");
        return sb.toString();
    }

    public UnprocessedIdentityId withErrorCode(String str) {
        this.errorCode = str;
        return this;
    }

    public UnprocessedIdentityId withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode.toString();
    }

    public UnprocessedIdentityId withErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode.toString();
        return this;
    }
}
