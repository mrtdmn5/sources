package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AssumedRoleUser implements Serializable {
    private String arn;
    private String assumedRoleId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumedRoleUser)) {
            return false;
        }
        AssumedRoleUser assumedRoleUser = (AssumedRoleUser) obj;
        if (assumedRoleUser.getAssumedRoleId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAssumedRoleId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (assumedRoleUser.getAssumedRoleId() != null && !assumedRoleUser.getAssumedRoleId().equals(getAssumedRoleId())) {
            return false;
        }
        if (assumedRoleUser.getArn() == null) {
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
        if (assumedRoleUser.getArn() == null || assumedRoleUser.getArn().equals(getArn())) {
            return true;
        }
        return false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getAssumedRoleId() {
        return this.assumedRoleId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getAssumedRoleId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAssumedRoleId().hashCode();
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

    public void setAssumedRoleId(String str) {
        this.assumedRoleId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAssumedRoleId() != null) {
            sb.append("AssumedRoleId: " + getAssumedRoleId() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumedRoleUser withArn(String str) {
        this.arn = str;
        return this;
    }

    public AssumedRoleUser withAssumedRoleId(String str) {
        this.assumedRoleId = str;
        return this;
    }
}
