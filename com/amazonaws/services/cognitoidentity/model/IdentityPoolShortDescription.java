package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class IdentityPoolShortDescription implements Serializable {
    private String identityPoolId;
    private String identityPoolName;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityPoolShortDescription)) {
            return false;
        }
        IdentityPoolShortDescription identityPoolShortDescription = (IdentityPoolShortDescription) obj;
        if (identityPoolShortDescription.getIdentityPoolId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityPoolId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (identityPoolShortDescription.getIdentityPoolId() != null && !identityPoolShortDescription.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (identityPoolShortDescription.getIdentityPoolName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityPoolName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (identityPoolShortDescription.getIdentityPoolName() == null || identityPoolShortDescription.getIdentityPoolName().equals(getIdentityPoolName())) {
            return true;
        }
        return false;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getIdentityPoolName() {
        return this.identityPoolName;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentityPoolName() != null) {
            r1 = getIdentityPoolName().hashCode();
        }
        return r0 + r1;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setIdentityPoolName(String str) {
        this.identityPoolName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentityPoolName() != null) {
            sb.append("IdentityPoolName: " + getIdentityPoolName());
        }
        sb.append("}");
        return sb.toString();
    }

    public IdentityPoolShortDescription withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public IdentityPoolShortDescription withIdentityPoolName(String str) {
        this.identityPoolName = str;
        return this;
    }
}
