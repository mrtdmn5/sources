package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class GenerateMacResult implements Serializable {
    private String keyId;
    private ByteBuffer mac;
    private String macAlgorithm;

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
        if (obj == null || !(obj instanceof GenerateMacResult)) {
            return false;
        }
        GenerateMacResult generateMacResult = (GenerateMacResult) obj;
        if (generateMacResult.getMac() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getMac() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateMacResult.getMac() != null && !generateMacResult.getMac().equals(getMac())) {
            return false;
        }
        if (generateMacResult.getMacAlgorithm() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMacAlgorithm() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateMacResult.getMacAlgorithm() != null && !generateMacResult.getMacAlgorithm().equals(getMacAlgorithm())) {
            return false;
        }
        if (generateMacResult.getKeyId() == null) {
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
        if (generateMacResult.getKeyId() == null || generateMacResult.getKeyId().equals(getKeyId())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getMac() {
        return this.mac;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getMac() == null) {
            hashCode = 0;
        } else {
            hashCode = getMac().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMacAlgorithm() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMacAlgorithm().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyId() != null) {
            r1 = getKeyId().hashCode();
        }
        return r02 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMac() != null) {
            sb.append("Mac: " + getMac() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateMacResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateMacResult withMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
        return this;
    }

    public GenerateMacResult withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public GenerateMacResult withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }
}
