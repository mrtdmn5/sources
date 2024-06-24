package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AssumeRoleWithSAMLRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private String principalArn;
    private String roleArn;
    private String sAMLAssertion;

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
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLRequest)) {
            return false;
        }
        AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest = (AssumeRoleWithSAMLRequest) obj;
        if (assumeRoleWithSAMLRequest.getRoleArn() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getRoleArn() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getRoleArn() != null && !assumeRoleWithSAMLRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPrincipalArn() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() != null && !assumeRoleWithSAMLRequest.getPrincipalArn().equals(getPrincipalArn())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getSAMLAssertion() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() != null && !assumeRoleWithSAMLRequest.getSAMLAssertion().equals(getSAMLAssertion())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getPolicyArns() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() != null && !assumeRoleWithSAMLRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicy() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getPolicy() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicy() != null && !assumeRoleWithSAMLRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getDurationSeconds() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getDurationSeconds() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getDurationSeconds() == null || assumeRoleWithSAMLRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return true;
        }
        return false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public String getPrincipalArn() {
        return this.principalArn;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getSAMLAssertion() {
        return this.sAMLAssertion;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int r1 = 0;
        if (getRoleArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getRoleArn().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPrincipalArn() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPrincipalArn().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getSAMLAssertion() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSAMLAssertion().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getPolicyArns() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPolicyArns().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getPolicy() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPolicy().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getDurationSeconds() != null) {
            r1 = getDurationSeconds().hashCode();
        }
        return r05 + r1;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setPolicyArns(Collection<PolicyDescriptorType> collection) {
        if (collection == null) {
            this.policyArns = null;
        } else {
            this.policyArns = new ArrayList(collection);
        }
    }

    public void setPrincipalArn(String str) {
        this.principalArn = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setSAMLAssertion(String str) {
        this.sAMLAssertion = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getPrincipalArn() != null) {
            sb.append("PrincipalArn: " + getPrincipalArn() + ",");
        }
        if (getSAMLAssertion() != null) {
            sb.append("SAMLAssertion: " + getSAMLAssertion() + ",");
        }
        if (getPolicyArns() != null) {
            sb.append("PolicyArns: " + getPolicyArns() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleWithSAMLRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public AssumeRoleWithSAMLRequest withPrincipalArn(String str) {
        this.principalArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withSAMLAssertion(String str) {
        this.sAMLAssertion = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }
}
