package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DisableKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DisableKeyRequest)) {
            return false;
        }
        DisableKeyRequest disableKeyRequest = (DisableKeyRequest) obj;
        if (disableKeyRequest.getKeyId() == null) {
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
        if (disableKeyRequest.getKeyId() == null || disableKeyRequest.getKeyId().equals(getKeyId())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int hashCode;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DisableKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
