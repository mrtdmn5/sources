package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class VerifyResult implements Serializable {
    private String keyId;
    private Boolean signatureValid;
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
        if (obj == null || !(obj instanceof VerifyResult)) {
            return false;
        }
        VerifyResult verifyResult = (VerifyResult) obj;
        if (verifyResult.getKeyId() == null) {
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
        if (verifyResult.getKeyId() != null && !verifyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyResult.getSignatureValid() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSignatureValid() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (verifyResult.getSignatureValid() != null && !verifyResult.getSignatureValid().equals(getSignatureValid())) {
            return false;
        }
        if (verifyResult.getSigningAlgorithm() == null) {
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
        if (verifyResult.getSigningAlgorithm() == null || verifyResult.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Boolean getSignatureValid() {
        return this.signatureValid;
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
        if (getSignatureValid() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSignatureValid().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getSigningAlgorithm() != null) {
            r1 = getSigningAlgorithm().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isSignatureValid() {
        return this.signatureValid;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSignatureValid(Boolean bool) {
        this.signatureValid = bool;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSignatureValid() != null) {
            sb.append("SignatureValid: " + getSignatureValid() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyResult withSignatureValid(Boolean bool) {
        this.signatureValid = bool;
        return this;
    }

    public VerifyResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }
}
