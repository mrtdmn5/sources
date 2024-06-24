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
public class ReEncryptRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private String destinationKeyId;
    private String sourceEncryptionAlgorithm;
    private String sourceKeyId;
    private Map<String, String> sourceEncryptionContext = new HashMap();
    private Map<String, String> destinationEncryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();

    public ReEncryptRequest addDestinationEncryptionContextEntry(String str, String str2) {
        if (this.destinationEncryptionContext == null) {
            this.destinationEncryptionContext = new HashMap();
        }
        if (!this.destinationEncryptionContext.containsKey(str)) {
            this.destinationEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public ReEncryptRequest addSourceEncryptionContextEntry(String str, String str2) {
        if (this.sourceEncryptionContext == null) {
            this.sourceEncryptionContext = new HashMap();
        }
        if (!this.sourceEncryptionContext.containsKey(str)) {
            this.sourceEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public ReEncryptRequest clearDestinationEncryptionContextEntries() {
        this.destinationEncryptionContext = null;
        return this;
    }

    public ReEncryptRequest clearSourceEncryptionContextEntries() {
        this.sourceEncryptionContext = null;
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
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptRequest)) {
            return false;
        }
        ReEncryptRequest reEncryptRequest = (ReEncryptRequest) obj;
        if (reEncryptRequest.getCiphertextBlob() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCiphertextBlob() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (reEncryptRequest.getCiphertextBlob() != null && !reEncryptRequest.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSourceEncryptionContext() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() != null && !reEncryptRequest.getSourceEncryptionContext().equals(getSourceEncryptionContext())) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getSourceKeyId() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() != null && !reEncryptRequest.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getDestinationKeyId() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() != null && !reEncryptRequest.getDestinationKeyId().equals(getDestinationKeyId())) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getDestinationEncryptionContext() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() != null && !reEncryptRequest.getDestinationEncryptionContext().equals(getDestinationEncryptionContext())) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getSourceEncryptionAlgorithm() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() != null && !reEncryptRequest.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getDestinationEncryptionAlgorithm() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() != null && !reEncryptRequest.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm())) {
            return false;
        }
        if (reEncryptRequest.getGrantTokens() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getGrantTokens() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (reEncryptRequest.getGrantTokens() == null || reEncryptRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public Map<String, String> getDestinationEncryptionContext() {
        return this.destinationEncryptionContext;
    }

    public String getDestinationKeyId() {
        return this.destinationKeyId;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public Map<String, String> getSourceEncryptionContext() {
        return this.sourceEncryptionContext;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int r1 = 0;
        if (getCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getCiphertextBlob().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getSourceEncryptionContext() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSourceEncryptionContext().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getSourceKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSourceKeyId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getDestinationKeyId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getDestinationKeyId().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getDestinationEncryptionContext() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getDestinationEncryptionContext().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getSourceEncryptionAlgorithm().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getDestinationEncryptionAlgorithm() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getDestinationEncryptionAlgorithm().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getGrantTokens() != null) {
            r1 = getGrantTokens().hashCode();
        }
        return r07 + r1;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public void setDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
    }

    public void setDestinationKeyId(String str) {
        this.destinationKeyId = str;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public void setSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getSourceEncryptionContext() != null) {
            sb.append("SourceEncryptionContext: " + getSourceEncryptionContext() + ",");
        }
        if (getSourceKeyId() != null) {
            sb.append("SourceKeyId: " + getSourceKeyId() + ",");
        }
        if (getDestinationKeyId() != null) {
            sb.append("DestinationKeyId: " + getDestinationKeyId() + ",");
        }
        if (getDestinationEncryptionContext() != null) {
            sb.append("DestinationEncryptionContext: " + getDestinationEncryptionContext() + ",");
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + ",");
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public ReEncryptRequest withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withDestinationKeyId(String str) {
        this.destinationKeyId = str;
        return this;
    }

    public ReEncryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
