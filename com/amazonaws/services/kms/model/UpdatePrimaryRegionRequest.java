package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class UpdatePrimaryRegionRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private String primaryRegion;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdatePrimaryRegionRequest)) {
            return false;
        }
        UpdatePrimaryRegionRequest updatePrimaryRegionRequest = (UpdatePrimaryRegionRequest) obj;
        if (updatePrimaryRegionRequest.getKeyId() == null) {
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
        if (updatePrimaryRegionRequest.getKeyId() != null && !updatePrimaryRegionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (updatePrimaryRegionRequest.getPrimaryRegion() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPrimaryRegion() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (updatePrimaryRegionRequest.getPrimaryRegion() == null || updatePrimaryRegionRequest.getPrimaryRegion().equals(getPrimaryRegion())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPrimaryRegion() {
        return this.primaryRegion;
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
        if (getPrimaryRegion() != null) {
            r1 = getPrimaryRegion().hashCode();
        }
        return r0 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPrimaryRegion(String str) {
        this.primaryRegion = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPrimaryRegion() != null) {
            sb.append("PrimaryRegion: " + getPrimaryRegion());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdatePrimaryRegionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public UpdatePrimaryRegionRequest withPrimaryRegion(String str) {
        this.primaryRegion = str;
        return this;
    }
}
