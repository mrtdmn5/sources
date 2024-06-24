package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class EncryptRequest extends AmazonWebServiceRequest implements Serializable {
    private String encryptionAlgorithm;
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer plaintext;

    public EncryptRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public EncryptRequest clearEncryptionContextEntries() {
        this.encryptionContext = null;
        return this;
    }

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
        if (obj == null || !(obj instanceof EncryptRequest)) {
            return false;
        }
        EncryptRequest encryptRequest = (EncryptRequest) obj;
        if (encryptRequest.getKeyId() == null) {
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
        if (encryptRequest.getKeyId() != null && !encryptRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (encryptRequest.getPlaintext() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPlaintext() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (encryptRequest.getPlaintext() != null && !encryptRequest.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if (encryptRequest.getEncryptionContext() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getEncryptionContext() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (encryptRequest.getEncryptionContext() != null && !encryptRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if (encryptRequest.getGrantTokens() == null) {
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
        if (encryptRequest.getGrantTokens() != null && !encryptRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if (encryptRequest.getEncryptionAlgorithm() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getEncryptionAlgorithm() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (encryptRequest.getEncryptionAlgorithm() == null || encryptRequest.getEncryptionAlgorithm().equals(getEncryptionAlgorithm())) {
            return true;
        }
        return false;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public Map<String, String> getEncryptionContext() {
        return this.encryptionContext;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
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
        if (getPlaintext() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPlaintext().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getEncryptionContext() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEncryptionContext().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getGrantTokens() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getGrantTokens().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getEncryptionAlgorithm() != null) {
            r1 = getEncryptionAlgorithm().hashCode();
        }
        return r04 + r1;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public void setEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
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

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getEncryptionContext() != null) {
            sb.append("EncryptionContext: " + getEncryptionContext() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getEncryptionAlgorithm() != null) {
            sb.append("EncryptionAlgorithm: " + getEncryptionAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public EncryptRequest withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public EncryptRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public EncryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public EncryptRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public EncryptRequest withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public EncryptRequest withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public EncryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
