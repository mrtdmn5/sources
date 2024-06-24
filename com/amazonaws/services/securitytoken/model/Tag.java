package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Tag implements Serializable {
    private String key;
    private String value;

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
        if (tag.getKey() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKey() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (tag.getKey() != null && !tag.getKey().equals(getKey())) {
            return false;
        }
        if (tag.getValue() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getValue() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (tag.getValue() == null || tag.getValue().equals(getValue())) {
            return true;
        }
        return false;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getKey().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getValue() != null) {
            r1 = getValue().hashCode();
        }
        return r0 + r1;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKey() != null) {
            sb.append("Key: " + getKey() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public Tag withKey(String str) {
        this.key = str;
        return this;
    }

    public Tag withValue(String str) {
        this.value = str;
        return this;
    }
}
