package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class RecipientInfo implements Serializable {
    private ByteBuffer attestationDocument;
    private String keyEncryptionAlgorithm;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecipientInfo)) {
            return false;
        }
        RecipientInfo recipientInfo = (RecipientInfo) obj;
        if (recipientInfo.getKeyEncryptionAlgorithm() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyEncryptionAlgorithm() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (recipientInfo.getKeyEncryptionAlgorithm() != null && !recipientInfo.getKeyEncryptionAlgorithm().equals(getKeyEncryptionAlgorithm())) {
            return false;
        }
        if (recipientInfo.getAttestationDocument() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAttestationDocument() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (recipientInfo.getAttestationDocument() == null || recipientInfo.getAttestationDocument().equals(getAttestationDocument())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getAttestationDocument() {
        return this.attestationDocument;
    }

    public String getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKeyEncryptionAlgorithm() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyEncryptionAlgorithm().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAttestationDocument() != null) {
            r1 = getAttestationDocument().hashCode();
        }
        return r0 + r1;
    }

    public void setAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
    }

    public void setKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyEncryptionAlgorithm() != null) {
            sb.append("KeyEncryptionAlgorithm: " + getKeyEncryptionAlgorithm() + ",");
        }
        if (getAttestationDocument() != null) {
            sb.append("AttestationDocument: " + getAttestationDocument());
        }
        sb.append("}");
        return sb.toString();
    }

    public RecipientInfo withAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
        return this;
    }

    public RecipientInfo withKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
        return this;
    }

    public void setKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
    }

    public RecipientInfo withKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
        return this;
    }
}
