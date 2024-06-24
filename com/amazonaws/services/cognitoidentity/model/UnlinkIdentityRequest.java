package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class UnlinkIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityId;
    private Map<String, String> logins;
    private List<String> loginsToRemove;

    public UnlinkIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public UnlinkIdentityRequest clearLoginsEntries() {
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
        if (obj == null || !(obj instanceof UnlinkIdentityRequest)) {
            return false;
        }
        UnlinkIdentityRequest unlinkIdentityRequest = (UnlinkIdentityRequest) obj;
        if (unlinkIdentityRequest.getIdentityId() == null) {
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
        if (unlinkIdentityRequest.getIdentityId() != null && !unlinkIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (unlinkIdentityRequest.getLogins() == null) {
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
        if (unlinkIdentityRequest.getLogins() != null && !unlinkIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if (unlinkIdentityRequest.getLoginsToRemove() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getLoginsToRemove() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (unlinkIdentityRequest.getLoginsToRemove() == null || unlinkIdentityRequest.getLoginsToRemove().equals(getLoginsToRemove())) {
            return true;
        }
        return false;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public List<String> getLoginsToRemove() {
        return this.loginsToRemove;
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
        if (getLoginsToRemove() != null) {
            r1 = getLoginsToRemove().hashCode();
        }
        return r02 + r1;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public void setLoginsToRemove(Collection<String> collection) {
        if (collection == null) {
            this.loginsToRemove = null;
        } else {
            this.loginsToRemove = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getLoginsToRemove() != null) {
            sb.append("LoginsToRemove: " + getLoginsToRemove());
        }
        sb.append("}");
        return sb.toString();
    }

    public UnlinkIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public UnlinkIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public UnlinkIdentityRequest withLoginsToRemove(String... strArr) {
        if (getLoginsToRemove() == null) {
            this.loginsToRemove = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.loginsToRemove.add(str);
        }
        return this;
    }

    public UnlinkIdentityRequest withLoginsToRemove(Collection<String> collection) {
        setLoginsToRemove(collection);
        return this;
    }
}
