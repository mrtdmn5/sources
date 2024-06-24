package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Tag implements Serializable {
    private String tagKey;
    private String tagValue;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (tag.getTagKey() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getTagKey() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (tag.getTagKey() != null && !tag.getTagKey().equals(getTagKey())) {
            return false;
        }
        if (tag.getTagValue() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getTagValue() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (tag.getTagValue() == null || tag.getTagValue().equals(getTagValue())) {
            return true;
        }
        return false;
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public String getTagValue() {
        return this.tagValue;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getTagKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getTagKey().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getTagValue() != null) {
            r1 = getTagValue().hashCode();
        }
        return r0 + r1;
    }

    public void setTagKey(String str) {
        this.tagKey = str;
    }

    public void setTagValue(String str) {
        this.tagValue = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTagKey() != null) {
            sb.append("TagKey: " + getTagKey() + ",");
        }
        if (getTagValue() != null) {
            sb.append("TagValue: " + getTagValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public Tag withTagKey(String str) {
        this.tagKey = str;
        return this;
    }

    public Tag withTagValue(String str) {
        this.tagValue = str;
        return this;
    }
}
