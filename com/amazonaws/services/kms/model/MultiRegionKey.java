package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MultiRegionKey implements Serializable {
    private String arn;
    private String region;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MultiRegionKey)) {
            return false;
        }
        MultiRegionKey multiRegionKey = (MultiRegionKey) obj;
        if (multiRegionKey.getArn() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getArn() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (multiRegionKey.getArn() != null && !multiRegionKey.getArn().equals(getArn())) {
            return false;
        }
        if (multiRegionKey.getRegion() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getRegion() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (multiRegionKey.getRegion() == null || multiRegionKey.getRegion().equals(getRegion())) {
            return true;
        }
        return false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getRegion() {
        return this.region;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getArn().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getRegion() != null) {
            r1 = getRegion().hashCode();
        }
        return r0 + r1;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getArn() != null) {
            sb.append("Arn: " + getArn() + ",");
        }
        if (getRegion() != null) {
            sb.append("Region: " + getRegion());
        }
        sb.append("}");
        return sb.toString();
    }

    public MultiRegionKey withArn(String str) {
        this.arn = str;
        return this;
    }

    public MultiRegionKey withRegion(String str) {
        this.region = str;
        return this;
    }
}
