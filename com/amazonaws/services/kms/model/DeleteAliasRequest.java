package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DeleteAliasRequest extends AmazonWebServiceRequest implements Serializable {
    private String aliasName;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteAliasRequest)) {
            return false;
        }
        DeleteAliasRequest deleteAliasRequest = (DeleteAliasRequest) obj;
        if (deleteAliasRequest.getAliasName() == null) {
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
        if (deleteAliasRequest.getAliasName() == null || deleteAliasRequest.getAliasName().equals(getAliasName())) {
            return true;
        }
        return false;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public int hashCode() {
        int hashCode;
        if (getAliasName() == null) {
            hashCode = 0;
        } else {
            hashCode = getAliasName().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAliasName() != null) {
            sb.append("AliasName: " + getAliasName());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteAliasRequest withAliasName(String str) {
        this.aliasName = str;
        return this;
    }
}
