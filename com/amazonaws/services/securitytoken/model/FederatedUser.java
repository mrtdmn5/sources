package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class FederatedUser implements Serializable {
    private String arn;
    private String federatedUserId;

    public FederatedUser() {
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FederatedUser)) {
            return false;
        }
        FederatedUser federatedUser = (FederatedUser) obj;
        if (federatedUser.getFederatedUserId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getFederatedUserId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (federatedUser.getFederatedUserId() != null && !federatedUser.getFederatedUserId().equals(getFederatedUserId())) {
            return false;
        }
        if (federatedUser.getArn() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getArn() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (federatedUser.getArn() == null || federatedUser.getArn().equals(getArn())) {
            return true;
        }
        return false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getFederatedUserId() {
        return this.federatedUserId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getFederatedUserId() == null) {
            hashCode = 0;
        } else {
            hashCode = getFederatedUserId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getArn() != null) {
            r1 = getArn().hashCode();
        }
        return r0 + r1;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setFederatedUserId(String str) {
        this.federatedUserId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getFederatedUserId() != null) {
            sb.append("FederatedUserId: " + getFederatedUserId() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public FederatedUser withArn(String str) {
        this.arn = str;
        return this;
    }

    public FederatedUser withFederatedUserId(String str) {
        this.federatedUserId = str;
        return this;
    }

    public FederatedUser(String str, String str2) {
        setFederatedUserId(str);
        setArn(str2);
    }
}
