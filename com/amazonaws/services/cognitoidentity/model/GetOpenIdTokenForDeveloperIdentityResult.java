package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetOpenIdTokenForDeveloperIdentityResult implements Serializable {
    private String identityId;
    private String token;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetOpenIdTokenForDeveloperIdentityResult)) {
            return false;
        }
        GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentityResult = (GetOpenIdTokenForDeveloperIdentityResult) obj;
        if (getOpenIdTokenForDeveloperIdentityResult.getIdentityId() == null) {
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
        if (getOpenIdTokenForDeveloperIdentityResult.getIdentityId() != null && !getOpenIdTokenForDeveloperIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityResult.getToken() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getToken() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityResult.getToken() == null || getOpenIdTokenForDeveloperIdentityResult.getToken().equals(getToken())) {
            return true;
        }
        return false;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getToken() {
        return this.token;
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
        if (getToken() != null) {
            r1 = getToken().hashCode();
        }
        return r0 + r1;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getToken() != null) {
            sb.append("Token: " + getToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetOpenIdTokenForDeveloperIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityResult withToken(String str) {
        this.token = str;
        return this;
    }
}
