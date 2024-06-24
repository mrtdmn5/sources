package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class GetFederationTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String name;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private List<Tag> tags;

    public GetFederationTokenRequest() {
    }

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenRequest)) {
            return false;
        }
        GetFederationTokenRequest getFederationTokenRequest = (GetFederationTokenRequest) obj;
        if (getFederationTokenRequest.getName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getFederationTokenRequest.getName() != null && !getFederationTokenRequest.getName().equals(getName())) {
            return false;
        }
        if (getFederationTokenRequest.getPolicy() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPolicy() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getFederationTokenRequest.getPolicy() != null && !getFederationTokenRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (getFederationTokenRequest.getPolicyArns() == null) {
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
        if (getFederationTokenRequest.getPolicyArns() != null && !getFederationTokenRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if (getFederationTokenRequest.getDurationSeconds() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getDurationSeconds() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (getFederationTokenRequest.getDurationSeconds() != null && !getFederationTokenRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if (getFederationTokenRequest.getTags() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getTags() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (getFederationTokenRequest.getTags() == null || getFederationTokenRequest.getTags().equals(getTags())) {
            return true;
        }
        return false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getName() {
        return this.name;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getName() == null) {
            hashCode = 0;
        } else {
            hashCode = getName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPolicy() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPolicy().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPolicyArns() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicyArns().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getDurationSeconds() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getDurationSeconds().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getTags() != null) {
            r1 = getTags().hashCode();
        }
        return r04 + r1;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setName(String str) {
        this.name = str;
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

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getPolicyArns() != null) {
            sb.append("PolicyArns: " + getPolicyArns() + ",");
        }
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds() + ",");
        }
        if (getTags() != null) {
            sb.append("Tags: " + getTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetFederationTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetFederationTokenRequest withName(String str) {
        this.name = str;
        return this;
    }

    public GetFederationTokenRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public GetFederationTokenRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public GetFederationTokenRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public GetFederationTokenRequest(String str) {
        setName(str);
    }

    public GetFederationTokenRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }

    public GetFederationTokenRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
