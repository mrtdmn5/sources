package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ReplicateKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String description;
    private String keyId;
    private String policy;
    private String replicaRegion;
    private List<Tag> tags = new ArrayList();

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
        if (obj == null || !(obj instanceof ReplicateKeyRequest)) {
            return false;
        }
        ReplicateKeyRequest replicateKeyRequest = (ReplicateKeyRequest) obj;
        if (replicateKeyRequest.getKeyId() == null) {
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
        if (replicateKeyRequest.getKeyId() != null && !replicateKeyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (replicateKeyRequest.getReplicaRegion() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getReplicaRegion() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (replicateKeyRequest.getReplicaRegion() != null && !replicateKeyRequest.getReplicaRegion().equals(getReplicaRegion())) {
            return false;
        }
        if (replicateKeyRequest.getPolicy() == null) {
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
        if (replicateKeyRequest.getPolicy() != null && !replicateKeyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (replicateKeyRequest.getBypassPolicyLockoutSafetyCheck() == null) {
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
        if (replicateKeyRequest.getBypassPolicyLockoutSafetyCheck() != null && !replicateKeyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return false;
        }
        if (replicateKeyRequest.getDescription() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getDescription() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (replicateKeyRequest.getDescription() != null && !replicateKeyRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (replicateKeyRequest.getTags() == null) {
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
        if (replicateKeyRequest.getTags() == null || replicateKeyRequest.getTags().equals(getTags())) {
            return true;
        }
        return false;
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getReplicaRegion() {
        return this.replicaRegion;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getReplicaRegion() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getReplicaRegion().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPolicy() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicy().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getDescription() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getDescription().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getTags() != null) {
            r1 = getTags().hashCode();
        }
        return r05 + r1;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setReplicaRegion(String str) {
        this.replicaRegion = str;
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
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getReplicaRegion() != null) {
            sb.append("ReplicaRegion: " + getReplicaRegion() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + ",");
        }
        if (getTags() != null) {
            sb.append("Tags: " + getTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public ReplicateKeyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public ReplicateKeyRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ReplicateKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ReplicateKeyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public ReplicateKeyRequest withReplicaRegion(String str) {
        this.replicaRegion = str;
        return this;
    }

    public ReplicateKeyRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public ReplicateKeyRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
