package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class PutKeyPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String keyId;
    private String policy;
    private String policyName;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutKeyPolicyRequest)) {
            return false;
        }
        PutKeyPolicyRequest putKeyPolicyRequest = (PutKeyPolicyRequest) obj;
        if (putKeyPolicyRequest.getKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (putKeyPolicyRequest.getKeyId() != null && !putKeyPolicyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicyName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPolicyName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicyName() != null && !putKeyPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicy() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPolicy() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicy() != null && !putKeyPolicyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck() == null || putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return true;
        }
        return false;
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPolicyName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPolicyName().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPolicy() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicy().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            r1 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        return r03 + r1;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPolicyName() != null) {
            sb.append("PolicyName: " + getPolicyName() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck());
        }
        sb.append("}");
        return sb.toString();
    }

    public PutKeyPolicyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public PutKeyPolicyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public PutKeyPolicyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public PutKeyPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
