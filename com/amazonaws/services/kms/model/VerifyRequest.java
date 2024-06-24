package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class VerifyRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer message;
    private String messageType;
    private ByteBuffer signature;
    private String signingAlgorithm;

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
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyRequest)) {
            return false;
        }
        VerifyRequest verifyRequest = (VerifyRequest) obj;
        if (verifyRequest.getKeyId() == null) {
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
        if (verifyRequest.getKeyId() != null && !verifyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyRequest.getMessage() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMessage() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (verifyRequest.getMessage() != null && !verifyRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (verifyRequest.getMessageType() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getMessageType() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (verifyRequest.getMessageType() != null && !verifyRequest.getMessageType().equals(getMessageType())) {
            return false;
        }
        if (verifyRequest.getSignature() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getSignature() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (verifyRequest.getSignature() != null && !verifyRequest.getSignature().equals(getSignature())) {
            return false;
        }
        if (verifyRequest.getSigningAlgorithm() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getSigningAlgorithm() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (verifyRequest.getSigningAlgorithm() != null && !verifyRequest.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return false;
        }
        if (verifyRequest.getGrantTokens() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getGrantTokens() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (verifyRequest.getGrantTokens() == null || verifyRequest.getGrantTokens().equals(getGrantTokens())) {
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

    public ByteBuffer getMessage() {
        return this.message;
    }

    public String getMessageType() {
        return this.messageType;
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
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMessage() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMessage().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getMessageType() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getMessageType().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getSignature() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSignature().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getSigningAlgorithm() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSigningAlgorithm().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r05 + r1;
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

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public void setMessageType(String str) {
        this.messageType = str;
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
        if (getMessage() != null) {
            sb.append("Message: " + getMessage() + ",");
        }
        if (getMessageType() != null) {
            sb.append("MessageType: " + getMessageType() + ",");
        }
        if (getSignature() != null) {
            sb.append("Signature: " + getSignature() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public VerifyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public VerifyRequest withMessageType(String str) {
        this.messageType = str;
        return this;
    }

    public VerifyRequest withSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
        return this;
    }

    public VerifyRequest withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyRequest withMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
        return this;
    }

    public VerifyRequest withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public VerifyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
