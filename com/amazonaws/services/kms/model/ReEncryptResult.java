package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ReEncryptResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private String keyId;
    private String sourceEncryptionAlgorithm;
    private String sourceKeyId;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptResult)) {
            return false;
        }
        ReEncryptResult reEncryptResult = (ReEncryptResult) obj;
        if (reEncryptResult.getCiphertextBlob() == null) {
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
        if (reEncryptResult.getCiphertextBlob() != null && !reEncryptResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if (reEncryptResult.getSourceKeyId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSourceKeyId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (reEncryptResult.getSourceKeyId() != null && !reEncryptResult.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if (reEncryptResult.getKeyId() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyId() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (reEncryptResult.getKeyId() != null && !reEncryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (reEncryptResult.getSourceEncryptionAlgorithm() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getSourceEncryptionAlgorithm() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (reEncryptResult.getSourceEncryptionAlgorithm() != null && !reEncryptResult.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if (reEncryptResult.getDestinationEncryptionAlgorithm() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getDestinationEncryptionAlgorithm() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (reEncryptResult.getDestinationEncryptionAlgorithm() == null || reEncryptResult.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getCiphertextBlob().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getSourceKeyId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSourceKeyId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSourceEncryptionAlgorithm().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getDestinationEncryptionAlgorithm() != null) {
            r1 = getDestinationEncryptionAlgorithm().hashCode();
        }
        return r04 + r1;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getSourceKeyId() != null) {
            sb.append("SourceKeyId: " + getSourceKeyId() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + ",");
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public ReEncryptResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ReEncryptResult withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ReEncryptResult withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptResult withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptResult withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptResult withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }
}
