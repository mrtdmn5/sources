package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AssumeRoleWithWebIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private String providerId;
    private String roleArn;
    private String roleSessionName;
    private String webIdentityToken;

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
        boolean z13;
        boolean z14;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithWebIdentityRequest)) {
            return false;
        }
        AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest = (AssumeRoleWithWebIdentityRequest) obj;
        if (assumeRoleWithWebIdentityRequest.getRoleArn() == null) {
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
        if (assumeRoleWithWebIdentityRequest.getRoleArn() != null && !assumeRoleWithWebIdentityRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getRoleSessionName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getRoleSessionName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getRoleSessionName() != null && !assumeRoleWithWebIdentityRequest.getRoleSessionName().equals(getRoleSessionName())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getWebIdentityToken() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getWebIdentityToken() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getWebIdentityToken() != null && !assumeRoleWithWebIdentityRequest.getWebIdentityToken().equals(getWebIdentityToken())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getProviderId() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getProviderId() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getProviderId() != null && !assumeRoleWithWebIdentityRequest.getProviderId().equals(getProviderId())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getPolicyArns() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getPolicyArns() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getPolicyArns() != null && !assumeRoleWithWebIdentityRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getPolicy() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getPolicy() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getPolicy() != null && !assumeRoleWithWebIdentityRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getDurationSeconds() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getDurationSeconds() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (assumeRoleWithWebIdentityRequest.getDurationSeconds() == null || assumeRoleWithWebIdentityRequest.getDurationSeconds().equals(getDurationSeconds())) {
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

    public String getProviderId() {
        return this.providerId;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleSessionName() {
        return this.roleSessionName;
    }

    public String getWebIdentityToken() {
        return this.webIdentityToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int r1 = 0;
        if (getRoleArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getRoleArn().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getRoleSessionName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRoleSessionName().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getWebIdentityToken() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getWebIdentityToken().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getProviderId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getProviderId().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getPolicyArns() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPolicyArns().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getPolicy() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getPolicy().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getDurationSeconds() != null) {
            r1 = getDurationSeconds().hashCode();
        }
        return r06 + r1;
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

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setRoleSessionName(String str) {
        this.roleSessionName = str;
    }

    public void setWebIdentityToken(String str) {
        this.webIdentityToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getRoleSessionName() != null) {
            sb.append("RoleSessionName: " + getRoleSessionName() + ",");
        }
        if (getWebIdentityToken() != null) {
            sb.append("WebIdentityToken: " + getWebIdentityToken() + ",");
        }
        if (getProviderId() != null) {
            sb.append("ProviderId: " + getProviderId() + ",");
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

    public AssumeRoleWithWebIdentityRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withProviderId(String str) {
        this.providerId = str;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withRoleSessionName(String str) {
        this.roleSessionName = str;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withWebIdentityToken(String str) {
        this.webIdentityToken = str;
        return this;
    }

    public AssumeRoleWithWebIdentityRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }
}
