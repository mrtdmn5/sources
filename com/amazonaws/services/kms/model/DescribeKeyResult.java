package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class DescribeKeyResult implements Serializable {
    private KeyMetadata keyMetadata;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeKeyResult)) {
            return false;
        }
        DescribeKeyResult describeKeyResult = (DescribeKeyResult) obj;
        if (describeKeyResult.getKeyMetadata() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyMetadata() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (describeKeyResult.getKeyMetadata() == null || describeKeyResult.getKeyMetadata().equals(getKeyMetadata())) {
            return true;
        }
        return false;
    }

    public KeyMetadata getKeyMetadata() {
        return this.keyMetadata;
    }

    public int hashCode() {
        int hashCode;
        if (getKeyMetadata() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyMetadata().hashCode();
        }
        return 31 + hashCode;
    }

    public void setKeyMetadata(KeyMetadata keyMetadata) {
        this.keyMetadata = keyMetadata;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyMetadata() != null) {
            sb.append("KeyMetadata: " + getKeyMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeKeyResult withKeyMetadata(KeyMetadata keyMetadata) {
        this.keyMetadata = keyMetadata;
        return this;
    }
}
