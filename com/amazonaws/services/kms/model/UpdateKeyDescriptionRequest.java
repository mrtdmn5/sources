package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class UpdateKeyDescriptionRequest extends AmazonWebServiceRequest implements Serializable {
    private String description;
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateKeyDescriptionRequest)) {
            return false;
        }
        UpdateKeyDescriptionRequest updateKeyDescriptionRequest = (UpdateKeyDescriptionRequest) obj;
        if (updateKeyDescriptionRequest.getKeyId() == null) {
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
        if (updateKeyDescriptionRequest.getKeyId() != null && !updateKeyDescriptionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (updateKeyDescriptionRequest.getDescription() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getDescription() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (updateKeyDescriptionRequest.getDescription() == null || updateKeyDescriptionRequest.getDescription().equals(getDescription())) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return this.description;
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
        if (getDescription() != null) {
            r1 = getDescription().hashCode();
        }
        return r0 + r1;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateKeyDescriptionRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public UpdateKeyDescriptionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
