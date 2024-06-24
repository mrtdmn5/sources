package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetCallerIdentityResult implements Serializable {
    private String account;
    private String arn;
    private String userId;

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
        if (obj == null || !(obj instanceof GetCallerIdentityResult)) {
            return false;
        }
        GetCallerIdentityResult getCallerIdentityResult = (GetCallerIdentityResult) obj;
        if (getCallerIdentityResult.getUserId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getUserId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getCallerIdentityResult.getUserId() != null && !getCallerIdentityResult.getUserId().equals(getUserId())) {
            return false;
        }
        if (getCallerIdentityResult.getAccount() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAccount() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getCallerIdentityResult.getAccount() != null && !getCallerIdentityResult.getAccount().equals(getAccount())) {
            return false;
        }
        if (getCallerIdentityResult.getArn() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getArn() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getCallerIdentityResult.getArn() == null || getCallerIdentityResult.getArn().equals(getArn())) {
            return true;
        }
        return false;
    }

    public String getAccount() {
        return this.account;
    }

    public String getArn() {
        return this.arn;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getUserId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAccount() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAccount().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getArn() != null) {
            r1 = getArn().hashCode();
        }
        return r02 + r1;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUserId() != null) {
            sb.append("UserId: " + getUserId() + ",");
        }
        if (getAccount() != null) {
            sb.append("Account: " + getAccount() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetCallerIdentityResult withAccount(String str) {
        this.account = str;
        return this;
    }

    public GetCallerIdentityResult withArn(String str) {
        this.arn = str;
        return this;
    }

    public GetCallerIdentityResult withUserId(String str) {
        this.userId = str;
        return this;
    }
}
