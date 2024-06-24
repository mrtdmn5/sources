package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CreateAliasRequest extends AmazonWebServiceRequest implements Serializable {
    private String aliasName;
    private String targetKeyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateAliasRequest)) {
            return false;
        }
        CreateAliasRequest createAliasRequest = (CreateAliasRequest) obj;
        if (createAliasRequest.getAliasName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAliasName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (createAliasRequest.getAliasName() != null && !createAliasRequest.getAliasName().equals(getAliasName())) {
            return false;
        }
        if (createAliasRequest.getTargetKeyId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getTargetKeyId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (createAliasRequest.getTargetKeyId() == null || createAliasRequest.getTargetKeyId().equals(getTargetKeyId())) {
            return true;
        }
        return false;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public String getTargetKeyId() {
        return this.targetKeyId;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getAliasName() == null) {
            hashCode = 0;
        } else {
            hashCode = getAliasName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getTargetKeyId() != null) {
            r1 = getTargetKeyId().hashCode();
        }
        return r0 + r1;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setTargetKeyId(String str) {
        this.targetKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAliasName() != null) {
            sb.append("AliasName: " + getAliasName() + ",");
        }
        if (getTargetKeyId() != null) {
            sb.append("TargetKeyId: " + getTargetKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateAliasRequest withAliasName(String str) {
        this.aliasName = str;
        return this;
    }

    public CreateAliasRequest withTargetKeyId(String str) {
        this.targetKeyId = str;
        return this;
    }
}
