package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class MultiRegionConfiguration implements Serializable {
    private String multiRegionKeyType;
    private MultiRegionKey primaryKey;
    private List<MultiRegionKey> replicaKeys = new ArrayList();

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
        if (obj == null || !(obj instanceof MultiRegionConfiguration)) {
            return false;
        }
        MultiRegionConfiguration multiRegionConfiguration = (MultiRegionConfiguration) obj;
        if (multiRegionConfiguration.getMultiRegionKeyType() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getMultiRegionKeyType() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (multiRegionConfiguration.getMultiRegionKeyType() != null && !multiRegionConfiguration.getMultiRegionKeyType().equals(getMultiRegionKeyType())) {
            return false;
        }
        if (multiRegionConfiguration.getPrimaryKey() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPrimaryKey() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (multiRegionConfiguration.getPrimaryKey() != null && !multiRegionConfiguration.getPrimaryKey().equals(getPrimaryKey())) {
            return false;
        }
        if (multiRegionConfiguration.getReplicaKeys() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getReplicaKeys() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (multiRegionConfiguration.getReplicaKeys() == null || multiRegionConfiguration.getReplicaKeys().equals(getReplicaKeys())) {
            return true;
        }
        return false;
    }

    public String getMultiRegionKeyType() {
        return this.multiRegionKeyType;
    }

    public MultiRegionKey getPrimaryKey() {
        return this.primaryKey;
    }

    public List<MultiRegionKey> getReplicaKeys() {
        return this.replicaKeys;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getMultiRegionKeyType() == null) {
            hashCode = 0;
        } else {
            hashCode = getMultiRegionKeyType().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPrimaryKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPrimaryKey().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getReplicaKeys() != null) {
            r1 = getReplicaKeys().hashCode();
        }
        return r02 + r1;
    }

    public void setMultiRegionKeyType(String str) {
        this.multiRegionKeyType = str;
    }

    public void setPrimaryKey(MultiRegionKey multiRegionKey) {
        this.primaryKey = multiRegionKey;
    }

    public void setReplicaKeys(Collection<MultiRegionKey> collection) {
        if (collection == null) {
            this.replicaKeys = null;
        } else {
            this.replicaKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMultiRegionKeyType() != null) {
            sb.append("MultiRegionKeyType: " + getMultiRegionKeyType() + ",");
        }
        if (getPrimaryKey() != null) {
            sb.append("PrimaryKey: " + getPrimaryKey() + ",");
        }
        if (getReplicaKeys() != null) {
            sb.append("ReplicaKeys: " + getReplicaKeys());
        }
        sb.append("}");
        return sb.toString();
    }

    public MultiRegionConfiguration withMultiRegionKeyType(String str) {
        this.multiRegionKeyType = str;
        return this;
    }

    public MultiRegionConfiguration withPrimaryKey(MultiRegionKey multiRegionKey) {
        this.primaryKey = multiRegionKey;
        return this;
    }

    public MultiRegionConfiguration withReplicaKeys(MultiRegionKey... multiRegionKeyArr) {
        if (getReplicaKeys() == null) {
            this.replicaKeys = new ArrayList(multiRegionKeyArr.length);
        }
        for (MultiRegionKey multiRegionKey : multiRegionKeyArr) {
            this.replicaKeys.add(multiRegionKey);
        }
        return this;
    }

    public void setMultiRegionKeyType(MultiRegionKeyType multiRegionKeyType) {
        this.multiRegionKeyType = multiRegionKeyType.toString();
    }

    public MultiRegionConfiguration withMultiRegionKeyType(MultiRegionKeyType multiRegionKeyType) {
        this.multiRegionKeyType = multiRegionKeyType.toString();
        return this;
    }

    public MultiRegionConfiguration withReplicaKeys(Collection<MultiRegionKey> collection) {
        setReplicaKeys(collection);
        return this;
    }
}
