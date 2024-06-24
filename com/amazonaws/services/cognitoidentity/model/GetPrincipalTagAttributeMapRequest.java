package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class GetPrincipalTagAttributeMapRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;
    private String identityProviderName;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPrincipalTagAttributeMapRequest)) {
            return false;
        }
        GetPrincipalTagAttributeMapRequest getPrincipalTagAttributeMapRequest = (GetPrincipalTagAttributeMapRequest) obj;
        if (getPrincipalTagAttributeMapRequest.getIdentityPoolId() == null) {
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
        if (getPrincipalTagAttributeMapRequest.getIdentityPoolId() != null && !getPrincipalTagAttributeMapRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (getPrincipalTagAttributeMapRequest.getIdentityProviderName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityProviderName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getPrincipalTagAttributeMapRequest.getIdentityProviderName() == null || getPrincipalTagAttributeMapRequest.getIdentityProviderName().equals(getIdentityProviderName())) {
            return true;
        }
        return false;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
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
        if (getIdentityProviderName() != null) {
            r1 = getIdentityProviderName().hashCode();
        }
        return r0 + r1;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentityProviderName() != null) {
            sb.append("IdentityProviderName: " + getIdentityProviderName());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetPrincipalTagAttributeMapRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetPrincipalTagAttributeMapRequest withIdentityProviderName(String str) {
        this.identityProviderName = str;
        return this;
    }
}
