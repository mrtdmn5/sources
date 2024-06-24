package com.amazonaws.services.kms.model;

import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GrantConstraints implements Serializable {
    private Map<String, String> encryptionContextSubset = new HashMap();
    private Map<String, String> encryptionContextEquals = new HashMap();

    public GrantConstraints addEncryptionContextEqualsEntry(String str, String str2) {
        if (this.encryptionContextEquals == null) {
            this.encryptionContextEquals = new HashMap();
        }
        if (!this.encryptionContextEquals.containsKey(str)) {
            this.encryptionContextEquals.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GrantConstraints addEncryptionContextSubsetEntry(String str, String str2) {
        if (this.encryptionContextSubset == null) {
            this.encryptionContextSubset = new HashMap();
        }
        if (!this.encryptionContextSubset.containsKey(str)) {
            this.encryptionContextSubset.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GrantConstraints clearEncryptionContextEqualsEntries() {
        this.encryptionContextEquals = null;
        return this;
    }

    public GrantConstraints clearEncryptionContextSubsetEntries() {
        this.encryptionContextSubset = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantConstraints)) {
            return false;
        }
        GrantConstraints grantConstraints = (GrantConstraints) obj;
        if (grantConstraints.getEncryptionContextSubset() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getEncryptionContextSubset() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (grantConstraints.getEncryptionContextSubset() != null && !grantConstraints.getEncryptionContextSubset().equals(getEncryptionContextSubset())) {
            return false;
        }
        if (grantConstraints.getEncryptionContextEquals() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getEncryptionContextEquals() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (grantConstraints.getEncryptionContextEquals() == null || grantConstraints.getEncryptionContextEquals().equals(getEncryptionContextEquals())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getEncryptionContextEquals() {
        return this.encryptionContextEquals;
    }

    public Map<String, String> getEncryptionContextSubset() {
        return this.encryptionContextSubset;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getEncryptionContextSubset() == null) {
            hashCode = 0;
        } else {
            hashCode = getEncryptionContextSubset().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getEncryptionContextEquals() != null) {
            r1 = getEncryptionContextEquals().hashCode();
        }
        return r0 + r1;
    }

    public void setEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
    }

    public void setEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEncryptionContextSubset() != null) {
            sb.append("EncryptionContextSubset: " + getEncryptionContextSubset() + ",");
        }
        if (getEncryptionContextEquals() != null) {
            sb.append("EncryptionContextEquals: " + getEncryptionContextEquals());
        }
        sb.append("}");
        return sb.toString();
    }

    public GrantConstraints withEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
        return this;
    }

    public GrantConstraints withEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
        return this;
    }
}
