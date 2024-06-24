package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class VerifyMacResult implements Serializable {
    private String keyId;
    private String macAlgorithm;
    private Boolean macValid;

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
        if (obj == null || !(obj instanceof VerifyMacResult)) {
            return false;
        }
        VerifyMacResult verifyMacResult = (VerifyMacResult) obj;
        if (verifyMacResult.getKeyId() == null) {
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
        if (verifyMacResult.getKeyId() != null && !verifyMacResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyMacResult.getMacValid() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMacValid() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (verifyMacResult.getMacValid() != null && !verifyMacResult.getMacValid().equals(getMacValid())) {
            return false;
        }
        if (verifyMacResult.getMacAlgorithm() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getMacAlgorithm() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (verifyMacResult.getMacAlgorithm() == null || verifyMacResult.getMacAlgorithm().equals(getMacAlgorithm())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public Boolean getMacValid() {
        return this.macValid;
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
        if (getMacValid() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMacValid().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getMacAlgorithm() != null) {
            r1 = getMacAlgorithm().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isMacValid() {
        return this.macValid;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public void setMacValid(Boolean bool) {
        this.macValid = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getMacValid() != null) {
            sb.append("MacValid: " + getMacValid() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyMacResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyMacResult withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public VerifyMacResult withMacValid(Boolean bool) {
        this.macValid = bool;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public VerifyMacResult withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }
}
