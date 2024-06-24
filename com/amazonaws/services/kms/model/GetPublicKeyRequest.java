package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class GetPublicKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPublicKeyRequest)) {
            return false;
        }
        GetPublicKeyRequest getPublicKeyRequest = (GetPublicKeyRequest) obj;
        if (getPublicKeyRequest.getKeyId() == null) {
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
        if (getPublicKeyRequest.getKeyId() != null && !getPublicKeyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getPublicKeyRequest.getGrantTokens() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getGrantTokens() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getPublicKeyRequest.getGrantTokens() == null || getPublicKeyRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
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
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r0 + r1;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetPublicKeyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public GetPublicKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetPublicKeyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
