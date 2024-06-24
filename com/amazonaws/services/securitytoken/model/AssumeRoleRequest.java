package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AssumeRoleRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String externalId;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private String roleArn;
    private String roleSessionName;
    private String serialNumber;
    private String sourceIdentity;
    private List<Tag> tags;
    private String tokenCode;
    private List<String> transitiveTagKeys;

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
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleRequest)) {
            return false;
        }
        AssumeRoleRequest assumeRoleRequest = (AssumeRoleRequest) obj;
        if (assumeRoleRequest.getRoleArn() == null) {
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
        if (assumeRoleRequest.getRoleArn() != null && !assumeRoleRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (assumeRoleRequest.getRoleSessionName() == null) {
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
        if (assumeRoleRequest.getRoleSessionName() != null && !assumeRoleRequest.getRoleSessionName().equals(getRoleSessionName())) {
            return false;
        }
        if (assumeRoleRequest.getPolicyArns() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPolicyArns() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (assumeRoleRequest.getPolicyArns() != null && !assumeRoleRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if (assumeRoleRequest.getPolicy() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getPolicy() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (assumeRoleRequest.getPolicy() != null && !assumeRoleRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (assumeRoleRequest.getDurationSeconds() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getDurationSeconds() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (assumeRoleRequest.getDurationSeconds() != null && !assumeRoleRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if (assumeRoleRequest.getTags() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getTags() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (assumeRoleRequest.getTags() != null && !assumeRoleRequest.getTags().equals(getTags())) {
            return false;
        }
        if (assumeRoleRequest.getTransitiveTagKeys() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getTransitiveTagKeys() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (assumeRoleRequest.getTransitiveTagKeys() != null && !assumeRoleRequest.getTransitiveTagKeys().equals(getTransitiveTagKeys())) {
            return false;
        }
        if (assumeRoleRequest.getExternalId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getExternalId() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (assumeRoleRequest.getExternalId() != null && !assumeRoleRequest.getExternalId().equals(getExternalId())) {
            return false;
        }
        if (assumeRoleRequest.getSerialNumber() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getSerialNumber() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (assumeRoleRequest.getSerialNumber() != null && !assumeRoleRequest.getSerialNumber().equals(getSerialNumber())) {
            return false;
        }
        if (assumeRoleRequest.getTokenCode() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (getTokenCode() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z19 ^ z20) {
            return false;
        }
        if (assumeRoleRequest.getTokenCode() != null && !assumeRoleRequest.getTokenCode().equals(getTokenCode())) {
            return false;
        }
        if (assumeRoleRequest.getSourceIdentity() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (getSourceIdentity() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z21 ^ z22) {
            return false;
        }
        if (assumeRoleRequest.getSourceIdentity() == null || assumeRoleRequest.getSourceIdentity().equals(getSourceIdentity())) {
            return true;
        }
        return false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleSessionName() {
        return this.roleSessionName;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getTokenCode() {
        return this.tokenCode;
    }

    public List<String> getTransitiveTagKeys() {
        return this.transitiveTagKeys;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
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
        if (getPolicyArns() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicyArns().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getPolicy() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPolicy().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getDurationSeconds() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getDurationSeconds().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getTags() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getTags().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getTransitiveTagKeys() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getTransitiveTagKeys().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getExternalId() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getExternalId().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getSerialNumber() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getSerialNumber().hashCode();
        }
        int r09 = (r08 + hashCode9) * 31;
        if (getTokenCode() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getTokenCode().hashCode();
        }
        int r010 = (r09 + hashCode10) * 31;
        if (getSourceIdentity() != null) {
            r1 = getSourceIdentity().hashCode();
        }
        return r010 + r1;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setExternalId(String str) {
        this.externalId = str;
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

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setRoleSessionName(String str) {
        this.roleSessionName = str;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setTokenCode(String str) {
        this.tokenCode = str;
    }

    public void setTransitiveTagKeys(Collection<String> collection) {
        if (collection == null) {
            this.transitiveTagKeys = null;
        } else {
            this.transitiveTagKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getRoleSessionName() != null) {
            sb.append("RoleSessionName: " + getRoleSessionName() + ",");
        }
        if (getPolicyArns() != null) {
            sb.append("PolicyArns: " + getPolicyArns() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds() + ",");
        }
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
        }
        if (getTransitiveTagKeys() != null) {
            sb.append("TransitiveTagKeys: " + getTransitiveTagKeys() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId() + ",");
        }
        if (getSerialNumber() != null) {
            sb.append("SerialNumber: " + getSerialNumber() + ",");
        }
        if (getTokenCode() != null) {
            sb.append("TokenCode: " + getTokenCode() + ",");
        }
        if (getSourceIdentity() != null) {
            sb.append("SourceIdentity: " + getSourceIdentity());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleRequest withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public AssumeRoleRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public AssumeRoleRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleRequest withRoleSessionName(String str) {
        this.roleSessionName = str;
        return this;
    }

    public AssumeRoleRequest withSerialNumber(String str) {
        this.serialNumber = str;
        return this;
    }

    public AssumeRoleRequest withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public AssumeRoleRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public AssumeRoleRequest withTokenCode(String str) {
        this.tokenCode = str;
        return this;
    }

    public AssumeRoleRequest withTransitiveTagKeys(String... strArr) {
        if (getTransitiveTagKeys() == null) {
            this.transitiveTagKeys = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.transitiveTagKeys.add(str);
        }
        return this;
    }

    public AssumeRoleRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }

    public AssumeRoleRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }

    public AssumeRoleRequest withTransitiveTagKeys(Collection<String> collection) {
        setTransitiveTagKeys(collection);
        return this;
    }
}
