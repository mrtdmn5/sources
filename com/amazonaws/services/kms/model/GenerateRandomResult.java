package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class GenerateRandomResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private ByteBuffer plaintext;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateRandomResult)) {
            return false;
        }
        GenerateRandomResult generateRandomResult = (GenerateRandomResult) obj;
        if (generateRandomResult.getPlaintext() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPlaintext() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateRandomResult.getPlaintext() != null && !generateRandomResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if (generateRandomResult.getCiphertextForRecipient() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCiphertextForRecipient() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateRandomResult.getCiphertextForRecipient() == null || generateRandomResult.getCiphertextForRecipient().equals(getCiphertextForRecipient())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getPlaintext() == null) {
            hashCode = 0;
        } else {
            hashCode = getPlaintext().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getCiphertextForRecipient() != null) {
            r1 = getCiphertextForRecipient().hashCode();
        }
        return r0 + r1;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateRandomResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public GenerateRandomResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }
}
