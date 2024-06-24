package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class KeyListEntry implements Serializable {
    private String keyArn;
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyListEntry)) {
            return false;
        }
        KeyListEntry keyListEntry = (KeyListEntry) obj;
        if (keyListEntry.getKeyId() == null) {
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
        if (keyListEntry.getKeyId() != null && !keyListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (keyListEntry.getKeyArn() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getKeyArn() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (keyListEntry.getKeyArn() == null || keyListEntry.getKeyArn().equals(getKeyArn())) {
            return true;
        }
        return false;
    }

    public String getKeyArn() {
        return this.keyArn;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getKeyArn() != null) {
            r1 = getKeyArn().hashCode();
        }
        return r0 + r1;
    }

    public void setKeyArn(String str) {
        this.keyArn = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyArn() != null) {
            sb.append("KeyArn: " + getKeyArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public KeyListEntry withKeyArn(String str) {
        this.keyArn = str;
        return this;
    }

    public KeyListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
