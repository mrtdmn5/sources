package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ReplicateKeyResult implements Serializable {
    private KeyMetadata replicaKeyMetadata;
    private String replicaPolicy;
    private List<Tag> replicaTags = new ArrayList();

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
        if (obj == null || !(obj instanceof ReplicateKeyResult)) {
            return false;
        }
        ReplicateKeyResult replicateKeyResult = (ReplicateKeyResult) obj;
        if (replicateKeyResult.getReplicaKeyMetadata() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getReplicaKeyMetadata() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (replicateKeyResult.getReplicaKeyMetadata() != null && !replicateKeyResult.getReplicaKeyMetadata().equals(getReplicaKeyMetadata())) {
            return false;
        }
        if (replicateKeyResult.getReplicaPolicy() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getReplicaPolicy() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (replicateKeyResult.getReplicaPolicy() != null && !replicateKeyResult.getReplicaPolicy().equals(getReplicaPolicy())) {
            return false;
        }
        if (replicateKeyResult.getReplicaTags() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getReplicaTags() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (replicateKeyResult.getReplicaTags() == null || replicateKeyResult.getReplicaTags().equals(getReplicaTags())) {
            return true;
        }
        return false;
    }

    public KeyMetadata getReplicaKeyMetadata() {
        return this.replicaKeyMetadata;
    }

    public String getReplicaPolicy() {
        return this.replicaPolicy;
    }

    public List<Tag> getReplicaTags() {
        return this.replicaTags;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getReplicaKeyMetadata() == null) {
            hashCode = 0;
        } else {
            hashCode = getReplicaKeyMetadata().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getReplicaPolicy() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getReplicaPolicy().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getReplicaTags() != null) {
            r1 = getReplicaTags().hashCode();
        }
        return r02 + r1;
    }

    public void setReplicaKeyMetadata(KeyMetadata keyMetadata) {
        this.replicaKeyMetadata = keyMetadata;
    }

    public void setReplicaPolicy(String str) {
        this.replicaPolicy = str;
    }

    public void setReplicaTags(Collection<Tag> collection) {
        if (collection == null) {
            this.replicaTags = null;
        } else {
            this.replicaTags = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getReplicaKeyMetadata() != null) {
            sb.append("ReplicaKeyMetadata: " + getReplicaKeyMetadata() + ",");
        }
        if (getReplicaPolicy() != null) {
            sb.append("ReplicaPolicy: " + getReplicaPolicy() + ",");
        }
        if (getReplicaTags() != null) {
            sb.append("ReplicaTags: " + getReplicaTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public ReplicateKeyResult withReplicaKeyMetadata(KeyMetadata keyMetadata) {
        this.replicaKeyMetadata = keyMetadata;
        return this;
    }

    public ReplicateKeyResult withReplicaPolicy(String str) {
        this.replicaPolicy = str;
        return this;
    }

    public ReplicateKeyResult withReplicaTags(Tag... tagArr) {
        if (getReplicaTags() == null) {
            this.replicaTags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.replicaTags.add(tag);
        }
        return this;
    }

    public ReplicateKeyResult withReplicaTags(Collection<Tag> collection) {
        setReplicaTags(collection);
        return this;
    }
}
