package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetKeyPolicyResult implements Serializable {
    private String policy;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyPolicyResult)) {
            return false;
        }
        GetKeyPolicyResult getKeyPolicyResult = (GetKeyPolicyResult) obj;
        if (getKeyPolicyResult.getPolicy() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPolicy() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getKeyPolicyResult.getPolicy() == null || getKeyPolicyResult.getPolicy().equals(getPolicy())) {
            return true;
        }
        return false;
    }

    public String getPolicy() {
        return this.policy;
    }

    public int hashCode() {
        int hashCode;
        if (getPolicy() == null) {
            hashCode = 0;
        } else {
            hashCode = getPolicy().hashCode();
        }
        return 31 + hashCode;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetKeyPolicyResult withPolicy(String str) {
        this.policy = str;
        return this;
    }
}
