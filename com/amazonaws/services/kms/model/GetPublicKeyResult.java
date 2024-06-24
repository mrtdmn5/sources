package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class GetPublicKeyResult implements Serializable {
    private String customerMasterKeySpec;
    private String keyId;
    private String keySpec;
    private String keyUsage;
    private ByteBuffer publicKey;
    private List<String> encryptionAlgorithms = new ArrayList();
    private List<String> signingAlgorithms = new ArrayList();

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPublicKeyResult)) {
            return false;
        }
        GetPublicKeyResult getPublicKeyResult = (GetPublicKeyResult) obj;
        if (getPublicKeyResult.getKeyId() == null) {
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
        if (getPublicKeyResult.getKeyId() != null && !getPublicKeyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getPublicKeyResult.getPublicKey() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPublicKey() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getPublicKeyResult.getPublicKey() != null && !getPublicKeyResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (getPublicKeyResult.getCustomerMasterKeySpec() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getCustomerMasterKeySpec() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getPublicKeyResult.getCustomerMasterKeySpec() != null && !getPublicKeyResult.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if (getPublicKeyResult.getKeySpec() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getKeySpec() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (getPublicKeyResult.getKeySpec() != null && !getPublicKeyResult.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if (getPublicKeyResult.getKeyUsage() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getKeyUsage() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (getPublicKeyResult.getKeyUsage() != null && !getPublicKeyResult.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if (getPublicKeyResult.getEncryptionAlgorithms() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getEncryptionAlgorithms() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (getPublicKeyResult.getEncryptionAlgorithms() != null && !getPublicKeyResult.getEncryptionAlgorithms().equals(getEncryptionAlgorithms())) {
            return false;
        }
        if (getPublicKeyResult.getSigningAlgorithms() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getSigningAlgorithms() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (getPublicKeyResult.getSigningAlgorithms() == null || getPublicKeyResult.getSigningAlgorithms().equals(getSigningAlgorithms())) {
            return true;
        }
        return false;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public List<String> getEncryptionAlgorithms() {
        return this.encryptionAlgorithms;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public List<String> getSigningAlgorithms() {
        return this.signingAlgorithms;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPublicKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPublicKey().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getCustomerMasterKeySpec() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCustomerMasterKeySpec().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getKeySpec() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getKeySpec().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getKeyUsage() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getKeyUsage().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getEncryptionAlgorithms() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getEncryptionAlgorithms().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getSigningAlgorithms() != null) {
            r1 = getSigningAlgorithms().hashCode();
        }
        return r06 + r1;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setEncryptionAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.encryptionAlgorithms = null;
        } else {
            this.encryptionAlgorithms = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public void setSigningAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.signingAlgorithms = null;
        } else {
            this.signingAlgorithms = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getCustomerMasterKeySpec() != null) {
            sb.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + ",");
        }
        if (getKeySpec() != null) {
            sb.append("KeySpec: " + getKeySpec() + ",");
        }
        if (getKeyUsage() != null) {
            sb.append("KeyUsage: " + getKeyUsage() + ",");
        }
        if (getEncryptionAlgorithms() != null) {
            sb.append("EncryptionAlgorithms: " + getEncryptionAlgorithms() + ",");
        }
        if (getSigningAlgorithms() != null) {
            sb.append("SigningAlgorithms: " + getSigningAlgorithms());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(String... strArr) {
        if (getEncryptionAlgorithms() == null) {
            this.encryptionAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.encryptionAlgorithms.add(str);
        }
        return this;
    }

    public GetPublicKeyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetPublicKeyResult withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public GetPublicKeyResult withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public GetPublicKeyResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(String... strArr) {
        if (getSigningAlgorithms() == null) {
            this.signingAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.signingAlgorithms.add(str);
        }
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
    }

    public void setKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
        return this;
    }

    public GetPublicKeyResult withKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
        return this;
    }

    public GetPublicKeyResult withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(Collection<String> collection) {
        setEncryptionAlgorithms(collection);
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(Collection<String> collection) {
        setSigningAlgorithms(collection);
        return this;
    }
}
