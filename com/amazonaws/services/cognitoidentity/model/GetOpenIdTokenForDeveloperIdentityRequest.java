package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GetOpenIdTokenForDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityId;
    private String identityPoolId;
    private Map<String, String> logins;
    private Map<String, String> principalTags;
    private Long tokenDuration;

    public GetOpenIdTokenForDeveloperIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GetOpenIdTokenForDeveloperIdentityRequest addPrincipalTagsEntry(String str, String str2) {
        if (this.principalTags == null) {
            this.principalTags = new HashMap();
        }
        if (!this.principalTags.containsKey(str)) {
            this.principalTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GetOpenIdTokenForDeveloperIdentityRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest clearPrincipalTagsEntries() {
        this.principalTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetOpenIdTokenForDeveloperIdentityRequest)) {
            return false;
        }
        GetOpenIdTokenForDeveloperIdentityRequest getOpenIdTokenForDeveloperIdentityRequest = (GetOpenIdTokenForDeveloperIdentityRequest) obj;
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId() == null) {
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
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId() != null && !getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityId() != null && !getOpenIdTokenForDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getLogins() == null) {
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
        if (getOpenIdTokenForDeveloperIdentityRequest.getLogins() != null && !getOpenIdTokenForDeveloperIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getPrincipalTags() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags() != null && !getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags().equals(getPrincipalTags())) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getTokenDuration() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration() == null || getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration().equals(getTokenDuration())) {
            return true;
        }
        return false;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public Map<String, String> getPrincipalTags() {
        return this.principalTags;
    }

    public Long getTokenDuration() {
        return this.tokenDuration;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentityId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getLogins() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLogins().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getPrincipalTags() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPrincipalTags().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getTokenDuration() != null) {
            r1 = getTokenDuration().hashCode();
        }
        return r04 + r1;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public void setPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
    }

    public void setTokenDuration(Long l) {
        this.tokenDuration = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getPrincipalTags() != null) {
            sb.append("PrincipalTags: " + getPrincipalTags() + ",");
        }
        if (getTokenDuration() != null) {
            sb.append("TokenDuration: " + getTokenDuration());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withTokenDuration(Long l) {
        this.tokenDuration = l;
        return this;
    }
}
