package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListKeysResult implements Serializable {
    private List<KeyListEntry> keys = new ArrayList();
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
        if (obj == null || !(obj instanceof ListKeysResult)) {
            return false;
        }
        ListKeysResult listKeysResult = (ListKeysResult) obj;
        if (listKeysResult.getKeys() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeys() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listKeysResult.getKeys() != null && !listKeysResult.getKeys().equals(getKeys())) {
            return false;
        }
        if (listKeysResult.getNextMarker() == null) {
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
        if (listKeysResult.getNextMarker() != null && !listKeysResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listKeysResult.getTruncated() == null) {
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
        if (listKeysResult.getTruncated() == null || listKeysResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public List<KeyListEntry> getKeys() {
        return this.keys;
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
        if (getKeys() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeys().hashCode();
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

    public void setKeys(Collection<KeyListEntry> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            this.keys = new ArrayList(collection);
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
        if (getKeys() != null) {
            sb.append("Keys: " + getKeys() + ",");
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

    public ListKeysResult withKeys(KeyListEntry... keyListEntryArr) {
        if (getKeys() == null) {
            this.keys = new ArrayList(keyListEntryArr.length);
        }
        for (KeyListEntry keyListEntry : keyListEntryArr) {
            this.keys.add(keyListEntry);
        }
        return this;
    }

    public ListKeysResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeysResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeysResult withKeys(Collection<KeyListEntry> collection) {
        setKeys(collection);
        return this;
    }
}
