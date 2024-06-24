package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetIdResult implements Serializable {
    private String identityId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdResult)) {
            return false;
        }
        GetIdResult getIdResult = (GetIdResult) obj;
        if (getIdResult.getIdentityId() == null) {
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
        if (getIdResult.getIdentityId() == null || getIdResult.getIdentityId().equals(getIdentityId())) {
            return true;
        }
        return false;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public int hashCode() {
        int hashCode;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }
}
