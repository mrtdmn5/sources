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
public class GenerateDataKeyWithoutPlaintextRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keySpec;
    private Integer numberOfBytes;

    public GenerateDataKeyWithoutPlaintextRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GenerateDataKeyWithoutPlaintextRequest clearEncryptionContextEntries() {
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
        if (obj == null || !(obj instanceof GenerateDataKeyWithoutPlaintextRequest)) {
            return false;
        }
        GenerateDataKeyWithoutPlaintextRequest generateDataKeyWithoutPlaintextRequest = (GenerateDataKeyWithoutPlaintextRequest) obj;
        if (generateDataKeyWithoutPlaintextRequest.getKeyId() == null) {
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
        if (generateDataKeyWithoutPlaintextRequest.getKeyId() != null && !generateDataKeyWithoutPlaintextRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getEncryptionContext() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getEncryptionContext() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getEncryptionContext() != null && !generateDataKeyWithoutPlaintextRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getKeySpec() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeySpec() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getKeySpec() != null && !generateDataKeyWithoutPlaintextRequest.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getNumberOfBytes() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getNumberOfBytes() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getNumberOfBytes() != null && !generateDataKeyWithoutPlaintextRequest.getNumberOfBytes().equals(getNumberOfBytes())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextRequest.getGrantTokens() == null) {
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
        if (generateDataKeyWithoutPlaintextRequest.getGrantTokens() == null || generateDataKeyWithoutPlaintextRequest.getGrantTokens().equals(getGrantTokens())) {
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

    public String getKeySpec() {
        return this.keySpec;
    }

    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
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
        if (getEncryptionContext() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getEncryptionContext().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeySpec() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeySpec().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getNumberOfBytes() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getNumberOfBytes().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r04 + r1;
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

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getEncryptionContext() != null) {
            sb.append("EncryptionContext: " + getEncryptionContext() + ",");
        }
        if (getKeySpec() != null) {
            sb.append("KeySpec: " + getKeySpec() + ",");
        }
        if (getNumberOfBytes() != null) {
            sb.append("NumberOfBytes: " + getNumberOfBytes() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyWithoutPlaintextRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public GenerateDataKeyWithoutPlaintextRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextRequest withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextRequest withNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
        return this;
    }

    public void setKeySpec(DataKeySpec dataKeySpec) {
        this.keySpec = dataKeySpec.toString();
    }

    public GenerateDataKeyWithoutPlaintextRequest withKeySpec(DataKeySpec dataKeySpec) {
        this.keySpec = dataKeySpec.toString();
        return this;
    }

    public GenerateDataKeyWithoutPlaintextRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
