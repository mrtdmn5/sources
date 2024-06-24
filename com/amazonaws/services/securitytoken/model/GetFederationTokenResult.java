package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetFederationTokenResult implements Serializable {
    private Credentials credentials;
    private FederatedUser federatedUser;
    private Integer packedPolicySize;

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
        if (obj == null || !(obj instanceof GetFederationTokenResult)) {
            return false;
        }
        GetFederationTokenResult getFederationTokenResult = (GetFederationTokenResult) obj;
        if (getFederationTokenResult.getCredentials() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCredentials() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getFederationTokenResult.getCredentials() != null && !getFederationTokenResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if (getFederationTokenResult.getFederatedUser() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getFederatedUser() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getFederationTokenResult.getFederatedUser() != null && !getFederationTokenResult.getFederatedUser().equals(getFederatedUser())) {
            return false;
        }
        if (getFederationTokenResult.getPackedPolicySize() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPackedPolicySize() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getFederationTokenResult.getPackedPolicySize() == null || getFederationTokenResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return true;
        }
        return false;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public FederatedUser getFederatedUser() {
        return this.federatedUser;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getCredentials() == null) {
            hashCode = 0;
        } else {
            hashCode = getCredentials().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getFederatedUser() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getFederatedUser().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPackedPolicySize() != null) {
            r1 = getPackedPolicySize().hashCode();
        }
        return r02 + r1;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setFederatedUser(FederatedUser federatedUser) {
        this.federatedUser = federatedUser;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getFederatedUser() != null) {
            sb.append("FederatedUser: " + getFederatedUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetFederationTokenResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public GetFederationTokenResult withFederatedUser(FederatedUser federatedUser) {
        this.federatedUser = federatedUser;
        return this;
    }

    public GetFederationTokenResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }
}
