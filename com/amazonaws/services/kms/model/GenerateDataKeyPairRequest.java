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
public class GenerateDataKeyPairRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keyPairSpec;
    private RecipientInfo recipient;

    public GenerateDataKeyPairRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public GenerateDataKeyPairRequest clearEncryptionContextEntries() {
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
        if (obj == null || !(obj instanceof GenerateDataKeyPairRequest)) {
            return false;
        }
        GenerateDataKeyPairRequest generateDataKeyPairRequest = (GenerateDataKeyPairRequest) obj;
        if (generateDataKeyPairRequest.getEncryptionContext() == null) {
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
        if (generateDataKeyPairRequest.getEncryptionContext() != null && !generateDataKeyPairRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if (generateDataKeyPairRequest.getKeyId() == null) {
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
        if (generateDataKeyPairRequest.getKeyId() != null && !generateDataKeyPairRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (generateDataKeyPairRequest.getKeyPairSpec() == null) {
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
        if (generateDataKeyPairRequest.getKeyPairSpec() != null && !generateDataKeyPairRequest.getKeyPairSpec().equals(getKeyPairSpec())) {
            return false;
        }
        if (generateDataKeyPairRequest.getGrantTokens() == null) {
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
        if (generateDataKeyPairRequest.getGrantTokens() != null && !generateDataKeyPairRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if (generateDataKeyPairRequest.getRecipient() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getRecipient() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (generateDataKeyPairRequest.getRecipient() == null || generateDataKeyPairRequest.getRecipient().equals(getRecipient())) {
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

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
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
        if (getGrantTokens() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getGrantTokens().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getRecipient() != null) {
            r1 = getRecipient().hashCode();
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

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
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
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getRecipient() != null) {
            sb.append("Recipient: " + getRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyPairRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyPairRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public GenerateDataKeyPairRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairRequest withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public GenerateDataKeyPairRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairRequest withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }

    public GenerateDataKeyPairRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
