package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SignResult implements Serializable {
    private String keyId;
    private ByteBuffer signature;
    private String signingAlgorithm;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignResult)) {
            return false;
        }
        SignResult signResult = (SignResult) obj;
        if (signResult.getKeyId() == null) {
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
        if (signResult.getKeyId() != null && !signResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (signResult.getSignature() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSignature() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (signResult.getSignature() != null && !signResult.getSignature().equals(getSignature())) {
            return false;
        }
        if (signResult.getSigningAlgorithm() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getSigningAlgorithm() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (signResult.getSigningAlgorithm() == null || signResult.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getSignature() {
        return this.signature;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getSignature() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSignature().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getSigningAlgorithm() != null) {
            r1 = getSigningAlgorithm().hashCode();
        }
        return r02 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSignature() != null) {
            sb.append("Signature: " + getSignature() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public SignResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public SignResult withSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
        return this;
    }

    public SignResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public SignResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }
}
