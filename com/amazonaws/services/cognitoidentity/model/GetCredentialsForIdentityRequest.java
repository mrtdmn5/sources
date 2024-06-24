package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GetCredentialsForIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String customRoleArn;
    private String identityId;
    private Map<String, String> logins;

    public GetCredentialsForIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GetCredentialsForIdentityRequest clearLoginsEntries() {
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
        if (obj == null || !(obj instanceof GetCredentialsForIdentityRequest)) {
            return false;
        }
        GetCredentialsForIdentityRequest getCredentialsForIdentityRequest = (GetCredentialsForIdentityRequest) obj;
        if (getCredentialsForIdentityRequest.getIdentityId() == null) {
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
        if (getCredentialsForIdentityRequest.getIdentityId() != null && !getCredentialsForIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getLogins() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getLogins() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getLogins() != null && !getCredentialsForIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getCustomRoleArn() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getCustomRoleArn() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getCustomRoleArn() == null || getCredentialsForIdentityRequest.getCustomRoleArn().equals(getCustomRoleArn())) {
            return true;
        }
        return false;
    }

    public String getCustomRoleArn() {
        return this.customRoleArn;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getLogins() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLogins().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getCustomRoleArn() != null) {
            r1 = getCustomRoleArn().hashCode();
        }
        return r02 + r1;
    }

    public void setCustomRoleArn(String str) {
        this.customRoleArn = str;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getCustomRoleArn() != null) {
            sb.append("CustomRoleArn: " + getCustomRoleArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetCredentialsForIdentityRequest withCustomRoleArn(String str) {
        this.customRoleArn = str;
        return this;
    }

    public GetCredentialsForIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public GetCredentialsForIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }
}
