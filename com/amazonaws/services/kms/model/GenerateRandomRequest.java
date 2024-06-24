package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class GenerateRandomRequest extends AmazonWebServiceRequest implements Serializable {
    private String customKeyStoreId;
    private Integer numberOfBytes;
    private RecipientInfo recipient;

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
        if (obj == null || !(obj instanceof GenerateRandomRequest)) {
            return false;
        }
        GenerateRandomRequest generateRandomRequest = (GenerateRandomRequest) obj;
        if (generateRandomRequest.getNumberOfBytes() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getNumberOfBytes() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (generateRandomRequest.getNumberOfBytes() != null && !generateRandomRequest.getNumberOfBytes().equals(getNumberOfBytes())) {
            return false;
        }
        if (generateRandomRequest.getCustomKeyStoreId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCustomKeyStoreId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (generateRandomRequest.getCustomKeyStoreId() != null && !generateRandomRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (generateRandomRequest.getRecipient() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getRecipient() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (generateRandomRequest.getRecipient() == null || generateRandomRequest.getRecipient().equals(getRecipient())) {
            return true;
        }
        return false;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getNumberOfBytes() == null) {
            hashCode = 0;
        } else {
            hashCode = getNumberOfBytes().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getCustomKeyStoreId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCustomKeyStoreId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getRecipient() != null) {
            r1 = getRecipient().hashCode();
        }
        return r02 + r1;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getNumberOfBytes() != null) {
            sb.append("NumberOfBytes: " + getNumberOfBytes() + ",");
        }
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getRecipient() != null) {
            sb.append("Recipient: " + getRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateRandomRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public GenerateRandomRequest withNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
        return this;
    }

    public GenerateRandomRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }
}
