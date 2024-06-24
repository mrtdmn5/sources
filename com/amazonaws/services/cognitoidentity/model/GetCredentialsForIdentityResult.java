package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetCredentialsForIdentityResult implements Serializable {
    private Credentials credentials;
    private String identityId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCredentialsForIdentityResult)) {
            return false;
        }
        GetCredentialsForIdentityResult getCredentialsForIdentityResult = (GetCredentialsForIdentityResult) obj;
        if (getCredentialsForIdentityResult.getIdentityId() == null) {
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
        if (getCredentialsForIdentityResult.getIdentityId() != null && !getCredentialsForIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (getCredentialsForIdentityResult.getCredentials() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCredentials() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getCredentialsForIdentityResult.getCredentials() == null || getCredentialsForIdentityResult.getCredentials().equals(getCredentials())) {
            return true;
        }
        return false;
    }

    public Credentials getCredentials() {
        return this.credentials;
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
        if (getCredentials() != null) {
            r1 = getCredentials().hashCode();
        }
        return r0 + r1;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetCredentialsForIdentityResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public GetCredentialsForIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }
}
