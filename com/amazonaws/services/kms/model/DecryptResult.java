package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class DecryptResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String encryptionAlgorithm;
    private String keyId;
    private ByteBuffer plaintext;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecryptResult)) {
            return false;
        }
        DecryptResult decryptResult = (DecryptResult) obj;
        if (decryptResult.getKeyId() == null) {
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
        if (decryptResult.getKeyId() != null && !decryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (decryptResult.getPlaintext() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPlaintext() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (decryptResult.getPlaintext() != null && !decryptResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if (decryptResult.getEncryptionAlgorithm() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getEncryptionAlgorithm() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (decryptResult.getEncryptionAlgorithm() != null && !decryptResult.getEncryptionAlgorithm().equals(getEncryptionAlgorithm())) {
            return false;
        }
        if (decryptResult.getCiphertextForRecipient() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getCiphertextForRecipient() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (decryptResult.getCiphertextForRecipient() == null || decryptResult.getCiphertextForRecipient().equals(getCiphertextForRecipient())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPlaintext() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPlaintext().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getEncryptionAlgorithm() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEncryptionAlgorithm().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCiphertextForRecipient() != null) {
            r1 = getCiphertextForRecipient().hashCode();
        }
        return r03 + r1;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getEncryptionAlgorithm() != null) {
            sb.append("EncryptionAlgorithm: " + getEncryptionAlgorithm() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public DecryptResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public DecryptResult withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public DecryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public DecryptResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public DecryptResult withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }
}
