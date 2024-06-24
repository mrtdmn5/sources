package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class GenerateDataKeyWithoutPlaintextResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String keyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = (GenerateDataKeyWithoutPlaintextResult) obj;
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCiphertextBlob() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() != null && !generateDataKeyWithoutPlaintextResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getKeyId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getKeyId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getKeyId() == null || generateDataKeyWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getCiphertextBlob().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getKeyId() != null) {
            r1 = getKeyId().hashCode();
        }
        return r0 + r1;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyWithoutPlaintextResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
