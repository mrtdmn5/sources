package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CognitoIdentityProvider implements Serializable {
    private String clientId;
    private String providerName;
    private Boolean serverSideTokenCheck;

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
        if (obj == null || !(obj instanceof CognitoIdentityProvider)) {
            return false;
        }
        CognitoIdentityProvider cognitoIdentityProvider = (CognitoIdentityProvider) obj;
        if (cognitoIdentityProvider.getProviderName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getProviderName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (cognitoIdentityProvider.getProviderName() != null && !cognitoIdentityProvider.getProviderName().equals(getProviderName())) {
            return false;
        }
        if (cognitoIdentityProvider.getClientId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getClientId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (cognitoIdentityProvider.getClientId() != null && !cognitoIdentityProvider.getClientId().equals(getClientId())) {
            return false;
        }
        if (cognitoIdentityProvider.getServerSideTokenCheck() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getServerSideTokenCheck() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (cognitoIdentityProvider.getServerSideTokenCheck() == null || cognitoIdentityProvider.getServerSideTokenCheck().equals(getServerSideTokenCheck())) {
            return true;
        }
        return false;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public Boolean getServerSideTokenCheck() {
        return this.serverSideTokenCheck;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getProviderName() == null) {
            hashCode = 0;
        } else {
            hashCode = getProviderName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getClientId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getServerSideTokenCheck() != null) {
            r1 = getServerSideTokenCheck().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isServerSideTokenCheck() {
        return this.serverSideTokenCheck;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setServerSideTokenCheck(Boolean bool) {
        this.serverSideTokenCheck = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getServerSideTokenCheck() != null) {
            sb.append("ServerSideTokenCheck: " + getServerSideTokenCheck());
        }
        sb.append("}");
        return sb.toString();
    }

    public CognitoIdentityProvider withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public CognitoIdentityProvider withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public CognitoIdentityProvider withServerSideTokenCheck(Boolean bool) {
        this.serverSideTokenCheck = bool;
        return this;
    }
}
