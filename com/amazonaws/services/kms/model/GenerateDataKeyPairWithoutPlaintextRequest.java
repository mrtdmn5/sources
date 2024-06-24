package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GenerateDataKeyPairWithoutPlaintextRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keyPairSpec;

    public GenerateDataKeyPairWithoutPlaintextRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GenerateDataKeyPairWithoutPlaintextRequest clearEncryptionContextEntries() {
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextRequest)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextRequest generateDataKeyPairWithoutPlaintextRequest = (GenerateDataKeyPairWithoutPlaintextRequest) obj;
        if (generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getEncryptionContext() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext() != null && !generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyId() == null) {
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
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyId() != null && !generateDataKeyPairWithoutPlaintextRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyPairSpec() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec() != null && !generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec().equals(getKeyPairSpec())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getGrantTokens() == null) {
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
        if (generateDataKeyPairWithoutPlaintextRequest.getGrantTokens() == null || generateDataKeyPairWithoutPlaintextRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
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

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getEncryptionContext() == null) {
            hashCode = 0;
        } else {
            hashCode = getEncryptionContext().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getKeyId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getKeyId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyPairSpec() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyPairSpec().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r03 + r1;
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

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEncryptionContext() != null) {
            sb.append("EncryptionContext: " + getEncryptionContext() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyPairSpec() != null) {
            sb.append("KeyPairSpec: " + getKeyPairSpec() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
