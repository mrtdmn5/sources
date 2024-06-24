package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class VerifyMacRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer mac;
    private String macAlgorithm;
    private ByteBuffer message;

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
        if (obj == null || !(obj instanceof VerifyMacRequest)) {
            return false;
        }
        VerifyMacRequest verifyMacRequest = (VerifyMacRequest) obj;
        if (verifyMacRequest.getMessage() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getMessage() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (verifyMacRequest.getMessage() != null && !verifyMacRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (verifyMacRequest.getKeyId() == null) {
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
        if (verifyMacRequest.getKeyId() != null && !verifyMacRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyMacRequest.getMacAlgorithm() == null) {
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
        if (verifyMacRequest.getMacAlgorithm() != null && !verifyMacRequest.getMacAlgorithm().equals(getMacAlgorithm())) {
            return false;
        }
        if (verifyMacRequest.getMac() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getMac() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (verifyMacRequest.getMac() != null && !verifyMacRequest.getMac().equals(getMac())) {
            return false;
        }
        if (verifyMacRequest.getGrantTokens() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getGrantTokens() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (verifyMacRequest.getGrantTokens() == null || verifyMacRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
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

    public ByteBuffer getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getMessage().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getKeyId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getKeyId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getMacAlgorithm() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getMacAlgorithm().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getMac() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getMac().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r04 + r1;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
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

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMessage() != null) {
            sb.append("Message: " + getMessage() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm() + ",");
        }
        if (getMac() != null) {
            sb.append("Mac: " + getMac() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyMacRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public VerifyMacRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyMacRequest withMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
        return this;
    }

    public VerifyMacRequest withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public VerifyMacRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public VerifyMacRequest withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }

    public VerifyMacRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
