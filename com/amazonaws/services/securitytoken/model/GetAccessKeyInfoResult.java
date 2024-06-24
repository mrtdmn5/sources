package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetAccessKeyInfoResult implements Serializable {
    private String account;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccessKeyInfoResult)) {
            return false;
        }
        GetAccessKeyInfoResult getAccessKeyInfoResult = (GetAccessKeyInfoResult) obj;
        if (getAccessKeyInfoResult.getAccount() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAccount() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getAccessKeyInfoResult.getAccount() == null || getAccessKeyInfoResult.getAccount().equals(getAccount())) {
            return true;
        }
        return false;
    }

    public String getAccount() {
        return this.account;
    }

    public int hashCode() {
        int hashCode;
        if (getAccount() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccount().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccount() != null) {
            sb.append("Account: " + getAccount());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetAccessKeyInfoResult withAccount(String str) {
        this.account = str;
        return this;
    }
}
