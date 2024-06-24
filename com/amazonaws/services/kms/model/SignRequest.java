package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class SignRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer message;
    private String messageType;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignRequest)) {
            return false;
        }
        SignRequest signRequest = (SignRequest) obj;
        if (signRequest.getKeyId() == null) {
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
        if (signRequest.getKeyId() != null && !signRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (signRequest.getMessage() == null) {
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
        if (signRequest.getMessage() != null && !signRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (signRequest.getMessageType() == null) {
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
        if (signRequest.getMessageType() != null && !signRequest.getMessageType().equals(getMessageType())) {
            return false;
        }
        if (signRequest.getGrantTokens() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getGrantTokens() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (signRequest.getGrantTokens() != null && !signRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if (signRequest.getSigningAlgorithm() == null) {
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
        if (signRequest.getSigningAlgorithm() == null || signRequest.getSigningAlgorithm().equals(getSigningAlgorithm())) {
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

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
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
        if (getGrantTokens() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getGrantTokens().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getSigningAlgorithm() != null) {
            r1 = getSigningAlgorithm().hashCode();
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

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public void setMessageType(String str) {
        this.messageType = str;
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
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public SignRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public SignRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public SignRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public SignRequest withMessageType(String str) {
        this.messageType = str;
        return this;
    }

    public SignRequest withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public SignRequest withMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
        return this;
    }

    public SignRequest withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public SignRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
