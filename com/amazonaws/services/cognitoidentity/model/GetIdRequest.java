package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GetIdRequest extends AmazonWebServiceRequest implements Serializable {
    private String accountId;
    private String identityPoolId;
    private Map<String, String> logins;

    public GetIdRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GetIdRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdRequest)) {
            return false;
        }
        GetIdRequest getIdRequest = (GetIdRequest) obj;
        if (getIdRequest.getAccountId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAccountId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getIdRequest.getAccountId() != null && !getIdRequest.getAccountId().equals(getAccountId())) {
            return false;
        }
        if (getIdRequest.getIdentityPoolId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityPoolId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getIdRequest.getIdentityPoolId() != null && !getIdRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (getIdRequest.getLogins() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getLogins() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getIdRequest.getLogins() == null || getIdRequest.getLogins().equals(getLogins())) {
            return true;
        }
        return false;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getAccountId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccountId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentityPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityPoolId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getLogins() != null) {
            r1 = getLogins().hashCode();
        }
        return r02 + r1;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccountId() != null) {
            sb.append("AccountId: " + getAccountId() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdRequest withAccountId(String str) {
        this.accountId = str;
        return this;
    }

    public GetIdRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetIdRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }
}
