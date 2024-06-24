package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeCustomKeyStoresResult implements Serializable {
    private List<CustomKeyStoresListEntry> customKeyStores = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

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
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresResult)) {
            return false;
        }
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = (DescribeCustomKeyStoresResult) obj;
        if (describeCustomKeyStoresResult.getCustomKeyStores() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCustomKeyStores() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (describeCustomKeyStoresResult.getCustomKeyStores() != null && !describeCustomKeyStoresResult.getCustomKeyStores().equals(getCustomKeyStores())) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getNextMarker() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() != null && !describeCustomKeyStoresResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (describeCustomKeyStoresResult.getTruncated() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTruncated() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (describeCustomKeyStoresResult.getTruncated() == null || describeCustomKeyStoresResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public List<CustomKeyStoresListEntry> getCustomKeyStores() {
        return this.customKeyStores;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getCustomKeyStores() == null) {
            hashCode = 0;
        } else {
            hashCode = getCustomKeyStores().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getNextMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNextMarker().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTruncated() != null) {
            r1 = getTruncated().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        if (collection == null) {
            this.customKeyStores = null;
        } else {
            this.customKeyStores = new ArrayList(collection);
        }
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStores() != null) {
            sb.append("CustomKeyStores: " + getCustomKeyStores() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(CustomKeyStoresListEntry... customKeyStoresListEntryArr) {
        if (getCustomKeyStores() == null) {
            this.customKeyStores = new ArrayList(customKeyStoresListEntryArr.length);
        }
        for (CustomKeyStoresListEntry customKeyStoresListEntry : customKeyStoresListEntryArr) {
            this.customKeyStores.add(customKeyStoresListEntry);
        }
        return this;
    }

    public DescribeCustomKeyStoresResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public DescribeCustomKeyStoresResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        setCustomKeyStores(collection);
        return this;
    }
}
