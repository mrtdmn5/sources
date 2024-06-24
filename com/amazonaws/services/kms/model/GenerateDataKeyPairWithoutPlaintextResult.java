package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class GenerateDataKeyPairWithoutPlaintextResult implements Serializable {
    private String keyId;
    private String keyPairSpec;
    private ByteBuffer privateKeyCiphertextBlob;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = (GenerateDataKeyPairWithoutPlaintextResult) obj;
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPrivateKeyCiphertextBlob() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() != null && !generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob().equals(getPrivateKeyCiphertextBlob())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPublicKey() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() != null && !generateDataKeyPairWithoutPlaintextResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() == null) {
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
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() != null && !generateDataKeyPairWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getKeyPairSpec() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null || generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec().equals(getKeyPairSpec())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public ByteBuffer getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getPrivateKeyCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getPrivateKeyCiphertextBlob().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPublicKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPublicKey().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getKeyPairSpec() != null) {
            r1 = getKeyPairSpec().hashCode();
        }
        return r03 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public void setPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPrivateKeyCiphertextBlob() != null) {
            sb.append("PrivateKeyCiphertextBlob: " + getPrivateKeyCiphertextBlob() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyPairSpec() != null) {
            sb.append("KeyPairSpec: " + getKeyPairSpec());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }
}
